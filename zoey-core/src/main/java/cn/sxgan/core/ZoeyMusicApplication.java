package cn.sxgan.core;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description: 主启动类
 * @Author: daniel
 * @Date: 2024/3/1 15:04
 * @Version: 1.0
 **/
@EnableDubbo
@SpringBootApplication
@MapperScan("cn.sxgan.common.mapper")
@ComponentScan(basePackages = {"cn.sxgan.core", "cn.sxgan.common",})
@ServletComponentScan(basePackages = "cn.sxgan.core.filter")
public class ZoeyMusicApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZoeyMusicApplication.class, args);
    }
}
