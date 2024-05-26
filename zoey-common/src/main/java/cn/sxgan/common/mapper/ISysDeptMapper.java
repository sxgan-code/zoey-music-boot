package cn.sxgan.common.mapper;

import cn.sxgan.common.entity.SysDept;
import cn.sxgan.common.entity.query.SysDeptQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 部门表映射mapper
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Mapper
public interface ISysDeptMapper extends BaseMapper<SysDept> {
    List<SysDept> selectSysDeptByCondition(SysDeptQuery query);
}