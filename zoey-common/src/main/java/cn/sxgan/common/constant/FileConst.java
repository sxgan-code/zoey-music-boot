package cn.sxgan.common.constant;

/**
 * @Description: 文件常量
 * @Author: sxgan
 * @Date: 2024-04-17 10:16
 * @Version: 1.0
 **/

public class FileConst {
    public static final String NAME = "name";
    // 工程路径
    public static final String PROJECT_URL = System.getProperty("user.dir");
    
    // 返回参数CODE 200 请求成功，数据校验正确
    public static final String CODE200 = "200";
    
    // 返回参数CODE 201 请求成功，数据校验非预期类型
    public static final String CODE201 = "201";
    
    // 返回参数CODE 500 请求错误
    public static final String CODE500 = "500";
    
    // 返回歌曲图片相对地址
    public static final String SONG_IMAGE_PATH = "/resources/image/songImg/";
    
    // 返回歌曲相对地址
    public static final String SONG_PATH = "/resources/song/";
    
    // 返回歌手头像相对地址
    public static final String SINGER_IMAGE_PATH = "/resources/image/singerImg/";
    
    // 返回走马灯图片相对地址
    public static final String CAROUSEL_IMAGE_PATH = "/resources/ClientImg/mainpage/";
    
    // 返回歌单图片相对地址
    public static final String SONG_LIST_IMAGE_PATH = "/resources/image/songListImg/";
}
