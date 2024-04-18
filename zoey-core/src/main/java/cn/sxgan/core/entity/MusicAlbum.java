package cn.sxgan.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 专辑表实体类
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Data
@TableName(value = "music_album")
@Schema(name = "MusicAlbum", description = "专辑表实体类")
public class MusicAlbum {
    /**
     * 专辑ID
     */
    // 指定主键使用数据库ID自增策略
    @TableId(type = IdType.AUTO)
    @Schema(description = "专辑ID", type = "Long")
    private Long albumId;
    
    /**
     * 专辑名称
     */
    @Schema(description = "专辑名称", type = "String")
    private String albumName;
    
    /**
     * 专辑图片地址
     */
    @Schema(description = "专辑图片地址", type = "String")
    private String albumPic;
    
    /**
     * 专辑发行日期
     */
    @Schema(description = "专辑发行日期", type = "Date")
    private Date releaseDate;
    
    /**
     * 歌手ID
     */
    @Schema(description = "歌手ID", type = "Long")
    private Long singerId;
    
    /**
     * 删除标志：0-未删除，1-已删除
     */
    @Schema(description = "删除标志：0-未删除，1-已删除", type = "Integer")
    private Integer delFlag;
    
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