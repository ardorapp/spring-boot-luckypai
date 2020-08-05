-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- 主机： 172.20.0.11:3306
-- 生成日期： 2020-08-05 08:33:32
-- 服务器版本： 8.0.21
-- PHP 版本： 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `luckypai`
--

-- --------------------------------------------------------

--
-- 表的结构 `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- 表的结构 `persistent_logins`
--

CREATE TABLE `persistent_logins` (
  `series` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'id',
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '登陆账号',
  `token` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'cookie令牌',
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='persistent_logins表，用户实现记住我功能' ROW_FORMAT=COMPACT;

--
-- 转存表中的数据 `persistent_logins`
--

INSERT INTO `persistent_logins` (`series`, `username`, `token`) VALUES
('JfzUH7JQ9FUEU+QX2+A0zg==', 'sa', 'BXHyCV+8CAuWh9Mjd1WFbg==');

-- --------------------------------------------------------

--
-- 表的结构 `red_packet_record`
--

CREATE TABLE `red_packet_record` (
  `id` bigint NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `money` int DEFAULT NULL,
  `red_packet_id` bigint DEFAULT NULL,
  `uid` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `red_packet_record`
--

INSERT INTO `red_packet_record` (`id`, `create_time`, `money`, `red_packet_id`, `uid`) VALUES
(1, '2020-07-25 11:23:43', 3441, 1, 13),
(2, '2020-07-25 11:23:43', 408, 1, 1),
(4, '2020-07-25 11:23:43', 2169, 1, 3),
(5, '2020-07-25 11:23:43', 1973, 1, 4),
(7, '2020-07-25 11:23:43', 3668, 1, 6),
(9, '2020-07-25 11:23:43', 802, 1, 12),
(10, '2020-07-25 11:23:43', 133, 1, 5),
(12, '2020-07-25 11:23:43', 2928, 1, 14),
(14, '2020-07-25 11:23:43', 4478, 1, 2),
(15, '2020-07-25 11:28:21', 953, 2, 14),
(16, '2020-07-25 11:28:21', 567, 2, 1),
(18, '2020-07-25 11:28:21', 3376, 2, 7),
(20, '2020-07-25 11:28:21', 3035, 2, 4),
(22, '2020-07-25 11:28:21', 2647, 2, 2),
(24, '2020-07-25 11:28:21', 234, 2, 6),
(25, '2020-07-25 11:28:21', 3004, 2, 3),
(27, '2020-07-25 11:28:21', 2752, 2, 9),
(29, '2020-07-25 11:28:21', 3432, 2, 5);

-- --------------------------------------------------------

--
-- 表的结构 `red_racket`
--

CREATE TABLE `red_racket` (
  `id` bigint NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `red_packet_id` bigint NOT NULL,
  `total_amount` int NOT NULL,
  `total_packet` int NOT NULL,
  `type` int NOT NULL,
  `uid` int NOT NULL,
  `version` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `seckill`
--

CREATE TABLE `seckill` (
  `seckill_id` bigint NOT NULL COMMENT '商品库存id',
  `name` varchar(120) NOT NULL COMMENT '商品名称',
  `number` int NOT NULL COMMENT '库存数量',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀开启时间',
  `end_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀结束时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `version` int NOT NULL COMMENT '版本号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';

--
-- 转存表中的数据 `seckill`
--

INSERT INTO `seckill` (`seckill_id`, `name`, `number`, `start_time`, `end_time`, `create_time`, `version`) VALUES
(1000, '1000元秒杀iphone8', 100, '2018-05-10 15:31:53', '2018-05-10 15:31:53', '2018-05-10 15:31:53', 0),
(1001, '500元秒杀ipad2', 100, '2018-05-10 15:31:53', '2018-05-10 15:31:53', '2018-05-10 15:31:53', 0),
(1002, '300元秒杀小米4', 100, '2018-05-10 15:31:53', '2018-05-10 15:31:53', '2018-05-10 15:31:53', 0),
(1003, '200元秒杀红米note', 100, '2018-05-10 15:31:53', '2018-05-10 15:31:53', '2018-05-10 15:31:53', 0);

-- --------------------------------------------------------

--
-- 表的结构 `success_killed`
--

CREATE TABLE `success_killed` (
  `seckill_id` bigint NOT NULL COMMENT '秒杀商品id',
  `user_id` bigint NOT NULL COMMENT '用户Id',
  `state` tinyint NOT NULL COMMENT '状态标示：-1指无效，0指成功，1指已付款',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';

-- --------------------------------------------------------

--
-- 表的结构 `sys_authority`
--

CREATE TABLE `sys_authority` (
  `authority_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限id',
  `authority_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称，ROLE_开头，全大写',
  `authority_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `authority_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限内容，可访问的url，多个时用,隔开'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统权限表' ROW_FORMAT=COMPACT;

--
-- 转存表中的数据 `sys_authority`
--

INSERT INTO `sys_authority` (`authority_id`, `authority_name`, `authority_remark`, `create_time`, `update_time`, `authority_content`) VALUES
('3fb1c570496d4c09ab99b8d31b06ccc', 'ROLE_USER', '普通用户', '2019-09-10 10:08:58', '2019-09-10 10:08:58', ''),
('3fb1c570496d4c09ab99b8d31b06xxx', 'ROLE_SA', '超级管理员', '2019-09-10 10:08:58', '2019-09-10 10:08:58', '/sys/**,/logging,/lucky/**'),
('3fb1c570496d4c09ab99b8d31b06zzz', 'ROLE_ADMIN', '管理员', '2019-09-10 10:08:58', '2019-09-10 10:08:58', '/sys/**');

-- --------------------------------------------------------

--
-- 表的结构 `sys_menu`
--

CREATE TABLE `sys_menu` (
  `menu_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单id',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `menu_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单路径',
  `menu_parent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上级id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单表' ROW_FORMAT=COMPACT;

--
-- 转存表中的数据 `sys_menu`
--

INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `menu_path`, `menu_parent_id`, `create_time`, `update_time`) VALUES
('11fafa2d2cbd4456817504d69478be7b', '地址管理', '/lucky/redPacket/wallet', 'bcf17dc0ce304f0ba02d64ce21ddb43d', '2020-08-04 12:32:57', '2020-08-04 12:32:57'),
('35cb950cebb04bb18bb1d8b742a02005', 'XXX菜单', '/xxx', '', '2019-09-11 18:05:21', '2019-09-11 18:05:21'),
('35cb950cebb04bb18bb1d8b742a02xaa', '权限管理', '/sys/sysAuthority/authority', '35cb950cebb04bb18bb1d8b742a02xxx', '2019-09-10 10:08:58', '2019-09-10 10:08:58'),
('35cb950cebb04bb18bb1d8b742a02xcc', '菜单管理', '/sys/sysMenu/menu', '35cb950cebb04bb18bb1d8b742a02xxx', '2019-09-10 10:08:58', '2019-09-10 10:08:58'),
('35cb950cebb04bb18bb1d8b742a02xxx', '系统管理', '/sys', '', '2019-09-10 10:08:58', '2019-09-10 10:08:58'),
('35cb950cebb04bb18bb1d8b742a02xzz', '用户管理', '/sys/sysUser/user', '35cb950cebb04bb18bb1d8b742a02xxx', '2019-09-10 10:08:58', '2019-09-10 10:08:58'),
('74315e162f524a4d88aa931f02416f26', '实时监控', '/monitor', '35cb950cebb04bb18bb1d8b742a02xxx', '2020-06-10 15:07:07', '2020-06-10 15:07:07'),
('914aa22c78af4327822061f3eada4067', '实时日志', '/logging', '35cb950cebb04bb18bb1d8b742a02xxx', '2019-09-11 11:19:52', '2019-09-11 11:19:52'),
('b9e5a8d943354e918b9b2e5d965ca0a6', '发红包', '/lucky/redPacket/create', 'bcf17dc0ce304f0ba02d64ce21ddb43d', '2020-08-04 12:29:44', '2020-08-04 12:29:44'),
('bcf17dc0ce304f0ba02d64ce21ddb43d', '红包管理', '/lucky', '', '2019-09-17 10:46:11', '2019-09-17 10:46:11'),
('bcf17dc0ce304f0ba02d64ce21ddb4f9', '系统设置', '/sys/sysSetting/setting', '35cb950cebb04bb18bb1d8b742a02xxx', '2019-09-17 10:46:11', '2019-09-17 10:46:11'),
('f65e2aa5ade94ca9a9e2994c9fbf3c58', '资产设置', '/wallet/assets/setting', 'bcf17dc0ce304f0ba02d64ce21ddb43d', '2020-08-05 06:25:07', '2020-08-05 06:25:07'),
('fe63a57226a84fc48dc303cd14f707b7', '收红包', '/lucky/redPacket/receive', 'bcf17dc0ce304f0ba02d64ce21ddb43d', '2020-08-04 13:03:00', '2020-08-04 13:03:00');

-- --------------------------------------------------------

--
-- 表的结构 `sys_setting`
--

CREATE TABLE `sys_setting` (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表id',
  `sys_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '系统名称',
  `sys_logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '系统logo图标',
  `sys_bottom_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '系统底部信息',
  `sys_notice_text` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '系统公告',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `user_init_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户管理：初始、重置密码',
  `sys_color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '系统颜色',
  `sys_api_encrypt` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'API加密 Y/N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统设置表' ROW_FORMAT=COMPACT;

--
-- 转存表中的数据 `sys_setting`
--

INSERT INTO `sys_setting` (`id`, `sys_name`, `sys_logo`, `sys_bottom_text`, `sys_notice_text`, `create_time`, `update_time`, `user_init_password`, `sys_color`, `sys_api_encrypt`) VALUES
('1', 'Lucky PAI', 'https://avatar.gitee.com/uploads/0/5137900_huanzi-qch.png!avatar100?1562729811', '© 2019 - 2020  Lucky PAI', '<h1 style=\"white-space: normal; text-align: center;\"><span style=\"color: rgb(255, 0, 0);\">通知</span></h1><p style=\"white-space: normal;\"><span style=\"color: rgb(255, 0, 0);\">1、不得在公共场sf合吸烟；afsafsf</span></p><p style=\"white-space: normal;\"><span style=\"color: rgb(255, 0, 0);\">2、xxxxxxx；</span></p><p>ff<br/></p>', '2019-09-17 10:15:38', '2019-09-17 10:15:40', '123456', 'rgba(54, 123, 183,  0.73)', 'Y');

-- --------------------------------------------------------

--
-- 表的结构 `sys_shortcut_menu`
--

CREATE TABLE `sys_shortcut_menu` (
  `shortcut_menu_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户快捷菜单id',
  `shortcut_menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户快捷菜单名称',
  `shortcut_menu_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户快捷菜单路径',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `shortcut_menu_parent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上级id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户快捷菜单表' ROW_FORMAT=COMPACT;

--
-- 转存表中的数据 `sys_shortcut_menu`
--

INSERT INTO `sys_shortcut_menu` (`shortcut_menu_id`, `shortcut_menu_name`, `shortcut_menu_path`, `user_id`, `shortcut_menu_parent_id`, `create_time`, `update_time`) VALUES
('104370a3fa7948bab156afd4a5f2a730', '个性化菜单', '', '1', '', '2019-09-12 18:35:13', '2019-09-12 18:35:13'),
('72d94b41b9994038bd2f2135a1de28d8', '快捷菜单', '', 'b5ac62e154964151a19c565346bb354a', '', '2019-09-17 14:36:28', '2019-09-17 14:36:28'),
('86bedbab7530477494883f65fed47f11', '撒放', '', '1', '', '2020-07-29 10:39:30', '2020-07-29 10:39:30'),
('88353f04ad5d47b182c984bfbb1693cc', 'ggg', '/xxx', 'b5ac62e154964151a19c565346bb354a', '72d94b41b9994038bd2f2135a1de28d8', '2019-09-17 14:36:50', '2019-09-17 14:36:50'),
('89d01bbd915b418e9b0fab09c4c7b94c', '是否', 'jshfius', '1', '', '2020-07-29 10:41:10', '2020-07-29 10:41:10');

-- --------------------------------------------------------

--
-- 表的结构 `sys_user`
--

CREATE TABLE `sys_user` (
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `login_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录名',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `valid` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '软删除标识，Y/N',
  `limited_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '限制允许登录的IP集合',
  `expired_time` datetime DEFAULT NULL COMMENT '账号失效时间，超过时间将不能登录系统',
  `last_change_pwd_time` datetime NOT NULL COMMENT '最近修改密码时间，超出时间间隔，提示用户修改密码',
  `limit_multi_login` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否允许账号同一个时刻多人在线，Y/N',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户表' ROW_FORMAT=COMPACT;

--
-- 转存表中的数据 `sys_user`
--

INSERT INTO `sys_user` (`user_id`, `login_name`, `user_name`, `password`, `valid`, `limited_ip`, `expired_time`, `last_change_pwd_time`, `limit_multi_login`, `create_time`, `update_time`) VALUES
('1', 'sa', '超级管理员', 'E10ADC3949BA59ABBE56E057F20F883E', 'Y', '', NULL, '2019-09-17 12:00:36', 'Y', '2019-07-19 16:36:03', '2020-08-05 06:25:26'),
('2', 'admin', '管理员', 'E10ADC3949BA59ABBE56E057F20F883E', 'Y', '', NULL, '2019-09-17 12:00:36', 'N', '2019-07-19 16:36:03', '2019-09-12 16:14:28'),
('3fb1c570496d4c09ab99b8d31b0671cf', 'daji', '妲己', 'E10ADC3949BA59ABBE56E057F20F883E', 'Y', '', NULL, '2019-09-17 12:00:36', 'Y', '2019-09-11 18:11:41', '2019-09-17 12:09:47'),
('b5ac62e154964151a19c565346bb354a', 'xiaofang', '小芳', 'E10ADC3949BA59ABBE56E057F20F883E', 'Y', '', NULL, '2019-09-17 12:00:36', 'N', '2019-09-17 14:12:41', '2020-07-28 14:41:47');

-- --------------------------------------------------------

--
-- 表的结构 `sys_user_authority`
--

CREATE TABLE `sys_user_authority` (
  `user_authority_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户权限表id',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `authority_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户权限表' ROW_FORMAT=COMPACT;

--
-- 转存表中的数据 `sys_user_authority`
--

INSERT INTO `sys_user_authority` (`user_authority_id`, `user_id`, `authority_id`, `create_time`, `update_time`) VALUES
('06a44d6d54a544068faedc240162bde5', '1', '3fb1c570496d4c09ab99b8d31b06xxx', '2020-08-05 06:25:27', '2020-08-05 06:25:27'),
('0dc1b156ed544c0986823e9cd818da08', '2', '3fb1c570496d4c09ab99b8d31b06ccc', '2019-09-12 16:14:28', '2019-09-12 16:14:28'),
('4c258be84d7a43dab8c478176e015740', '1', '3fb1c570496d4c09ab99b8d31b06ccc', '2020-08-05 06:25:27', '2020-08-05 06:25:27'),
('90c18739f3ad41ae8010f6c2b7eeaac5', '3fb1c570496d4c09ab99b8d31b0671cf', '3fb1c570496d4c09ab99b8d31b06ccc', '2019-09-17 12:09:47', '2019-09-17 12:09:47'),
('96cb900a068649fbb5fa1f7f7cdff355', '1', '3fb1c570496d4c09ab99b8d31b06zzz', '2020-08-05 06:25:27', '2020-08-05 06:25:27'),
('a414567aaae54b42b8344da02795cb91', '2', '3fb1c570496d4c09ab99b8d31b06zzz', '2019-09-12 16:14:28', '2019-09-12 16:14:28'),
('dd46ed0e01e24855b5430a9dc8d416f3', 'b5ac62e154964151a19c565346bb354a', '3fb1c570496d4c09ab99b8d31b06ccc', '2020-07-28 14:41:48', '2020-07-28 14:41:48');

-- --------------------------------------------------------

--
-- 表的结构 `sys_user_menu`
--

CREATE TABLE `sys_user_menu` (
  `user_menu_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户菜单表id',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `menu_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户菜单表' ROW_FORMAT=COMPACT;

--
-- 转存表中的数据 `sys_user_menu`
--

INSERT INTO `sys_user_menu` (`user_menu_id`, `user_id`, `menu_id`, `create_time`, `update_time`) VALUES
('05acfd5ff2074081ac8cfcea6f33767e', 'b5ac62e154964151a19c565346bb354a', '35cb950cebb04bb18bb1d8b742a02005', '2020-07-28 14:41:48', '2020-07-28 14:41:48'),
('12b01886190d4fec859fa054e73dad62', '1', '914aa22c78af4327822061f3eada4067', '2020-08-05 06:25:27', '2020-08-05 06:25:27'),
('187d863050a740ae9046cfc8e25780fb', '1', 'b9e5a8d943354e918b9b2e5d965ca0a6', '2020-08-05 06:25:27', '2020-08-05 06:25:27'),
('3232782f25ec44b09438ab9805b85f83', '2', '35cb950cebb04bb18bb1d8b742a02xcc', '2019-09-12 16:14:28', '2019-09-12 16:14:28'),
('45882e5900f3455b84d8a32cbcf6ed17', '1', '35cb950cebb04bb18bb1d8b742a02xxx', '2020-08-05 06:25:27', '2020-08-05 06:25:27'),
('57791437b9774d8abf74562a49c55a1a', '2', '35cb950cebb04bb18bb1d8b742a02xxx', '2019-09-12 16:14:28', '2019-09-12 16:14:28'),
('5cadc22ea37b46a3b332ddd0aeee9b00', '1', '11fafa2d2cbd4456817504d69478be7b', '2020-08-05 06:25:27', '2020-08-05 06:25:27'),
('630b0d594ca74884999aabe7cd4c144f', '1', '74315e162f524a4d88aa931f02416f26', '2020-08-05 06:25:27', '2020-08-05 06:25:27'),
('6e8fe2b9307a4855ba7d006dc17c97ae', '3fb1c570496d4c09ab99b8d31b0671cf', '35cb950cebb04bb18bb1d8b742a02005', '2019-09-17 12:09:47', '2019-09-17 12:09:47'),
('7738e3f10f7d4b658f66bfdc075f4909', '1', 'bcf17dc0ce304f0ba02d64ce21ddb43d', '2020-08-05 06:25:27', '2020-08-05 06:25:27'),
('97a62a24ce50428aab0090fe38bfa9c6', '1', '35cb950cebb04bb18bb1d8b742a02xaa', '2020-08-05 06:25:27', '2020-08-05 06:25:27'),
('9f8ccddc9fa84e0b9ff74128d20e9024', '2', '35cb950cebb04bb18bb1d8b742a02xaa', '2019-09-12 16:14:28', '2019-09-12 16:14:28'),
('9fcaa1e74743415aa8c68cf616dbbab9', '1', '35cb950cebb04bb18bb1d8b742a02xzz', '2020-08-05 06:25:27', '2020-08-05 06:25:27'),
('a3166bcfbc724e5f8c17b3f4733e9a0c', '1', 'f65e2aa5ade94ca9a9e2994c9fbf3c58', '2020-08-05 06:25:27', '2020-08-05 06:25:27'),
('c4220e4602fd4f2ca70da046466c6b45', '2', '35cb950cebb04bb18bb1d8b742a02xzz', '2019-09-12 16:14:28', '2019-09-12 16:14:28'),
('e77f67d3d1b34cda96d0773e343585ac', '1', 'fe63a57226a84fc48dc303cd14f707b7', '2020-08-05 06:25:27', '2020-08-05 06:25:27'),
('f3e77a2447784d2f8a9debbe39403eee', '1', '35cb950cebb04bb18bb1d8b742a02xcc', '2020-08-05 06:25:27', '2020-08-05 06:25:27'),
('f61b018a6aef483e89fa7156eeacd8ce', '1', 'bcf17dc0ce304f0ba02d64ce21ddb4f9', '2020-08-05 06:25:27', '2020-08-05 06:25:27');

-- --------------------------------------------------------

--
-- 表的结构 `wallet_account`
--

CREATE TABLE `wallet_account` (
  `id` varchar(255) NOT NULL,
  `account_password` varchar(255) DEFAULT NULL,
  `assets_id` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_block_height` varchar(255) DEFAULT NULL,
  `last_block_time` varchar(255) DEFAULT NULL,
  `receive_account` varchar(255) DEFAULT NULL,
  `receive_address` varchar(255) DEFAULT NULL,
  `receive_balance` varchar(255) DEFAULT NULL,
  `send_account` varchar(255) DEFAULT NULL,
  `send_address` varchar(255) DEFAULT NULL,
  `send_balance` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `wallet_assets`
--

CREATE TABLE `wallet_assets` (
  `assets_id` varchar(255) NOT NULL,
  `assets_home` varchar(255) DEFAULT NULL,
  `assets_introduction` varchar(255) DEFAULT NULL,
  `assets_name` varchar(255) DEFAULT NULL,
  `assets_name_zh` varchar(255) DEFAULT NULL,
  `assets_symbol` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_block_height` varchar(255) DEFAULT NULL,
  `last_block_time` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `wallet_assets`
--

INSERT INTO `wallet_assets` (`assets_id`, `assets_home`, `assets_introduction`, `assets_name`, `assets_name_zh`, `assets_symbol`, `create_time`, `last_block_height`, `last_block_time`, `update_time`) VALUES
('16cd4f04344f4bbd95babeae768d23b4', 'projectpai.com', '介绍PAI', 'Project PAI', '1派', 'PAI', '2020-08-05 08:29:03', '', NULL, '2020-08-05 08:29:52'),
('e7d5705c15dc466d9578e347cdbd12bb', '', '', 'bitcoin', '比特币', 'BTC', '2020-08-05 08:29:58', '', NULL, '2020-08-05 08:30:18');

--
-- 转储表的索引
--

--
-- 表的索引 `persistent_logins`
--
ALTER TABLE `persistent_logins`
  ADD PRIMARY KEY (`series`);

--
-- 表的索引 `red_packet_record`
--
ALTER TABLE `red_packet_record`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `red_racket`
--
ALTER TABLE `red_racket`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `seckill`
--
ALTER TABLE `seckill`
  ADD PRIMARY KEY (`seckill_id`),
  ADD KEY `idx_start_time` (`start_time`),
  ADD KEY `idx_end_time` (`end_time`),
  ADD KEY `idx_create_time` (`create_time`);

--
-- 表的索引 `success_killed`
--
ALTER TABLE `success_killed`
  ADD PRIMARY KEY (`seckill_id`,`user_id`),
  ADD KEY `idx_create_time` (`create_time`);

--
-- 表的索引 `sys_authority`
--
ALTER TABLE `sys_authority`
  ADD PRIMARY KEY (`authority_id`) USING BTREE;

--
-- 表的索引 `sys_menu`
--
ALTER TABLE `sys_menu`
  ADD PRIMARY KEY (`menu_id`) USING BTREE;

--
-- 表的索引 `sys_setting`
--
ALTER TABLE `sys_setting`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- 表的索引 `sys_shortcut_menu`
--
ALTER TABLE `sys_shortcut_menu`
  ADD PRIMARY KEY (`shortcut_menu_id`) USING BTREE;

--
-- 表的索引 `sys_user`
--
ALTER TABLE `sys_user`
  ADD PRIMARY KEY (`user_id`) USING BTREE;

--
-- 表的索引 `sys_user_authority`
--
ALTER TABLE `sys_user_authority`
  ADD PRIMARY KEY (`user_authority_id`) USING BTREE,
  ADD KEY `FKnctpqug9dy29vudpe8ohryqmx` (`authority_id`),
  ADD KEY `FK9qswc2542weq0b2oidoiqw8lw` (`user_id`);

--
-- 表的索引 `sys_user_menu`
--
ALTER TABLE `sys_user_menu`
  ADD PRIMARY KEY (`user_menu_id`) USING BTREE,
  ADD KEY `FK6va8c3wvegutnirrjla5dqpnn` (`menu_id`),
  ADD KEY `FKfqsgyqt79xa4wybipbli5e0pn` (`user_id`);

--
-- 表的索引 `wallet_account`
--
ALTER TABLE `wallet_account`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `wallet_assets`
--
ALTER TABLE `wallet_assets`
  ADD PRIMARY KEY (`assets_id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `red_packet_record`
--
ALTER TABLE `red_packet_record`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- 使用表AUTO_INCREMENT `red_racket`
--
ALTER TABLE `red_racket`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `seckill`
--
ALTER TABLE `seckill`
  MODIFY `seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id', AUTO_INCREMENT=1005;

--
-- 限制导出的表
--

--
-- 限制表 `sys_user_authority`
--
ALTER TABLE `sys_user_authority`
  ADD CONSTRAINT `FK9qswc2542weq0b2oidoiqw8lw` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`),
  ADD CONSTRAINT `FKnctpqug9dy29vudpe8ohryqmx` FOREIGN KEY (`authority_id`) REFERENCES `sys_authority` (`authority_id`);

--
-- 限制表 `sys_user_menu`
--
ALTER TABLE `sys_user_menu`
  ADD CONSTRAINT `FK6va8c3wvegutnirrjla5dqpnn` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`menu_id`),
  ADD CONSTRAINT `FKfqsgyqt79xa4wybipbli5e0pn` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
