package cn.sxgan.common.entity.converts;


import cn.sxgan.common.entity.MusicSong;
import cn.sxgan.common.entity.query.SearchSongQuery;
import cn.sxgan.common.entity.vo.MusicSongVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 歌曲表实体转换接口
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Mapper
public interface IMusicSongConvert {
    IMusicSongConvert INSTANCE = Mappers.getMapper(IMusicSongConvert.class);
    
    MusicSong convert(MusicSongVO vo);
    
    @Mapping(source = "musicSinger.singerName", target = "singerName")
    @Mapping(source = "musicAlbum.albumName", target = "albumName")
    SearchSongQuery convertQuery(MusicSongVO vo);
    
    @Mappings({
            @Mapping(source = "songId", target = "songId"),
    })
    MusicSongVO convert(MusicSong entity);
    
    List<MusicSongVO> convertList(List<MusicSong> list);
    
}