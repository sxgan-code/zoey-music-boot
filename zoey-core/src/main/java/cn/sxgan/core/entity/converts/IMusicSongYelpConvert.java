package cn.sxgan.core.entity.converts;


import cn.sxgan.core.entity.MusicSongYelp;
import cn.sxgan.core.entity.vo.MusicSongYelpVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 歌曲评论表实体转换接口
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Mapper
public interface IMusicSongYelpConvert {
    IMusicSongYelpConvert INSTANCE = Mappers.getMapper(IMusicSongYelpConvert.class);
    
    MusicSongYelp convert(MusicSongYelpVO vo);
    
    MusicSongYelpVO convert(MusicSongYelp entity);
    
    List<MusicSongYelpVO> convertList(List<MusicSongYelp> list);
    
}