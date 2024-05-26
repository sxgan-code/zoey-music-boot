package cn.sxgan.common.entity.converts;


import cn.sxgan.common.entity.SysRole;
import cn.sxgan.common.entity.vo.SysRoleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 角色表实体转换接口
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Mapper
public interface ISysRoleConvert {
    ISysRoleConvert INSTANCE = Mappers.getMapper(ISysRoleConvert.class);
    
    SysRole convert(SysRoleVO vo);
    
    SysRoleVO convert(SysRole entity);
    
    List<SysRoleVO> convertList(List<SysRole> list);
    
}