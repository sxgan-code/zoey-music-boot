package cn.sxgan.admin.controller.file;

import cn.sxgan.admin.api.file.FileManageControllerApi;
import cn.sxgan.common.entity.MusicSong;
import cn.sxgan.common.entity.Page;
import cn.sxgan.common.response.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 文件管理控制器
 * @Author: sxgan
 * @Date: 2024-05-26 17:45
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/file")
public class FileManageController implements FileManageControllerApi {
    
    
    @Override
    @PostMapping("/song/list")
    public ResponseResult<Page<MusicSong>> getSongList(Page<MusicSong> page) {
        
        return null;
    }
}
