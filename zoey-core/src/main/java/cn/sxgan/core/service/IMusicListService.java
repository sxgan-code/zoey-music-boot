package cn.sxgan.core.service;

import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.core.entity.vo.RecommendVO;

/**
 * @Description: 歌单表服务接口
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
public interface IMusicListService {
    
    /**
     * 获取今日推荐
     */
    ResponseResult<RecommendVO> getTodayRecommend();
}