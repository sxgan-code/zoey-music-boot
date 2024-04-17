package cn.sxgan.core.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 角色表视图对象
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Data
@Schema(name = "SysRoleVO", description = "角色表")
public class SysRoleVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Schema(description = "角色ID")
    private Integer roleId;
    
    @Schema(description = "角色名称")
    private String roleName;
    
    @Schema(description = "创建时间")
    private Date createTime;
    
    @Schema(description = "更新时间")
    private Date updateTime;
    
    @Schema(description = "删除标志：0-未删除，1-已删除")
    private Integer delFlag;
    
    
}