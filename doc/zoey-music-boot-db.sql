-- 创建数据库
create database if not exists zoey_music_boot_db default charset utf8mb4;
-- 切换到数据库

use zoey_music_boot_db;
SET NAMES utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- 1、系统配置表
-- ----------------------------
drop table if exists sys_code;
drop table if exists sys_code;
create table sys_code
(
    config_id    bigint(6)     not null auto_increment comment '主键配置ID，主键约束',
    config_key   varchar(128)  not null comment '配置Key值，唯一约束',
    config_value varchar(2000) not null comment '配置的Value值，如果有多个，用逗号隔开',
    config_type  varchar(50)   not null default '' comment '配置类型',
    description  varchar(100)  not null default '' comment '作用描述',
    create_time  datetime      not null default current_timestamp comment '创建时间',
    update_time  datetime      not null default current_timestamp on update current_timestamp comment '更新时间',
    del_flag     tinyint       not null default '0' comment '是否删除：0-否；1-是',
    primary key (config_id),
    unique key uk_config_key (config_key)
) engine = innodb
  auto_increment = 1000
  default charset = utf8mb4 comment ='系统代码配置表';
desc sys_code;
-- ----------------------------
-- 2、用户信息表
-- ----------------------------
drop table if exists sys_user;
create table sys_user
(
    user_id         bigint(10)   not null auto_increment comment '用户ID',
    user_name       varchar(30)  not null default '' comment '用户昵称',
    email           varchar(50)  not null default '' comment '用户邮箱',
    password        varchar(50)  not null default '' comment '密码',
    sex             tinyint(1)   not null default 2 comment '用户性别（0男 1女 2未知）',
    phone_number    varchar(11)  not null default '' comment '手机号码',
    avatar          varchar(100) not null default '' comment '头像路径',
    personal_sign   varchar(500) not null default '' comment '个性签名',
    salt            varchar(20)  not null default '' comment '盐加密',
    dept_id         bigint(4)    not null default -1 comment '部门ID',
    user_type       tinyint(1)   not null default 1 comment '用户类型（0系统用户 1普通用户）',
    status          tinyint(1)   not null default 1 comment '帐号状态（1正常 0停用）',
    login_ip        varchar(128) not null default '' comment '最后登录IP',
    login_date      datetime     not null default current_timestamp comment '最后登录时间',
    pwd_update_date datetime     not null default current_timestamp comment '密码最后更新时间',
    remark          varchar(500) not null default '' comment '备注',
    create_by       varchar(64)  not null default '' comment '创建者',
    update_by       varchar(64)  not null default '' comment '更新者',
    create_time     datetime     not null default current_timestamp comment '创建时间',
    update_time     datetime     not null default current_timestamp on update current_timestamp comment '更新时间',
    del_flag        tinyint(1)   not null default 0 comment '删除标志（0代表存在 1代表删除）',
    primary key (user_id),
    unique key un_email_key (email)
) engine = innodb
  default charset = utf8mb4
  auto_increment = 10000 comment = '用户信息表';

-- ----------------------------
-- 3、部门表
-- ----------------------------
drop table if exists sys_dept;
create table sys_dept
(
    dept_id     int          not null auto_increment comment '部门ID',
    dept_name   varchar(100) not null default '' comment '部门名称',
    dept_no     varchar(20)  not null default '' comment '部门编号',
    create_time datetime     not null default current_timestamp comment '创建时间',
    update_time datetime     not null default current_timestamp on update current_timestamp comment '更新时间',
    del_flag    tinyint(1)   not null default 0 comment '删除标志：0-未删除，1-已删除',
    primary key (dept_id),
    unique key un_dept_no (dept_no)
) engine = innodb
  default charset = utf8mb4
  auto_increment = 1000 comment = '部门表';

-- ----------------------------
-- 4、用户角色关联表
-- ----------------------------
drop table if exists sys_role_user_relate;
create table sys_role_user_relate
(
    role_user_id int        not null auto_increment comment '账户角色ID',
    role_id      int        not null default -1 comment '角色ID',
    user_id      bigint(10) not null default -1 comment '账户ID',
    create_time  datetime   not null default current_timestamp comment '创建时间',
    update_time  datetime   not null default current_timestamp on update current_timestamp comment '更新时间',
    del_flag     tinyint(1) not null default 0 comment '删除标志：0-未删除，1-已删除',
    primary key (role_user_id),
    unique key un_role_user_key (role_id, user_id)
) engine = innodb
  default charset = utf8mb4
  auto_increment = 1000 comment = '用户角色关联表';

-- ----------------------------
-- 5、角色表
-- ----------------------------
drop table if exists sys_role;
create table sys_role
(
    role_id     int         not null auto_increment comment '角色ID',
    role_name   varchar(50) not null default '' comment '角色名称',
    create_time datetime    not null default current_timestamp comment '创建时间',
    update_time datetime    not null default current_timestamp on update current_timestamp comment '更新时间',
    del_flag    tinyint(1)  not null default 0 comment '删除标志：0-未删除，1-已删除',
    primary key (role_id)
) engine = innodb
  default charset = utf8mb4
  auto_increment = 1000 comment = '角色表';

-- ----------------------------
-- 6、角色权限表
-- ----------------------------
drop table if exists sys_auth;
create table sys_auth
(
    auth_id     int         not null auto_increment comment '权限ID',
    auth_name   varchar(64) not null default '' comment '权限名称',
    role_id     int         not null default -1 comment '角色ID',
    create_time datetime    not null default current_timestamp comment '创建时间',
    update_time datetime    not null default current_timestamp on update current_timestamp comment '更新时间',
    del_flag    tinyint(1)  not null default 0 comment '删除标志：0-未删除，1-已删除',
    primary key (auth_id)
) engine = innodb
  default charset = utf8mb4
  auto_increment = 1000 comment = '角色权限表';

-- ----------------------------
-- 7、歌单表
-- ----------------------------
drop table if exists music_list;
create table music_list
(
    list_id     bigint(10)   not null auto_increment comment '歌单号',
    list_name   varchar(50)  not null default '' comment '歌单名',
    list_type   int          not null default 2 comment '歌单类型: 1：创建，2：收藏，3创建及收藏',
    list_info   varchar(255) not null default '' comment '歌单简介',
    list_style  varchar(255) not null default '' comment '歌单风格',
    list_pic    varchar(255) not null default '' comment '歌单图片地址',
    user_id     bigint(10)   not null default -1 comment '所属用户',
    create_time datetime     not null default current_timestamp comment '创建时间',
    update_time datetime     not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (list_id)
) engine = innodb
  default charset = utf8mb4
  auto_increment = 1000000000 comment = '歌单表';

-- ----------------------------
-- 8、歌曲歌单关联表
-- ----------------------------
drop table if exists music_list_song_relate;
create table music_list_song_relate
(
    list_song_id bigint(10) not null auto_increment comment '歌曲歌单关联id',
    list_id      bigint(10) not null default -1 comment '歌单号',
    song_id      bigint(10) not null default -1 comment '歌曲ID',
    create_time  datetime   not null default current_timestamp comment '创建时间',
    update_time  datetime   not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (list_song_id),
    unique key un_list_song_key (list_id, song_id)
) engine = innodb
  default charset = utf8mb4
  auto_increment = 0 comment = '歌曲歌单关联表';

-- ----------------------------
-- 9、歌曲表
-- ----------------------------
drop table if exists music_song;
create table music_song
(
    song_id      bigint(10)   not null auto_increment comment '歌曲ID',
    song_name    varchar(50)  not null default '' comment '歌曲名称',
    song_url     varchar(255) not null default '' comment '歌曲地址',
    song_pic     varchar(255) not null default '' comment '歌曲图片地址',
    lyric_url    varchar(255) not null default '' comment '歌词文件地址',
    song_style   varchar(255) not null default '' comment '歌曲风格',
    release_date datetime     not null default current_timestamp comment '歌曲发行时间',
    album_id     varchar(50)  not null default '' comment '所属专辑',
    singer_id    varchar(50)  not null default '' comment '歌手id',
    del_flag     tinyint(1)   not null default 0 comment '删除标志：0-未删除，1-已删除',
    create_time  datetime     not null default current_timestamp comment '创建时间',
    update_time  datetime     not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (song_id)
) engine = innodb
  default charset = utf8mb4
  auto_increment = 3000000000 comment = '歌曲表';

-- ----------------------------
-- 10、歌手表(music_singer)
-- ----------------------------
drop table if exists music_singer;
create table music_singer
(
    singer_id   bigint(10)   not null auto_increment comment '歌手ID',
    singer_name varchar(50)  not null default '' comment '歌手名称',
    singer_pic  varchar(255) not null default '' comment '歌手图片地址',
    address     varchar(255) not null default '' comment '歌手所属地区',
    del_flag    tinyint(1)   not null default 0 comment '删除标志：0-未删除，1-已删除',
    create_time datetime     not null default current_timestamp comment '创建时间',
    update_time datetime     not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (singer_id)
) engine = innodb
  default charset = utf8mb4
  auto_increment = 5000000000 comment = '歌手表';

-- ----------------------------
-- 11、专辑表
-- ----------------------------
drop table if exists music_album;
create table music_album
(
    album_id     bigint(8)    not null auto_increment comment '专辑ID',
    album_name   varchar(50)  not null default '' comment '专辑名称',
    album_pic    varchar(255) not null default '' comment '专辑图片地址',
    release_date datetime     not null default current_timestamp comment '专辑发行日期',
    singer_id    bigint(10)   not null default -1 comment '歌手ID',
    del_flag     tinyint(1)   not null default 0 comment '删除标志：0-未删除，1-已删除',
    create_time  datetime     not null default current_timestamp comment '创建时间',
    update_time  datetime     not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (album_id)
) engine = innodb
  default charset = utf8mb4
  auto_increment = 80000000 comment = '专辑表';

-- ----------------------------
-- 12、歌曲评论表
-- ----------------------------
drop table if exists music_song_yelp;
create table music_song_yelp
(
    song_yelp_id bigint(10)   not null auto_increment comment '歌曲点评ID',
    yelp_content varchar(500) not null default '' comment '用户歌曲评论',
    user_id      bigint(10)   not null default -1 comment '用户ID',
    song_id      bigint(10)   not null default -1 comment '歌曲ID',
    is_like      tinyint(1)   not null default 0 comment '是否喜欢: 1-喜欢，0-不喜欢',
    create_time  datetime     not null default current_timestamp comment '创建时间',
    update_time  datetime     not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (song_yelp_id)
) engine = innodb
  default charset = utf8mb4
  auto_increment = 6000000000 comment = '歌曲评论表';

-- ----------------------------
-- 13、歌单评论表
-- ----------------------------
drop table if exists music_list_yelp;
create table music_list_yelp
(
    list_yelp_id bigint(10)   not null auto_increment comment '歌单点评ID',
    yelp_content varchar(500) not null default '' comment '用户歌单评论',
    user_id      bigint(10)   not null default -1 comment '用户ID',
    list_id      bigint(10)   not null default -1 comment '歌单号',
    create_time  datetime     not null default current_timestamp comment '创建时间',
    update_time  datetime     not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (list_yelp_id)
) engine = innodb
  default charset = utf8mb4
  auto_increment = 7000000000 comment = '歌单评论表';