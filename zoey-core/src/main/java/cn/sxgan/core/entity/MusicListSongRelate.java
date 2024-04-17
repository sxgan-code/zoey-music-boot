package cn.sxgan.core.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 歌曲歌单关联表实体类
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Data
@TableName(value = "music_list_song_relate")
@Schema(name = "MusicListSongRelate", description = "歌曲歌单关联表实体类")
public class MusicListSongRelate {
    /**
     * 歌曲歌单关联id
     */
    @TableId
    @Schema(description = "歌曲歌单关联id", type = "Long")
    private Long listSongId;
    
    /**
     * 歌单号
     */
    @Schema(description = "歌单号", type = "Long")
    private Long listId;
    
    /**
     * 歌曲ID
     */
    @Schema(description = "歌曲ID", type = "Long")
    private Long songId;
    
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