package cn.sxgan.admin.service.impl;

import cn.sxgan.admin.service.IFileManageService;
import cn.sxgan.common.entity.MusicSong;
import cn.sxgan.common.entity.Page;
import cn.sxgan.common.entity.converts.IMusicSongConvert;
import cn.sxgan.common.entity.vo.MusicSongVO;
import cn.sxgan.common.mapper.IMusicSongMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public List<MusicSongVO> getAllSongFile(Page<MusicSongVO> page) {
        // 根据分页获取对应数据
        Integer pageNum = page.getCurrentIndex();
        Integer pageSize = page.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<MusicSong> musicSongs = iMusicSongMapper.selectList(new QueryWrapper<>());
        PageInfo<MusicSong> musicSongPageInfo = new PageInfo<>();
        long total = musicSongPageInfo.getTotal();
        page.setPageTotal(Integer.parseInt(String.valueOf(total)));
        return IMusicSongConvert.INSTANCE.convertList(musicSongs);
    }
}
