/*
Navicat MySQL Data Transfer

Source Server         : rjgc
Source Server Version : 50732
Source Host           : 121.196.160.71:3306
Source Database       : system

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-06-24 14:42:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `activity_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_sub` varchar(200) NOT NULL,
  `activity_content` varchar(1000) NOT NULL,
  `activity_url` varchar(1000) DEFAULT NULL,
  `activity_start_time` datetime NOT NULL,
  `activity_finish_time` datetime NOT NULL,
  `activity_state` varchar(100) NOT NULL,
  `activity_score` int(11) NOT NULL,
  `activity_leader_name` varchar(200) NOT NULL,
  `activity_end_content` varchar(1000) DEFAULT NULL,
  `activity_end_url` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('2', '第一届浙大城市学院羽毛球交流大会', '本次友谊交流活动以羽毛球交流比赛为主，共有近60名队员热情参与。交流活动中，队员们秉承着“友谊第一，比赛第二，增进友谊，强身健体”的精神，以球会友，切磋球技。此次交流活动以相互切磋、提高球技为目的，重在加强我校与其他俱乐部之间的技术交流，增强队员适应不同风格的比赛对手的能力。同时，通过对外交流比赛，增进我校与其他俱乐部的友谊，促进长期合作，共同为青少年羽毛球运动的发展努力。', 'http://5b0988e595225.cdn.sohucs.com/images/20180706/5626e3da5e494b8688c65a2fbfb9aed2.jpeg', '2021-05-23 18:15:24', '2021-05-29 18:15:27', '报名中', '3', '陆雪犹', '', null);
INSERT INTO `activity` VALUES ('4', '第二届城院羽毛球赛', '本次羽毛球比赛的赛制为淘汰赛，各分院参赛派两名选手参赛，第一天.................................................', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=15032502,2637421419&fm=26&gp=0.jpg', '2021-05-19 18:55:14', '2021-05-22 18:55:17', '活动结束', '4', '陆雪犹', null, null);
INSERT INTO `activity` VALUES ('6', '足球是一家', '我们将在 2021年6月1日。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。举行一场联谊赛~有兴趣的同学积极报名啊', 'http://zhangjz-tgam-example.oss-cn-hangzhou.aliyuncs.com/activity/OA29eGnAwX.jpg?Expires=1622474812&OSSAccessKeyId=LTAI5tBji2779oNNiitohXS7&Signature=7QbNqxn%2FG820PJz3SHYfCLB4g2g%3D', '2021-05-31 14:39:52', '2021-06-01 14:39:56', '活动结束', '3', '张博尘', '测试测试', 'http://zhangjz-tgam-example.oss-cn-hangzhou.aliyuncs.com/activity/CwCZLByvaU.jpg?Expires=1622511526&OSSAccessKeyId=LTAI5tBji2779oNNiitohXS7&Signature=KCrVKkr392b9O8fihC1bR%2BcKleU%3D');
INSERT INTO `activity` VALUES ('7', '城院足球交流赛', '领军足球赛事回归本质的意义在于，检验队员训练成果，帮助队员更好的提高，增强各球队的凝聚力和可持续发展，加强家长、队员、俱乐部的交流和互动，同时这也是一次领军足球自我检验的过程，从教学质量，服务能力的双重检验！', 'http://zhangjz-tgam-example.oss-cn-hangzhou.aliyuncs.com/activity/esvKe4Z4wm.jpg?Expires=1622490448&OSSAccessKeyId=LTAI5tBji2779oNNiitohXS7&Signature=Zck%2FKrGyW7nvZEWcQNeh52SXr0k%3D', '2021-05-22 19:01:40', '2021-06-05 19:01:45', '活动结束', '3', '张博尘', '结束拉', 'http://zhangjz-tgam-example.oss-cn-hangzhou.aliyuncs.com/activity/r5YMMeJ2cA.jpg?Expires=1622511328&OSSAccessKeyId=LTAI5tBji2779oNNiitohXS7&Signature=7qA8H63jjQqZMcHvuDMCKMWgp5s%3D');
INSERT INTO `activity` VALUES ('8', '1', '1', 'http://zhangjz-tgam-example.oss-cn-hangzhou.aliyuncs.com/activity/2KyYo8Uhf7.jpg?Expires=1622490621&OSSAccessKeyId=LTAI5tBji2779oNNiitohXS7&Signature=IhrcEFFvijYXqBnTLe46wg1jZqw%3D', '2021-04-28 19:04:37', '2021-05-27 19:04:40', '活动结束', '1', '张博尘', '测试测试！', 'http://zhangjz-tgam-example.oss-cn-hangzhou.aliyuncs.com/activity/nG2yxdcNTA.jpg?Expires=1622511468&OSSAccessKeyId=LTAI5tBji2779oNNiitohXS7&Signature=%2FlqbSzFHlxnvAQ%2BRSw5USs%2FYrUQ%3D');
INSERT INTO `activity` VALUES ('10', '羽毛球运动--林丹执教', '林丹来 城市学院啦！', 'http://zhangjz-tgam-example.oss-cn-hangzhou.aliyuncs.com/activity/sI7ruG36vm.jpg?Expires=1623237991&OSSAccessKeyId=LTAI5tBji2779oNNiitohXS7&Signature=NsfgyafsHQaTs9FXRQgBIfNOiY8%3D', '2021-06-07 10:40:31', '2021-06-10 10:40:35', '活动结束', '3', '陆雪犹', '啊哈', 'http://zhangjz-tgam-example.oss-cn-hangzhou.aliyuncs.com/activity/yX4xDg63DA.jpg?Expires=1623894803&OSSAccessKeyId=LTAI5tBji2779oNNiitohXS7&Signature=HLs3RPRxqDmp5Q1z7pdwB2cUaiI%3D');
INSERT INTO `activity` VALUES ('11', '欧洲杯观赛感收集', '足球---欧洲杯已经有一段时间拉！观赛感收集截至至2021年6月28日12：00', 'http://zhangjz-tgam-example.oss-cn-hangzhou.aliyuncs.com/activity/jJ5p9H1y6T.jpg?Expires=1624225876&OSSAccessKeyId=LTAI5tBji2779oNNiitohXS7&Signature=rxdpx2a3pKUR%2BO76H9yhSRbGLIo%3D', '2021-06-17 23:04:26', '2021-06-28 12:00:00', '审核中', '2', '张博尘', null, null);
INSERT INTO `activity` VALUES ('12', '社团破冰', '围棋社所有成员将于2021年6月24日晚18：00在理四324教室集合，进行交流。', 'http://zhangjz-tgam-example.oss-cn-hangzhou.aliyuncs.com/activity/xomB2NRFWT.jpg?Expires=1624226175&OSSAccessKeyId=LTAI5tBji2779oNNiitohXS7&Signature=LKx35Y0b8MTfTxmEy%2BA27jaF1Sk%3D', '2021-06-20 21:09:54', '2021-06-25 21:09:59', '报名中', '2', '汪悦', null, null);
INSERT INTO `activity` VALUES ('13', '111', '11', 'http://zhangjz-tgam-example.oss-cn-hangzhou.aliyuncs.com/activity/uUNIwEFVfZ.jpg?Expires=1624449216&OSSAccessKeyId=LTAI5tBji2779oNNiitohXS7&Signature=UousUmMacPulIws17mVEt99MARs%3D', '2021-06-01 12:08:07', '2021-06-23 11:08:09', '审核中', '3', '陆雪犹', null, null);

-- ----------------------------
-- Table structure for ass
-- ----------------------------
DROP TABLE IF EXISTS `ass`;
CREATE TABLE `ass` (
  `ass_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ass_name` varchar(50) NOT NULL,
  `ass_positon` varchar(80) NOT NULL,
  `ass_capital` float NOT NULL,
  `ass_teacher` varchar(100) NOT NULL,
  `ass_notice` varchar(1024) DEFAULT NULL,
  `ass_state` varchar(100) DEFAULT NULL,
  `ass_leader` varchar(45) NOT NULL,
  PRIMARY KEY (`ass_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ass
-- ----------------------------
INSERT INTO `ass` VALUES ('1', '羽毛球社', '教4-323', '2000', 'aaa', '本羽毛球社 在最近一个月将有长期活动！', '已通过', '陆雪犹');
INSERT INTO `ass` VALUES ('2', '足球社', '理四-415', '8000', '韩zk老师', '本足球社 将在6.6日发布新活动~', '已通过', '张博尘');
INSERT INTO `ass` VALUES ('5', '围棋社', '教四-319', '2000', '金信欣', '', '已通过', '汪悦');
INSERT INTO `ass` VALUES ('8', '街舞社', '理四221', '1000', '仅是超', '', '申请中', '王三');
INSERT INTO `ass` VALUES ('9', '杭州社', '理四342', '1000', 'lsx', '', '已通过', '何雨珊');

-- ----------------------------
-- Table structure for ass_activity
-- ----------------------------
DROP TABLE IF EXISTS `ass_activity`;
CREATE TABLE `ass_activity` (
  `ass_activity` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) DEFAULT NULL,
  `ass_id` bigint(20) DEFAULT NULL,
  `ass_activity_state` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ass_activity`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ass_activity
-- ----------------------------
INSERT INTO `ass_activity` VALUES ('2', '2', '1', '已通过');
INSERT INTO `ass_activity` VALUES ('4', '4', '1', '已通过');
INSERT INTO `ass_activity` VALUES ('6', '6', '2', '已通过');
INSERT INTO `ass_activity` VALUES ('7', '7', '2', '已通过');
INSERT INTO `ass_activity` VALUES ('8', '8', '2', '已通过');
INSERT INTO `ass_activity` VALUES ('10', '10', '1', '已通过');
INSERT INTO `ass_activity` VALUES ('11', '11', '2', '申请中');
INSERT INTO `ass_activity` VALUES ('12', '12', '5', '已通过');
INSERT INTO `ass_activity` VALUES ('13', '13', '1', '申请中');

-- ----------------------------
-- Table structure for leader_activity
-- ----------------------------
DROP TABLE IF EXISTS `leader_activity`;
CREATE TABLE `leader_activity` (
  `leader_activity_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `activity_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`leader_activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of leader_activity
-- ----------------------------
INSERT INTO `leader_activity` VALUES ('2', '21', '2');
INSERT INTO `leader_activity` VALUES ('4', '21', '4');
INSERT INTO `leader_activity` VALUES ('6', '22', '6');
INSERT INTO `leader_activity` VALUES ('7', '22', '7');
INSERT INTO `leader_activity` VALUES ('8', '22', '8');
INSERT INTO `leader_activity` VALUES ('9', '22', '9');
INSERT INTO `leader_activity` VALUES ('10', '21', '10');
INSERT INTO `leader_activity` VALUES ('11', '22', '11');
INSERT INTO `leader_activity` VALUES ('12', '33', '12');
INSERT INTO `leader_activity` VALUES ('13', '21', '13');

-- ----------------------------
-- Table structure for leader_ass
-- ----------------------------
DROP TABLE IF EXISTS `leader_ass`;
CREATE TABLE `leader_ass` (
  `leader_ass_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ass_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`leader_ass_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of leader_ass
-- ----------------------------
INSERT INTO `leader_ass` VALUES ('1', '1', '21');
INSERT INTO `leader_ass` VALUES ('3', '2', '22');
INSERT INTO `leader_ass` VALUES ('4', '5', '33');
INSERT INTO `leader_ass` VALUES ('7', '9', '20');

-- ----------------------------
-- Table structure for member_ass
-- ----------------------------
DROP TABLE IF EXISTS `member_ass`;
CREATE TABLE `member_ass` (
  `member_ass_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `ass_id` bigint(20) DEFAULT NULL,
  `member_ass_state` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`member_ass_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member_ass
-- ----------------------------
INSERT INTO `member_ass` VALUES ('1', '1', '1', '已通过');
INSERT INTO `member_ass` VALUES ('2', '20', '1', '已通过');
INSERT INTO `member_ass` VALUES ('4', '21', '2', '已通过');
INSERT INTO `member_ass` VALUES ('6', '22', '1', '已通过');
INSERT INTO `member_ass` VALUES ('7', '22', '5', '已通过');
INSERT INTO `member_ass` VALUES ('9', '32', '2', '已通过');
INSERT INTO `member_ass` VALUES ('10', '32', '5', '申请中');
INSERT INTO `member_ass` VALUES ('12', '20', '5', '已通过');
INSERT INTO `member_ass` VALUES ('13', '20', '2', '已通过');
INSERT INTO `member_ass` VALUES ('14', '21', '5', '申请中');
INSERT INTO `member_ass` VALUES ('15', '40', '1', '申请中');
INSERT INTO `member_ass` VALUES ('16', '40', '2', '申请中');
INSERT INTO `member_ass` VALUES ('17', '38', '1', '已通过');
INSERT INTO `member_ass` VALUES ('18', '20', '9', '申请中');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `notice_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `notice_content` varchar(1024) NOT NULL,
  `notice_pic` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '欢迎大家来到本学生社团系统，本系统由张钧泽和童鑫聪共同开发完成！感写大家的支持！', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `user_true_name` varchar(50) NOT NULL,
  `user_pwd` varchar(50) NOT NULL,
  `user_authority` int(11) NOT NULL,
  `user_score` int(11) NOT NULL,
  `user_number` varchar(40) NOT NULL,
  `user_gender` varchar(20) NOT NULL,
  `user_position` varchar(50) NOT NULL,
  `user_token` varchar(1024) DEFAULT NULL,
  `user_pic` varchar(1024) DEFAULT NULL,
  `user_phone` varchar(200) NOT NULL,
  `user_signature` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zjzgg', '张钧泽', '123123', '2', '0', '31801087', '男', '管理员', '', null, '13867917372', '我是唯一的管理员 弟弟们哈哈哈');
INSERT INTO `user` VALUES ('20', '何一三', '何雨珊', '123123', '1', '9', '31901127', '女', '社长', null, null, '13600691421', '姐就是女王，自信放光芒ssssss');
INSERT INTO `user` VALUES ('21', '陆学游是大傻逼', '陆雪犹', '123123', '1', '15', '123123', '男', '社长', null, null, '12312312311', '陆学游是大傻逼陆学游是大傻逼陆学游是大傻逼陆学游是大傻逼陆学游是大傻逼陆学游是大傻逼');
INSERT INTO `user` VALUES ('22', 'xswl', '张博尘', '123123', '1', '7', '31801105', '男', '社长', null, null, '12312312311', '沉默是毁谤最好的答覆。');
INSERT INTO `user` VALUES ('24', '风骚小哥哥', '王杨凯', '123123', '0', '0', '31801026', '男', '社员', null, null, '13000191100', '对人恭敬，就是在庄严你自己。');
INSERT INTO `user` VALUES ('25', 'zhagnqq', '张三', '123123', '0', '0', '10001', '男', '社员', null, null, '12312312312', '染血一生终不悔，红尘逍遥我独醉。');
INSERT INTO `user` VALUES ('26', '天涯明月刀', '李王行', '123123', '0', '0', '10002', '男', '社员', '', '', '12312312312', '染血一生终不悔，红尘逍遥我独醉。');
INSERT INTO `user` VALUES ('27', '天马流星券~', '钱向', '123123', '0', '0', '10003', '男', '社员', '', '', '12312312312', '少女求你不要痴心痛');
INSERT INTO `user` VALUES ('28', '天龙八部', '孙武', '123123', '0', '0', '10004', '男', '社员', '', '', '12312312312', '忘记一个人需要多久春夏秋冬够不够');
INSERT INTO `user` VALUES ('29', '可儿', '戴燕妮', '123123', '0', '0', '10005', '女', '社员', '', '', '12312312312', '姑娘我天不怕地不怕就怕数理化。\r\n\r\n');
INSERT INTO `user` VALUES ('30', '哇啊哈哈哈', '秦风', '123123', '0', '0', '10006', '男', '社员', '', '', '12312312312', '姑娘我天不怕地不怕就怕数理化。\r\n\r\n');
INSERT INTO `user` VALUES ('31', '我是宝贝', '李天耿', '123123', '0', '0', '10007', '男', '社员', '', '', '12312312312', '我碍i我家八婆、');
INSERT INTO `user` VALUES ('32', '活到老学到头', '盛可欣', '123123', '0', '8', '10008', '女', '社员', '', '', '12312312312', '我耐i我家流氓、');
INSERT INTO `user` VALUES ('33', '美少女战士', '汪悦', '123123', '1', '0', '10009', '女', '社长', '', '', '12312312312', '我安静的忧伤，在失去你的回忆中绽放。');
INSERT INTO `user` VALUES ('34', '云琦', '云琦', '123123', '0', '0', '10010', '女', '社员', '', '', '12312312312', '手榴弹是贵，要是一块钱六个，我先扔你一百块钱的，法律要是不管，我早打死你了');
INSERT INTO `user` VALUES ('36', '可是但是', '傅可杰', '123123', '0', '0', '10012', '男', '社员', null, null, '12312312312', '每个人心里总会有一个人， 想了碰不得，扔了舍不得');
INSERT INTO `user` VALUES ('37', '我怕', '冯邵峰', '123123', '0', '0', '10013', '男', '社员', '', '', '12312312312', '始终忘不掉你 ，因为 你已在我心里扎根');
INSERT INTO `user` VALUES ('38', '洗白白', '杨音', '123123', '0', '5', '10014', '男', '社员', '', '', '12312312312', '我害怕我们最后除了那张笑的很傻的毕业照就什么都没有了');
INSERT INTO `user` VALUES ('39', 'ahhhhh', '王明', '123123', '0', '0', '10090', '男', '社员', null, null, '12312312312', null);
INSERT INTO `user` VALUES ('40', 'waaaaa', '王三', '123123', '0', '0', '10080', '男', '社员', null, null, '12312312312', null);

-- ----------------------------
-- Table structure for user_activity
-- ----------------------------
DROP TABLE IF EXISTS `user_activity`;
CREATE TABLE `user_activity` (
  `user_activity_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `user_activity_state` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_activity
-- ----------------------------
INSERT INTO `user_activity` VALUES ('2', '2', '32', '已通过');
INSERT INTO `user_activity` VALUES ('4', '6', '21', '已通过');
INSERT INTO `user_activity` VALUES ('8', '7', '32', '已通过');
INSERT INTO `user_activity` VALUES ('9', '2', '20', '已通过');
