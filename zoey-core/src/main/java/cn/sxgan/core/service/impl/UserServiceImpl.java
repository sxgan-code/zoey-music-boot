package cn.sxgan.core.service.impl;


import cn.hutool.core.util.StrUtil;
import cn.sxgan.common.entity.SysUser;
import cn.sxgan.common.entity.SysUserVO;
import cn.sxgan.common.entity.UserSessionInfo;
import cn.sxgan.common.entity.converts.SysUserConvert;
import cn.sxgan.common.entity.query.SysUserQuery;
import cn.sxgan.common.mapper.SysUserMapper;
import cn.sxgan.core.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
    
    @Override
    public String updateSysUserInfo(SysUserVO sysUserVO) {
        if (sysUserVO == null || StrUtil.isBlank(sysUserVO.getEmail())) {
            return null;
        }
        SysUser sysUser = SysUserConvert.INSTANCE.sysUserVOToDAO(sysUserVO);
        
        int bool = userMapper.update(sysUser,
                new UpdateWrapper<SysUser>()
                        .eq("email", sysUser.getEmail())
                        .set("user_name", sysUser.getUserName())
                        .set("personal_sign", sysUser.getPersonalSign()));
        return bool > 0 ? "用户更新完成" : null;
    }
}
