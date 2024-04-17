package cn.sxgan.core.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 歌单表视图对象
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Data
@Schema(name = "MusicListVO", description = "歌单表")
public class MusicListVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Schema(description = "歌单号")
    private Long listId;
    
    @Schema(description = "歌单名")
    private String listName;
    
    @Schema(description = "歌单类型: 1：创建，2：收藏，3创建及收藏")
    private Integer listType;
    
    @Schema(description = "歌单简介")
    private String listInfo;
    
    @Schema(description = "歌单风格")
    private String listStyle;
    
    @Schema(description = "歌单图片地址")
    private String listPic;
    
    @Schema(description = "所属用户")
    private Long userId;
    
    @Schema(description = "创建时间")
    private Date createTime;
    
    @Schema(description = "更新时间")
    private Date updateTime;
    
    
}