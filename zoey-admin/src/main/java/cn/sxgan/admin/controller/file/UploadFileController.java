package cn.sxgan.admin.controller.file;

import cn.sxgan.admin.api.file.UploadFileControllerApi;
import cn.sxgan.common.constant.FileConst;
import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.common.utils.FileUploadUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: 文件上传控制器
 * @Author: sxgan
 * @Date: 2024-05-31 20:07
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/file")
public class UploadFileController implements UploadFileControllerApi {
    
    
    @Override
    @PostMapping(value = "/upload/single")
    public ResponseResult<String> uploadSingleFile(MultipartFile file) {
        String result = FileUploadUtils.uploadFile(file, FileConst.SONG_IMAGE_PATH, null);
        if (result != null) {
            return ResponseResult.success("上传成功！");
        }
        return ResponseResult.fail("上传失败！");
    }
}
