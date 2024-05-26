package cn.sxgan.core.service.impl;

import cn.sxgan.common.entity.MusicList;
import cn.sxgan.common.entity.MusicSong;
import cn.sxgan.common.entity.converts.IMusicListConvert;
import cn.sxgan.common.entity.converts.IMusicSongConvert;
import cn.sxgan.common.entity.vo.MusicListVO;
import cn.sxgan.common.entity.vo.MusicSongVO;
import cn.sxgan.common.entity.vo.RecommendVO;
import cn.sxgan.common.mapper.IMusicListMapper;
import cn.sxgan.common.mapper.IMusicSongMapper;
import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.core.service.IMusicListService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 歌单表服务实现类
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Service
@AllArgsConstructor
public class MusicListServiceImpl implements IMusicListService {
    
    @Resource
    IMusicListMapper iMusicListMapper;
    
    @Resource
    IMusicSongMapper iMusicSongMapper;
    
    @Override
    public ResponseResult<RecommendVO> getTodayRecommend() {
        RecommendVO recommendVO = new RecommendVO();
        // 获取猜你喜欢歌曲，
        MusicSong musicSong = iMusicSongMapper.randomSelectSong();
        MusicSongVO musicSongVO = IMusicSongConvert.INSTANCE.convert(musicSong);
        recommendVO.setMusicSongVO(musicSongVO);
        // 获取今日推荐歌单
        List<MusicList> musicLists = iMusicListMapper.selectMusicListByPlayCount();
        List<MusicListVO> musicListVOS = IMusicListConvert.INSTANCE.convertList(musicLists);
        
        recommendVO.setMusicListVOS(musicListVOS);
        return ResponseResult.success(recommendVO);
    }
    
    @Override
    public ResponseResult<List<MusicListVO>> getRecommendPrivateMusicList() {
        List<MusicList> musicLists = iMusicListMapper.getRecommendPrivateMusicList();
        return ResponseResult.success(IMusicListConvert.INSTANCE.convertList(musicLists));
    }
}