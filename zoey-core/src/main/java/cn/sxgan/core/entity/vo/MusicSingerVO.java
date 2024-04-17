package cn.sxgan.core.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 歌手表视图对象
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Data
@Schema(name = "MusicSingerVO", description = "歌手表")
public class MusicSingerVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Schema(description = "歌手ID")
    private Long singerId;
    
    @Schema(description = "歌手名称")
    private String singerName;
    
    @Schema(description = "歌手图片地址")
    private String singerPic;
    
    @Schema(description = "歌手所属地区")
    private String address;
    
    @Schema(description = "删除标志：0-未删除，1-已删除")
    private Integer delFlag;
    
    @Schema(description = "创建时间")
    private Date createTime;
    
    @Schema(description = "更新时间")
    private Date updateTime;
    
    
}