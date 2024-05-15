package cn.sxgan.admin.utils.audio;

import cn.sxgan.admin.utils.FileUtils;
import cn.sxgan.admin.utils.audio.impl.FlacAudioProcessImpl;
import cn.sxgan.common.constant.FileConst;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.List;

/**
 * @Description: 音频测试类
 * @Author: sxgan
 * @Date: 2024-05-15 23:18
 * @Version: 1.0
 **/
@Slf4j
@SpringBootTest
public class AudioTest {
    
    @Test
    public void test() {
        // 去除子模块zoey-admin路径
        String userDir = FileConst.PROJECT_URL.replaceAll("zoey-admin", "");
        File songsDir = new File(userDir + "/resources/songs/");
        List<File> files = FileUtils.listAllFiles(songsDir);
        for (File file : files) {
            String[] split = file.getAbsoluteFile().toString().split("\\.");
            String extension = split[split.length - 1];
            if ("flac".equals(extension)) {
                log.info("file: {}", file.getAbsolutePath());
                File flacImgFile = new File(userDir + FileConst.FLAC_IMG_PATH);
                flacImgFile.mkdirs();
                AudioContext audioContext = new AudioContext(new FlacAudioProcessImpl());
                audioContext.use(file);
            }
        }
        
    }
}
