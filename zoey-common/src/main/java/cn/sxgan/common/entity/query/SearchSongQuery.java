package cn.sxgan.common.entity.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 搜索歌曲
 * @Author: sxgan
 * @Date: 2024-06-04 20:19
 * @Version: 1.0
 **/
@Data
public class SearchSongQuery {
    /**
     * 歌曲名称
     */
    @Schema(description = "歌曲名称", type = "String")
    private String songName;
    
    @Schema(description = "歌手名")
    private String singerName;
    
    
    @Schema(description = "专辑名")
    private String albumName;
    /**
     * 歌曲发行时间
     */
    @Schema(description = "歌曲发行时间", type = "Date")
    private Date releaseDate;
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
