package cn.sxgan.core.config;

import cn.sxgan.common.constant.SystemConst;
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
                String appDir = SystemConst.APP_DIR;
                String os = SystemConst.OS_NAME_UPPER_CASE;
                String fileUrl = "";
                if (!os.contains("WIN")) {
                    fileUrl = SystemConst.APP_DIR + "resources/";
                } else {
                    fileUrl = SystemConst.APP_DIR + "/resources/";
                    fileUrl = fileUrl.replaceAll("\\\\", "/");
                }
                log.info("当前项目启动根目录" + appDir);
                log.info("当前资源目录目录为：{}", fileUrl);
                registry.addResourceHandler("/static/**").addResourceLocations("file:" + fileUrl);
            }
        };
    }
}