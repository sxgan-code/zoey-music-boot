package cn.sxgan.core.mapper;

import cn.sxgan.core.entity.MusicListYelp;
import cn.sxgan.core.entity.query.MusicListYelpQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 歌单评论表映射mapper
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Mapper
public interface IMusicListYelpMapper extends BaseMapper<MusicListYelp> {
    List<MusicListYelp> selectMusicListYelpByCondition(MusicListYelpQuery query);
}