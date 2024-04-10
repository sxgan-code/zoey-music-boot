package cn.sxgan.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Description: 系统配置查询对象
 * @Author: sxgan
 * @Date: 2024-04-10 22:47
 * @Version: 1.0
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class SysConfigQuery extends SysConfig {
    private Date createStartDate;
    private Date createEndDate;
    private Date updateStartDate;
    private Date updateEndDate;
}
