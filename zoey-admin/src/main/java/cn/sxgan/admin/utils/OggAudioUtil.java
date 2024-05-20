package cn.sxgan.admin.utils;

import cn.sxgan.common.utils.CommonUtils;
import cn.sxgan.common.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.audio.ogg.OggFileReader;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.id3.AbstractID3v2Frame;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.framebody.FrameBodyAPIC;

import java.io.File;

@Slf4j
public class OggAudioUtil {
    
    public static void main(String[] args) {
        String dirurl = System.getProperty("user.dir");
        dirurl = dirurl.replaceAll("\\\\", "/");
        File file = new File(dirurl + "/resources/songs");
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
        // ogg
        AudioFile read = new OggFileReader().read(file);
        // 标签
        Tag tag = read.getTag();
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
            path = path.substring(path.indexOf("Resource")).replaceAll("\\\\", "/");
            
            String filedir = file.getParent();
            filedir = filedir.substring(filedir.indexOf("Resource")).replaceAll("\\\\", "/");
            
            if (!CommonUtils.checkIsNullOrEmpty(songName)
                    && !CommonUtils.checkIsNullOrEmpty(singerName)
                    && !CommonUtils.checkIsNullOrEmpty(albumName)) {
                // 保存专辑图片
                String relativePath = FileUtils.writeAImage(mp3Image, dirurl, "/resources/image/songImg/" + songName + ".png", true);
                // 构建album数据SQL
                String albumId = buildAlbumSql(albumName, dirurl, path, relativePath);
                
                // 构建singer数据SQL
                String singerId = buildSingerSql(singerName, dirurl, path);
                // 构建song数据SQL
                String songId = buildSongSql(songName, dirurl, path, albumId, singerId);
                
                
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
    private static String buildSingerSql(String singerName, String dirurl, String path) {
        String singerId = CommonUtils.getUUIDStr("SINGER");
        StringBuffer sb = new StringBuffer();
        sb.append("delete from singer where singer_id = '" + singerId + "';\n");
        sb.append("insert into singer (singer_id, singer_name, singer_pic, address) " +
                "values ('" + singerId + "','" + singerName + "','/resources/image/singerImg/" + singerName + ".png','中国上海');");
        FileUtils.writeADocument(sb.toString(), dirurl + "/DB/singerSql.sql", true);
        return singerId;
    }
    
    /**
     * 构建album数据SQL
     *
     * @param albumName
     * @param path
     * @return
     */
    private static String buildAlbumSql(String albumName, String dirurl, String path, String relativePath) {
        String albumId = CommonUtils.getUUIDStr("ALBUM");
        StringBuffer sb = new StringBuffer();
        sb.append("delete from album where album_id = '" + albumId + "';\n");
        sb.append("insert into album (album_id, album_name, album_pic, release_date)\n" +
                "values ('" + albumId + "','" + albumName + "','" + relativePath + "','" + DateUtils.getDateStr() + "');");
        FileUtils.writeADocument(sb.toString(), dirurl + "/DB/albumSql.sql", true);
        return albumId;
    }
    
    /**
     * 构建SongList表SQL数据
     *
     * @param musicName
     * @param path
     * @return
     */
    private static String buildSongSql(String musicName, String dirurl, String path, String albumId, String singerId) {
        String songId = CommonUtils.getUUIDStr("SONG");
        StringBuffer sb = new StringBuffer();
        sb.append("delete from song where song_id = '" + songId + "';\n");
        sb.append("insert into song(song_id, song_name, song_url, song_pic, lyric_url, song_style, release_date, album_id, singer_id) values ('");
        sb.append(songId);
        sb.append("','" + musicName);
        sb.append("','/" + path);
        sb.append("','/resources/image/songImg/" + musicName + ".png");
        sb.append("','','#流行，#怀旧','" + DateUtils.getDateStr());
        sb.append("','" + albumId + "','" + singerId + "');\n");
        String data = sb.toString();
        log.info(data);
        FileUtils.writeADocument(data, dirurl + "/DB/songSql.sql", true);
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
            AbstractID3v2Frame frame = (AbstractID3v2Frame) tag.getFrame("APIC");
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