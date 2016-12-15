/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50553
Source Host           : 127.0.0.1:3306
Source Database       : hm

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2016-12-15 17:04:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for win_prize_info
-- ----------------------------
DROP TABLE IF EXISTS `win_prize_info`;
CREATE TABLE `win_prize_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_num` varchar(15) NOT NULL COMMENT '手机号',
  `work_name` varchar(10) NOT NULL,
  `prize_no` varchar(3) DEFAULT NULL COMMENT '奖品编号',
  `prize_grade` varchar(10) DEFAULT NULL,
  `prize_name` varchar(100) DEFAULT NULL,
  `work_address` varchar(100) DEFAULT NULL COMMENT '配送地址',
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户获奖信息表';
