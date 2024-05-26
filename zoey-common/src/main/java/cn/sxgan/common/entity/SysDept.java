package cn.sxgan.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 部门表实体类
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Data
@TableName(value = "sys_dept")
@Schema(name = "SysDept", description = "部门表实体类")
public class SysDept {
    /**
     * 部门ID
     */
    // 指定主键使用数据库ID自增策略
    @TableId(type = IdType.AUTO)
    @Schema(description = "部门ID", type = "Integer")
    private Integer deptId;
    
    /**
     * 部门名称
     */
    @Schema(description = "部门名称", type = "String")
    private String deptName;
    
    /**
     * 部门编号
     */
    @Schema(description = "部门编号", type = "String")
    private String deptNo;
    
    /**
     * 创建时间
     */
    @Schema(description = "创建时间", type = "Date")
    private Date createTime;
    
    /**
     * 更新时间
     */
    @Schema(description = "更新时间", type = "Date")
    private Date updateTime;
    
    /**
     * 删除标志：0-未删除，1-已删除
     */
    @Schema(description = "删除标志：0-未删除，1-已删除", type = "Integer")
    private Integer delFlag;
    
}