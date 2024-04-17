package cn.sxgan.core.entity.converts;


import cn.sxgan.core.entity.MusicSong;
import cn.sxgan.core.entity.vo.MusicSongVO;
import org.mapstruct.Mapper;
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
    
    MusicSongVO convert(MusicSong entity);
    
    List<MusicSongVO> convertList(List<MusicSong> list);
    
}