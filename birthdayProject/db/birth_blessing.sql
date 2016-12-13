/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50553
Source Host           : 127.0.0.1:3306
Source Database       : hm

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2016-12-13 23:41:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for birth_blessing
-- ----------------------------
DROP TABLE IF EXISTS `birth_blessing`;
CREATE TABLE `birth_blessing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `birth_person` varchar(10) DEFAULT NULL COMMENT '本月寿星名字',
  `birth_person_pnum` varchar(15) DEFAULT NULL COMMENT '本月寿星手机号',
  `ble_person` varchar(10) DEFAULT NULL COMMENT '送祝贺者名',
  `ble_person_pnum` varchar(15) DEFAULT NULL COMMENT '送祝福者手机号',
  `ble_content` varchar(200) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生日祝福信息表';

-- ----------------------------
-- Records of birth_blessing
-- ----------------------------
