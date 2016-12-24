/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50553
Source Host           : 127.0.0.1:3306
Source Database       : hm

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2016-12-24 19:09:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for win_praise
-- ----------------------------
DROP TABLE IF EXISTS `win_praise`;
CREATE TABLE `win_praise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_num` varchar(15) NOT NULL,
  `activity_type` varchar(2) DEFAULT NULL COMMENT '01：（活动），02：（奖品）',
  `is_praise` varchar(2) DEFAULT NULL COMMENT '01：满意，02 不满意',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `crete_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='获赞信息表';

-- ----------------------------
-- Records of win_praise
-- ----------------------------
INSERT INTO `win_praise` VALUES ('1', '15937712253', '01', '01', '2016-12-17 14:21:10', '2016-12-17 14:21:10');
INSERT INTO `win_praise` VALUES ('2', '15937712253', '02', '01', '2016-12-17 14:21:10', '2016-12-17 14:21:10');
INSERT INTO `win_praise` VALUES ('3', '15937712254', '01', '01', '2016-12-17 14:21:10', '2016-12-17 14:21:10');
INSERT INTO `win_praise` VALUES ('4', '15937712255', '01', '01', '2016-12-17 14:21:10', '2016-12-17 14:21:10');
INSERT INTO `win_praise` VALUES ('5', '15937712255', '02', '01', '2016-12-17 14:21:10', '2016-12-17 14:21:10');
INSERT INTO `win_praise` VALUES ('6', '15937712257', '01', '02', '2016-12-24 19:07:11', '2016-12-24 19:07:11');
INSERT INTO `win_praise` VALUES ('7', '15937712257', '02', '02', '2016-12-24 19:07:38', '2016-12-24 19:07:38');
