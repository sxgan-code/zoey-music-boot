package cn.sxgan.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: 全局系统信息配置类
 * @Author: sxgan
 * @Date: 2024/3/1 15:14
 * @Version: 1.0
 **/
@Component
@ConfigurationProperties(prefix = "zoey")
public class ZoeyConfig {

    /**
     * 作者
     */
    private static String authorName;
    /**
     * 邮箱
     */
    private static String authorEmail;

    /**
     * 个人地址
     */
    private static String authorUrl;

    /**
     * 标题
     */
    private static String docTitle;

    /**
     * 版本
     */
    private static String version;

    /**
     * 版权年份
     */
    private static String copyrightYear;

    /**
     * 实例演示开关
     */
    private static boolean demoEnabled;

    /**
     * 上传路径
     */
    private static String profile;

    /**
     * 获取地址开关
     */
    private static boolean addressEnabled;

    public static String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        ZoeyConfig.authorName = authorName;
    }

    public static String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        ZoeyConfig.authorEmail = authorEmail;
    }

    public static String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        ZoeyConfig.authorUrl = authorUrl;
    }

    public static String getDocTitle() {
        return docTitle;
    }

    public void setDocTitle(String docTitle) {
        ZoeyConfig.docTitle = docTitle;
    }

    public static String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        ZoeyConfig.version = version;
    }

    public static String getCopyrightYear() {
        return copyrightYear;
    }

    public void setCopyrightYear(String copyrightYear) {
        ZoeyConfig.copyrightYear = copyrightYear;
    }

    public static boolean isDemoEnabled() {
        return demoEnabled;
    }

    public void setDemoEnabled(boolean demoEnabled) {
        ZoeyConfig.demoEnabled = demoEnabled;
    }

    public static String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        ZoeyConfig.profile = profile;
    }

    public static boolean isAddressEnabled() {
        return addressEnabled;
    }

    public void setAddressEnabled(boolean addressEnabled) {
        ZoeyConfig.addressEnabled = addressEnabled;
    }

    /**
     * 获取导入上传路径
     */
    public static String getImportPath() {
        return getProfile() + "/import";
    }

    /**
     * 获取头像上传路径
     */
    public static String getAvatarPath() {
        return getProfile() + "/avatar";
    }

    /**
     * 获取下载路径
     */
    public static String getDownloadPath() {
        return getProfile() + "/download/";
    }

    /**
     * 获取上传路径
     */
    public static String getUploadPath() {
        return getProfile() + "/upload";
    }

}
