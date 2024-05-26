package cn.sxgan.core.controller.list;

import cn.hutool.core.util.ObjectUtil;
import cn.sxgan.common.constant.ExceptionStatus;
import cn.sxgan.common.entity.UserSessionInfo;
import cn.sxgan.common.entity.vo.MusicListVO;
import cn.sxgan.common.entity.vo.MusicSongVO;
import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.core.api.list.IMusicListApi;
import cn.sxgan.core.http.RequestHolder;
import cn.sxgan.core.service.impl.MusicSongServiceImpl;
import cn.sxgan.core.service.impl.SongListServiceImpl;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
    
    @Resource
    MusicSongServiceImpl musicSongService;
    
    @GetMapping(value = "/getUserSongList")
    public ResponseResult<Map<String, List<MusicListVO>>> getUserSongList() {
        UserSessionInfo currentUser = RequestHolder.getCurrentUser();
        if (ObjectUtil.isEmpty(currentUser)) {
            return ResponseResult.fail(Maps.newHashMap(),
                    ExceptionStatus.EXCEPTION_STATUS_700.getExceptionCode(),
                    ExceptionStatus.EXCEPTION_STATUS_700.getExceptionMsg());
        }
        return songListService.getSongList(currentUser);
    }
    
    @PostMapping(value = "/getSongList")
    public ResponseResult<List<MusicSongVO>> getSongList(@RequestBody MusicListVO musicList) {
        if (musicList.getListId() == null) {
            return ResponseResult.fail(Lists.newArrayList(),
                    ExceptionStatus.EXCEPTION_STATUS_700.getExceptionCode(),
                    ExceptionStatus.EXCEPTION_STATUS_700.getExceptionMsg());
        }
        return musicSongService.getSongs(musicList);
    }
}
