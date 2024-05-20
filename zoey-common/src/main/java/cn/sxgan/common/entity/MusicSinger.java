package cn.sxgan.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 歌手表实体类
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Data
@TableName(value = "music_singer")
@Schema(name = "MusicSinger", description = "歌手表实体类")
public class MusicSinger {
    /**
     * 歌手ID
     */
    // 指定主键使用数据库ID自增策略
    @TableId(type = IdType.AUTO)
    @Schema(description = "歌手ID", type = "Long")
    private Long singerId;
    
    /**
     * 歌手名称
     */
    @Schema(description = "歌手名称", type = "String")
    private String singerName;
    
    /**
     * 歌手图片地址
     */
    @Schema(description = "歌手图片地址", type = "String")
    private String singerPic;
    
    public String getSingerPic() {
        return singerPic + "?time=" + System.currentTimeMillis();
    }
    
    /**
     * 歌手所属地区
     */
    @Schema(description = "歌手所属地区", type = "String")
    private String address;
    
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