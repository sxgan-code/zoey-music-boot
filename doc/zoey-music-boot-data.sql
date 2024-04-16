/* email.password请根据实际情况配置，以下为示例 */
insert into sys_code(config_key, config_value, config_type, description)
values ('email.password', 'xxxxxxxxxxxx', 'sys_config', '授权码');



insert into music_list(list_name, list_info, list_style, list_pic, user_id, list_type)
values ('汐若初见', '山林是你们的也是我们的，为什么要霸占它呢，人类和狸子还有那么多的动物，为什么不能和睦的相处呢?', '',
        '/Resource/image/songListImg/001_1642492472819.jfif', 1000000000, 2),
       ('顾北凉城', '归于土，而滋养了草。蒙古人在这个巨大的食物链和生命循环体系中生存，也看到自己的存在。', '',
        '/Resource/image/songListImg/020_1642661583557.jfif', 1000000000, 2),
       ('流年亂了浮生', '如果失去了童真的话，那狸子就不是狸子了。', '',
        '/Resource/image/songListImg/021_1642661639671.jfif', 1000000000, 2),
       ('巴黎的雪花飘落在东京路上', '我浑身伤痛，跋涉万里，疲倦地寻找，只为来与你相见。', '',
        '/Resource/image/songListImg/022_1642661680344.jfif', 1000000000, 2),
       ('孤久则安', '曾经发生过的事不可能忘记，只是想不起来了', '', '/Resource/image/songListImg/123.jpg', 1000000000,
        2),
       ('海是天的影子', '成长，是每个孩子的权力，也是他们必经的征程，或平坦', '',
        '/Resource/image/songListImg/300 (9)_1642493108952.jfif', 1000000000, 2),
       ('时光如画，划过你明媚的眼', '不要对外表过分在意，心灵才是最重要的。', '',
        '/Resource/image/songListImg/109951163408189924.jpg', 1000000000, 2),
       ('花前月下，只为伱如痴如醉', '不要吃太胖噢，会被杀掉的!', '', '/Resource/image/songListImg/109951163414509421.jpg',
        1000000000, 2),
       ('夏末沉沦', '多年后，再回想年少时的迷茫和执着，或许原因都不记得了。青春就是让你张扬地笑，也给你莫名的痛。', '',
        '/Resource/image/songListImg/109951163443093546.jpg', 1000000000, 2),
       ('未完的旋律', '人老的唯一好处就是，少了的东西越来越少了。', '',
        '/Resource/image/songListImg/109951163462173993.jpg', 1000000000, 2);

insert into music_song(song_name, song_url, song_pic, lyric_url, song_style, release_date, album_id, singer_id)
values ('Because of You', '/Resource/songs/Because of You - Kelly Clarkson.mp3',
        '/Resource/image/songImg/Because of You.png', '', '#流行，#怀旧', '2022-10-18 14:22:10', 80000001, 50000001),
       ('Everytime We Touch', '/Resource/songs/Everytime We Touch - 录音吉娃娃 _ 谢子新.mp3',
        '/Resource/image/songImg/Everytime We Touch.png', '', '#流行，#怀旧', '2022-10-18 14:22:10', 80000001, 50000001),
       ('Fugitive', '/Resource/songs/Fugitive - Tebey.mp3', '/Resource/image/songImg/Fugitive.png', '', '#流行，#怀旧',
        '2022-10-18 14:22:10', 80000001, 50000001),
       ('Lemon', '/Resource/songs/Lemon - 米津玄師 (よねづ けんし).mp3', '/Resource/image/songImg/Lemon.png', '',
        '#流行，#怀旧', '2022-10-18 14:22:10', 80000001, 50000001),
       ('君がくれたもの(secret base 你给我的所有)',
        '/Resource/songs/secret base ~君がくれたもの~ (secret base ~你给我的所有~) (10 years after Ver_) - 茅野愛衣 (かやの あい) _ 戸松遥 (とまつ はるか) _ 早见沙织 (はやみ さおり).mp3',
        '/Resource/image/songImg/secret base ~君がくれたもの~ (secret base ~你给我的所有~) (10 years after Ver.).png',
        '', '#流行，#怀旧', '2022-10-18 14:22:10', 80000001, 50000001),
       ('Stay With Me', '/Resource/songs/Stay With Me - 灿烈 (찬열) _ PUNCH (펀치).mp3',
        '/Resource/image/songImg/Stay With Me.png', '', '#流行，#怀旧', '2022-10-18 14:22:10', 80000001, 50000001),
       ('Take Me Hand', '/Resource/songs/Take Me Hand - DAISHI DANCE (ダイシ・ダンス) _ Cécile Corbel.mp3',
        '/Resource/image/songImg/Take Me Hand.png', '', '#流行，#怀旧', '2022-10-18 14:22:10', 80000001, 50000001),
       ('Yeminler Ediyorum', '/Resource/songs/Yeminler Ediyorum - Rido _ Faxo.mp3',
        '/Resource/image/songImg/Yeminler Ediyorum.png', '', '#流行，#怀旧', '2022-10-18 14:22:10', 80000001, 50000001),
       ('ありがとう… (谢谢…)', '/Resource/songs/ありがとう… (谢谢…) - KOKIA (吉田亚纪子).mp3',
        '/Resource/image/songImg/ありがとう… (谢谢…).png', '', '#流行，#怀旧', '2022-10-18 14:22:10', 80000001,
        50000001),
       ('いつも何度でも (永远同在)', '/Resource/songs/いつも何度でも (永远同在) - 木村弓 (きむら ゆみ).mp3',
        '/Resource/image/songImg/いつも何度でも (永远同在).png', '', '#流行，#怀旧', '2022-10-18 14:22:10', 80000001,
        50000001),
       ('一半', '/Resource/songs/一半 - 薛之谦.mp3', '/Resource/image/songImg/一半.png', '', '#流行，#怀旧',
        '2022-10-18 14:22:10', 80000001, 50000001),
       ('下雨了 (Live)', '/Resource/songs/下雨了 (Live) - 薛之谦 _ 毛不易.mp3',
        '/Resource/image/songImg/下雨了 (Live).png', '', '#流行，#怀旧', '2022-10-18 14:22:10', 80000001, 50000001),
       ('下雨了', '/Resource/songs/下雨了 - 薛之谦(1).mp3', '/Resource/image/songImg/下雨了.png', '', '#流行，#怀旧',
        '2022-10-18 14:22:10', 80000001, 50000001),
       ('下雨了', '/Resource/songs/下雨了 - 薛之谦.mp3', '/Resource/image/songImg/下雨了.png', '', '#流行，#怀旧',
        '2022-10-18 14:22:10', 80000001, 50000001),
       ('不染', '/Resource/songs/不染 - 简弘亦.mp3', '/Resource/image/songImg/不染.png', '', '#流行，#怀旧',
        '2022-10-18 14:22:10', 80000001, 50000001),
       ('不爱我', '/Resource/songs/不爱我 - 薛之谦.mp3', '/Resource/image/songImg/不爱我.png', '', '#流行，#怀旧',
        '2022-10-18 14:22:10', 80000001, 50000001),
       ('不知所措', '/Resource/songs/不知所措 - 王靖雯.mp3', '/Resource/image/songImg/不知所措.png', '', '#流行，#怀旧',
        '2022-10-18 14:22:10', 80000001, 50000001);

select *
from music_list;

select *
from music_song;


insert into music_list_song_relate (list_id, song_id)
values (1000000000, 3000000000),
       (1000000001, 3000000001),
       (1000000002, 3000000002),
       (1000000003, 3000000003),
       (1000000004, 3000000004),
       (1000000005, 3000000005),
       (1000000006, 3000000006),
       (1000000007, 3000000007),
       (1000000008, 3000000010),
       (1000000001, 3000000011),
       (1000000002, 3000000012),
       (1000000003, 3000000013),
       (1000000001, 3000000014),
       (1000000005, 3000000015),
       (1000000001, 3000000016),
       (1000000008, 3000000008),
       (1000000009, 3000000009);