/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50553
Source Host           : 127.0.0.1:3306
Source Database       : hm

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2016-12-24 17:02:04
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
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of worker_info
-- ----------------------------
INSERT INTO `worker_info` VALUES ('1', '13901231369', '鲍洪升', 'Djo3qoWhTjWd90+nft7T9g==', '1960-09-28', '01', 'imgs/headpro/董事长13901231369.png', 'imgs/headpro/shrink_董事长13901231369.png', '天秤座', '002', '打高尔夫', '01', '2016-12-24 16:21:57', '2016-12-24 16:21:57');
INSERT INTO `worker_info` VALUES ('2', '13701226766', '段炬红', 'GBn7kDT3lideb2SVChNOKg==', '1971-02-22', '01', 'imgs/headpro/段炬红13701226766.png', 'imgs/headpro/shrink_段炬红13701226766.png', '双鱼座', '003', '看书', '1', '2016-12-23 15:07:04', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('3', '13301109919', '丁跃军', 'roFqgOTBxWyqLrThgZy7Lw==', '1959-10-04', '01', 'imgs/headpro/丁跃军13301109919.png', 'imgs/headpro/shrink_丁跃军13301109919.png', '天秤座', '001', '打高尔夫', '1', '2016-12-23 15:06:37', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('4', '13910090932', '张一平', 'bDoxeemYfzCO2aP/3uPx5g==', '1968-04-21', '01', 'imgs/headpro/张一平13910090932.png', 'imgs/headpro/shrink_张一平13910090932.png', '金牛座', '002', '唱歌、写诗', '1', '2016-12-23 15:07:50', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('5', '13501006618', '鲍东奇', 'fz/P7ZEJ8npLnkq9Fp1uQw==', '1984-09-09', '01', 'imgs/headpro/鲍东奇13501006618.jpg', 'imgs/headpro/shrink_鲍东奇13501006618.jpg', '处女座', '002', '工作、出差', '1', '2016-12-23 17:54:51', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('32', '13992816220', '韩军', 'kMxECxuMqlIMVirE5LvLUQ==', '1969-05-16', '01', 'imgs/headpro/韩军13992816220.png', 'imgs/headpro/shrink_韩军13992816220.png', '金牛座', '002', '运动', '1', '2016-12-23 15:08:44', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('33', '18911287233', '徐亮', 'ASqRRn8hBHL6tOETWbv+9g==', '1970-02-25', '01', 'imgs/headpro/徐亮18911287233.png', 'imgs/headpro/shrink_徐亮18911287233.png', '双鱼座', '002', '工作、出差', '1', '2016-12-23 18:34:48', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('34', '13581854578', '张建琴', 'wokNRNBrr7bHtKoZSFfMvA==', '1975-09-01', '01', 'imgs/headpro/张建琴13581854578.png', 'imgs/headpro/shrink_张建琴13581854578.png', '处女座', '004', '运动旅游', '1', '2016-12-23 18:51:48', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('35', '13911879353', '王宝民', 'qYg+e7IOVgYHeM95QSWvxA==', '1956-05-18', '01', 'imgs/headpro/王宝民13911879353.png', 'imgs/headpro/shrink_王宝民13911879353.png', '金牛座', '003', '工作', '1', '2016-12-23 15:09:38', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('36', '18022880309', '林军', 'lE3oZzsPLRYDpv8zsYuBkg==', '1971-08-11', '01', 'imgs/headpro/林军18022880309.png', 'imgs/headpro/shrink_林军18022880309.png', '狮子座', '004', '网球', '1', '2016-12-23 22:19:01', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('37', '18611404718', '宝尔', 'uxgeg7msa+GyiyorJtzXPg==', '1979-07-05', '01', 'imgs/headpro/宝尔18611404718.png', 'imgs/headpro/shrink_宝尔18611404718.png', '巨蟹座', '003', '爱好游戏和运动', '1', '2016-12-23 22:19:26', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('38', '13718284698', '杜直锐', 'EGi86xkyP+crKzRMz4XCVA==', '1981-07-14', '01', 'imgs/headpro/杜直锐13718284698.png', 'imgs/headpro/shrink_杜直锐13718284698.png', '巨蟹座', '002', '旅游', '1', '2016-12-23 22:19:52', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('39', '13929408854', '谭佳明', 'vW/SBSRVPaXwUE0x5BNFAA==', '1992-01-02', '01', 'imgs/headpro/谭佳明13929408854.png', 'imgs/headpro/shrink_谭佳明13929408854.png', '魔羯座', '004', '健身和羽毛球', '1', '2016-12-23 22:21:45', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('40', '18611974614', '崔德利', 'CsCJELfoE3GIffPWK4lArA==', '1983-01-25', '01', 'imgs/headpro/崔德利18611974614.png', 'imgs/headpro/shrink_崔德利18611974614.png', '水瓶座', '001', '读书、写作、赚钱', '1', '2016-12-23 22:20:39', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('41', '13301231363', '蔡建国', 'loPMX4lWLqSOcrsyHZ8D+w==', '1968-08-23', '01', 'imgs/headpro/蔡建国13301231363.png', 'imgs/headpro/shrink_蔡建国13301231363.png', '处女座', '003', '旅游、喝茶、美食', '1', '2016-12-23 22:21:31', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('42', '17701145432', '鲁健', 'LpKWLAtplq3ZUX5CQuqb3A==', '1965-10-24', '01', 'imgs/headpro/鲁健17701145432.png', 'imgs/headpro/shrink_鲁健17701145432.png', '天蝎座', '002', '行走、交流、记录', '1', '2016-12-23 22:22:13', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('43', '18500027202', '杨晓曼', '+GLRNFT9JnuqX+3/+yAFZw==', '1988-01-28', '01', 'imgs/headpro/杨晓曼18500027202.png', 'imgs/headpro/shrink_杨晓曼18500027202.png', '水瓶座', '003', '旅游', '1', '2016-12-23 22:22:49', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('44', '13911892362', '王振', 'iuxRQisw1hvOB4sn8Lq+sQ==', '1982-12-14', '01', 'imgs/headpro/王振13911892362.png', 'imgs/headpro/shrink_王振13911892362.png', '射手座', '004', '旅游、学习', '1', '2016-12-23 22:23:17', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('45', '13810323203', '郝懿芳', 'eZ3m09rkySQULPJFodf3Aw==', '1983-09-28', '01', 'imgs/headpro/郝懿芳13810323203.png', 'imgs/headpro/shrink_郝懿芳13810323203.png', '天秤座', '002', '旅游', '1', '2016-12-23 22:16:38', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('46', '13911695991', '李翠萍', 'wDVmQfQhs4HkdXdrYCpdqA==', '1975-04-25', '01', 'imgs/headpro/李翠萍13911695991.png', 'imgs/headpro/shrink_李翠萍13911695991.png', '金牛座', '002', '旅游', '1', '2016-12-23 22:17:06', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('47', '13520855714', '吴晨旭', 'D+apSEjlxopUAQths+lLDg==', '1988-07-17', '01', 'imgs/headpro/吴晨旭13520855714.png', 'imgs/headpro/shrink_吴晨旭13520855714.png', '巨蟹座', '001', '旅游和美食', '1', '2016-12-23 22:15:40', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('48', '13810445998', '李冬梅', 'uYo3c+z3FXUdPPD7bcukJA==', '1986-02-06', '01', 'imgs/headpro/李冬梅13810445998.png', 'imgs/headpro/shrink_李冬梅13810445998.png', '水瓶座', '002', '旅游和美食', '1', '2016-12-23 22:15:11', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('49', '15901016804', '刘颖', 'oyKFLODfc+IEt+Z8u+8NCg==', '1985-02-18', '01', '', '', '水瓶座', '004', '读书听歌旅游美食', '1', '2016-12-23 22:18:34', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('50', '15810640576', '王颜伟', 'DKOEiH0JtpQfk9U/3qnb7Q==', '1982-09-17', '01', 'imgs/headpro/王颜伟15810640576.png', 'imgs/headpro/shrink_王颜伟15810640576.png', '处女座', '004', '读书、影视', '1', '2016-12-23 22:10:19', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('51', '13488734284', '刘小平', 'QbDbSf0Q2VkgKB3q0HEPWA==', '1982-11-18', '01', 'imgs/headpro/刘小平13488734284.png', 'imgs/headpro/shrink_刘小平13488734284.png', '天蝎座', '001', '多肉植物、阅读', '1', '2016-12-23 22:11:04', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('52', '18511418800', '马建仁', 'esUuPycp0bP20rfo9kZyJg==', '1981-10-10', '01', 'imgs/headpro/马建仁18511418800.png', 'imgs/headpro/shrink_马建仁18511418800.png', '天秤座', '003', '户外、音乐、十字绣', '1', '2016-12-23 22:12:06', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('53', '15001068380', '陈翔', 'WF60Enr9ADvXhPbo3BMr4g==', '1983-01-17', '01', 'imgs/headpro/陈翔15001068380.png', 'imgs/headpro/shrink_陈翔15001068380.png', '魔羯座', '002', '厨艺、影视、读书', '1', '2016-12-23 22:13:59', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('54', '18613801739', '沈朝磊', 'dS0lofjb+y1la6wwlL+4HA==', '1981-12-23', '01', 'imgs/headpro/沈朝磊18613801739.png', 'imgs/headpro/shrink_沈朝磊18613801739.png', '魔羯座', '004', '爬山、骑行', '1', '2016-12-23 22:10:43', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('55', '13220146522', '谷海伟', 'yQD+koQMUnoMVPKGQMLyVA==', '1982-08-02', '01', 'imgs/headpro/谷海伟13220146522.png', 'imgs/headpro/shrink_谷海伟13220146522.png', '狮子座', '001', '书法、绘画、摄影、音乐', '1', '2016-12-23 22:11:36', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('56', '18701491883', '邸文雪', 'xFAIIS97326rYFDCpWRDWg==', '1984-10-25', '01', 'imgs/headpro/邸文雪18701491883.png', 'imgs/headpro/shrink_邸文雪18701491883.png', '天蝎座', '002', '安静、时尚、厨艺', '1', '2016-12-23 22:13:21', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('57', '15600062450', '裴海艳', 'SdSy+utLe550V3V5MUHisg==', '1988-08-31', '01', 'imgs/headpro/裴海艳15600062450.png', 'imgs/headpro/shrink_裴海艳15600062450.png', '处女座', '002', '休息、旅游、写字', '1', '2016-12-23 22:12:35', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('58', '15110202488', '杨春燕', 'eYntrRTrzTrfrMc0Tca3OQ==', '1982-02-11', '01', 'imgs/headpro/杨春燕15110202488.png', 'imgs/headpro/shrink_杨春燕15110202488.png', '水瓶座', '001', '美食、羽毛球、游泳', '1', '2016-12-23 18:35:46', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('59', '18613319596', '张薇薇', '0LTlTd2fCYLbUivsuAQQcQ==', '1983-12-20', '01', 'imgs/headpro/张薇薇18613319596.png', 'imgs/headpro/shrink_张薇薇18613319596.png', '射手座', '001', 'shopping', '1', '2016-12-23 18:37:16', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('60', '13810722941', '裴卉妹', 'SyHPltTPYS8jmmwyKxDI/g==', '1986-08-24', '01', 'imgs/headpro/裴卉妹13810722941.png', 'imgs/headpro/shrink_裴卉妹13810722941.png', '处女座', '002', '旅游、电影', '1', '2016-12-23 18:36:07', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('61', '18600538760', '李亚芳', 'rpUpbifX9pX4kc0mtPNweA==', '1991-03-05', '01', 'imgs/headpro/李亚芳18600538760.png', 'imgs/headpro/shrink_李亚芳18600538760.png', '双鱼座', '003', '运动、跳舞', '1', '2016-12-23 18:37:48', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('62', '18518938589', '李进', 'WG7ly18XVBNyzdfVS2QU1w==', '1992-08-05', '01', 'imgs/headpro/李进18518938589.png', 'imgs/headpro/shrink_李进18518938589.png', '狮子座', '003', '吉他、吃肉', '1', '2016-12-23 18:37:28', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('63', '18911215262', '王少卿', 'BNpK6o44rJM6sjyyOJ3d7w==', '1992-12-31', '01', 'imgs/headpro/王少卿18911215262.png', 'imgs/headpro/shrink_王少卿18911215262.png', '魔羯座', '003', '读书、养鱼', '1', '2016-12-23 18:38:21', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('64', '13634171721', '黄璜', 'KNxrDhszdptLlGheT00eXA==', '1993-08-31', '01', 'imgs/headpro/黄璜13634171721.png', 'imgs/headpro/shrink_黄璜13634171721.png', '处女座', '004', '宠物、shopping', '1', '2016-12-23 18:38:04', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('65', '13466374870', '张陆新', 'PFZUhbvSxUuw6+BcfsdB/A==', '1983-10-01', '01', 'imgs/headpro/张陆新13466374870.png', 'imgs/headpro/shrink_张陆新13466374870.png', '天秤座', '001', '作诗、唱民歌', '1', '2016-12-23 18:39:05', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('66', '13911838624', '郭威', 'FsDXjvana1wkcROkyVFAWQ==', '1987-08-26', '01', 'imgs/headpro/郭威13911838624.png', 'imgs/headpro/shrink_郭威13911838624.png', '处女座', '004', '减肥、卤煮', '1', '2016-12-23 18:38:51', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('67', '13301308971', '张强', 'boOd2TkR+UXNAsmxXaI9sA==', '1989-07-01', '01', 'imgs/headpro/张强13301308971.png', 'imgs/headpro/shrink_张强13301308971.png', '巨蟹座', '003', '摄影', '1', '2016-12-23 18:39:23', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('68', '15922118870', '丁玉球', '+KJrtjbezToctIKkRNrUZw==', '1962-02-28', '01', 'imgs/headpro/丁玉球15922118870.png', 'imgs/headpro/shrink_丁玉球15922118870.png', '双鱼座', '004', '演讲', '1', '2016-12-23 22:04:59', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('69', '13911355544', '王晓洁', 'l3heBQCtFsGFdMZBicz0tA==', '1982-10-02', '01', 'imgs/headpro/王晓洁13911355544.png', 'imgs/headpro/shrink_王晓洁13911355544.png', '天秤座', '002', '广泛', '1', '2016-12-23 22:04:17', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('70', '15116971112', '高朋', 'INE18PKBhbhKTPeqUfKVAA==', '1977-11-12', '01', 'imgs/headpro/高朋15116971112.png', 'imgs/headpro/shrink_高朋15116971112.png', '天蝎座', '002', '戏曲', '1', '2016-12-23 22:06:49', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('71', '18301657417', '崔志君', 'zon2sRvcWzZQhahANuk2Ww==', '1967-02-28', '01', 'imgs/headpro/崔志君18301657417.png', 'imgs/headpro/shrink_崔志君18301657417.png', '双鱼座', '003', '踢足球', '1', '2016-12-23 22:06:08', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('72', '18500045663', '吕跃伦', 'rHHgB5eZpXzGYWMSy7uvhA==', '1958-02-15', '01', 'imgs/headpro/吕跃伦18500045663.png', 'imgs/headpro/shrink_吕跃伦18500045663.png', '水瓶座', '004', '旅行、摄影', '1', '2016-12-23 22:05:33', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('73', '13693014251', '徐辉', 'YIsw5F9LYK2yVKgSem2o7w==', '1976-05-20', '01', 'imgs/headpro/徐辉13693014251.png', 'imgs/headpro/shrink_徐辉13693014251.png', '金牛座', '004', '爬山', '1', '2016-12-23 22:07:56', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('74', '15901348116', '李茂盛', 'j2JCeTAXBH03PynycDiLqQ==', '1977-12-23', '01', 'imgs/headpro/李茂盛15901348116.png', 'imgs/headpro/shrink_李茂盛15901348116.png', '魔羯座', '001', '读书、旅游', '1', '2016-12-23 22:08:35', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('75', '13269426382', '王博帅', '/gTgX75IkguLqQvqLd/mCw==', '1979-10-08', '01', 'imgs/headpro/王博帅13269426382.png', 'imgs/headpro/shrink_王博帅13269426382.png', '天秤座', '001', '旅游，唱歌', '1', '2016-12-23 22:01:43', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('76', '13661085409', '周秀华', '4XqIbvwh+kW53EmhfCnc8Q==', '1958-08-06', '01', 'imgs/headpro/周秀华13661085409.png', 'imgs/headpro/shrink_周秀华13661085409.png', '狮子座', '001', '广泛', '1', '2016-12-23 22:02:16', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('77', '13241496929', '王秀艳', '4DCNc5ctjdXi3SeFMQY4bg==', '1978-10-23', '01', 'imgs/headpro/王秀艳13241496929.png', 'imgs/headpro/shrink_王秀艳13241496929.png', '天蝎座', '001', '美食', '1', '2016-12-23 22:01:15', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('78', '15010741878', '孙亚楠', '3F1jftXmLDbstztlSwW6Kg==', '1989-03-08', '01', 'imgs/headpro/孙亚楠15010741878.png', 'imgs/headpro/shrink_孙亚楠15010741878.png', '双鱼座', '002', '打篮球，运动', '1', '2016-12-23 22:03:21', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('79', '18311066885', '张菊香', '2edPR2EDhbEeKV7sTFjUcw==', '1986-09-13', '01', 'imgs/headpro/张菊香18311066885.png', 'imgs/headpro/shrink_张菊香18311066885.png', '处女座', '002', '听歌看书运动', '1', '2016-12-23 22:03:51', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('80', '13311128373', '李兴旺', 'c/nduhZbXFnGHdZJYLqLLQ==', '1963-01-03', '01', 'imgs/headpro/李兴旺13311128373.png', 'imgs/headpro/shrink_李兴旺13311128373.png', '魔羯座', '003', '下棋、写字', '1', '2016-12-23 18:40:37', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('81', '13552900839', '胥雅杰', 't1MdcNuwF/06cu7KS06R9g==', '1976-01-19', '01', 'imgs/headpro/胥雅杰13552900839.png', 'imgs/headpro/shrink_胥雅杰13552900839.png', '魔羯座', '003', '旅游、写字', '1', '2016-12-23 18:41:07', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('82', '15895973378', '陈安娜', 'LiwIDVSQdgr1nQuvWsu4Tg==', '1991-05-06', '01', 'imgs/headpro/陈安娜15895973378.png', 'imgs/headpro/shrink_陈安娜15895973378.png', '金牛座', '003', '吃', '1', '2016-12-23 18:41:58', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('83', '13810308793', '王菁丽', 'T8fpxN8wqv2LfhqzJPJ3Eg==', '1987-02-25', '01', 'imgs/headpro/王菁丽13810308793.png', 'imgs/headpro/shrink_王菁丽13810308793.png', '双鱼座', '002', '旅游、摄影、画画', '1', '2016-12-23 18:40:25', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('84', '18721018759', '林泽', 'qyLii1jB495rzvSNP12LSg==', '1989-09-04', '01', 'imgs/headpro/林泽18721018759.png', 'imgs/headpro/shrink_林泽18721018759.png', '处女座', '004', '象棋', '1', '2016-12-23 18:40:50', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('85', '18888848619', '付小飞', 'tjgm9+3S/DrYRJrdDAT86w==', '1992-02-06', '01', 'imgs/headpro/付小飞18888848619.png', 'imgs/headpro/shrink_付小飞18888848619.png', '水瓶座', '004', '购物、读书、摄影', '1', '2016-12-23 21:58:41', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('86', '18611832022', '刘贺欣', 'OoJBVLFu19q4mb8AC4Du7g==', '1979-08-04', '01', 'imgs/headpro/刘贺欣18611832022.png', 'imgs/headpro/shrink_刘贺欣18611832022.png', '狮子座', '002', '养花、养鱼', '1', '2016-12-23 17:49:31', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('87', '18911950806', '韩云雪', 'N5K/1yyKkHGseQpLO2DRWg==', '1987-07-19', '01', 'imgs/headpro/韩云雪18911950806.png', 'imgs/headpro/shrink_韩云雪18911950806.png', '巨蟹座', '003', '旅游、听音乐', '1', '2016-12-23 17:50:04', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('88', '18810176792', '万晴', 'XpjSOv4Zp3TRsty+/VED6w==', '1989-08-20', '01', 'imgs/headpro/万晴18810176792.png', 'imgs/headpro/shrink_万晴18810176792.png', '狮子座', '003', '美食、睡觉', '1', '2016-12-23 17:51:11', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('89', '13520378742', '张冉', 'axqGSyQPx346kB40cLJD+Q==', '1987-05-19', '01', 'imgs/headpro/张冉13520594607.png', 'imgs/headpro/shrink_张冉13520594607.png', '金牛座', '003', '游泳', '1', '2016-12-23 17:51:38', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('90', '13381135599', '王树兰', 'ikSIwXfZ3Iw9p8dFyJyiFA==', '1975-01-30', '01', 'imgs/headpro/王树兰13381135599.png', 'imgs/headpro/shrink_王树兰13381135599.png', '水瓶座', '002', '做美食', '1', '2016-12-23 18:52:37', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('91', '13601150937', '孟婷', 'cmQr82GN3v2+bKivXD1gCw==', '1983-06-06', '01', 'imgs/headpro/孟婷13601150937.png', 'imgs/headpro/shrink_孟婷13601150937.png', '双子座', '001', '旅游', '1', '2016-12-23 18:53:44', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('92', '15311464927', '刘俊伶', 'UNLSJidiZIWJsZQweHEqpg==', '1990-11-07', '01', 'imgs/headpro/刘俊伶15311464927.png', 'imgs/headpro/shrink_刘俊伶15311464927.png', '天蝎座', '002', '看日剧', '1', '2016-12-23 18:54:16', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('93', '13911934846', '张述侠', 'zmur0GCqRsYaV3eQLMp4rw==', '1963-06-25', '01', 'imgs/headpro/张述侠13911934846.png', 'imgs/headpro/shrink_张述侠13911934846.png', '巨蟹座', '003', '古玩', '1', '2016-12-23 18:59:40', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('94', '18801269598', '鲍振华', '3pJA9cYjvwMdzw/Kl3DbRA==', '1989-01-03', '01', 'imgs/headpro/鲍振华18801269598.png', 'imgs/headpro/shrink_鲍振华18801269598.png', '魔羯座', '003', '游戏', '1', '2016-12-23 18:59:00', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('95', '15311219751', '丁跃荣', 'RqrI6M6caOmh9PX1alo4MQ==', '1964-12-31', '01', 'imgs/headpro/丁跃荣15311219751.png', 'imgs/headpro/shrink_丁跃荣15311219751.png', '魔羯座', '001', '旅游', '1', '2016-12-23 18:49:44', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('96', '13681567305', '胡靖', 'WI2npzoukZojy5pBnExtRA==', '1975-02-09', '01', 'imgs/headpro/胡靖13681567305.png', 'imgs/headpro/shrink_胡靖13681567305.png', '水瓶座', '003', '旅游', '1', '2016-12-23 18:50:29', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('97', '13520810203', '柯华', 'yBwrnpl6gfhIOM2OYLk6AQ==', '1969-07-01', '01', 'imgs/headpro/柯华13520810203.png', 'imgs/headpro/shrink_柯华13520810203.png', '巨蟹座', '001', '旅游', '1', '2016-12-23 18:50:58', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('98', '13146709501', '付建敏', 'uVDqJsoS2q4UK9dNukQnyA==', '1973-04-26', '01', 'imgs/headpro/付建敏13146709501.png', 'imgs/headpro/shrink_付建敏13146709501.png', '金牛座', '003', '旅游', '1', '2016-12-23 18:48:54', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('99', '13901047888', '赵家新', 'ES6dZ3x0g3R/IWoUcL7XNA==', '1966-01-11', '01', 'imgs/headpro/赵家新13901047888.png', 'imgs/headpro/shrink_赵家新13901047888.png', '魔羯座', '003', '文玩杂项、读书、音乐、旅行', '1', '2016-12-23 19:03:39', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('100', '18933937833', '刘文勇', 'R0f1ymO46L1nCybksVc5YQ==', '1967-12-12', '01', 'imgs/headpro/刘文勇18933937833.png', 'imgs/headpro/shrink_刘文勇18933937833.png', '射手座', '003', '阅读', '1', '2016-12-23 19:04:18', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('101', '15910786020', '刘婷', 'rCpyj58Xtdhgttq9gKUWLw==', '1985-02-06', '01', 'imgs/headpro/刘婷15910786020.png', 'imgs/headpro/shrink_刘婷15910786020.png', '水瓶座', '001', '读书、运动', '1', '2016-12-23 19:04:52', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('102', '15611346636', '李倩', 'hrPhZbgVRlanH/6KMn3tfQ==', '1987-01-20', '01', 'imgs/headpro/李倩15611346636.png', 'imgs/headpro/shrink_李倩15611346636.png', '水瓶座', '001', '读书、旅行', '1', '2016-12-23 19:05:31', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('103', '18310323218', '王婧楠', 'sBaTUM01VmxHuoPG7B1vgg==', '1990-09-06', '01', 'imgs/headpro/王婧楠18310323218.png', 'imgs/headpro/shrink_王婧楠18310323218.png', '处女座', '003', '读书、轮滑、羽毛球', '1', '2016-12-23 19:06:04', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('104', '18600821166', '张万绥', 'Dyyak+6m84+rs6yxwxSIxg==', '1962-12-24', '01', 'imgs/headpro/张万绥18600821166.png', 'imgs/headpro/shrink_张万绥18600821166.png', '魔羯座', '003', '睡觉', '1', '2016-12-23 15:10:50', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('105', '13260086901', '刘松波', 'hLZOU38I6BuN6ozOlyoosg==', '1987-03-06', '01', 'imgs/headpro/刘松波13260086901.png', 'imgs/headpro/shrink_刘松波13260086901.png', '双鱼座', '001', '运动', '1', '2016-12-23 15:11:48', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('106', '18601010332', '王琦', 'IHUrgW9FPoNDgp/ewsJYHQ==', '1988-08-01', '01', 'imgs/headpro/王琦18601010332.png', 'imgs/headpro/shrink_王琦18601010332.png', '狮子座', '001', '足球、旅游、吃', '1', '2016-12-23 15:45:26', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('107', '15117981891', '吴慧君', 'ExaOai5shLS33pOQwO9exQ==', '1979-12-02', '01', 'imgs/headpro/吴慧君15117981891.png', 'imgs/headpro/shrink_吴慧君15117981891.png', '射手座', '002', '音乐、美食', '1', '2016-12-23 15:46:07', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('108', '13810050939', '翁健', 'NvOWP4zOCVKaiq5DCb1KgA==', '1984-09-28', '01', 'imgs/headpro/翁健13810050939.png', 'imgs/headpro/shrink_翁健13810050939.png', '天秤座', '003', '逛街、唱歌、上网', '1', '2016-12-23 18:40:04', '2016-11-28 19:25:16');
INSERT INTO `worker_info` VALUES ('111', 'admin', '管理员', '4QrcOUm6Wau+VuBX8g+IPg==', '2016-12-12', '02', '', '', '白羊座', '004', '不工作有钱赚', '01', '2016-12-24 12:25:51', '2016-12-20 16:58:18');
INSERT INTO `worker_info` VALUES ('113', '18515050540', '孙蕾', 'lwASMacJxtxf9UarY1xbcA==', '1980-12-01', '01', 'imgs/headpro/孙蕾18515050540.png', 'imgs/headpro/shrink_孙蕾18515050540.png', '处女座', '001', '美食', '01', '2016-12-24 15:49:40', '2016-12-24 15:49:40');
