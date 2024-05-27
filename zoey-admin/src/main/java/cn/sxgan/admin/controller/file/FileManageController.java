package cn.sxgan.admin.controller.file;

import cn.sxgan.admin.api.file.FileManageControllerApi;
import cn.sxgan.admin.service.impl.FileManageServiceImpl;
import cn.sxgan.common.entity.MyPage;
import cn.sxgan.common.entity.vo.MusicSongVO;
import cn.sxgan.common.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @Autowired
    private FileManageServiceImpl fileManageService;
    
    @Override
    @PostMapping("/song/list")
    public ResponseResult<MyPage<MusicSongVO>> getSongList(@RequestBody MyPage<MusicSongVO> page) {
        page.setList(fileManageService.getAllSongFile(page));
        return ResponseResult.success(page);
    }
}
