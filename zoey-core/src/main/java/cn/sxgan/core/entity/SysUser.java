package cn.sxgan.core.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 用户实体类
 * @Author: sxgan
 * @Date: 2024/3/1 15:11
 * @Version: 1.0
 **/

@Data
@TableName(value = "sys_user")
@Schema(name = "SysUser", description = "用户实体类")
public class SysUser {
    @TableId
    @Schema(description = "用户ID", type = "Integer", example = "000000")
    private String userId;
    @Schema(description = "部门ID", type = "Integer", example = "000000")
    private String deptId;
    @Schema(description = "用户昵称", type = "string", example = "")
    private String userName;
    @Schema(description = "用户类型（00系统用户 01普通用户）", type = "string", example = "")
    private String userType;
    @Schema(description = "用户邮箱", type = "string", example = "")
    private String email;
    @Schema(description = "手机号码", type = "string", example = "")
    private String phoneNumber;
    @Schema(description = "用户性别（0男 1女 2未知）", type = "string", example = "")
    private String sex;
    @Schema(description = "头像路径", type = "string", example = "")
    private String avatar;
    @Schema(description = "密码", type = "string", example = "")
    private String password;
    @Schema(description = "个性签名", type = "string", example = "")
    private String personalSign;
    @Schema(description = "盐加密", type = "string", example = "")
    private String salt;
    @Schema(description = "帐号状态（0正常 1停用）", type = "string", example = "")
    private String status;
    @Schema(description = "删除标志（0代表存在 2代表删除）", type = "string", example = "")
    private String delFlag;
    @Schema(description = "最后登录IP", type = "string", example = "")
    private String loginIp;
    @Schema(description = "最后登录时间", type = "string", example = "")
    private String loginDate;
    @Schema(description = "密码最后更新时间", type = "string", example = "")
    private String pwdUpdateDate;
    @Schema(description = "创建者", type = "string", example = "")
    private String createBy;
    @Schema(description = "创建时间", type = "string", example = "")
    private String createTime;
    @Schema(description = "更新者", type = "string", example = "")
    private String updateBy;
    @Schema(description = "更新时间", type = "string", example = "")
    private String updateTime;
    @Schema(description = "备注", type = "string", example = "")
    private String remark;
}
