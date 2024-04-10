package cn.sxgan.core.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 用户信息视图对象
 * @Author: sxgan
 * @Date: 2024-04-10 10:39
 * @Version: 1.0
 **/
@Data
@Schema(name = "SysUserVO", description = "用户信息视图对象")
public class SysUserVO {
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
    @Schema(description = "帐号状态（0正常 1停用）", type = "string", example = "")
    private String status;
    @Schema(description = "删除标志（0代表存在 2代表删除）", type = "string", example = "")
    private String delFlag;
    @Schema(description = "备注", type = "string", example = "")
    private String remark;
}
