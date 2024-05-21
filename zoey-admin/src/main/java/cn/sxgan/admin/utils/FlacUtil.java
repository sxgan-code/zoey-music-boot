package cn.sxgan.admin.utils;


import cn.sxgan.common.constant.FileConst;
import cn.sxgan.common.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
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
 * @Description: Flac音频解析
 * @Author: sxgan
 * @Date: 2024-05-15 22:19
 * @Version: 1.0
 **/
@Slf4j
public class FlacUtil {
    
    public static void main(String[] args) {
        String dirurl = System.getProperty("user.dir");
        dirurl = dirurl.replaceAll("\\\\", "/");
        File flacFile = new File(dirurl + "/resources/songs/flac/陈一发儿 - 童话镇.flac");
        File imageFiles = new File(dirurl + "/resources/songs/flac/img/");
        log.info("file:{}", flacFile.getAbsolutePath());
        if (!imageFiles.exists()) {
            imageFiles.mkdirs();
        }
        try {
            FlacFileReader flacFileReader = new FlacFileReader();
            AudioFile audioFile = flacFileReader.read(flacFile);
            
            if (audioFile != null) {
                FileUtils.copyFileToDir(flacFile, FileConst.PROJECT_URL + FileConst.FLAC_SONG_PATH);
                FlacTag tag = (FlacTag) audioFile.getTag();
                TagField title1 = tag.getFields("TITLE").getFirst();
                String string = title1.toString();
                Artwork artwork = tag.getFirstArtwork();
                
                if (artwork != null) {
                    byte[] imageData = artwork.getBinaryData();
                    File file = new File(FileConst.PROJECT_URL + FileConst.FLAC_IMG_PATH);
                    file.mkdirs();
                    // 处理图片数据，例如保存到文件
                    String imageFilePath = file.toPath() + "/" + string + ".png"; // 替换为你想保存图片的路径
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