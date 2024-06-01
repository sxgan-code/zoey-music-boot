package cn.sxgan.common.utils;

import cn.hutool.core.util.StrUtil;
import cn.sxgan.common.constant.FileConst;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 文件公共操作类
 * @Author: sxgan
 * @Date: 2024/5/21 19:42
 * @Version: 1.0
 **/
public class FileUtils {
    
    // 获取根目录
    private static String PROJECT_DIR = System.getProperty("user.dir");
    
    /**
     * 根据相对路径删除本地文件
     *
     * @param filePath
     * @return
     */
    public static boolean removeFile(String filePath) {
        if (StrUtil.hasEmpty(filePath)) {
            return false;
        }
        File file = new File(FileConst.PROJECT_URL, filePath);
        if (file.exists()) {
            file.delete();
        }
        return true;
    }
    
    
    /**
     * 向一个文件写入字符内容
     *
     * @param data 写入的内容
     * @param path 文件路径
     * @param type 写入方式（true:追加，false:覆盖）
     */
    public static void writeADocument(String data, String path, boolean type) {
        try {
            FileWriter fileWriter = new FileWriter(path, type);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(data);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 写入一个图片
     *
     * @param data
     * @param dirurl
     * @param url
     * @param type
     * @return
     */
    public static String writeAImage(byte[] data, String dirurl, String url, boolean type) {
        String path = dirurl + url;
        String relativePath = url.replaceAll("\\\\", "/");
        
        try {
            // 添加如下代码
            path = java.net.URLDecoder.decode(path, "utf-8");
            File file = new File(path);
            
            file.mkdirs();
            if (!file.exists()) {
                file.createNewFile();
            } else {
                file.delete();
                file.createNewFile();
            }
            FileOutputStream fileWriter = new FileOutputStream(path, type);
            BufferedOutputStream bw = new BufferedOutputStream(fileWriter);
            bw.write(data);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return relativePath;
    }
    
    /**
     * 加载指定路径的文件，按行输出List数组
     *
     * @param path 文件路径
     * @return List<String>
     */
    public static List<String> loadFileToList(String path) {
        List<String> result = new ArrayList<String>();
        File file = new File(path);
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            // 创建流对象
            BufferedReader br = new BufferedReader(fr);
            // 定义字符串,保存读取的一行文字
            String line = null;
            // 循环读取,读取到最后返回null
            while ((line = br.readLine()) != null) {
                result.add(line);
                System.out.print(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    
    /**
     * 获取文件夹下所有文件
     *
     * @param dir
     * @return
     */
    public static List<File> listAllFiles(File dir) {
        List<File> fileList = new ArrayList<>();
        File[] files = dir.listFiles();
        
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    fileList.addAll(listAllFiles(file));
                } else {
                    fileList.add(file);
                }
            }
        }
        
        return fileList;
    }
    
    
    /**
     * 复制文件到指定文件夹下
     *
     * @param sourceFile
     * @param targetDir
     */
    public static File copyFileToDir(File sourceFile, String targetDir) throws IOException {
        String[] split = sourceFile.getName().split("\\.");
        String fileName = sourceFile.getName();
        if (split.length == 2) {
            String name = StringUtils.trim(split[0], '-').trim();
            fileName = name + "." + split[1];
        }
        File file = new File(targetDir + File.separator + fileName);
        Files.copy(sourceFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        return file;
    }
    
    /**
     * 文件名根据文件路径获取后缀名
     *
     * @param filePath 字符串路径
     * @return 后缀名
     */
    public static String getFileExtension(String filePath) {
        // 路径处理
        filePath = filePath.replaceAll("\\\\", "/");
        if (filePath.contains("/")) {
            String[] split = filePath.split("/");
            filePath = split[split.length - 1];
        }
        if (filePath.contains(".")) {
            String[] split = filePath.split("\\.");
            return split[split.length - 1];
        }
        return "";
    }
    
    /**
     * 文件名根据文件路径获取后缀名
     *
     * @param file 文件类型路径
     * @return 后缀名
     */
    public static String getFileExtension(File file) {
        String filePath = file.getAbsolutePath();
        return getFileExtension(filePath);
    }
    
    
    /**
     * 根据文件类型获取文件系统绝对路径
     *
     * @param fileName
     * @return
     */
    public static String getFileAbsolutePathByType(String fileName) {
        String fileExtension = getFileExtension(fileName);
        switch (fileExtension) {
            case "flac":
                return FileConst.PROJECT_URL + FileConst.FLAC_SONG_PATH + fileName;
            case "mp3":
                return FileConst.PROJECT_URL + FileConst.MP3_IMG_PATH + fileName;
        }
        return "";
    }
    
    /**
     * 根据文件类型获取文件相对路径(不包含文件名)
     *
     * @param fileName 文件名
     * @return 相对路径
     */
    public static String getFileRelativePathByType(String fileName) {
        String fileExtension = getFileExtension(fileName);
        switch (fileExtension) {
            case "flac":
                return FileConst.FLAC_SONG_PATH;
            case "mp3":
                return FileConst.MP3_IMG_PATH;
        }
        return "";
    }
}
