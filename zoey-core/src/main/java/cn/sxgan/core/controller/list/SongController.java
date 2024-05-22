package cn.sxgan.core.controller.list;

import cn.hutool.core.util.ObjectUtil;
import cn.sxgan.common.constant.ExceptionStatus;
import cn.sxgan.common.entity.UserSessionInfo;
import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.core.entity.vo.MusicSongYelpVO;
import cn.sxgan.core.http.RequestHolder;
import cn.sxgan.core.service.impl.MusicSongYelpServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 歌曲相关控制器
 * @Author: sxgan
 * @Date: 2024-04-20 17:56
 * @Version: 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/song/")
public class SongController {
    
    @Resource
    private MusicSongYelpServiceImpl musicSongYelpService;
    
    
    @PostMapping(value = "/updateSongYelp")
    public ResponseResult<String> updateSongYelp(@RequestBody MusicSongYelpVO musicSongYelpVO) {
        UserSessionInfo currentUser = RequestHolder.getCurrentUser();
        if (ObjectUtil.isEmpty(currentUser)) {
            return ResponseResult.fail(null,
                    ExceptionStatus.EXCEPTION_STATUS_700.getExceptionCode(),
                    ExceptionStatus.EXCEPTION_STATUS_700.getExceptionMsg());
        }
        return musicSongYelpService.updateSongYelp(musicSongYelpVO);
    }
}
