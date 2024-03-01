package cn.sxgan.core.service.impl;

import cn.sxgan.common.cache.RedisUtil;
import cn.sxgan.common.constant.ExceptionStatus;
import cn.sxgan.common.constant.RedisConst;
import cn.sxgan.common.exception.auth.AuthorityException;
import cn.sxgan.common.utils.CommonUtils;
import cn.sxgan.core.service.IMailSendService;
import jakarta.annotation.Resource;
import jakarta.mail.internet.InternetAddress;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 邮箱验证服务实现类
 * @Author: sxgan
 * @Date: 2024/3/1 15:14
 * @Version: 1.0
 **/
@Slf4j
@Service
public class MailSendServiceImpl implements IMailSendService {

    @Value("${spring.mail.username}")
    private String sendEmail;

    @Resource
    private JavaMailSender javaMailSender;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public String sendVerifyCodeToSpecifiedEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return ExceptionStatus.EXCEPTION_STATUS_711.getExceptionMsg();
        }
        int count = 1;
        String captcha = CommonUtils.generateCaptcha();
        String captchaCacheVal;
        String captchaCacheKey = redisUtil.get(RedisConst.CARD_CAPTCHA_PREFIX + email, String.class);
        if (StringUtils.isBlank(captchaCacheKey)) {
            captchaCacheVal = captcha + "_" + count;
        } else {
            String[] capStrArr = captchaCacheKey.split("_");
            count = Integer.parseInt(capStrArr[1]);
            count++;
            if (count > 5) {
                return "验证码次数超过今日上限，请明天再试";
            }
            captchaCacheVal = captcha + "_" + count;
        }
        captchaCacheVal = captchaCacheVal + "_" + System.currentTimeMillis();
        // 定义Redis的key
        captchaCacheKey = RedisConst.CARD_CAPTCHA_PREFIX + email;
        // 邮件对象（邮件模板，根据自身业务修改）
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Zoey注册邮箱验证码");
        message.setText("尊敬的用户 " + email + "\n\n您好! 感谢您注册Zoey。\n\n您的校验验证码为: "
                + captcha + "\n\n有效期5分钟，请不要把验证码信息泄露给其他人,如非本人请勿操作");
        message.setTo(email);
        try {
            // 对方看到的发送人（发件人的邮箱，根据实际业务进行修改，一般填写的是企业邮箱）
            log.info("发送人邮箱：{}", sendEmail);
            message.setFrom(new InternetAddress(sendEmail).toString());
            // 发送邮件
            javaMailSender.send(message);
            log.info("mail send success");
            redisUtil.set(captchaCacheKey, captchaCacheVal, RedisConst.LOGIN_TIME_1, TimeUnit.DAYS);
            return "发送成功";
        } catch (Exception e) {
            log.info("mail send failed");
            throw new AuthorityException(
                    ExceptionStatus.EXCEPTION_STATUS_712.getExceptionCode(),
                    ExceptionStatus.EXCEPTION_STATUS_712.getExceptionMsg());
        }
    }
}
