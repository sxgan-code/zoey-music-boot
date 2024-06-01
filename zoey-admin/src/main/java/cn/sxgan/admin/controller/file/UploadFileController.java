package cn.sxgan.admin.controller.file;

import cn.sxgan.admin.api.file.UploadFileControllerApi;
import cn.sxgan.admin.utils.audio.AudioContext;
import cn.sxgan.admin.utils.audio.impl.FlacAudioProcessImpl;
import cn.sxgan.common.constant.FileConst;
import cn.sxgan.common.entity.MusicSong;
import cn.sxgan.common.entity.converts.IMusicSongConvert;
import cn.sxgan.common.entity.vo.MusicSongVO;
import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.common.utils.FileUploadUtils;
import cn.sxgan.common.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @Description: 文件上传控制器
 * @Author: sxgan
 * @Date: 2024-05-31 20:07
 * @Version: 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/file")
public class UploadFileController implements UploadFileControllerApi {
    
    
    @Override
    @PostMapping(value = "/upload/single/img")
    public ResponseResult<String> uploadSingleFile(MultipartFile file) {
        String result = FileUploadUtils.uploadFile(file, FileConst.SONG_IMAGE_PATH, null, false);
        if (result != null) {
            return ResponseResult.success("上传成功！");
        }
        return ResponseResult.fail("上传失败！");
    }
    
    @Override
    @PostMapping(value = "/upload/single/song")
    public ResponseResult<MusicSongVO> songFileUploadApi(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String path = FileUtils.getFileRelativePathByType(originalFilename);
        String result = FileUploadUtils.uploadFile(file, path, null, false);
        MusicSong musicSong = null;
        if (result != null) {
            File songFile = new File(FileConst.PROJECT_URL + result);
            String fileExtension = FileUtils.getFileExtension(songFile);
            
            if ("flac".equals(fileExtension)) {
                log.info("flac file: {}", songFile.getAbsolutePath());
                AudioContext audioContext = new AudioContext(new FlacAudioProcessImpl());
                musicSong = audioContext.use(songFile);
            } else if ("mp3".equals(fileExtension)) {
                // log.info("mp3 file: {}", file.getAbsolutePath());
                // File flacImgFile = new File(FileConst.FLAC_IMG_PATH);
                // flacImgFile.mkdirs();
                // AudioContext audioContext = new AudioContext(new FlacAudioProcessImpl());
                // audioContext.use(file);
            }
            MusicSongVO musicSongVO = IMusicSongConvert.INSTANCE.convert(musicSong);
            return ResponseResult.success(musicSongVO);
        }
        return ResponseResult.fail(null);
    }
}
