package cn.sxgan.common.enums;

/**
 * @Description: 文件扩展枚举
 * @Author: sxgan
 * @Date: 2024-05-21 19:51
 * @Version: 1.0
 **/
public enum FileExtensionEnum {
    /**
     * 歌曲类型
     */
    MP3("mp3"),
    WAV("wav"),
    FLAC("flac"),
    APE("ape"),
    OGG("ogg"),
    MID("mid"),
    WMA("wma"),
    AMR("amr"),
    AAC("aac"),
    M4A("m4a"),
    /**
     * 视频类型
     */
    MP4("mp4"),
    AVI("avi"),
    MOV("mov"),
    WMV("wmv"),
    RMVB("rmvb"),
    FLV("flv"),
    MPEG("mpeg"),
    MPG("mpg"),
    VOB("vob"),
    ASF("asf"),
    MKV("mkv"),
    WEBM("webm"),
    
    /**
     * 图片类型
     */
    JPG("jpg"),
    PNG("png"),
    GIF("gif"),
    PDF("pdf"),
    
    /**
     * 文档类型
     */
    DOC("doc"),
    DOCX("docx"),
    XLS("xls"),
    XLSX("xlsx"),
    TXT("txt"),
    /**
     * 压缩文件类型
     */
    ZIP("zip"),
    RAR("rar"),
    JAR("jar"),
    
    /**
     * 程序类型
     */
    EXE("exe");
    
    private String value;
    
    FileExtensionEnum(String value) {
        this.value = value;
    }
    
    
    public String getValue() {
        return this.value;
    }
}


