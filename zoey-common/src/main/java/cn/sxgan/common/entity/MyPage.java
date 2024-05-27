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
public class MyPage<T> implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 1L;
    
    @Schema(description = "当前页面", type = "Long")
    private Long currentIndex;
    @Schema(description = "页面大小，当前页条数", type = "Long")
    private Long pageSize;
    @Schema(description = "总页数", type = "Long")
    private Long pageTotal;
    @Schema(description = "数据总条数", type = "Long")
    private Long dataTotal;
    @Schema(description = "数据", type = "List")
    private List<T> list;
}
