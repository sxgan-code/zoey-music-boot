/* email.password请根据实际情况配置，以下为示例 */
insert into sys_code
    (config_key, config_value, config_type, description)
values ('email.password', 'xxxxxxxxxxxx', 'sys_config', '授权码');

truncate table music_list;
insert into music_list(list_id, list_name, list_info, list_style, list_pic, user_id, list_type)
values (1000000001, '只此一生',
        '每个人的生活都是一本书。透过字里行间琐碎的情节，洞悉自己，了解自己，活出生命的韧性与强大，是我们毕生的功课。——《自渡》 ',
        '#流行,#治愈,#情歌', '/image/list/song-list-zip-0001.jpg', 10000, 1),
       (1000000002, '此行光明', '事物的发展是螺旋式上升和波浪式前进的，虽然道路是曲折的，但是前途是光明的。',
        '#流行,#治愈,#情歌', '/image/list/song-list-zip-0002.jpg', 10000, 1),
       (1000000003, '童话故事',
        '我愿变成童话里，你爱的那个天使，张开双手变成翅膀守护你，你要相信，相信我们会像童话故事里，幸福和快乐是结局。',
        '#流行,#治愈,#情歌', '/image/list/song-list-zip-0003.jpg', 10000, 1),
       (1000000004, '从前慢', '从前的日色变得慢，车，马，邮件都慢，一生只够爱一个人。', '#流行,#治愈,#情歌',
        '/image/list/song-list-zip-0004.jpg', 10000, 1),
       (1000000005, '天上星，海底月', '我还是相信，星星会说话，石头会开花，穿过夏天的木栅栏和冬天的风雪之后，你终会抵达！ ',
        '#流行,#治愈,#情歌', '/image/list/song-list-zip-0005.jpg', 10000, 1),
       (1000000006, '漫长的旅途', '成长，是每个孩子的权力，也是他们必经的征程，或平坦', '#流行,#治愈,#情歌',
        '/image/list/song-list-zip-0006.jpg', 10000, 2),
       (1000000007, '和光同尘', '人和人在一起，是时机成熟的一个总和，需要天时地利人和，才有缘聚在一起细数细水长流的日子。',
        '#流行,#治愈,#情歌', '/image/list/song-list-zip-0007.jpg', 10000, 1),
       (1000000008, '活出自己的人生',
        '人生是不断与"理想的自己"进行比较，而非生活在他人的评价之下。阿德勒心理学否定寻求他人的认可。我们不是为了满足别人的期待而活着，而是为了自己活出自己的人生。',
        '#流行,#治愈,#情歌', '/image/list/song-list-zip-0008.jpg', 10000, 2),
       (1000000009, '成为你自己',
        '我们终其一生寻找的，应该是自己喜欢的生活方式和成为想成为的人。多走点弯路没关系，多花点时间在路上也不要紧，和别人所期待的不一样也可以。只要你是在成为你的路上就够了。',
        '#流行,#治愈,#情歌', '/image/list/song-list-zip-0009.jpg', 10000, 2),
       (1000000010, '未完的旋律', '真正强大的人，不会因为别人的眼光去改变而是用自己的能力去改变别人的眼光。',
        '#流行,#治愈,#情歌', '/image/list/song-list-zip-0010.jpg', 10000, 1);

truncate table music_list_song_relate;
insert into music_list_song_relate(list_song_id, list_id, song_id)
values (default, 1000000000, 3000000000),
       (default, 1000000001, 3000000001),
       (default, 1000000002, 3000000002),
       (default, 1000000003, 3000000003),
       (default, 1000000004, 3000000004),
       (default, 1000000005, 3000000005),
       (default, 1000000006, 3000000006),
       (default, 1000000007, 3000000007),
       (default, 1000000008, 3000000008),
       (default, 1000000001, 3000000009),
       (default, 1000000002, 3000000010),
       (default, 1000000003, 3000000011),
       (default, 1000000001, 3000000012),
       (default, 1000000005, 3000000013),
       (default, 1000000001, 3000000014),
       (default, 1000000008, 3000000015),
       (default, 1000000009, 3000000016),
       (default, 1000000009, 3000000017),
       (default, 1000000009, 3000000018),
       (default, 1000000009, 3000000019),
       (default, 1000000002, 3000000020),
       (default, 1000000003, 3000000021),
       (default, 1000000004, 3000000022),
       (default, 1000000005, 3000000023),
       (default, 1000000006, 3000000024),
       (default, 1000000007, 3000000025),
       (default, 1000000008, 3000000026),
       (default, 1000000001, 3000000027),
       (default, 1000000002, 3000000028),
       (default, 1000000003, 3000000029),
       (default, 1000000004, 3000000030),
       (default, 1000000005, 3000000031),
       (default, 1000000006, 3000000032),
       (default, 1000000006, 3000000033),
       (default, 1000000007, 3000000034),
       (default, 1000000008, 3000000035),
       (default, 1000000001, 3000000036),
       (default, 1000000002, 3000000037),
       (default, 1000000003, 3000000038),
       (default, 1000000001, 3000000039),
       (default, 1000000005, 3000000040),
       (default, 1000000001, 3000000041),
       (default, 1000000005, 3000000042),
       (default, 1000000006, 3000000043),
       (default, 1000000006, 3000000044),
       (default, 1000000007, 3000000045),
       (default, 1000000008, 3000000046),
       (default, 1000000001, 3000000047),
       (default, 1000000002, 3000000048),
       (default, 1000000003, 3000000049),
       (default, 1000000001, 3000000050),
       (default, 1000000005, 3000000051),
       (default, 1000000010, 3000000052),
       (default, 1000000010, 3000000053),
       (default, 1000000010, 3000000054),
       (default, 1000000010, 3000000055),
       (default, 1000000005, 3000000056),
       (default, 1000000006, 3000000057),
       (default, 1000000006, 3000000058),
       (default, 1000000007, 3000000059),
       (default, 1000000008, 3000000060),
       (default, 1000000001, 3000000061),
       (default, 1000000002, 3000000062),
       (default, 1000000003, 3000000063),
       (default, 1000000001, 3000000064),
       (default, 1000000005, 3000000065),
       (default, 1000000005, 3000000066);