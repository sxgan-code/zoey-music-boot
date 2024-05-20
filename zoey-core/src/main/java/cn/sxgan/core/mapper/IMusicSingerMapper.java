package cn.sxgan.core.mapper;

import cn.sxgan.common.entity.MusicSinger;
import cn.sxgan.core.entity.query.MusicSingerQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 歌手表映射mapper
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Mapper
public interface IMusicSingerMapper extends BaseMapper<MusicSinger> {
    List<MusicSinger> selectMusicSingerByCondition(MusicSingerQuery query);
}