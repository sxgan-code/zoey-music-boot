package cn.sxgan.core.mapper;

import cn.sxgan.core.entity.User;
import cn.sxgan.core.entity.UserQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 用户实体映射接口
 * @Author: sxgan
 * @Date: 2024/3/1 15:19
 * @Version: 1.0
 **/

@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> selectUserByCondition(UserQuery userQuery);
}
