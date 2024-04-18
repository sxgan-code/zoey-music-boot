package cn.sxgan.core.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 歌单评论表视图对象
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Data
@Schema(name = "MusicListYelpVO", description = "歌单评论表")
public class MusicListYelpVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    
    @Schema(description = "歌单点评ID")
    private Long listYelpId;
    
    @Schema(description = "用户歌单评论")
    private String yelpContent;
    
    @Schema(description = "用户ID")
    private Long userId;
    
    @Schema(description = "歌单号")
    private Long listId;
    
    @Schema(description = "创建时间")
    private Date createTime;
    
    @Schema(description = "更新时间")
    private Date updateTime;
    
    
}