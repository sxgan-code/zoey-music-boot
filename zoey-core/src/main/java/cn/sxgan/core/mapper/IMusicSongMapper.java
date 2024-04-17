package cn.sxgan.core.mapper;

import cn.sxgan.core.entity.MusicSong;
import cn.sxgan.core.entity.query.MusicSongQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 歌曲表映射mapper
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Mapper
public interface IMusicSongMapper extends BaseMapper<MusicSong> {
    List<MusicSong> selectMusicSongByCondition(MusicSongQuery query);
}