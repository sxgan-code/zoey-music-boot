package cn.sxgan.common.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: 分页实体类
 * @Author: sxgan
 * @Date: 2024-05-26 17:48
 * @Version: 1.0
 **/
@Data
@Schema(name = "Page", description = "分页实体")
public class Page<T> implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 1L;
    
    @Schema(description = "当前页面", type = "Integer")
    private Integer currentIndex;
    @Schema(description = "页面大小，当前页条数", type = "Integer")
    private Integer pageSize;
    @Schema(description = "总页数", type = "Integer")
    private Integer pageTotal;
    @Schema(description = "分页选项：5，10，50，100", type = "Integer")
    private Integer sizeOptions;
    @Schema(description = "数据", type = "Integer")
    private List<T> list;
}
