package cn.sxgan.common.mapper;

import cn.sxgan.common.entity.SysCode;
import cn.sxgan.common.entity.query.SysCodeQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Description: 系统配置Mapper
 * @Author: sxgan
 * @Date: 2024-04-10 22:37
 * @Version: 1.0
 **/

public interface SysCodeMapper extends BaseMapper<SysCode> {
    
    List<SysCode> selectConfigByCondition(SysCodeQuery sysCodeQuery);
}
