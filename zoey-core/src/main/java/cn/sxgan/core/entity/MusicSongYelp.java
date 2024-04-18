package cn.sxgan.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 歌曲评论表实体类
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Data
@TableName(value = "music_song_yelp")
@Schema(name = "MusicSongYelp", description = "歌曲评论表实体类")
public class MusicSongYelp {
    /**
     * 歌曲点评ID
     */
    // 指定主键使用数据库ID自增策略
    @TableId(type = IdType.AUTO)
    @Schema(description = "歌曲点评ID", type = "Long")
    private Long songYelpId;
    
    /**
     * 用户歌曲评论
     */
    @Schema(description = "用户歌曲评论", type = "String")
    private String yelpContent;
    
    /**
     * 用户ID
     */
    @Schema(description = "用户ID", type = "Long")
    private Long userId;
    
    /**
     * 歌曲ID
     */
    @Schema(description = "歌曲ID", type = "Long")
    private Long songId;
    
    /**
     * 是否喜欢: 1-喜欢，0-不喜欢
     */
    @Schema(description = "是否喜欢: 1-喜欢，0-不喜欢", type = "Integer")
    private Integer isLike;
    
    /**
     * 创建时间
     */
    @Schema(description = "创建时间", type = "Date")
    private Date createTime;
    
    /**
     * 更新时间
     */
    @Schema(description = "更新时间", type = "Date")
    private Date updateTime;
    
}