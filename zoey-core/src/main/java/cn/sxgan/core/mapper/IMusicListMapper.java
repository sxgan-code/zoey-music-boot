package cn.sxgan.core.mapper;

import cn.sxgan.core.entity.MusicList;
import cn.sxgan.core.entity.query.MusicListQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 歌单表映射mapper
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Mapper
public interface IMusicListMapper extends BaseMapper<MusicList> {
    List<MusicList> selectMusicListByCondition(MusicListQuery query);
    
    List<MusicList> selectMusicListByPlayCount();
    
    List<MusicList> getRecommendPrivateMusicList();
}