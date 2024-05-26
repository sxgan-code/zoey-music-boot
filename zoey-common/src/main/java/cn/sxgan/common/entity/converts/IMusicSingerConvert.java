package cn.sxgan.common.entity.converts;


import cn.sxgan.common.entity.MusicSinger;
import cn.sxgan.common.entity.vo.MusicSingerVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 歌手表实体转换接口
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Mapper
public interface IMusicSingerConvert {
    IMusicSingerConvert INSTANCE = Mappers.getMapper(IMusicSingerConvert.class);
    
    MusicSinger convert(MusicSingerVO vo);
    
    MusicSingerVO convert(MusicSinger entity);
    
    List<MusicSingerVO> convertList(List<MusicSinger> list);
    
}