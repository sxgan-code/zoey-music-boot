package cn.sxgan.core.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 歌曲评论表视图对象
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Data
@Schema(name = "MusicSongYelpVO", description = "歌曲评论表")
public class MusicSongYelpVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Schema(description = "歌曲点评ID")
    private Long songYelpId;
    
    @Schema(description = "用户歌曲评论")
    private String yelpContent;
    
    @Schema(description = "用户ID")
    private Long userId;
    
    @Schema(description = "歌曲ID")
    private Long songId;
    
    @Schema(description = "是否喜欢: 1-喜欢，0-不喜欢")
    private Integer isLike;
    
    @Schema(description = "创建时间")
    private Date createTime;
    
    @Schema(description = "更新时间")
    private Date updateTime;
    
    
}