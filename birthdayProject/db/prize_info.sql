/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50553
Source Host           : 127.0.0.1:3306
Source Database       : hm

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-01-05 10:45:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for prize_info
-- ----------------------------
DROP TABLE IF EXISTS `prize_info`;
CREATE TABLE `prize_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prize_no` varchar(3) DEFAULT NULL COMMENT '奖品编号',
  `prize_grade` varchar(10) DEFAULT NULL COMMENT '奖品等级（一等奖，二等奖，三等奖......）',
  `prize_name` varchar(100) DEFAULT NULL COMMENT '奖品名称',
  `prize_weight` int(3) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `crete_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='奖品信息表';

-- ----------------------------
-- Records of prize_info
-- ----------------------------
INSERT INTO `prize_info` VALUES ('1', '003', '二等奖', '北京商通卡', '15', '2016-12-13 13:03:01', '2016-12-13 13:03:01');
INSERT INTO `prize_info` VALUES ('2', '001', '一等奖', '北京中欣卡', '5', '2016-12-13 13:03:01', '2016-12-13 13:03:01');
INSERT INTO `prize_info` VALUES ('3', '005', '三等奖', '1号店礼品卡', '10', '2016-12-13 13:03:01', '2016-12-13 13:03:01');
INSERT INTO `prize_info` VALUES ('4', '004', '二等奖', '床上四件套', '15', '2016-12-13 13:03:01', '2016-12-13 13:03:01');
INSERT INTO `prize_info` VALUES ('5', '002', '一等奖', '优丽可迷你投影仪', '5', '2016-12-13 13:03:01', '2016-12-13 13:03:01');
INSERT INTO `prize_info` VALUES ('6', '010', '五等奖', '鸿茅白酒1瓶', '15', '2016-12-13 13:03:01', '2016-12-13 13:03:01');
INSERT INTO `prize_info` VALUES ('7', '007', '四等奖', '天堂折叠伞', '5', '2016-12-13 13:03:01', '2016-12-13 13:03:01');
INSERT INTO `prize_info` VALUES ('8', '009', '五等奖', '鸿茅药酒2瓶', '15', '2016-12-13 13:03:01', '2016-12-13 13:03:01');
INSERT INTO `prize_info` VALUES ('9', '006', '三等奖', '加湿器', '10', '2016-12-13 13:03:01', '2016-12-13 13:03:01');
INSERT INTO `prize_info` VALUES ('10', '008', '四等奖', '保温杯', '5', '2016-12-13 13:03:01', '2016-12-13 13:03:01');
