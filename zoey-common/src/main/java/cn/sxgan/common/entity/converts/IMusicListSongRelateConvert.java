package cn.sxgan.common.entity.converts;


import cn.sxgan.common.entity.MusicListSongRelate;
import cn.sxgan.common.entity.vo.MusicListSongRelateVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 歌曲歌单关联表实体转换接口
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Mapper
public interface IMusicListSongRelateConvert {
    IMusicListSongRelateConvert INSTANCE = Mappers.getMapper(IMusicListSongRelateConvert.class);
    
    MusicListSongRelate convert(MusicListSongRelateVO vo);
    
    MusicListSongRelateVO convert(MusicListSongRelate entity);
    
    List<MusicListSongRelateVO> convertList(List<MusicListSongRelate> list);
    
}