package cn.sxgan.core.controller.online;

import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.core.api.online.IRecommendControllerApi;
import cn.sxgan.core.entity.vo.MusicListVO;
import cn.sxgan.core.entity.vo.RecommendVO;
import cn.sxgan.core.service.IMusicListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 在线音乐模块-推荐
 * @Author: sxgan
 * @Date: 2024-05-08 21:01
 * @Version: 1.0
 **/
@RestController
@RequestMapping(value = "/online")
public class RecommendController implements IRecommendControllerApi {
    
    @Autowired
    IMusicListService iMusicListService;
    
    @Override
    @GetMapping(value = "/today/recommend")
    public ResponseResult<RecommendVO> getTodayRecommend() {
        return iMusicListService.getTodayRecommend();
    }
    
    @Override
    @GetMapping(value = "/private/list")
    public ResponseResult<List<MusicListVO>> getRecommendPrivateMusicList() {
        return iMusicListService.getRecommendPrivateMusicList();
    }
    
    
}
