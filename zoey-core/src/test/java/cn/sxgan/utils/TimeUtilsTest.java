package cn.sxgan.utils;

import cn.sxgan.common.utils.TimeUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 时间测试类
 * @Author: sxgan
 * @Date: 2024-04-06 21:57
 * @Version: 1.0
 **/
@Slf4j
public class TimeUtilsTest {

    public static void main(String[] args) {
        Integer secondsToMidnight = TimeUtils.getSecondsToMidnight();
        log.info(secondsToMidnight.toString());
    }
}
