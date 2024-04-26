package cn.sxgan.common.utils;

import cn.hutool.core.util.RandomUtil;
import cn.sxgan.common.constant.NumberConstants;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

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
    
    /**
     * 生成某一区间内的n个唯一随机数
     *
     * @param min 区间最小值
     * @param max 区间最大值
     * @param n   多少个数
     * @return Set<Integer>
     */
    public static Set<Integer> generateUniqueRandomNumbers(int min, int max, int n) {
        Random random = new Random();
        Set<Integer> uniqueNumbers = new HashSet<>();
        
        while (uniqueNumbers.size() < n) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            uniqueNumbers.add(randomNumber);
        }
        
        return uniqueNumbers;
    }
    
    /**
     * 将传入的Integer数组转换为固定位数的字符串数组形式
     *
     * @param array  固定数组
     * @param length 字符串长度
     * @return String[]
     */
    public static String[] intArrayToStringArray(List<Integer> array, int length) {
        String[] result = new String[array.size()];
        for (int i = 0; i < array.size(); i++) {
            result[i] = String.format("%0" + length + "d", array.get(i));
        }
        return result;
    }
    
    /**
     * 判断所提供的Object是否为空或null；如果传入List数组，则逐项判空或null，有且仅有全部项都不为空或不为null则返回false
     *
     * @param obj Object类型
     * @return boolean
     */
    public static boolean checkIsNullOrEmpty(Object obj) {
        if (obj instanceof String) {
            return (obj == null || (((String) obj).equals("")) || (((String) obj).equals("null")) || ((String) obj).equals("undefined"));
        } else if (obj instanceof List) {
            List list = (List) obj;
            for (Object o : list) {
                if (o instanceof String) {
                    if (o == null || (((String) o).equals(""))) {
                        return true;
                    }
                }
                if (o instanceof Integer) {
                    if (o == null) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            return obj == null;
        }
    }
    
    
    /**
     * 获取当前日期的字符串形式，yyyy-MM-dd HH:mm:ss
     *
     * @return String
     */
    public static String getDateString() {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sf.format(date);
        return strDate;
    }
    
    /**
     * 按指定格式将日期类型换为字符串类型转
     *
     * @param date Date类型 缺省值：当前时间
     * @param df   String类型 缺省值：yyyy-MM-dd HH:mm:ss
     * @return String
     */
    public static String getDateToString(Date date, String df) {
        if (CommonUtils.checkIsNullOrEmpty(date)) {
            date = new Date();
        }
        if (CommonUtils.checkIsNullOrEmpty(df)) {
            df = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sf = new SimpleDateFormat(df);
        String strDate = sf.format(date);
        return strDate;
    }
    
    /**
     * 按指定格式将字符串类型转换为日期类型
     *
     * @param dateStr
     * @param df      缺省值：yyyy-MM-dd HH:mm:ss
     * @return Date
     */
    public static Date getStringToDate(String dateStr, String df) {
        Date date = null;
        if (!CommonUtils.checkIsNullOrEmpty(dateStr)) {
            if (CommonUtils.checkIsNullOrEmpty(df)) {
                df = "yyyy-MM-dd HH:mm:ss";
            }
            DateFormat format = new SimpleDateFormat(df);
            try {
                date = format.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("日期转换出错，字符串转日期类型传参为空！");
        }
        return date;
    }
    
    /**
     * 获取当前日期时间的字符串数组，数组第0位为日期，第1位为时间
     *
     * @return String[]
     */
    public static String[] getDateAndTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd@HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        return format.split("[@]");
    }
    
    /**
     * 获取一个UUID
     *
     * @return
     */
    public static String getUUIDStr() {
        return UUID.randomUUID().toString().toUpperCase(Locale.ROOT);
    }
    
    /**
     * 带前缀的UUID
     *
     * @param prefix
     * @return
     */
    public static String getUUIDStr(String prefix) {
        return (prefix + "-" + UUID.randomUUID().toString()).toUpperCase(Locale.ROOT);
    }
}