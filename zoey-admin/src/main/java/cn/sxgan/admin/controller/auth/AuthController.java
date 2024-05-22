package cn.sxgan.admin.controller.auth;

import cn.sxgan.common.entity.UserSessionInfo;
import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.common.rpc.auth.IDubboAuthService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description: 后台管理认证接口
 * @Author: sxgan
 * @Date: 2024-05-23 00:27
 * @Version: 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/admin/auth/")
public class AuthController {
    
    @DubboReference(version = "v2.0.0")
    IDubboAuthService iDubboAuthService;
    
    @PostMapping("/signin")
    public ResponseResult<Map<String, String>> signin(@RequestBody @Validated UserSessionInfo userSessionInfo) {
        return iDubboAuthService.userAuthByEmail(userSessionInfo);
    }
}
