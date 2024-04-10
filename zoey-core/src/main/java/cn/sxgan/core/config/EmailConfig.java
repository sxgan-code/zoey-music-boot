package cn.sxgan.core.config;

import cn.sxgan.core.entity.SysConfig;
import cn.sxgan.core.entity.SysConfigQuery;
import cn.sxgan.core.mapper.SysConfigMapper;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.List;

/**
 * @Description: 邮件配置类
 * @Author: sxgan
 * @Date: 2024-04-10 22:19
 * @Version: 1.0
 **/
@Configuration
public class EmailConfig {
    @Resource
    private SysConfigMapper sysConfigMapper;
    
    @Bean
    public JavaMailSender getJavaMailSender() {
        SysConfigQuery sysConfigQuery = new SysConfigQuery();
        sysConfigQuery.setConfigKey("email.password");
        List<SysConfig> sysConfigs = sysConfigMapper.selectConfigByCondition(sysConfigQuery);
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com");
        mailSender.setUsername("zoey.code@foxmail.com");
        mailSender.setPassword(sysConfigs.getFirst().getConfigValue());
        mailSender.setDefaultEncoding("utf-8");
        mailSender.setProtocol("smtp");
        mailSender.getJavaMailProperties().put("mail.smtp.ssl.enable", "true");
        mailSender.getJavaMailProperties().put("mail.smtp.ssl.required", "true");
        mailSender.getJavaMailProperties().put("mail.smtp.timeout", "10000");
        mailSender.getJavaMailProperties().put("mail.smtp.connection-timeout", "10000");
        mailSender.getJavaMailProperties().put("mail.smtp.write-timeout", "10000");
        
        return mailSender;
    }
}
