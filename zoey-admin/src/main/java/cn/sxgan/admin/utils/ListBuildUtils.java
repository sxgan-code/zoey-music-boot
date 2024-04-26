package cn.sxgan.admin.utils;

import cn.sxgan.common.constant.SystemConst;
import cn.sxgan.common.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 歌单处理工具
 * @Author: sxgan
 * @Date: 2024-04-23 10:51
 * @Version: 1.0
 **/

public class ListBuildUtils {
    private static final Logger log = LoggerFactory.getLogger(ListBuildUtils.class);
    private static Long SONG_NUM = 902L;
    private static Long SONG_List_NUM = 1000000011L;
    
    
    public static void main(String[] args) {
        Map<String, String> textInfos = loadListInfoFile();
        buildSongList(textInfos);
        buildListSongRelateSql(textInfos);
    }
    
    private static void buildListSongRelateSql(Map<String, String> textInfos) {
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append("insert into music_list_song_relate(list_song_id, list_id, song_id) values \n");
        
        SONG_List_NUM = 1000000011L;
        for (int i = 0; i < textInfos.size(); i++) {
            // 随机歌曲
            Set<Integer> randomSongIds = CommonUtils.generateUniqueRandomNumbers(0, 902, (int) (Math.random() * 40 + 30));
            List songIds = new ArrayList<Integer>(randomSongIds);
            String[] songIdStr = CommonUtils.intArrayToStringArray(songIds, 3);
            for (String s : songIdStr) {
                stringBuilder.append("(default, " + SONG_List_NUM + ", 3000000" + s + "),\n");
            }
            SONG_List_NUM += 1;
        }
        String substring = stringBuilder.toString().substring(0, stringBuilder.length() - 2);
        substring = substring + ";";
        FileUtils.writeADocument(substring, SystemConst.APP_DIR + "/doc/list_song_relate.sql", false);
    }
    
    private static Map<String, String> loadListInfoFile() {
        Map map = new HashMap<String, String>();
        List<String> strings = FileUtils.loadFileToList(SystemConst.APP_DIR + "/resources/image/list/list_info.text");
        for (String item : strings) {
            String[] split = item.split("，");
            String listName = "";
            for (int i = 0; i < split.length - 2; i++) {
                if (i == 0) {
                    listName = split[i];
                }
                if (listName.length() > split[i + 1].length()) {
                    listName = split[i + 1];
                }
            }
            listName.replaceAll("。", "");
            listName.replaceAll("、", "");
            listName.replaceAll("；", "");
            map.put(listName, item);
        }
        return map;
    }
    
    private static void buildSongList(Map textInfos) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("insert into music_list(list_id, list_name, list_info, list_style, list_pic, user_id, list_type)\n" +
                "values \n");
        textInfos.forEach((key, value) -> {
            // 随机照片
            Set<Integer> randomListImg = CommonUtils.generateUniqueRandomNumbers(0, 90, 1);
            List listImgs = new ArrayList<Integer>(randomListImg);
            String[] songListIdStr = CommonUtils.intArrayToStringArray(listImgs, 2);
            stringBuilder.append("(" + SONG_List_NUM + ", '" + key + "'," +
                    "'" + value + "'," +
                    "'#流行,#治愈,#情歌', '/image/list/song-list-zip-00" + songListIdStr[0] + ".jpg', -1, 1),\n");
            SONG_List_NUM += 1;
        });
        String substring = stringBuilder.toString().substring(0, stringBuilder.length() - 2);
        substring = substring + ";";
        FileUtils.writeADocument(substring, SystemConst.APP_DIR + "/doc/list_info.sql", false);
    }
}
