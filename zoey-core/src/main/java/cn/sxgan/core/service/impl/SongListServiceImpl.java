package cn.sxgan.core.service.impl;

import cn.sxgan.common.constant.ExceptionStatus;
import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.core.entity.MusicList;
import cn.sxgan.core.entity.UserSessionInfo;
import cn.sxgan.core.entity.converts.IMusicListConvert;
import cn.sxgan.core.entity.query.MusicListQuery;
import cn.sxgan.core.entity.vo.MusicListVO;
import cn.sxgan.core.enums.MusicListTypeEnum;
import cn.sxgan.core.mapper.IMusicListMapper;
import cn.sxgan.core.service.ISongListService;
import com.google.common.collect.Maps;
import jakarta.annotation.Resource;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Description: 歌单服务
 * @Author: sxgan
 * @Date: 2024-04-17 13:33
 * @Version: 1.0
 **/

@Service
public class SongListServiceImpl implements ISongListService {
    
    @Resource
    IMusicListMapper iMusicListMapper;
    
    @Override
    public ResponseResult<Map<String, List<MusicListVO>>> getSongList(UserSessionInfo userSessionInfo) {
        if (userSessionInfo.getId() == null || userSessionInfo.getId() == -1) {
            return ResponseResult.fail(Maps.newHashMap(), ExceptionStatus.EXCEPTION_STATUS_900.getExceptionCode(),
                    ExceptionStatus.EXCEPTION_STATUS_900.getExceptionMsg());
        }
        // 查询用户的歌单
        MusicListQuery musicListQuery = new MusicListQuery();
        musicListQuery.setUserId(userSessionInfo.getId());
        List<MusicList> musicLists = Lists.newArrayList();
        musicLists = iMusicListMapper.selectMusicListByCondition(musicListQuery);
        Map<String, List<MusicListVO>> result = new HashMap<>();
        List<MusicListVO> musicListVOS = IMusicListConvert.INSTANCE.convertList(musicLists);
        // 创建的歌单
        List<MusicListVO> createList = musicListVOS.stream()
                .filter(musicList -> Objects.equals(musicList.getListType(), MusicListTypeEnum.CREATE.getType()))
                .toList();
        // 收藏的歌单
        List<MusicListVO> collectList = musicListVOS.stream()
                .filter(musicList -> Objects.equals(musicList.getListType(), MusicListTypeEnum.COLLECT.getType()))
                .toList();
        result.put("creates", createList);
        result.put("collects", collectList);
        return ResponseResult.success(result, musicLists.size());
    }
}
