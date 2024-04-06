package cn.sxgan.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @Description: 时间处理工具类
 * @Author: sxgan
 * @Date: 2024-04-06 21:50
 * @Version: 1.0
 **/
@Slf4j
public class TimeUtils {
    /**
     * 获取当前时间到午夜零点的秒数（今天剩余秒数）
     *
     * @return 今天剩余秒数
     */
    public static Integer getSecondsToMidnight() {
        Calendar curDate = Calendar.getInstance();
        Calendar tommorowDate = new GregorianCalendar(curDate
                .get(Calendar.YEAR), curDate.get(Calendar.MONTH), curDate
                .get(Calendar.DATE) + 1, 0, 0, 0);
        return (int) (tommorowDate.getTimeInMillis() - curDate.getTimeInMillis()) / 1000;
    }
}
