package cn.sxgan.core.service.impl;

import cn.sxgan.common.entity.MusicSongYelp;
import cn.sxgan.common.entity.UserSessionInfo;
import cn.sxgan.common.entity.converts.IMusicSongYelpConvert;
import cn.sxgan.common.entity.query.MusicSongYelpQuery;
import cn.sxgan.common.entity.vo.MusicSongYelpVO;
import cn.sxgan.common.mapper.IMusicSongYelpMapper;
import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.core.http.RequestHolder;
import cn.sxgan.core.service.IMusicSongYelpService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 歌曲评论表服务实现类
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Service
@AllArgsConstructor
public class MusicSongYelpServiceImpl implements IMusicSongYelpService {
    
    @Resource
    IMusicSongYelpMapper musicSongYelpMapper;
    
    @Override
    public List<MusicSongYelp> getSongYelpByUserId(UserSessionInfo userSessionInfo) {
        MusicSongYelpQuery musicSongYelpQuery = new MusicSongYelpQuery();
        musicSongYelpQuery.setUserId(userSessionInfo.getId());
        return musicSongYelpMapper.selectMusicSongYelpByCondition(musicSongYelpQuery);
    }
    
    @Override
    public void addSongYelp(MusicSongYelp musicSongYelp) {
        UserSessionInfo currentUser = RequestHolder.getCurrentUser();
        musicSongYelpMapper.insert(musicSongYelp);
        musicSongYelpMapper.update(musicSongYelp, new UpdateWrapper<MusicSongYelp>().set("user_id", currentUser.getId()));
    }
    
    @Override
    public ResponseResult<String> updateSongYelp(MusicSongYelpVO musicSongYelpVO) {
        MusicSongYelp musicSongYelp = IMusicSongYelpConvert.INSTANCE.convert(musicSongYelpVO);
        UserSessionInfo currentUser = RequestHolder.getCurrentUser();
        MusicSongYelpQuery musicSongYelpQuery = new MusicSongYelpQuery();
        musicSongYelpQuery.setUserId(currentUser.getId());
        musicSongYelpQuery.setSongId(musicSongYelp.getSongId());
        List<MusicSongYelp> musicSongYelps = musicSongYelpMapper.selectMusicSongYelpByCondition(musicSongYelpQuery);
        int result = 0;
        if (!musicSongYelps.isEmpty()) {
            UpdateWrapper<MusicSongYelp> updateWrapper = new UpdateWrapper<MusicSongYelp>();
            updateWrapper.eq("user_id", currentUser.getId()) // 添加第一个条件
                    .eq("song_id", musicSongYelp.getSongId()) // 添加第二个条件
                    .set("is_like", musicSongYelp.getIsLike()); // 设置更新的字段
            
            result = musicSongYelpMapper.update(updateWrapper);
            if (result > 0) {
                return ResponseResult.success("插入评论成功");
            }
        } else {
            musicSongYelp.setUserId(currentUser.getId());
            result = musicSongYelpMapper.insert(musicSongYelp);
            if (result > 0) {
                return ResponseResult.success("更新评论成功");
            }
        }
        return ResponseResult.fail("更新评论失败");
    }
}