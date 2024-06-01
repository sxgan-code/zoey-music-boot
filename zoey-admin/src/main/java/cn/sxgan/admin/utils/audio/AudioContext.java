package cn.sxgan.admin.utils.audio;


import cn.sxgan.common.entity.MusicSong;

import java.io.File;

/**
 * @Description: 音频使用场景
 * @Author: sxgan
 * @Date: 2024-05-15 23:13
 * @Version: 1.0
 **/

public class AudioContext {
    
    private final IAudioProcess iAudioProcess;
    
    
    public AudioContext(IAudioProcess strategy) {
        this.iAudioProcess = strategy;
    }
    
    public MusicSong use(File file) {
        return iAudioProcess.process(file);
    }
}
