package cn.sxgan.common.mapper;

import cn.sxgan.common.entity.MusicSong;
import cn.sxgan.common.entity.query.MusicListQuery;
import cn.sxgan.common.entity.query.MusicSongQuery;
import cn.sxgan.common.entity.query.SearchSongQuery;
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
    
    List<MusicSong> selectSongBySongListId(MusicListQuery query);
    
    List<MusicSong> searchSongByCondition(SearchSongQuery query);
    
    MusicSong randomSelectSong();
}