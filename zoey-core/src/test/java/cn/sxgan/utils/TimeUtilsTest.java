package cn.sxgan.utils;

import cn.sxgan.common.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description: 时间测试类
 * @Author: sxgan
 * @Date: 2024-04-06 21:57
 * @Version: 1.0
 **/
@Slf4j
@SpringBootTest(classes = {TimeUtilsTest.class})
public class TimeUtilsTest {
    
    public static void main(String[] args) {
        Integer secondsToMidnight = DateUtils.getSecondsToMidnight();
        log.info(secondsToMidnight.toString());
    }
    
    @Test
    public void testGetSecondsToMidnight() {
        log.info("user.dir={}", System.getProperty("user.dir"));
    }
}
