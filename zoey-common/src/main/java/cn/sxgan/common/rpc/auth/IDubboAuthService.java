package cn.sxgan.common.rpc.auth;

import cn.sxgan.common.entity.UserSessionInfo;
import cn.sxgan.common.response.ResponseResult;

import java.util.Map;

/**
 * @Description: 远程认证调用接口
 * @Author: sxgan
 * @Date: 2024-05-22 20:18
 * @Version: 1.0
 **/

public interface IDubboAuthService {
    /**
     * 通过邮箱验证用户
     *
     * @param userSessionInfo 当前登录用户
     * @return 存在返回用户
     */
    ResponseResult<Map<String, String>> userAuthByEmail(UserSessionInfo userSessionInfo);
}
