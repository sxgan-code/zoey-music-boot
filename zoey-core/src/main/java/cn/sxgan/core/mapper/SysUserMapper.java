package cn.sxgan.core.mapper;

import cn.sxgan.core.entity.SysUser;
import cn.sxgan.core.entity.SysUserQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @Description: 用户mapper映射类
 * @Author: sxgan
 * @Date: 2024/3/4 13:52
 * @Version: 1.0
 **/
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> selectUserByCondition(SysUserQuery sysUserQuery);
}