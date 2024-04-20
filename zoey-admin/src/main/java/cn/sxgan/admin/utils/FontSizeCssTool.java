package cn.sxgan.admin.utils;

import cn.sxgan.common.constant.SystemConst;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Description: 生成前端media动态脚本
 * @Author: sxgan
 * @Date: 2024-04-20 11:45
 * @Version: 1.0
 **/

public class FontSizeCssTool {
    // 屏幕变更间距
    static int screenSpacing = 10;
    
    // 屏幕变化区间
    static int minScreenWidth = 1200;
    static int maxScreenWidth = 2600;
    
    // 字体大小区间
    static int minFontSize = 10;
    static int maxFontSize = 15;
    
    public static void main(String[] args) {
        
        
        // 构造Css脚本方法
        buildCssScript();
    }
    
    private static void buildCssScript() {
        // 计算自增屏幕总份数
        int screenNum = (int) (maxScreenWidth - minScreenWidth) / 12;
        
        // 计算自增字体大小间距
        double fontSizeSpacing = (double) (maxFontSize - minFontSize) / screenNum;
        BigDecimal bd = new BigDecimal(fontSizeSpacing);
        bd = bd.setScale(3, BigDecimal.ROUND_HALF_UP);
        fontSizeSpacing = bd.doubleValue();
        // 生成Css脚本
        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/* 当屏幕宽度小于" + minScreenWidth + "px时，根元素字体大小调整为" + minFontSize + "px */\n" +
                "@media (max-width: " + minScreenWidth + "px) {\n" +
                "  html,body {\n" +
                "    font-size: " + minFontSize + "px;\n" +
                "  }\n" +
                "}\n");
        
        int startWidth = minScreenWidth;
        int endWidth = startWidth + screenSpacing;
        double currFontSize = minFontSize;
        for (int i = 1; i <= screenNum; i++) {
            stringBuilder.append("/* 当屏幕宽度在" + startWidth + "px到" + endWidth + "px之间时，根元素字体大小调整为13px */\n" +
                    "@media (min-width: " + startWidth + "px) and (max-width: " + endWidth + "px) {\n" +
                    "  html,body {\n" +
                    "    font-size: " + getNumber(currFontSize) + "px;\n" +
                    "  }\n" +
                    "}\n");
            startWidth += screenSpacing;
            endWidth += screenSpacing;
            
            currFontSize += fontSizeSpacing;
            
        }
        
        
        stringBuilder.append("/* 当屏幕宽度大于" + startWidth + "px时，根元素字体大小调整为" + maxFontSize + "px */\n" +
                "@media (min-width: " + startWidth + "px) {\n" +
                "  html,body {\n" +
                "    font-size: " + maxFontSize + "px;\n" +
                "  }\n" +
                "}\n");
        
        FileUtils.writeADocument(stringBuilder.toString(), SystemConst.APP_DIR + "/doc/media.scss", false);
    }
    
    public static String getNumber(double num) {
        BigDecimal originalValue = new BigDecimal(num);
        BigDecimal roundedValue = originalValue.setScale(3, RoundingMode.HALF_UP);
        String input = roundedValue.toString();
        // 判断是否是整数
        String result = "";
        String[] split = input.split("\\.");
        int intNum = Integer.parseInt(split[0]);
        int decimalNum = Integer.parseInt(split[1]);
        if (decimalNum == 0) {
            result = String.valueOf(intNum); // 是整数，直接返回
        } else {
            // 不是整数，截取小数点后四位
            String[] parts = input.split("\\.");
            // 如果小数点后位数不足四位，直接返回原字符串
            if (parts.length < 2 || parts[1].length() < 4) {
                result = input;
            } else {
                result = new StringBuilder(parts[0]).append(".")
                        .append(parts[1].substring(0, 4)).toString();
            }
        }
        
        return result;
    }
}
