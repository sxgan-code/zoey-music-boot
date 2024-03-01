package cn.sxgan.core.filter;


import cn.sxgan.core.http.RequestHolder;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @Description: 用户登录过滤器，存入全局会话
 * @Author: sxgan
 * @Date: 2024/3/1 15:16
 * @Version: 1.0
 **/
@WebFilter(filterName = "userSessionFilter", urlPatterns = "/*")
@Slf4j
public class UserSessionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        log.info("httpRequest = {}", httpRequest);
        RequestHolder.add(httpRequest);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}