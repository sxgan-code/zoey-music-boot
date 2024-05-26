package cn.sxgan.common.entity.converts;

import cn.sxgan.common.entity.SysUser;
import cn.sxgan.common.entity.SysUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 用户信息实体转换
 * @Author: sxgan
 * @Date: 2024-04-10 11:18
 * @Version: 1.0
 **/
@Mapper(componentModel = "spring")
public interface SysUserConvert {
    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);
    
    /**
     * 将SysUser转换成SysUserVO
     *
     * @param sysUser 用户实体对象
     * @return 用户视图对象
     */
    @Mappings({
            @Mapping(source = "userId", target = "userId")
    })
    SysUserVO sysUserToVO(SysUser sysUser);
    
    /**
     * 将SysUserList转换成SysUserVOList
     *
     * @param sysUserList 用户实体对象列表
     * @return 用户视图对象列表
     */
    List<SysUserVO> sysUserListToVOList(List<SysUser> sysUserList);
    
    /**
     * 将SysUserVO转换成SysUser
     *
     * @param sysUserVO 用户视图对象
     * @return 用户实体对象
     */
    @Mappings({
            @Mapping(source = "userId", target = "userId")
    })
    SysUser sysUserVOToDAO(SysUserVO sysUserVO);
    
    
}
