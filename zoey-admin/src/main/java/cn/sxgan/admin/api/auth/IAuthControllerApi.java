package cn.sxgan.admin.api.auth;

import cn.sxgan.common.entity.UserSessionInfo;
import cn.sxgan.common.response.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @Description: 认证服务控制器接口
 * @Author: sxgan
 * @Date: 2024-05-26 22:50
 * @Version: 1.0
 **/
@Tag(name = "认证服务控制器接口", description = "认证服务控制器接口")
public interface IAuthControllerApi {
    @Operation(summary = "登录", description = "登录",
            parameters = {
                    @Parameter(name = "userSessionInfo", description = "用户会话对象", content = @Content(mediaType = "application/json", schema = @Schema(contentSchema = UserSessionInfo.class)))
            },
            responses = {
                    @ApiResponse(description = "返回登录结果", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Map.class))),
                    @ApiResponse(responseCode = "700~800", description = "系统权限校验业务错误")
            })
    ResponseResult<Map<String, String>> signin(@RequestBody @Validated UserSessionInfo userSessionInfo);
}
