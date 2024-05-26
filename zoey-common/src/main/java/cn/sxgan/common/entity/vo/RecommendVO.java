package cn.sxgan.common.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description: 今日推荐实体VO
 * @Author: sxgan
 * @Date: 2024-05-08 21:06
 * @Version: 1.0
 **/
@Data
public class RecommendVO {
    // 今日推荐歌曲
    private MusicSongVO musicSongVO;
    // 推荐歌单列表
    private List<MusicListVO> musicListVOS;
}
