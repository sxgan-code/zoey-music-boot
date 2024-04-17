package cn.sxgan.core.config;

import cn.sxgan.core.interceptor.AllRequestInterceptor;
import cn.sxgan.core.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: Web拦截器
 * @Author: sxgan
 * @Date: 2024/3/1 15:11
 * @Version: 1.0
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 添加自定义拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AllRequestInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/v3/api-docs");
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/v3/api-docs")
                .excludePathPatterns("/card/auth/signin")
                .excludePathPatterns("/card/auth/signup")
                .excludePathPatterns("/card/auth/mailVerifyCode")
                .excludePathPatterns("/static/**");
    }
}