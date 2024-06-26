package cn.sxgan.common.mapper;

import cn.sxgan.common.entity.SysRole;
import cn.sxgan.common.entity.query.SysRoleQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 角色表映射mapper
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Mapper
public interface ISysRoleMapper extends BaseMapper<SysRole> {
    List<SysRole> selectSysRoleByCondition(SysRoleQuery query);
}