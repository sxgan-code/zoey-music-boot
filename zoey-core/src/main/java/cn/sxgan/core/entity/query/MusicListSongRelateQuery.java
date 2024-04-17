package cn.sxgan.core.entity.query;

import cn.sxgan.core.entity.MusicListSongRelate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Description: 歌曲歌单关联表查询类
 * @Author: sxgan
 * @Date: 2024/3/1 15:11
 * @Version: 1.0
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class MusicListSongRelateQuery extends MusicListSongRelate {
    private Date createStartDate;
    private Date createEndDate;
    private Date updateStartDate;
    private Date updateEndDate;
}