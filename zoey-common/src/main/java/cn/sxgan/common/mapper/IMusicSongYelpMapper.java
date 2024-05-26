package cn.sxgan.common.mapper;

import cn.sxgan.common.entity.MusicSongYelp;
import cn.sxgan.common.entity.query.MusicSongYelpQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 歌曲评论表映射mapper
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Mapper
public interface IMusicSongYelpMapper extends BaseMapper<MusicSongYelp> {
    List<MusicSongYelp> selectMusicSongYelpByCondition(MusicSongYelpQuery query);
}