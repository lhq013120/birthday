/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50553
Source Host           : 127.0.0.1:3306
Source Database       : hm

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2016-12-12 20:23:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for worker_info
-- ----------------------------
DROP TABLE IF EXISTS `worker_info`;
CREATE TABLE `worker_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_num` varchar(15) NOT NULL DEFAULT '' COMMENT '电话',
  `work_name` varchar(10) NOT NULL DEFAULT '' COMMENT '职工姓名',
  `password` varchar(128) NOT NULL DEFAULT '' COMMENT '密码',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `worker_role` varchar(2) DEFAULT '01' COMMENT '用户权限',
  `worker_img` varchar(200) DEFAULT '' COMMENT '用户头像',
  `shrink_img` varchar(200) DEFAULT '' COMMENT '缩略图像位置',
  `worker_constellation` varchar(20) DEFAULT '' COMMENT '星座',
  `blood_type` varchar(3) DEFAULT '' COMMENT '血型',
  `worker_hobby` varchar(100) DEFAULT '' COMMENT '爱好',
  `isfirst_login` varchar(2) DEFAULT '01' COMMENT '是否首次登陆（01：首次登陆，02 不是首次登陆）',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `crete_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of worker_info
-- ----------------------------
INSERT INTO `worker_info` VALUES ('2', '13701226766', '段炬红', '123', '1971-02-22', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('3', '13301109919', '丁跃军', '123', '1959-10-04', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('4', '13910090932', '张一平', '123', '1968-04-21', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('5', '13501006618', '鲍东奇', '123', '1984-09-09', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('32', '13992816220', '韩军', '123', '1969-05-16', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('33', '18911287233', '徐亮', '123', '1970-02-25', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('34', '13581854578', '张建琴', '123', '1975-09-01', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('35', '13911879353', '王宝民', '123', '1956-05-18', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('36', '18022880309', '林军', '123', '1971-08-11', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('37', '18611404718', '宝尔', '123', '1979-07-05', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('38', '13718284698', '杜直锐', '123', '1981-07-14', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('39', '13929408854', '谭佳明', '123', '1992-01-02', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('40', '18611974614', '崔德利', '123', '1983-01-25', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('41', '13301231363', '蔡建国', '123', '1968-08-23', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('42', '17701145432', '鲁健', '123', '1965-10-24', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('43', '18500027202', '杨晓曼', '123', '1988-01-28', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('44', '13911892362', '王振', '123', '1982-12-14', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('45', '13810323203', '郝懿芳', '123', '1983-09-28', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('46', '13911695991', '李翠萍', '123', '1975-04-25', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('47', '13520855714', '吴晨旭', '123', '1988-07-17', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('48', '13810445998', '李冬梅', '123', '1986-02-06', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('49', '15901016804', '刘颖', '123', '1985-02-18', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('50', '15810640576', '王颜伟', '123', '1982-09-17', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('51', '13488734284', '刘小平', '123', '1982-11-18', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('52', '18511418800', '马建仁', '123', '1981-10-10', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('53', '15001068380', '陈翔', '123', '1983-01-17', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('54', '18613801739', '沈朝磊', '123', '1981-12-23', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('55', '13220146522', '谷海伟', '123', '1982-08-02', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('56', '18701491883', '邸文雪', '123', '1984-10-25', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('57', '15600062450', '裴海艳', '123', '1988-08-31', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('58', '15110202488', '杨春燕', '123', '1982-02-11', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('59', '18613319596', '张薇薇', '123', '1983-12-20', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('60', '13810722941', '裴卉妹', '123', '1986-08-24', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('61', '18600538760', '李亚芳', '123', '1991-03-05', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('62', '18518938589', '李进', '123', '1992-08-05', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('63', '18911215262', '王少卿', '123', '1992-12-31', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('64', '13634171721', '黄璜', '123', '1993-08-31', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('65', '13466374870', '张陆新', '123', '1983-10-01', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('66', '13911838624', '郭威', '123', '1987-08-26', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('67', '13301308971', '张强', '123', '1989-07-01', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('68', '15922118870', '丁玉球', '123', '1962-02-28', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('69', '13911355544', '王晓洁', '123', '1982-10-02', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('70', '15116971112', '高朋', '123', '1977-11-12', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('71', '18301657417', '崔志君', '123', '1967-02-28', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('72', '18500045663', '吕跃伦', '123', '1958-02-15', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('73', '13693014251', '徐辉', '123', '1976-05-20', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('74', '15901348116', '李茂盛', '123', '1977-12-23', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('75', '13269426382', '王博帅', '123', '1979-10-08', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('76', '13661085409', '周秀华', '123', '1958-08-06', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('77', '13241496929', '王秀艳', '123', '1978-10-23', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('78', '15010741878', '孙亚楠', '123', '1989-03-08', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('79', '18311066885', '张菊香', '123', '1986-09-13', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('80', '13311128373', '李兴旺', '123', '1963-01-03', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('81', '13552900839', '胥雅杰', '123', '1976-01-19', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('82', '15895973378', '陈安娜', '123', '1991-05-06', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('83', '13810308793', '王菁丽', '123', '1987-02-25', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('84', '18721018759', '林泽', '123', '1989-09-04', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('85', '18888848619', '付小飞', '123', '1992-02-06', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('86', '18611832022', '刘贺欣', '123', '1979-08-04', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('87', '18911950806', '韩云雪', '123', '1987-07-19', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('88', '18810176792', '万晴', '123', '1989-08-20', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('89', '13520378742', '张冉', '123', '1987-05-19', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('90', '13381135599', '王树兰', '123', '1975-01-30', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('91', '13601150937', '孟婷', '123', '1983-06-06', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('92', '15311464927', '刘俊伶', '123', '1990-11-07', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('93', '13911934846', '张述侠', '123', '1963-06-25', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('94', '18801269598', '鲍振华', '123', '1989-01-03', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('95', '15311219751', '丁跃荣', '123', '1964-12-31', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('96', '13681567305', '胡靖', '123', '1975-02-09', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('97', '13520810203', '柯华', '123', '1969-07-01', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('98', '13146709501', '付建敏', '123', '1973-04-26', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('99', '13901047888', '赵家新', '123', '1966-01-11', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('100', '18933937833', '刘文勇', '123', '1967-12-12', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('101', '15910786020', '刘婷', '123', '1985-02-06', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('102', '15611346636', '李倩', '123', '1987-01-20', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('103', '18310323218', '王婧楠', '123', '1990-09-06', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('104', '18600821166', '张万绥', '123', '1962-12-24', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('105', '13260086901', '刘松波', '123', '1987-03-06', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('106', '18601010332', '王琦', '123', '1988-08-01', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('107', '15117981891', '吴慧君', '123', '1979-12-02', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('108', '13810050939', '翁健', '123', '1984-09-28', '01', null, null, null, null, null, '1', '2016-11-28 19:25:10', '2016-11-28 19:25:16');
