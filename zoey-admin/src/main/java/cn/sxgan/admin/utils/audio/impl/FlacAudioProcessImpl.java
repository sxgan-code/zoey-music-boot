package cn.sxgan.admin.utils.audio.impl;

import cn.sxgan.admin.utils.AudioUtil;
import cn.sxgan.admin.utils.audio.IAudioProcess;
import cn.sxgan.common.constant.FileConst;
import cn.sxgan.common.entity.MusicAlbum;
import cn.sxgan.common.entity.MusicSinger;
import cn.sxgan.common.entity.MusicSong;
import cn.sxgan.common.utils.CommonUtils;
import cn.sxgan.common.utils.DateUtils;
import cn.sxgan.common.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.flac.FlacFileReader;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.flac.FlacTag;
import org.jaudiotagger.tag.images.Artwork;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @Description: Flac音频处理实现类
 * @Author: sxgan
 * @Date: 2024-05-15 22:43
 * @Version: 1.0
 **/
@Slf4j
public class FlacAudioProcessImpl implements IAudioProcess {
    
    // 初始化文件路径*/
    static {
        new File(FileConst.FLAC_SONG_PATH).mkdirs();
        new File(FileConst.FLAC_IMG_PATH).mkdirs();
        new File(FileConst.FLAC_LRC_PATH).mkdirs();
    }
    
    @Override
    public void process(File file1) {
        try {
            FlacFileReader flacFileReader = new FlacFileReader();
            AudioFile audioFile = flacFileReader.read(file1);
            
            if (audioFile != null) {
                Long songId = 0L;
                Long albumId = 0L;
                Long singerId = 0L;
                synchronized (AudioUtil.LOCK) {
                    songId = AudioUtil.SONG_ID++;
                    albumId = AudioUtil.ALBUM_ID++;
                    singerId = AudioUtil.SINGER_ID++;
                }
                // 保存到指定目录
                File copyFile = FileUtils.copyFileToDir(file1, FileConst.FLAC_SONG_PATH);
                String songUrl = copyFile.getAbsolutePath().replaceAll("\\\\", "/");
                // 1、获取歌曲信息
                MusicSong musicSong = new MusicSong();
                musicSong.setSongId(songId);
                musicSong.setAlbumId(albumId);
                musicSong.setSingerId(singerId);
                FlacTag tag = (FlacTag) audioFile.getTag();
                String songName = tag.getFields("TITLE").getFirst().toString();
                songName = songName.replaceAll("/", "、");
                songName = songName.replaceAll("'", "‘");
                songName = songName.replaceAll("#", "").trim();
                String releaseDate = "2010-01-01";
                if (!tag.getFields("DATE").isEmpty()) {
                    releaseDate = tag.getFields("DATE").getFirst().toString();
                }
                musicSong.setSongUrl(songUrl.substring(songUrl.indexOf("/data")));
                musicSong.setSongName(songName.toString());
                musicSong.setReleaseDate(new Date());
                // 判断时间是否符合预期
                if (!CommonUtils.checkIsNullOrEmpty(releaseDate) &&
                        DateUtils.isBetween(releaseDate, "1980-01-01", "2100-01-01",
                                DateUtils.DatePatternEnum.YYYY_MM_DD.getPattern())) {
                    musicSong.setReleaseDate(DateUtils.parseStrToDate(releaseDate,
                            DateUtils.DatePatternEnum.YYYY_MM_DD.getPattern()));
                }
                // 获取图片信息
                String picPath = getImage(tag, songName.toString());
                musicSong.setSongPic(picPath);
                // 2、获取歌手信息
                MusicSinger musicSinger = new MusicSinger();
                String singerName = tag.getFields("ARTIST").getFirst().toString();
                singerName = singerName.replaceAll("/", "、");
                singerName = singerName.replaceAll("'", "‘");
                singerName = singerName.replaceAll("#", "").trim();
                musicSinger.setSingerId(musicSong.getSingerId());
                musicSinger.setSingerName(singerName);
                musicSinger.setAddress("中国");
                musicSinger.setSingerPic(musicSong.getSongPic());
                // 3、获取专辑信息
                MusicAlbum musicAlbum = new MusicAlbum();
                String albumName = tag.getFields("ALBUM").getFirst().toString();
                albumName = albumName.replaceAll("/", "、");
                albumName = albumName.replaceAll("'", "‘");
                albumName = albumName.replaceAll("#", "").trim();
                musicAlbum.setAlbumId(musicSong.getAlbumId());
                musicAlbum.setAlbumPic(picPath);
                musicAlbum.setReleaseDate(musicSong.getReleaseDate());
                musicAlbum.setAlbumName(albumName);
                musicAlbum.setSingerId(musicSong.getSingerId());
                // 4、生成脚本
                if (!CommonUtils.checkIsNullOrEmpty(songName)
                        && !CommonUtils.checkIsNullOrEmpty(singerName)
                        && !CommonUtils.checkIsNullOrEmpty(albumName)) {
                    AudioUtil.buildSongSql(musicSong);
                    AudioUtil.buildSingerSql(musicSinger);
                    AudioUtil.buildAlbumSql(musicAlbum);
                } else {
                    log.error("文件信息不完整，无法生成脚本，文件路径为->{}", copyFile.getAbsolutePath());
                }
                
                
            }
        } catch (IOException | CannotReadException | TagException | InvalidAudioFrameException e) {
            e.printStackTrace();
        } catch (ReadOnlyFileException e) {
            throw new RuntimeException(e);
        }
    }
    
    private String getImage(FlacTag tag, String string) throws IOException {
        Artwork artwork = tag.getFirstArtwork();
        String imageFilePath = FileConst.FLAC_IMG_PATH + string + ".png";
        imageFilePath = imageFilePath.replaceAll("\\\\", "/");
        imageFilePath = imageFilePath.replaceAll("\\\\", "/");
        if (artwork != null) {
            byte[] imageData = artwork.getBinaryData();
            // 处理图片数据，例如保存到文件
            FileUtils.writeAImage(imageData, imageFilePath, "", true);
        } else {
            System.out.println("No image found in FLAC file.");
        }
        return imageFilePath.substring(imageFilePath.indexOf("/data"));
    }
}
