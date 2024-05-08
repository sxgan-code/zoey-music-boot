package cn.sxgan.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 歌单表实体类
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Data
@TableName(value = "music_list")
@Schema(name = "MusicList", description = "歌单表实体类")
public class MusicList {
    /**
     * 歌单号
     */
    // 指定主键使用数据库ID自增策略
    @TableId(type = IdType.AUTO)
    @Schema(description = "歌单号", type = "Long")
    private Long listId;
    
    /**
     * 歌单名
     */
    @Schema(description = "歌单名", type = "String")
    private String listName;
    
    /**
     * 歌单类型: 1：创建，2：收藏，3创建及收藏
     */
    @Schema(description = "歌单类型: 1：创建，2：收藏，3创建及收藏", type = "Integer")
    private Integer listType;
    
    /**
     * 歌单简介
     */
    @Schema(description = "歌单简介", type = "String")
    private String listInfo;
    
    /**
     * 歌单风格
     */
    @Schema(description = "歌单风格", type = "String")
    private String listStyle;
    
    /**
     * 歌单图片地址
     */
    @Schema(description = "歌单图片地址", type = "String")
    private String listPic;
    
    /**
     * 歌单播放次数
     */
    @Schema(description = "歌单播放次数", type = "Long")
    private Long playCount;
    
    /**
     * 所属用户
     */
    @Schema(description = "所属用户", type = "Long")
    private Long userId;
    
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