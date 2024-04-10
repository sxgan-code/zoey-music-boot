package cn.sxgan.core.service.impl;


import cn.hutool.core.util.StrUtil;
import cn.sxgan.core.entity.SysUser;
import cn.sxgan.core.entity.SysUserQuery;
import cn.sxgan.core.entity.SysUserVO;
import cn.sxgan.core.entity.UserSessionInfo;
import cn.sxgan.core.entity.converts.SysUserConvert;
import cn.sxgan.core.mapper.SysUserMapper;
import cn.sxgan.core.service.IUserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 用户业务服务实现类
 * @Author: sxgan
 * @Date: 2024/3/1 15:35
 * @Version: 1.0
 **/
@Slf4j
@Service
public class UserServiceImpl implements IUserService {
    
    @Resource
    SysUserMapper userMapper;
    
    @Override
    public SysUserVO selectSysUserInfo(UserSessionInfo currentUser) {
        SysUserVO sysUserVO = new SysUserVO();
        if (currentUser == null || StrUtil.isBlank(currentUser.getEmail())) {
            return sysUserVO;
        }
        SysUserQuery sysUserQuery = new SysUserQuery();
        sysUserQuery.setEmail(currentUser.getEmail());
        List<SysUser> sysUsers = userMapper.selectUserByCondition(sysUserQuery);
        if (!sysUsers.isEmpty()) {
            sysUserVO = SysUserConvert.INSTANCE.sysUserToVO(sysUsers.getFirst());
        } else {
            return null;
        }
        return sysUserVO;
    }
}
