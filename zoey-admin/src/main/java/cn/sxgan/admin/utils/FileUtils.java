package cn.sxgan.admin.utils;

import cn.hutool.core.util.StrUtil;
import cn.sxgan.common.constant.FileConst;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文件公共操作类
 *
 * @author GanShaoXi
 * @return cn.daniel.music.utils
 * @date 2021/11/23 17:33
 * @versions 1.0.0
 */
public class FileUtils {
    
    // 获取根目录
    private static String PROJECT_DIR = System.getProperty("user.dir");
    
    /**
     * 上传文件到项目指定目录
     *
     * @param file 上传的文件 (必传项)
     * @param path 需要保存到项目根目录下的路径(必传项)
     * @param type 文件扩展名类型(非必传项：可传null,表示以当前文件类型保存；指定类型则会校验上传文件与指定类型是否相同)
     * @return String  是否上传成功 文件保存则返回相对路径，失败返回null
     */
    public static String uploadFile(MultipartFile file, String path, String type) {
        // 判断上传文件是否为空
        if (file == null || path == null) return null;
        // 判断上传文件与指定类型是否相等
        String originalFilename = file.getOriginalFilename();
        if (type != null) {
            String fileType = originalFilename.split("[.]")[1];
            if (!fileType.equals(type)) {
                return null;
            }
        }
        // 完整的文件路径，不带文件
        File fileDir = new File(PROJECT_DIR, path);
        // 判断文件路径是否存在
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        // 给文件加时间戳的文件名
        originalFilename = originalFilename.split("[.]")[0] + "_" + new Date().getTime() + "." + originalFilename.split("[.]")[1];
        // 带文件的完整路径
        File allFilePath = new File(fileDir, originalFilename);
        // 声明
        InputStream inputStream = null;
        BufferedInputStream bis = null;
        OutputStream outputStream = null;
        BufferedOutputStream bos = null;
        // 上传是否成功
        String flag = null;
        try {
            // 获取文件输入流daniel_1637832410037.jpg
            inputStream = file.getInputStream();
            // 获取文件输入缓冲流
            bis = new BufferedInputStream(inputStream);
            // 获取文件输出流
            outputStream = new FileOutputStream(allFilePath);
            // 获取文件输出缓冲流
            bos = new BufferedOutputStream(outputStream);
            // 缓冲数组
            byte[] by = new byte[10 * 1024 * 1024];
            // 将文件读入数组并写入输出文件
            while (bis.read(by) != -1) {
                bos.write(by, 0, by.length);
            }
            flag = path + originalFilename;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            closeIOStream(inputStream, outputStream, bis, bos);
        }
        return flag;
    }
    
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
     * 关闭io流
     *
     * @param is
     * @param os
     * @param bis
     * @param bos
     */
    public static void closeIOStream(InputStream is, OutputStream os, BufferedInputStream bis, BufferedOutputStream bos) {
        try {
            if (bos != null) {
                bos.close();
            }
            if (bis != null) {
                bis.close();
            }
            if (os != null) {
                os.close();
            }
            if (is != null) {
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
