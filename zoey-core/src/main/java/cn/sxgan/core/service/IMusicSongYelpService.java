package cn.sxgan.core.service;

import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.core.entity.MusicSongYelp;
import cn.sxgan.core.entity.UserSessionInfo;
import cn.sxgan.core.entity.vo.MusicSongYelpVO;

import java.util.List;

/**
 * @Description: 歌曲评论表服务接口
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
public interface IMusicSongYelpService {
    /**
     * 根据用户id查询用户点评的所有歌曲
     *
     * @param userSessionInfo
     * @return
     */
    List<MusicSongYelp> getSongYelpByUserId(UserSessionInfo userSessionInfo);
    
    /**
     * 用户添加点评
     *
     * @param musicSongYelp
     */
    void addSongYelp(MusicSongYelp musicSongYelp);
    
    /**
     * 用户更新点评
     *
     * @param musicSongYelpVO
     */
    ResponseResult<String> updateSongYelp(MusicSongYelpVO musicSongYelpVO);
}