package cn.sxgan.common.mapper;

import cn.sxgan.common.entity.SysAuth;
import cn.sxgan.common.entity.query.SysAuthQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 角色权限表映射mapper
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Mapper
public interface ISysAuthMapper extends BaseMapper<SysAuth> {
    List<SysAuth> selectSysAuthByCondition(SysAuthQuery query);
}