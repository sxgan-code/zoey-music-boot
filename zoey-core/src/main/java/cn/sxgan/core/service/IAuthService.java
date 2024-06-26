package cn.sxgan.core.service;


import cn.sxgan.common.entity.UserSessionInfo;
import cn.sxgan.common.response.ResponseResult;

import java.util.Map;

public interface IAuthService {
    /**
     * 通过邮箱验证用户
     *
     * @param userSessionInfo 当前登录用户
     * @return 存在返回用户
     */
    ResponseResult<Map<String, String>> userAuthByEmail(UserSessionInfo userSessionInfo);
    
    /**
     * 通过邮箱注册用户
     *
     * @param userSessionInfo 当前登录用户
     * @return 提示消息
     */
    ResponseResult<Map<String, String>> signupUserByEmail(UserSessionInfo userSessionInfo);
}
