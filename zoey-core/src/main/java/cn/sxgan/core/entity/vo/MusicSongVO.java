package cn.sxgan.core.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 歌曲表视图对象
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Data
@Schema(name = "MusicSongVO", description = "歌曲表")
public class MusicSongVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Schema(description = "歌曲ID")
    private Long songId;
    
    @Schema(description = "歌曲名称")
    private String songName;
    
    @Schema(description = "歌曲地址")
    private String songUrl;
    
    @Schema(description = "歌曲图片地址")
    private String songPic;
    
    @Schema(description = "歌词文件地址")
    private String lyricUrl;
    
    @Schema(description = "歌曲风格")
    private String songStyle;
    
    @Schema(description = "歌曲发行时间")
    private Date releaseDate;
    
    @Schema(description = "所属专辑")
    private String albumId;
    
    @Schema(description = "歌手id")
    private String singerId;
    
    @Schema(description = "删除标志：0-未删除，1-已删除")
    private Integer delFlag;
    
    @Schema(description = "创建时间")
    private Date createTime;
    
    @Schema(description = "更新时间")
    private Date updateTime;
    
    
}