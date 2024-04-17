package cn.sxgan.core.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 角色表实体类
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Data
@TableName(value = "sys_role")
@Schema(name = "SysRole", description = "角色表实体类")
public class SysRole {
    /**
     * 角色ID
     */
    @TableId
    @Schema(description = "角色ID", type = "Integer")
    private Integer roleId;
    
    /**
     * 角色名称
     */
    @Schema(description = "角色名称", type = "String")
    private String roleName;
    
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