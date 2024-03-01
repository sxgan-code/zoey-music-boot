package cn.sxgan.core.controller;

import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.core.api.TestControllerApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 测试控制器
 * @Author: sxgan
 * @Date: 2024/3/1 21:17
 * @Version: 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/zoey")
public class TestController implements TestControllerApi {
    @GetMapping("/test")
    public ResponseResult<String> test(@RequestParam(name = "var") String var) {
        log.info("当前传入参数为：var = {}", var);
        return ResponseResult.success("hello world!!!,hello jenkins!!!，start。。。。项目启动");
    }
}
