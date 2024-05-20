package cn.sxgan.admin.utils.audio.impl;

import cn.sxgan.admin.utils.audio.IAudioProcess;
import lombok.extern.slf4j.Slf4j;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.id3.AbstractID3v2Frame;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.framebody.FrameBodyAPIC;

import java.io.File;

/**
 * @Description: Mp3音频处理实现类
 * @Author: sxgan
 * @Date: 2024-05-17 10:08
 * @Version: 1.0
 **/
@Slf4j
public class Mp3AudioProcessImpl implements IAudioProcess {
    @Override
    public void process(File file) {
        // mp3文件
        MP3File mp3File = null;
        try {
            mp3File = (MP3File) AudioFileIO.read(file);
            
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
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e);
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
