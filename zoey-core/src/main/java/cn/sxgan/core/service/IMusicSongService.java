package cn.sxgan.core.service;

import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.core.entity.vo.MusicListVO;
import cn.sxgan.core.entity.vo.MusicSongVO;

import java.util.List;

/**
 * @Description: 歌曲表服务接口
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
public interface IMusicSongService {
    /**
     * 获取歌曲列表通过歌单号
     *
     * @param musicListVO 歌单视图对象
     * @return 歌曲列表
     */
    ResponseResult<List<MusicSongVO>> getSongs(MusicListVO musicListVO);
}