package cn.sxgan.admin.api.file;

import cn.sxgan.common.entity.MusicSong;
import cn.sxgan.common.entity.Page;
import cn.sxgan.common.entity.UserSessionInfo;
import cn.sxgan.common.response.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.Map;

/**
 * @Description: 文件管理控制器接口
 * @Author: sxgan
 * @Date: 2024-05-26 17:46
 * @Version: 1.0
 **/

public interface FileManageControllerApi {
    @Operation(summary = "登陆", description = "登陆接口",
            parameters = {
                    @Parameter(name = "userSessionInfo", description = "用户会话对象", content = @Content(mediaType = "application/json", schema = @Schema(contentSchema = UserSessionInfo.class)))
            },
            responses = {
                    @ApiResponse(description = "返回登录结果", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Map.class))),
                    @ApiResponse(responseCode = "700~800", description = "系统权限校验业务错误")
            })
    ResponseResult<Page<MusicSong>> getSongList(Page<MusicSong> page);
}
