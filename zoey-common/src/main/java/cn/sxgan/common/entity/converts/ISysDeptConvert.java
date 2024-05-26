package cn.sxgan.common.entity.converts;


import cn.sxgan.common.entity.SysDept;
import cn.sxgan.common.entity.vo.SysDeptVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 部门表实体转换接口
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Mapper
public interface ISysDeptConvert {
    ISysDeptConvert INSTANCE = Mappers.getMapper(ISysDeptConvert.class);
    
    SysDept convert(SysDeptVO vo);
    
    SysDeptVO convert(SysDept entity);
    
    List<SysDeptVO> convertList(List<SysDept> list);
    
}