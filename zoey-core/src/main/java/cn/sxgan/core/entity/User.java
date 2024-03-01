package cn.sxgan.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 用户实体类
 * @Author: sxgan
 * @Date: 2024/3/1 15:11
 * @Version: 1.0
 **/

@Data
@TableName(value = "user")
@Schema(name = "user", description = "用户实体类")
public class User {
    @Schema(description = "用户ID", type = "Integer", example = "000000")
    private Integer id;
    @Schema(description = "用户名称", type = "String", example = "张三")
    private String userName;
    @Schema(description = "密码", type = "String", example = "123456")
    private String password;
    @Schema(description = "用户昵称", type = "String", example = "小张")
    private String nickName;
    @Schema(description = "邮箱", type = "String", example = "123@123.com")
    private String email;
    @Schema(description = "用户头像", type = "String", example = "/pic/pic.png")
    private String userPic;
    @Schema(description = "用户创建时间", type = "Date", example = "2023-02-09")
    private Date createDate;
    @Schema(description = "用户创建时间", type = "Date", example = "2023-02-10")
    private Date updateDate;
}
