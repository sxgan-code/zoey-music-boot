package cn.sxgan.common.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 专辑表视图对象
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Data
@Schema(name = "MusicAlbumVO", description = "专辑表")
public class MusicAlbumVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    
    @Schema(description = "专辑ID")
    private Long albumId;
    
    @Schema(description = "专辑名称")
    private String albumName;
    
    @Schema(description = "专辑图片地址")
    private String albumPic;
    
    @Schema(description = "专辑发行日期")
    private Date releaseDate;
    
    @Schema(description = "歌手ID")
    private Long singerId;
    
    @Schema(description = "删除标志：0-未删除，1-已删除")
    private Integer delFlag;
    
    @Schema(description = "创建时间")
    private Date createTime;
    
    @Schema(description = "更新时间")
    private Date updateTime;
    
    
}