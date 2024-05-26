package cn.sxgan.common.entity.converts;


import cn.sxgan.common.entity.MusicListYelp;
import cn.sxgan.common.entity.vo.MusicListYelpVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 歌单评论表实体转换接口
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Mapper
public interface IMusicListYelpConvert {
    IMusicListYelpConvert INSTANCE = Mappers.getMapper(IMusicListYelpConvert.class);
    
    MusicListYelp convert(MusicListYelpVO vo);
    
    MusicListYelpVO convert(MusicListYelp entity);
    
    List<MusicListYelpVO> convertList(List<MusicListYelp> list);
    
}