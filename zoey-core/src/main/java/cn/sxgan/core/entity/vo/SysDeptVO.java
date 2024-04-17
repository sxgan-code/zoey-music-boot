package cn.sxgan.core.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 部门表视图对象
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-04-17
 * @Version: 1.0.0
 **/
@Data
@Schema(name = "SysDeptVO", description = "部门表")
public class SysDeptVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Schema(description = "部门ID")
    private Integer deptId;
    
    @Schema(description = "部门名称")
    private String deptName;
    
    @Schema(description = "部门编号")
    private String deptNo;
    
    @Schema(description = "创建时间")
    private Date createTime;
    
    @Schema(description = "更新时间")
    private Date updateTime;
    
    @Schema(description = "删除标志：0-未删除，1-已删除")
    private Integer delFlag;
    
    
}