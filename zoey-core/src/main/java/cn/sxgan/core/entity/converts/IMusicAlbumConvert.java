package cn.sxgan.core.entity.converts;


import cn.sxgan.common.entity.MusicAlbum;
import cn.sxgan.core.entity.vo.MusicAlbumVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 专辑表实体转换接口
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Mapper
public interface IMusicAlbumConvert {
    IMusicAlbumConvert INSTANCE = Mappers.getMapper(IMusicAlbumConvert.class);
    
    MusicAlbum convert(MusicAlbumVO vo);
    
    MusicAlbumVO convert(MusicAlbum entity);
    
    List<MusicAlbumVO> convertList(List<MusicAlbum> list);
    
}