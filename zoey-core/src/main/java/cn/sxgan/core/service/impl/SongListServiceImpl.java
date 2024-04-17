package cn.sxgan.core.service.impl;

import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.core.entity.UserSessionInfo;
import cn.sxgan.core.service.ISongListService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 歌单服务
 * @Author: sxgan
 * @Date: 2024-04-17 13:33
 * @Version: 1.0
 **/

@Service
public class SongListServiceImpl implements ISongListService {
    @Override
    public ResponseResult<List> getSongList(UserSessionInfo userSessionInfo) {
        return null;
    }
}
