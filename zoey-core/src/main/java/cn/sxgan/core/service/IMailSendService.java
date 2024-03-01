package cn.sxgan.core.service;

public interface IMailSendService {


    /**
     * 发送验证码到指定邮箱
     *
     * @param email 邮箱
     * @return
     */
    String sendVerifyCodeToSpecifiedEmail(String email);
}