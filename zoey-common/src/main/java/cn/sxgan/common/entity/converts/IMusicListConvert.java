package cn.sxgan.common.entity.converts;


import cn.sxgan.common.entity.MusicList;
import cn.sxgan.common.entity.vo.MusicListVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 歌单表实体转换接口
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Mapper
public interface IMusicListConvert {
    IMusicListConvert INSTANCE = Mappers.getMapper(IMusicListConvert.class);
    
    MusicList convert(MusicListVO vo);
    
    MusicListVO convert(MusicList entity);
    
    List<MusicListVO> convertList(List<MusicList> list);
    
}