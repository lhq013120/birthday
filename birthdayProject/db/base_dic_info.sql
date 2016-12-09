/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50553
Source Host           : 127.0.0.1:3306
Source Database       : hm

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2016-12-09 18:22:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_dic_info
-- ----------------------------
DROP TABLE IF EXISTS `base_dic_info`;
CREATE TABLE `base_dic_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) DEFAULT NULL COMMENT '字典类型',
  `code` varchar(4) DEFAULT NULL COMMENT '字典编码',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `index` varchar(10) DEFAULT NULL COMMENT '索引顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of base_dic_info
-- ----------------------------
INSERT INTO `base_dic_info` VALUES ('1', 'blood_type', '001', 'A型', '1');
INSERT INTO `base_dic_info` VALUES ('2', 'blood_type', '002', 'B型', '2');
INSERT INTO `base_dic_info` VALUES ('3', 'blood_type', '003', 'O型', '3');
INSERT INTO `base_dic_info` VALUES ('4', 'blood_type', '004', 'AB型', '4');
