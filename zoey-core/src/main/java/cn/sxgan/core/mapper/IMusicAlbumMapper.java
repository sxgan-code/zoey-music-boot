package cn.sxgan.core.mapper;

import cn.sxgan.core.entity.MusicAlbum;
import cn.sxgan.core.entity.query.MusicAlbumQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 专辑表映射mapper
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Mapper
public interface IMusicAlbumMapper extends BaseMapper<MusicAlbum> {
    List<MusicAlbum> selectMusicAlbumByCondition(MusicAlbumQuery query);
}