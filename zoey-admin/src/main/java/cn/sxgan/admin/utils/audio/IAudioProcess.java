package cn.sxgan.admin.utils.audio;

import java.io.File;

/**
 * @Description: 音频处理接口
 * @Author: sxgan
 * @Date: 2024-05-15 22:39
 * @Version: 1.0
 **/

public interface IAudioProcess {
    /**
     * 每种音频处理的方法
     */
    void process(File audioFile);
}
