package cn.sxgan.admin.service.impl;

import cn.sxgan.admin.service.IFileManageService;
import cn.sxgan.common.entity.MusicSong;
import cn.sxgan.common.entity.MyPage;
import cn.sxgan.common.entity.converts.IMusicSongConvert;
import cn.sxgan.common.entity.query.SearchSongQuery;
import cn.sxgan.common.entity.vo.MusicSongVO;
import cn.sxgan.common.mapper.IMusicSongMapper;
import cn.sxgan.common.response.ResponseResult;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 歌曲文件服务
 * @Author: sxgan
 * @Date: 2024-05-26 21:28
 * @Version: 1.0
 **/
@Slf4j
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
    
    @Override
    public ResponseResult<String> updateSongInfo(MusicSongVO songVO) {
        log.info("FileManageServiceImpl updateSongInfo: {}", songVO);
        MusicSong musicSong = IMusicSongConvert.INSTANCE.convert(songVO);
        // 更新歌曲信息
        int update = iMusicSongMapper.update(musicSong, new UpdateWrapper<MusicSong>().eq("song_id", songVO.getSongId()));
        
        if (update > 0) {
            return ResponseResult.success("更新成功");
        }
        return ResponseResult.fail("更新失败");
    }
    
    @Override
    public ResponseResult<MyPage<MusicSongVO>> searchSongList(MusicSongVO songVO) {
        SearchSongQuery searchSongQuery = IMusicSongConvert.INSTANCE.convertQuery(songVO);
        List<MusicSong> musicSongs = iMusicSongMapper.searchSongByCondition(searchSongQuery);
        List<MusicSongVO> list = IMusicSongConvert.INSTANCE.convertList(musicSongs);
        MyPage<MusicSongVO> page = new MyPage<>();
        page.setPageTotal(1L);
        page.setList(list);
        page.setPageSize((long) list.size());
        page.setDataTotal((long) list.size());
        page.setCurrentIndex(1L);
        return ResponseResult.success(page);
    }
}
