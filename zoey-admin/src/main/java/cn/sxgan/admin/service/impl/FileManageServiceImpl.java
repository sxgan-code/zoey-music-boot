package cn.sxgan.admin.service.impl;

import cn.sxgan.admin.service.IFileManageService;
import cn.sxgan.common.entity.MusicSong;
import cn.sxgan.common.entity.MyPage;
import cn.sxgan.common.entity.converts.IMusicSongConvert;
import cn.sxgan.common.entity.vo.MusicSongVO;
import cn.sxgan.common.mapper.IMusicSongMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 歌曲文件服务
 * @Author: sxgan
 * @Date: 2024-05-26 21:28
 * @Version: 1.0
 **/
@Service
public class FileManageServiceImpl implements IFileManageService {
    
    @Resource
    private IMusicSongMapper iMusicSongMapper;
    
    @Override
    public List<MusicSongVO> getAllSongFile(MyPage<MusicSongVO> page) {
        // 根据分页获取对应数据
        Long pageNum = page.getCurrentIndex();
        Long pageSize = page.getPageSize();
        Page<MusicSong> musicSongPage = iMusicSongMapper.selectPage(new Page<>(pageNum, pageSize), null);
        List<MusicSong> musicSongs = musicSongPage.getRecords();
        page.setDataTotal(musicSongPage.getTotal());
        page.setPageTotal(musicSongPage.getPages());
        return IMusicSongConvert.INSTANCE.convertList(musicSongs);
    }
}
