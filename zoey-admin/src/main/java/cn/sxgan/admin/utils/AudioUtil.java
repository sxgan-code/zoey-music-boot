package cn.sxgan.admin.utils;

import cn.sxgan.common.constant.FileConst;
import cn.sxgan.common.entity.MusicAlbum;
import cn.sxgan.common.entity.MusicSinger;
import cn.sxgan.common.entity.MusicSong;
import cn.sxgan.common.utils.CommonUtils;
import cn.sxgan.common.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.id3.AbstractID3v2Frame;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.framebody.FrameBodyAPIC;

import java.io.File;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class AudioUtil {
    public static Long SONG_ID = 3000000000L;
    public static Long SINGER_ID = 5000000000L;
    public static Long ALBUM_ID = 80000000L;
    public final static Lock LOCK = new ReentrantLock();
    
    private static StringBuilder songStrSql = new StringBuilder();
    private static StringBuilder singerStrSql = new StringBuilder();
    private static StringBuilder albumStrSql = new StringBuilder();
    
    static {
        String songParent = new File(FileConst.SONG_SQL_PATH).getParent();
        new File(songParent).mkdirs();
        String singerParent = new File(FileConst.SINGER_SQL_PATH).getParent();
        new File(songParent).mkdirs();
        String albumParent = new File(FileConst.ALBUM_SQL_PATH).getParent();
        new File(albumParent).mkdirs();
        songStrSql.append("insert into music_song(song_id, song_name, song_url, song_pic, lyric_url, song_style, release_date, album_id, singer_id) values \n");
        FileUtils.writeADocument(songStrSql.toString(), FileConst.SONG_SQL_PATH, true);
        singerStrSql.append("insert into music_singer(singer_id, singer_name, singer_pic, address) values \n");
        FileUtils.writeADocument(singerStrSql.toString(), FileConst.SINGER_SQL_PATH, true);
        albumStrSql.append("insert into music_album(album_id, album_name, album_pic, release_date, singer_id)" + " values \n");
        FileUtils.writeADocument(albumStrSql.toString(), FileConst.ALBUM_SQL_PATH, true);
    }
    
    /**
     * 构建Song表SQL数据
     *
     * @param musicSong 歌曲信息实体
     */
    public static void buildSongSql(MusicSong musicSong) {
        StringBuffer sb = new StringBuffer();
        sb.append("(")
                .append(musicSong.getSongId())
                .append(",'").append(musicSong.getSongName())
                .append("','").append(musicSong.getSongUrl())
                .append("','").append(musicSong.getSongPic())
                .append("','")
                .append("','#流行，#怀旧")
                .append("','").append(DateUtils.parseDateToStr(musicSong.getReleaseDate(),
                        DateUtils.DatePatternEnum.YYYY_MM_DD.getPattern()))
                .append("',").append(musicSong.getAlbumId())
                .append(",").append(musicSong.getSingerId())
                .append("),\n");
        FileUtils.writeADocument(sb.toString(), FileConst.SONG_SQL_PATH, true);
    }
    
    /**
     * 构建singer数据SQL
     *
     * @param musicSinger 歌手信息
     */
    
    public static void buildSingerSql(MusicSinger musicSinger) {
        StringBuffer sb = new StringBuffer();
        sb.append("(")
                .append(musicSinger.getSingerId())
                .append(",'").append(musicSinger.getSingerName())
                .append("','").append(musicSinger.getSingerPic())
                .append("','").append("中国上海'),\n");
        FileUtils.writeADocument(sb.toString(), FileConst.SINGER_SQL_PATH, true);
    }
    
    /**
     * 构建album数据SQL
     *
     * @param musicAlbum 专辑详情
     */
    public static void buildAlbumSql(MusicAlbum musicAlbum) {
        StringBuffer sb = new StringBuffer();
        sb.append("(").append(musicAlbum.getAlbumId())
                .append(",'").append(musicAlbum.getAlbumName())
                .append("','").append(musicAlbum.getAlbumPic())
                .append("','").append(DateUtils.parseDateToStr(musicAlbum.getReleaseDate(),
                        DateUtils.DatePatternEnum.YYYY_MM_DD.getPattern()))
                .append("',").append(musicAlbum.getSingerId())
                .append("),\n");
        FileUtils.writeADocument(sb.toString(), FileConst.ALBUM_SQL_PATH, true);
    }
    
    
    public static void main(String[] args) {
        String dirurl = System.getProperty("user.dir");
        dirurl = dirurl.replaceAll("\\\\", "/");
        File file = new File(dirurl + "/resources/songs/");
        File songFileData = new File(dirurl + "/doc/music_song_data.sql");
        File albumFileData = new File(dirurl + "/doc/music_album_data.sql");
        File singerFileData = new File(dirurl + "/doc/music_singer_data.sql");
        
        if (songFileData.exists()) {
            songFileData.delete();
        }
        if (albumFileData.exists()) {
            albumFileData.delete();
        }
        if (singerFileData.exists()) {
            singerFileData.delete();
        }
        File[] files = file.listFiles();
        for (File file1 : files) {
//            System.out.println(file1.getAbsolutePath());
            try {
                getMusicInfo(file1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        log.info("歌曲信息构建完成,歌曲截止id为：{}", SONG_ID - 1);
    }
    
    /**
     * 获取歌曲信息构造Music对象
     *
     * @param file 歌曲路径
     * @return Music对象
     * @throws Exception Exception
     */
    public static void getMusicInfo(File file) throws Exception {
        
        // mp3文件
        MP3File mp3File = (MP3File) AudioFileIO.read(file);
        // 标签
        Tag tag = mp3File.getID3v2Tag();
        String dirurl = System.getProperty("user.dir");
        dirurl = dirurl.replaceAll("\\\\", "/");
        if (tag != null) {
            // 歌曲名
            String songName = tag.getFirst(FieldKey.TITLE);
            // 歌手
            String singerName = tag.getFirst(FieldKey.ARTIST);
            // 专辑
            String albumName = tag.getFirst(FieldKey.ALBUM);
            // 歌曲图片
            byte[] mp3Image = getMp3Image(file);
            // 路径
            String path = file.getAbsolutePath();
            path = path.substring(path.indexOf("resources")).replaceAll("\\\\", "/");
            
            String filedir = file.getParent();
            filedir = filedir.substring(filedir.indexOf("resources")).replaceAll("\\\\", "/");
            
            if (!CommonUtils.checkIsNullOrEmpty(songName) && !CommonUtils.checkIsNullOrEmpty(singerName) && !CommonUtils.checkIsNullOrEmpty(albumName)) {
                songName = songName.replaceAll("'", "´");
                singerName = singerName.replaceAll("'", "´");
                albumName = albumName.replaceAll("'", "´");
                // 保存专辑图片
                String relativePath = FileUtils.writeAImage(mp3Image, dirurl, "/resources/image/songImg/" + songName + ".png", true);
                // 构建album数据SQL
                // Long albumId = buildAlbumSql(albumName, dirurl, SINGER_ID, relativePath);
                
                // 构建singer数据SQL
                // Long singerId = buildSingerSql(singerName, dirurl, path);
                // 构建song数据SQL
                // Long songId = buildSongSql(songName, dirurl, path, albumId, singerId);
                
                SINGER_ID++;
                SONG_ID++;
                ALBUM_ID++;
                
            } else {
                file.delete();
            }
            
        }
    }
    
    
    /**
     * 获取MP3封面图片
     *
     * @param mp3File mp3文件
     * @return 图片字节数组
     */
    private static byte[] getMp3Image(File mp3File) {
        byte[] imageData;
        try {
            MP3File mp3file = new MP3File(mp3File);
            AbstractID3v2Tag tag = mp3file.getID3v2Tag();
            AbstractID3v2Frame frame = (AbstractID3v2Frame) tag.getFrame("APIC").getFirst();
            FrameBodyAPIC body;
            if (frame != null && !frame.isEmpty()) {
                body = (FrameBodyAPIC) frame.getBody();
                imageData = body.getImageData();
                return imageData;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
