package cn.sxgan.admin.service;

import cn.sxgan.common.entity.vo.MusicSongVO;

import java.util.List;

/**
 * @Description: 文件管理服务接口
 * @Author: sxgan
 * @Date: 2024-05-26 21:27
 * @Version: 1.0
 **/

public interface IFileManageService {
    /**
     * 获取全部歌曲文件
     */
    List<MusicSongVO> getAllSongFile();
}
