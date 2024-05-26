package cn.sxgan.admin;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description: 管理启动类
 * @Author: sxgan
 * @Date: 2024-05-15 23:39
 * @Version: 1.0
 **/
@EnableDubbo
@SpringBootApplication
@MapperScan("cn.sxgan.common.mapper")
@ComponentScan(basePackages = {"cn.sxgan.admin", "cn.sxgan.common",})
public class ZoeyAdminApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ZoeyAdminApplication.class, args);
    }
}
