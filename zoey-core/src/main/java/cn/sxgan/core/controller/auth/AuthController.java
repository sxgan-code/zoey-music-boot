package cn.sxgan.core.controller.auth;


import cn.hutool.core.util.StrUtil;
import cn.sxgan.common.constant.ExceptionStatus;
import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.core.api.auth.IAuthControllerApi;
import cn.sxgan.core.entity.UserSessionInfo;
import cn.sxgan.core.service.impl.AuthServiceImpl;
import cn.sxgan.core.service.impl.MailSendServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description: 认证控制器
 * @Author: sxgan
 * @Date: 2024/3/1 21:27
 * @Version: 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/card/auth/")
public class AuthController implements IAuthControllerApi {

    @Resource
    MailSendServiceImpl mailSendService;

    @Resource
    AuthServiceImpl authService;

    @PostMapping("/signin")
    public ResponseResult<Map<String, String>> login(@RequestBody @Validated UserSessionInfo userSessionInfo) {
        return authService.userAuthByEmail(userSessionInfo);
    }

    @PostMapping("/signup")
    public ResponseResult<Map<String, String>> signup(@RequestBody UserSessionInfo userSessionInfo) {
        return authService.signupUserByEmail(userSessionInfo);
    }

    @PostMapping("/mailVerifyCode")
    public ResponseResult<String> sendVerifyCode(@RequestBody UserSessionInfo userSessionInfo) {
        String email = userSessionInfo.getEmail();
        if (StrUtil.isBlankIfStr(email)) {
            return ResponseResult.fail(ExceptionStatus.EXCEPTION_STATUS_900.getExceptionMsg());
        }
        String sendResult = mailSendService.sendVerifyCodeToSpecifiedEmail(email);
        return ResponseResult.success(sendResult);
    }
}