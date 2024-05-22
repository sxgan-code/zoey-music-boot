package cn.sxgan.core.service.rpc;

import cn.sxgan.common.entity.UserSessionInfo;
import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.common.rpc.auth.IDubboAuthService;
import cn.sxgan.core.service.impl.AuthServiceImpl;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Map;

/**
 * @Description: rpc认证实现类
 * @Author: sxgan
 * @Date: 2024-05-23 00:55
 * @Version: 1.0
 **/
@DubboService(timeout = 3000, version = "v2.0.0")
public class DubboAuthService implements IDubboAuthService {
    
    @Resource
    AuthServiceImpl authService;
    
    @Override
    public ResponseResult<Map<String, String>> userAuthByEmail(UserSessionInfo userSessionInfo) {
        return authService.userAuthByEmail(userSessionInfo);
    }
}
