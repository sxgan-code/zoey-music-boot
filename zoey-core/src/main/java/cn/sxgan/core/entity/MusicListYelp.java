package cn.sxgan.core.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 歌单评论表实体类
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Data
@TableName(value = "music_list_yelp")
@Schema(name = "MusicListYelp", description = "歌单评论表实体类")
public class MusicListYelp {
    /**
     * 歌单点评ID
     */
    @TableId
    @Schema(description = "歌单点评ID", type = "Long")
    private Long listYelpId;
    
    /**
     * 用户歌单评论
     */
    @Schema(description = "用户歌单评论", type = "String")
    private String yelpContent;
    
    /**
     * 用户ID
     */
    @Schema(description = "用户ID", type = "Long")
    private Long userId;
    
    /**
     * 歌单号
     */
    @Schema(description = "歌单号", type = "Long")
    private Long listId;
    
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