-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- 主机： 172.18.0.2:3306
-- 生成日期： 2020-07-25 11:02:32
-- 服务器版本： 5.7.29-32-57
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
-- 表的结构 `red_packet_record`
--

CREATE TABLE `red_packet_record` (
  `id` bigint(20) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  `red_packet_id` bigint(20) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL
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
  `id` bigint(20) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `red_packet_id` bigint(20) NOT NULL,
  `total_amount` int(11) NOT NULL,
  `total_packet` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `version` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `role`
--

CREATE TABLE `role` (
  `id` bigint(11) NOT NULL COMMENT '角色id',
  `name` varchar(20) NOT NULL COMMENT '角色名',
  `display_name` varchar(120) NOT NULL COMMENT '显示名称',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

--
-- 转存表中的数据 `role`
--

INSERT INTO `role` (`id`, `name`, `display_name`, `update_time`, `create_time`) VALUES
(1, 'vip1', 'vip1', '2020-07-25 09:54:45', '2020-07-25 09:54:45'),
(3, 'vip2', 'vip2', '2020-07-25 09:54:45', '2020-07-25 09:54:45');

-- --------------------------------------------------------

--
-- 表的结构 `seckill`
--

CREATE TABLE `seckill` (
  `seckill_id` bigint(20) NOT NULL COMMENT '商品库存id',
  `name` varchar(120) NOT NULL COMMENT '商品名称',
  `number` int(11) NOT NULL COMMENT '库存数量',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀开启时间',
  `end_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀结束时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `version` int(11) NOT NULL COMMENT '版本号'
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
  `seckill_id` bigint(20) NOT NULL COMMENT '秒杀商品id',
  `user_id` bigint(20) NOT NULL COMMENT '用户Id',
  `state` tinyint(4) NOT NULL COMMENT '状态标示：-1指无效，0指成功，1指已付款',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(120) NOT NULL COMMENT '用户名',
  `password` varchar(1024) NOT NULL COMMENT '密码',
  `enabled` tinyint(1) NOT NULL COMMENT '账号是否可用',
  `locked` tinyint(1) NOT NULL COMMENT '是否被锁',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `locked`, `update_time`, `create_time`) VALUES
(1, 'admin', 'admin', 1, 1, '2020-07-25 09:52:15', '2020-07-25 09:52:15');

-- --------------------------------------------------------

--
-- 表的结构 `user_role`
--

CREATE TABLE `user_role` (
  `id` bigint(11) NOT NULL COMMENT 'id',
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `rid` bigint(11) NOT NULL COMMENT '角色ID',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

--
-- 转存表中的数据 `user_role`
--

INSERT INTO `user_role` (`id`, `uid`, `rid`, `update_time`, `create_time`) VALUES
(1, 1, 1, '2020-07-25 09:55:13', '2020-07-25 09:55:13');

--
-- 转储表的索引
--

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
-- 表的索引 `role`
--
ALTER TABLE `role`
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
-- 表的索引 `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `red_packet_record`
--
ALTER TABLE `red_packet_record`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- 使用表AUTO_INCREMENT `red_racket`
--
ALTER TABLE `red_racket`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '角色id', AUTO_INCREMENT=5;

--
-- 使用表AUTO_INCREMENT `seckill`
--
ALTER TABLE `seckill`
  MODIFY `seckill_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品库存id', AUTO_INCREMENT=1005;

--
-- 使用表AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id', AUTO_INCREMENT=3;

--
-- 使用表AUTO_INCREMENT `user_role`
--
ALTER TABLE `user_role`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'id', AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
