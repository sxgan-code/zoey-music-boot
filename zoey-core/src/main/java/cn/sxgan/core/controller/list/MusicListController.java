package cn.sxgan.core.controller.list;

import cn.sxgan.common.constant.ExceptionStatus;
import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.common.utils.CommonUtils;
import cn.sxgan.core.api.list.IMusicListApi;
import cn.sxgan.core.entity.UserSessionInfo;
import cn.sxgan.core.http.RequestHolder;
import cn.sxgan.core.service.impl.SongListServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 音乐列表控制器
 * @Author: sxgan
 * @Date: 2024-04-17 13:21
 * @Version: 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/list/")
public class MusicListController implements IMusicListApi {
    
    @Resource
    SongListServiceImpl songListService;
    
    @RequestMapping(value = "/getUserSongList", method = RequestMethod.POST)
    public ResponseResult<List> getUserSongList() {
        UserSessionInfo currentUser = RequestHolder.getCurrentUser();
        if (CommonUtils.checkIsNullOrEmpty(currentUser)) {
            return ResponseResult.fail(Lists.newArrayList(),
                    ExceptionStatus.EXCEPTION_STATUS_700.getExceptionCode(),
                    ExceptionStatus.EXCEPTION_STATUS_700.getExceptionMsg());
        }
        return songListService.getSongList(currentUser);
    }
}
