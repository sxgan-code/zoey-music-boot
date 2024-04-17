package cn.sxgan.core.api.list;

import cn.sxgan.common.response.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Map;

/**
 * @Description: 音乐列表相关API
 * @Author: sxgan
 * @Date: 2024-04-17 13:20
 * @Version: 1.0
 **/
@Tag(name = "音乐列表API", description = "我的音乐、个人歌单等列表API")
public interface IMusicListApi {
    
    @Operation(summary = "歌单", description = "用户歌单接口",
            responses = {
                    @ApiResponse(description = "返回用户歌单列表", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Map.class))),
                    @ApiResponse(responseCode = "700~800", description = "系统业务错误")
            })
    ResponseResult<List> getUserSongList();
}
