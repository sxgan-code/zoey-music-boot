package cn.sxgan.core.service.impl;

import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.core.entity.MusicSong;
import cn.sxgan.core.entity.MusicSongYelp;
import cn.sxgan.core.entity.UserSessionInfo;
import cn.sxgan.core.entity.converts.IMusicSongConvert;
import cn.sxgan.core.entity.query.MusicListQuery;
import cn.sxgan.core.entity.vo.MusicListVO;
import cn.sxgan.core.entity.vo.MusicSongVO;
import cn.sxgan.core.http.RequestHolder;
import cn.sxgan.core.mapper.IMusicListSongRelateMapper;
import cn.sxgan.core.mapper.IMusicSongMapper;
import cn.sxgan.core.service.IMusicSongService;
import com.google.common.collect.Lists;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 歌曲表服务实现类
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Service
@AllArgsConstructor
public class MusicSongServiceImpl implements IMusicSongService {
    
    @Resource
    IMusicListSongRelateMapper iMusicListSongRelateMapper;
    
    @Resource
    IMusicSongMapper musicSongMapper;
    
    @Resource
    MusicSongYelpServiceImpl musicSongYelpService;
    
    @Override
    public ResponseResult<List<MusicSongVO>> getSongs(MusicListVO musicListVO) {
        Long listId = musicListVO.getListId();
        // 查询关联歌曲列表
        MusicListQuery musicListQuery = new MusicListQuery();
        musicListQuery.setListId(listId);
        List<MusicSong> musicSongs = Lists.newArrayList();
        musicSongs = musicSongMapper.selectSongBySongListId(musicListQuery);
        // 转换为VO
        List<MusicSongVO> musicSongVOS = IMusicSongConvert.INSTANCE.convertList(musicSongs);
        
        // 查询当前歌单用户喜欢状态
        musicSongVOS.forEach(item -> item.setIsLike(0));
        UserSessionInfo currentUser = RequestHolder.getCurrentUser();
        List<MusicSongYelp> songYelps = musicSongYelpService.getSongYelpByUserId(currentUser);
        songYelps.forEach(item -> {
            musicSongVOS.forEach(musicSongVO -> {
                if (musicSongVO.getSongId().equals(item.getSongId())) {
                    musicSongVO.setIsLike(item.getIsLike());
                }
            });
        });
        return ResponseResult.success(musicSongVOS, musicSongVOS.size());
    }
}