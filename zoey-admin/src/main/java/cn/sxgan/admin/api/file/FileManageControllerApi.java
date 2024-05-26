package cn.sxgan.admin.api.file;

import cn.sxgan.common.entity.Page;
import cn.sxgan.common.entity.vo.MusicSongVO;
import cn.sxgan.common.response.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

/**
 * @Description: 文件管理控制器接口
 * @Author: sxgan
 * @Date: 2024-05-26 17:46
 * @Version: 1.0
 **/
@Tag(name = "文件管理API", description = "文件管理")
public interface FileManageControllerApi {
    @Operation(summary = "获取所有歌曲文件", description = "获取所有歌曲文件",
            parameters = {
                    @Parameter(name = "page", description = "分页对象", content = @Content(mediaType = "application/json", schema = @Schema(contentSchema = Page.class)))
            },
            responses = {
                    @ApiResponse(description = "返回查询列表结果", content = @Content(mediaType = "application/json", schema = @Schema(implementation = List.class))),
                    @ApiResponse(responseCode = "700~800", description = "系统权限校验业务错误")
            })
    ResponseResult<Page<MusicSongVO>> getSongList(Page<MusicSongVO> page);
}
