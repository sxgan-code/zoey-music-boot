package cn.sxgan.admin.utils.audio.impl;

import cn.sxgan.admin.utils.audio.IAudioProcess;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.flac.FlacFileReader;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.flac.FlacTag;
import org.jaudiotagger.tag.images.Artwork;

import java.io.File;
import java.io.IOException;

/**
 * @Description: Flac音频处理实现类
 * @Author: sxgan
 * @Date: 2024-05-15 22:43
 * @Version: 1.0
 **/

public class FlacAudioProcessImpl implements IAudioProcess {
    
    @Override
    public void process(File file) {
        try {
            FlacFileReader flacFileReader = new FlacFileReader();
            AudioFile audioFile = flacFileReader.read(file);
            
            if (audioFile != null) {
                FlacTag tag = (FlacTag) audioFile.getTag();
                TagField title1 = tag.getFields("TITLE").getFirst();
                String string = title1.toString();
                Artwork artwork = tag.getFirstArtwork();
                
                if (artwork != null) {
                    byte[] imageData = artwork.getBinaryData();
                    // 处理图片数据，例如保存到文件
                    String imageFilePath = file.getParent() + "/images/" + string + ".png"; // 替换为你想保存图片的路径
                    java.nio.file.Files.write(new File(imageFilePath).toPath(), imageData);
                } else {
                    System.out.println("No image found in FLAC file.");
                }
            }
        } catch (IOException | CannotReadException | TagException | InvalidAudioFrameException e) {
            e.printStackTrace();
        } catch (ReadOnlyFileException e) {
            throw new RuntimeException(e);
        }
    }
}
