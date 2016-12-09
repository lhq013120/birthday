/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50553
Source Host           : 127.0.0.1:3306
Source Database       : hm

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2016-12-09 18:22:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for win_prize_info
-- ----------------------------
DROP TABLE IF EXISTS `win_prize_info`;
CREATE TABLE `win_prize_info` (
  `id` int(11) NOT NULL,
  `phone_num` varchar(15) NOT NULL COMMENT '手机号',
  `work_name` varchar(10) NOT NULL,
  `prize_name` varchar(30) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户获奖信息表';

-- ----------------------------
-- Records of win_prize_info
-- ----------------------------
