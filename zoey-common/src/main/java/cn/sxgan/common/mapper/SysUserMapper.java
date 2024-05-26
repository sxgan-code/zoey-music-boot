package cn.sxgan.common.mapper;

import cn.sxgan.common.entity.SysUser;
import cn.sxgan.common.entity.query.SysUserQuery;
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