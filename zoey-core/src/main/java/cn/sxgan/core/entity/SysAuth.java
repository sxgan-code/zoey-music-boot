package cn.sxgan.core.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 角色权限表实体类
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Data
@TableName(value = "sys_auth")
@Schema(name = "SysAuth", description = "角色权限表实体类")
public class SysAuth {
    /**
     * 权限ID
     */
    @TableId
    @Schema(description = "权限ID", type = "Integer")
    private Integer authId;
    
    /**
     * 权限名称
     */
    @Schema(description = "权限名称", type = "String")
    private String authName;
    
    /**
     * 角色ID
     */
    @Schema(description = "角色ID", type = "Integer")
    private Integer roleId;
    
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