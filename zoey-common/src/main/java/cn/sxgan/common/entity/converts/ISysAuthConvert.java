package cn.sxgan.common.entity.converts;


import cn.sxgan.common.entity.SysAuth;
import cn.sxgan.common.entity.vo.SysAuthVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 角色权限表实体转换接口
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Mapper
public interface ISysAuthConvert {
    ISysAuthConvert INSTANCE = Mappers.getMapper(ISysAuthConvert.class);
    
    SysAuth convert(SysAuthVO vo);
    
    SysAuthVO convert(SysAuth entity);
    
    List<SysAuthVO> convertList(List<SysAuth> list);
    
}