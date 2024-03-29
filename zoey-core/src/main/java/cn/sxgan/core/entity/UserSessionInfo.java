package cn.sxgan.core.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * @Description: 用户全局会话对象
 * @Author: sxgan
 * @Date: 2024/3/1 15:15
 * @Version: 1.0
 **/
@Data
@Schema(name = "UserSessionInfo", description = "用户全局会话对象")
public class UserSessionInfo {
    @Schema(description = "用户ID", type = "Integer", example = "000000")
    private Integer id;
    @Schema(description = "密码", type = "String", example = "123456")
    private String password;
    @Pattern(regexp = "^\\S{1,10}$")
    @Schema(description = "用户昵称", type = "String", example = "小张")
    private String userName;
    @NotEmpty
    @Email
    @Schema(description = "邮箱", type = "String", example = "123@123.com")
    private String email;
    @Schema(description = "验证码", type = "String", example = "666666")
    private String verifyCode;
}
