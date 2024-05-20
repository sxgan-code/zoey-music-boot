package cn.sxgan.core.enums;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @Description: 歌单类型枚举，歌单类型: 1：创建，2：收藏，3：喜欢，4：最近播放
 * @Author: sxgan
 * @Date: 2024-04-17 23:16
 * @Version: 1.0
 **/

@Getter
@AllArgsConstructor
public enum MusicListTypeEnum {
    // 账户异常
    @Schema(description = "创建")
    CREATE(1),
    @Schema(description = "收藏")
    COLLECT(2),
    @Schema(description = "我喜欢")
    LOVE(3),
    @Schema(description = "最近播放")
    PLAYED(4);
    
    public static final List<MusicListTypeEnum> MUSIC_LIST_TYPE_ALL = List.of(CREATE, COLLECT);
    
    /* exception code*/
    private final Integer type;
    
}
