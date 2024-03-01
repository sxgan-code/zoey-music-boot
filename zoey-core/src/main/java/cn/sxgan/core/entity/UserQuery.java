package cn.sxgan.core.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 用户实体查询类
 * @Author: sxgan
 * @Date: 2024/3/1 15:11
 * @Version: 1.0
 **/
@Data
public class UserQuery extends User {
    private Date createStartDate;
    private Date createEndDate;
    private Date updateStartDate;
    private Date updateEndDate;
}
