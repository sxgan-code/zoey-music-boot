package cn.sxgan.core.api.auth;


import cn.sxgan.common.entity.UserSessionInfo;
import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.core.entity.SysUserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Map;

/**
 * @Description: 认证相关接口API
 * @Author: sxgan
 * @Date: 2024/3/1 21:21
 * @Version: 1.0
 **/

@Tag(name = "认证接口API", description = "系统权限校验接口")
public interface IAuthControllerApi {

    @Operation(summary = "登陆", description = "登陆接口",
            parameters = {
                    @Parameter(name = "userSessionInfo", description = "用户会话对象", content = @Content(mediaType = "application/json", schema = @Schema(contentSchema = UserSessionInfo.class)))
            },
            responses = {
                    @ApiResponse(description = "返回登录结果", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Map.class))),
                    @ApiResponse(responseCode = "700~800", description = "系统权限校验业务错误")
            })
    ResponseResult<Map<String, String>> signin(UserSessionInfo userSessionInfo);

    @Operation(summary = "注册", description = "注册接口",
            parameters = {
                    @Parameter(name = "userSessionInfo", description = "用户会话对象", content = @Content(mediaType = "application/json", schema = @Schema(contentSchema = UserSessionInfo.class)))
            },
            responses = {
                    @ApiResponse(description = "返回注册结果", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Map.class))),
                    @ApiResponse(responseCode = "400", description = "返回400时错误")
            })
    ResponseResult<Map<String, String>> signup(UserSessionInfo userSessionInfo);

    @Operation(summary = "验证码", description = "请求邮箱验证码",
            parameters = {
                    @Parameter(name = "userSessionInfo", description = "用户会话对象", content = @Content(mediaType = "application/json", schema = @Schema(contentSchema = UserSessionInfo.class)))
            },
            responses = {
                    @ApiResponse(description = "返回验证码", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Map.class))),
                    @ApiResponse(responseCode = "400", description = "返回400时错误")
            })
    ResponseResult<String> sendVerifyCode(UserSessionInfo userSessionInfo);
    
    @Operation(summary = "获取用户", description = "获取用户详细信息",
            responses = {
                    @ApiResponse(description = "返回用户信息视图对象", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SysUserVO.class))),
                    @ApiResponse(responseCode = "700", description = "返回700时错误")
            })
    ResponseResult<SysUserVO> getSysUserInfo();
    
    @Operation(summary = "更新用户", description = "更新用户",
            parameters = {
                    @Parameter(name = "sysUserVO", description = "用户信息视图对象", content = @Content(mediaType = "application/json", schema = @Schema(contentSchema = SysUserVO.class)))
            },
            responses = {
                    @ApiResponse(description = "返回提示信息", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
                    @ApiResponse(responseCode = "707", description = "返回707时错误")
            })
    ResponseResult<String> updateSysUserInfo(SysUserVO sysUserVO);
}
