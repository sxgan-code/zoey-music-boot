package cn.sxgan.admin.utils;

import cn.sxgan.common.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.id3.AbstractID3v2Frame;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.framebody.FrameBodyAPIC;

import java.io.File;

@Slf4j
public class AudioUtil {
    private static Long SONG_ID = 3000000000L;
    private static Long SINGER_ID = 5000000000L;
    private static Long ALBUM_ID = 80000000L;
    
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
                // 保存专辑图片
                String relativePath = FileUtils.writeAImage(mp3Image, dirurl, "/resources/image/songImg/" + songName + ".png", true);
                // 构建album数据SQL
                Long albumId = buildAlbumSql(albumName, dirurl, SINGER_ID, relativePath);
                
                // 构建singer数据SQL
                Long singerId = buildSingerSql(singerName, dirurl, path);
                // 构建song数据SQL
                Long songId = buildSongSql(songName, dirurl, path, albumId, singerId);
                
                SINGER_ID++;
                SONG_ID++;
                ALBUM_ID++;
                
            } else {
                file.delete();
            }
            
        }
    }
    
    /**
     * 构建singer数据SQL
     *
     * @param singerName
     * @param path
     * @return
     */
    private static Long buildSingerSql(String singerName, String dirurl, String path) {
        Long singerId = SINGER_ID;
        StringBuffer sb = new StringBuffer();
        sb.append("insert into music_singer(singer_id, singer_name, singer_pic, address)" +
                " value (" + singerId + ",'" + singerName + "','/image/singerImg/" + singerName + ".png','中国上海');\n");
        FileUtils.writeADocument(sb.toString(), dirurl + "/doc/music_singer_data.sql", true);
        return singerId;
    }
    
    /**
     * 构建album数据SQL
     *
     * @param albumName
     * @param singerId
     * @return
     */
    private static Long buildAlbumSql(String albumName, String dirurl, Long singerId, String relativePath) {
        Long albumId = ALBUM_ID;
        StringBuffer sb = new StringBuffer();
        sb.append("insert into music_album(album_id, album_name, album_pic, release_date, singer_id)" +
                " value (" + albumId + ",'" + albumName + "','" + relativePath.substring(10) + "','" + CommonUtils.getDateString() + "'," + singerId + ");\n");
        FileUtils.writeADocument(sb.toString(), dirurl + "/doc/music_album_data.sql", true);
        return ALBUM_ID;
    }
    
    /**
     * 构建SongList表SQL数据
     *
     * @param musicName
     * @param path
     * @return
     */
    private static Long buildSongSql(String musicName, String dirurl, String path, Long albumId, Long singerId) {
        Long songId = SONG_ID;
        StringBuffer sb = new StringBuffer();
        sb.append("insert into music_song(song_id, song_name, song_url, song_pic, lyric_url, song_style, release_date, album_id, singer_id) value(");
        sb.append(songId);
        sb.append(",'" + musicName);
        sb.append("','" + path.substring(9));
        sb.append("','/image/songImg/" + musicName + ".png");
        sb.append("','");
        sb.append("','#流行，#怀旧");
        sb.append("','" + CommonUtils.getDateString());
        sb.append("'," + albumId + "," + singerId + ");\n");
        String data = sb.toString();
        log.info(data);
        FileUtils.writeADocument(data, dirurl + "/doc/music_song_data.sql", true);
        return songId;
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
