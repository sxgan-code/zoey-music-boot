package cn.sxgan.core.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 系统配置实体
 * @Author: sxgan
 * @Date: 2024-04-10 22:38
 * @Version: 1.0
 **/
@Data
@TableName(value = "sys_config")
@Schema(name = "SysConfig", description = "系统配置实体")
public class SysConfig {
    @TableId
    @Schema(description = "配置ID", type = "Integer")
    private Integer id;
    @Schema(description = "配置的key", type = "String")
    private String configKey;
    @Schema(description = "配置的值。如果有多个，用逗号隔开", type = "String")
    private String configValue;
    @Schema(description = "配置说明", type = "String")
    private String description;
    @Schema(description = "配置创建时间", type = "Date")
    private Date createTime;
    @Schema(description = "配置更新时间", type = "Date")
    private Date updateTime;
    @Schema(description = "删除标志：0-未删除，1-已删除", type = "Integer")
    private Integer isDelete;
}
