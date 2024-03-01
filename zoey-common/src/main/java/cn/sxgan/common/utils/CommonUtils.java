package cn.sxgan.common.utils;

import cn.hutool.core.util.RandomUtil;
import cn.sxgan.common.constant.NumberConstants;

import java.util.Locale;

/**
 * @Description: 全局公共工具类
 * @Author: sxgan
 * @Date: 2024/3/1 15:11
 * @Version: 1.0
 **/
public class CommonUtils {

    /**
     * 生成8位的随机验证码
     *
     * @return
     */
    public static String generateCaptcha() {
        String captcha = RandomUtil.randomString(NumberConstants.NUMBER_8.intValue());
        return captcha.toUpperCase(Locale.ROOT);
    }
}