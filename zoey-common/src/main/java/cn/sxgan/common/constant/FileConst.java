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
    
    // 返回flac歌曲资源保存相对地址
    public static final String FLAC_SONG_PATH = PROJECT_URL.replaceAll("zoey-admin", "") +
            "/resources/data/flac/songs/";
    public static final String FLAC_IMG_PATH = PROJECT_URL.replaceAll("zoey-admin", "") +
            "/resources/data/flac/images/";
    public static final String FLAC_LRC_PATH = PROJECT_URL.replaceAll("zoey-admin", "") +
            "/resources/data/flac/lyrics/";
    
    // 返回mp3歌曲保存相对地址
    public static final String MP3_SONG_PATH = PROJECT_URL.replaceAll("zoey-admin", "") +
            "/resources/data/mp3/songs/";
    public static final String MP3_IMG_PATH = PROJECT_URL.replaceAll("zoey-admin", "") +
            "/resources/data/mp3/images/";
    public static final String MP3_LRC_PATH = PROJECT_URL.replaceAll("zoey-admin", "") +
            "/resources/data/mp3/lyrics/";
    
    // 返回ogg歌曲保存相对地址
    public static final String OGG_SONG_PATH = PROJECT_URL.replaceAll("zoey-admin", "") +
            "/resources/data/ogg/songs/";
    public static final String OGG_IMG_PATH = PROJECT_URL.replaceAll("zoey-admin", "") +
            "/resources/data/ogg/images/";
    public static final String OGG_LRC_PATH = PROJECT_URL.replaceAll("zoey-admin", "") +
            "/resources/data/ogg/lyrics/";
    
    // sql脚本保存地址
    public static final String SONG_SQL_PATH = PROJECT_URL.replaceAll("zoey-admin", "") +
            "/resources/sql/music_song_data.sql";
    public static final String SINGER_SQL_PATH = PROJECT_URL.replaceAll("zoey-admin", "") +
            "/resources/sql/music_singer_data.sql";
    public static final String ALBUM_SQL_PATH = PROJECT_URL.replaceAll("zoey-admin", "") +
            "/resources/sql/music_album_data.sql";
    // 返回走马灯图片相对地址
    public static final String CAROUSEL_IMAGE_PATH = "/resources/ClientImg/mainpage/";
    
    // 返回歌单图片相对地址
    public static final String SONG_LIST_IMAGE_PATH = "/resources/image/songListImg/";
}
