package cn.sxgan.common.utils;

/**
 * @Description: 字符串处理工具类
 * @Author: sxgan
 * @Date: 2024-05-17 21:22
 * @Version: 1.0
 **/

public class StringUtils {
    
    /**
     * 去除字符串两端指定的字符
     *
     * @param str          待处理的字符串
     * @param charToRemove 要去除的字符
     * @return 去除两端指定字符后的字符串
     */
    public static String trim(String str, char charToRemove) {
        int start = 0, end = str.length() - 1;
        // 去除开头的指定字符
        while (start <= end && str.charAt(start) == charToRemove) {
            start++;
        }
        // 去除结尾的指定字符
        while (start <= end && str.charAt(end) == charToRemove) {
            end--;
        }
        // 返回去除后的字符串
        return str.substring(start, end + 1);
    }
    
    
}
