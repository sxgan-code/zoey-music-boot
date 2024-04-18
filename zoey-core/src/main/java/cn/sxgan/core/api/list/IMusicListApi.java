package cn.sxgan.core.api.list;

import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.core.entity.vo.MusicListVO;
import cn.sxgan.core.entity.vo.MusicSongVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
                    @ApiResponse(
                            description = "返回用户歌单列表",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Map.class))),
                    @ApiResponse(responseCode = "700~800", description = "系统业务错误")
            })
    ResponseResult<Map<String, List<MusicListVO>>> getUserSongList();
    
    @Operation(summary = "歌曲列表", description = "通过歌单号查询当前歌单歌曲",
            parameters = {
                    @Parameter(
                            name = "musicList",
                            description = "歌曲列表视图对象",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(contentSchema = MusicListVO.class)))},
            responses = {
                    @ApiResponse(
                            description = "返回歌曲列表",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = List.class))),
                    @ApiResponse(responseCode = "700~800", description = "系统业务错误")
            })
    ResponseResult<List<MusicSongVO>> getSongList(MusicListVO musicList);
}
