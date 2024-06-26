package cn.sxgan.core.controller.play;

import cn.sxgan.common.constant.FileConst;
import cn.sxgan.core.api.play.MusicPlayControllerApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Description: 音乐播放控制器
 * @Author: sxgan
 * @Date: 2024-05-20 22:48
 * @Version: 1.0
 **/
@RequestMapping(value = "/play")
@Controller
@Slf4j
public class MusicPlayController implements MusicPlayControllerApi {
    
    @GetMapping(value = "/music")
    public ResponseEntity<Resource> getPlayMusicStream(@RequestParam String file) {
        String filePath = FileConst.PROJECT_URL + "/resources/" + file;
        Path audioDirectory = Paths.get(filePath);
        try {
            Resource resource = new UrlResource(audioDirectory.toUri());
            
            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType("audio/mpeg")) // 或者其他适当的媒体类型
                        .body(resource);
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (Exception e) {
            log.info("发生异常");
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}


