package cn.sxgan.common.utils;

import cn.sxgan.common.constant.FileConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * @Description: 通用文件上传类
 * @Author: sxgan
 * @Date: 2024-05-31 20:16
 * @Version: 1.0
 **/

public class FileUploadUtils {
    
    private static final Logger log = LoggerFactory.getLogger(FileUploadUtils.class);
    
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
        File fileDir = new File(FileConst.PROJECT_URL, path);
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
            log.info("上传路径为:{}", flag);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            closeIOStream(inputStream, outputStream, bis, bos);
        }
        return flag;
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
}
