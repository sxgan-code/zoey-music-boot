package cn.sxgan.core.service.impl;

import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.core.entity.MusicList;
import cn.sxgan.core.entity.converts.IMusicListConvert;
import cn.sxgan.core.entity.vo.MusicListVO;
import cn.sxgan.core.entity.vo.RecommendVO;
import cn.sxgan.core.mapper.IMusicListMapper;
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
    
    @Override
    public ResponseResult<RecommendVO> getTodayRecommend() {
        List<MusicList> musicLists = iMusicListMapper.selectMusicListByPlayCount();
        List<MusicListVO> musicListVOS = IMusicListConvert.INSTANCE.convertList(musicLists);
        RecommendVO recommendVO = new RecommendVO();
        recommendVO.setMusicListVOS(musicListVOS);
        return ResponseResult.success(recommendVO);
    }
}