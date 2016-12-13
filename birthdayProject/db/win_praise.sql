/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50553
Source Host           : 127.0.0.1:3306
Source Database       : hm

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2016-12-13 23:41:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for win_praise
-- ----------------------------
DROP TABLE IF EXISTS `win_praise`;
CREATE TABLE `win_praise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_num` varchar(15) NOT NULL,
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `crete_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='获赞信息表';

-- ----------------------------
-- Records of win_praise
-- ----------------------------
