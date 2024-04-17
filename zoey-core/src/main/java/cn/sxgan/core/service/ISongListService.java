package cn.sxgan.core.service;

import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.core.entity.UserSessionInfo;

import java.util.List;

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
    ResponseResult<List> getSongList(UserSessionInfo userSessionInfo);
}
