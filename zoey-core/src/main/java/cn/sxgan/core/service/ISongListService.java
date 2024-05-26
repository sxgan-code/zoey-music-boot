package cn.sxgan.core.service;

import cn.sxgan.common.entity.UserSessionInfo;
import cn.sxgan.common.entity.vo.MusicListVO;
import cn.sxgan.common.response.ResponseResult;

import java.util.List;
import java.util.Map;

/**
 * @Description: 歌单服务接口
 * @Author: sxgan
 * @Date: 2024-04-17 13:32
 * @Version: 1.0
 **/

public interface ISongListService {
    /**
     * 获取用户歌单
     *
     * @return
     */
    ResponseResult<Map<String, List<MusicListVO>>> getSongList(UserSessionInfo userSessionInfo);
}
