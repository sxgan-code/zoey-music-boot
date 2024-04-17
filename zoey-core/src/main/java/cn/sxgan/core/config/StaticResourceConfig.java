package cn.sxgan.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class StaticResourceConfig {
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                String userDir = System.getProperty("user.dir");
                log.info("当前根目录"+userDir);
                String fileUrl = userDir +"resources/";
                log.info("当前资源目录目录为：{}", fileUrl);
                registry.addResourceHandler("/static/**").addResourceLocations("file:"+fileUrl);
            }
        };
    }
}