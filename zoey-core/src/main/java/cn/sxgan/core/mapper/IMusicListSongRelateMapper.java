package cn.sxgan.core.mapper;

import cn.sxgan.core.entity.MusicListSongRelate;
import cn.sxgan.core.entity.query.MusicListSongRelateQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 歌曲歌单关联表映射mapper
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Mapper
public interface IMusicListSongRelateMapper extends BaseMapper<MusicListSongRelate> {
    List<MusicListSongRelate> selectMusicListSongRelateByCondition(MusicListSongRelateQuery query);
}