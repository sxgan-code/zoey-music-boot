package cn.sxgan.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 歌曲表实体类
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Data
@TableName(value = "music_song")
@Schema(name = "MusicSong", description = "歌曲表实体类")
public class MusicSong {
    /**
     * 歌曲ID
     */
    // 指定主键使用数据库ID自增策略
    @TableId(type = IdType.AUTO)
    @Schema(description = "歌曲ID", type = "Long")
    private Long songId;
    
    /**
     * 歌曲名称
     */
    @Schema(description = "歌曲名称", type = "String")
    private String songName;
    
    /**
     * 歌曲地址
     */
    @Schema(description = "歌曲地址", type = "String")
    private String songUrl;
    
    /**
     * 歌曲图片地址
     */
    @Schema(description = "歌曲图片地址", type = "String")
    private String songPic;
    
    public String getSongPic() {
        return songPic + "?time=" + System.currentTimeMillis();
    }
    
    /**
     * 歌词文件地址
     */
    @Schema(description = "歌词文件地址", type = "String")
    private String lyricUrl;
    
    /**
     * 歌曲风格
     */
    @Schema(description = "歌曲风格", type = "String")
    private String songStyle;
    
    /**
     * 歌曲发行时间
     */
    @Schema(description = "歌曲发行时间", type = "Date")
    private Date releaseDate;
    
    /**
     * 所属专辑
     */
    @Schema(description = "所属专辑", type = "Long")
    private Long albumId;
    
    /**
     * 歌手id
     */
    @Schema(description = "歌手id", type = "Long")
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
    
    @Schema(description = "歌手信息")
    @TableField(exist = false)
    private MusicSinger musicSinger;
    
    
    @Schema(description = "专辑信息")
    @TableField(exist = false)
    private MusicAlbum musicAlbum;
    
}