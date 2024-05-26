package cn.sxgan.common.mapper;

import cn.sxgan.common.entity.MusicListSongRelate;
import cn.sxgan.common.entity.query.MusicListSongRelateQuery;
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