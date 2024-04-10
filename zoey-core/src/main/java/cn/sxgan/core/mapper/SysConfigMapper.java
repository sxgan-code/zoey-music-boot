package cn.sxgan.core.mapper;

import cn.sxgan.core.entity.SysConfig;
import cn.sxgan.core.entity.SysConfigQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Description: 系统配置Mapper
 * @Author: sxgan
 * @Date: 2024-04-10 22:37
 * @Version: 1.0
 **/

public interface SysConfigMapper extends BaseMapper<SysConfig> {
    
    List<SysConfig> selectConfigByCondition(SysConfigQuery sysConfigQuery);
}
