package cn.sxgan.core.service;

import cn.sxgan.core.entity.SysUserVO;
import cn.sxgan.core.entity.UserSessionInfo;

/**
 * @Description: 用户服务接口
 * @Author: sxgan
 * @Date: 2023-12-17 20:39
 * @Version: 1.0
 **/

public interface IUserService {
    /**
     * 通过邮箱查询用户
     *
     * @param currentUser 当前登录用户
     * @return 视图对象
     */
    SysUserVO selectSysUserInfo(UserSessionInfo currentUser);
    
    /**
     * 通过邮箱更新用户
     *
     * @param sysUserVO
     * @return
     */
    String updateSysUserInfo(SysUserVO sysUserVO);
}
