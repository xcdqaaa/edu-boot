/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : edu

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2021-12-10 21:32:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_class
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `c_id` varchar(25) NOT NULL,
  `c_name` varchar(255) DEFAULT NULL,
  `c_type` int(255) DEFAULT NULL,
  `c_term` varchar(255) DEFAULT NULL,
  `m_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  KEY `m_id` (`m_id`),
  KEY `c_term` (`c_term`),
  CONSTRAINT `t_class_ibfk_2` FOREIGN KEY (`c_term`) REFERENCES `t_period` (`p_id`),
  CONSTRAINT `t_class_ibfk_1` FOREIGN KEY (`m_id`) REFERENCES `t_major` (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES ('5001', '软件191', '1', '20199', '2001');
INSERT INTO `t_class` VALUES ('5002', '软件192', '1', '20199', '2001');
INSERT INTO `t_class` VALUES ('5003', '计科191', '1', '20199', '2002');
INSERT INTO `t_class` VALUES ('5004', '计科192', '1', '20199', '2002');
INSERT INTO `t_class` VALUES ('5201', '重修001', '2', '20213', '2000');
INSERT INTO `t_class` VALUES ('5301', '选修001', '3', '20213', '2000');

-- ----------------------------
-- Table structure for t_college
-- ----------------------------
DROP TABLE IF EXISTS `t_college`;
CREATE TABLE `t_college` (
  `g_id` varchar(255) NOT NULL,
  `g_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_college
-- ----------------------------
INSERT INTO `t_college` VALUES ('1001', '智能学院');
INSERT INTO `t_college` VALUES ('1002', '理学院');
INSERT INTO `t_college` VALUES ('1003', '文法学院');
INSERT INTO `t_college` VALUES ('1004', '机械学院');
INSERT INTO `t_college` VALUES ('1005', '能环学院');
INSERT INTO `t_college` VALUES ('1006', '外国语学院');
INSERT INTO `t_college` VALUES ('1007', '化工学院');

-- ----------------------------
-- Table structure for t_lesson
-- ----------------------------
DROP TABLE IF EXISTS `t_lesson`;
CREATE TABLE `t_lesson` (
  `l_id` varchar(255) NOT NULL,
  `b_id` varchar(255) NOT NULL,
  `l_name` varchar(255) NOT NULL,
  `l_term` varchar(255) DEFAULT NULL,
  `l_place` varchar(255) DEFAULT NULL,
  `l_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`l_id`,`l_name`),
  KEY `b_id` (`b_id`),
  KEY `l_term` (`l_term`),
  CONSTRAINT `t_lesson_ibfk_2` FOREIGN KEY (`l_term`) REFERENCES `t_period` (`p_id`),
  CONSTRAINT `t_lesson_ibfk_1` FOREIGN KEY (`b_id`) REFERENCES `t_subject` (`b_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_lesson
-- ----------------------------
INSERT INTO `t_lesson` VALUES ('4001', '3001', '软件工程211', '20219', 'A101', '9-16:3');
INSERT INTO `t_lesson` VALUES ('4002', '3001', '软件工程212', '20219', 'A102', '8-15:4');
INSERT INTO `t_lesson` VALUES ('4003', '3001', '软件工程213', '20219', 'A103', '1-3:2,2-9:3');
INSERT INTO `t_lesson` VALUES ('4004', '3002', '数据库211', '20219', 'B101', '9-16:2');
INSERT INTO `t_lesson` VALUES ('4005', '3002', '数据库212', '20219', 'B102', '9-16:2');
INSERT INTO `t_lesson` VALUES ('4006', '3002', '数据库213', '20219', 'B103', '9-16:2');
INSERT INTO `t_lesson` VALUES ('4007', '3003', 'web框架211', '20219', 'C101', '9-16:2');
INSERT INTO `t_lesson` VALUES ('4008', '3003', 'web框架212', '20219', 'C102', '9-16:2');

-- ----------------------------
-- Table structure for t_lesson_class
-- ----------------------------
DROP TABLE IF EXISTS `t_lesson_class`;
CREATE TABLE `t_lesson_class` (
  `l_id` varchar(255) NOT NULL,
  `c_id` varchar(255) NOT NULL,
  PRIMARY KEY (`l_id`,`c_id`),
  KEY `c_id` (`c_id`),
  CONSTRAINT `t_lesson_class_ibfk_2` FOREIGN KEY (`c_id`) REFERENCES `t_class` (`c_id`),
  CONSTRAINT `t_lesson_class_ibfk_1` FOREIGN KEY (`l_id`) REFERENCES `t_lesson` (`l_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_lesson_class
-- ----------------------------
INSERT INTO `t_lesson_class` VALUES ('4001', '5001');
INSERT INTO `t_lesson_class` VALUES ('4004', '5001');
INSERT INTO `t_lesson_class` VALUES ('4001', '5002');
INSERT INTO `t_lesson_class` VALUES ('4004', '5002');
INSERT INTO `t_lesson_class` VALUES ('4002', '5003');
INSERT INTO `t_lesson_class` VALUES ('4005', '5003');
INSERT INTO `t_lesson_class` VALUES ('4002', '5004');
INSERT INTO `t_lesson_class` VALUES ('4005', '5004');
INSERT INTO `t_lesson_class` VALUES ('4001', '5201');

-- ----------------------------
-- Table structure for t_major
-- ----------------------------
DROP TABLE IF EXISTS `t_major`;
CREATE TABLE `t_major` (
  `m_id` varchar(255) NOT NULL,
  `m_name` varchar(255) DEFAULT NULL,
  `g_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`m_id`),
  KEY `g_id` (`g_id`),
  CONSTRAINT `t_major_ibfk_1` FOREIGN KEY (`g_id`) REFERENCES `t_college` (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_major
-- ----------------------------
INSERT INTO `t_major` VALUES ('2000', '重修选修', null);
INSERT INTO `t_major` VALUES ('2001', '软件工程', '1001');
INSERT INTO `t_major` VALUES ('2002', '计算机科学与技术', '1001');
INSERT INTO `t_major` VALUES ('2003', '物联网工程', '1001');
INSERT INTO `t_major` VALUES ('2004', '大数据', '1001');
INSERT INTO `t_major` VALUES ('2005', '人工智能', '1001');
INSERT INTO `t_major` VALUES ('2006', '数学', '1002');
INSERT INTO `t_major` VALUES ('2007', '物理', '1002');
INSERT INTO `t_major` VALUES ('2008', '法学', '1003');
INSERT INTO `t_major` VALUES ('2009', '公共管理', '1003');
INSERT INTO `t_major` VALUES ('2010', '汉语', '1003');

-- ----------------------------
-- Table structure for t_period
-- ----------------------------
DROP TABLE IF EXISTS `t_period`;
CREATE TABLE `t_period` (
  `p_id` varchar(255) DEFAULT NULL COMMENT '学期id',
  `p_name` varchar(255) DEFAULT NULL COMMENT '学期名',
  KEY `d_id` (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_period
-- ----------------------------
INSERT INTO `t_period` VALUES ('20199', '2019-2020 秋');
INSERT INTO `t_period` VALUES ('20203', '2019-2020 春');
INSERT INTO `t_period` VALUES ('20209', '2020-2021 秋');
INSERT INTO `t_period` VALUES ('20213', '2020-2021 春');
INSERT INTO `t_period` VALUES ('20219', '2021-2022 秋');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `r_id` int(11) NOT NULL,
  `r_flag` varchar(255) DEFAULT NULL,
  `r_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'admin', '管理员');
INSERT INTO `t_role` VALUES ('2', 'teacher', '教师');
INSERT INTO `t_role` VALUES ('3', 'student', '学生');

-- ----------------------------
-- Table structure for t_score
-- ----------------------------
DROP TABLE IF EXISTS `t_score`;
CREATE TABLE `t_score` (
  `s_id` varchar(255) DEFAULT NULL,
  `c_id` varchar(255) DEFAULT NULL,
  `l_id` varchar(255) DEFAULT '',
  `score` double(10,2) DEFAULT '-1.00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_score
-- ----------------------------

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `u_id` int(11) DEFAULT NULL,
  `s_name` varchar(255) DEFAULT NULL,
  `s_class` varchar(255) DEFAULT NULL,
  KEY `u_id` (`u_id`),
  KEY `s_class` (`s_class`),
  CONSTRAINT `t_student_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `t_user` (`u_id`),
  CONSTRAINT `t_student_ibfk_2` FOREIGN KEY (`s_class`) REFERENCES `t_class` (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('11', '刘备', '5001');
INSERT INTO `t_student` VALUES ('12', '曹操', '5002');
INSERT INTO `t_student` VALUES ('13', '孔明', '5001');
INSERT INTO `t_student` VALUES ('14', '孙权', '5003');
INSERT INTO `t_student` VALUES ('15', '关羽', '5001');
INSERT INTO `t_student` VALUES ('16', '张飞', '5001');
INSERT INTO `t_student` VALUES ('17', '黄忠', '5001');
INSERT INTO `t_student` VALUES ('18', '马超', '5001');
INSERT INTO `t_student` VALUES ('19', '赵云', '5001');

-- ----------------------------
-- Table structure for t_subject
-- ----------------------------
DROP TABLE IF EXISTS `t_subject`;
CREATE TABLE `t_subject` (
  `b_id` varchar(255) NOT NULL,
  `b_name` varchar(255) DEFAULT NULL,
  `b_crs` double(8,2) DEFAULT NULL,
  `b_period` varchar(255) DEFAULT NULL,
  `g_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`b_id`),
  KEY `b_` (`b_id`),
  KEY `g_id` (`g_id`),
  KEY `b_period` (`b_period`),
  CONSTRAINT `t_subject_ibfk_2` FOREIGN KEY (`b_period`) REFERENCES `t_period` (`p_id`),
  CONSTRAINT `t_subject_ibfk_1` FOREIGN KEY (`g_id`) REFERENCES `t_college` (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_subject
-- ----------------------------
INSERT INTO `t_subject` VALUES ('3001', '软件工程', '5.50', '20219', '1001');
INSERT INTO `t_subject` VALUES ('3002', '数据库原理及应用', '2.50', '20219', '1001');
INSERT INTO `t_subject` VALUES ('3003', 'web前端开发技术', '2.50', '20219', '1001');
INSERT INTO `t_subject` VALUES ('3004', 'web开发框架技术', '2.00', '20219', '1001');
INSERT INTO `t_subject` VALUES ('3005', 'java程序设计', '2.00', '20219', '1001');
INSERT INTO `t_subject` VALUES ('3006', '高等数学', '5.50', '20199', '1002');
INSERT INTO `t_subject` VALUES ('3007', '线性代数', '3.00', '20199', '1002');
INSERT INTO `t_subject` VALUES ('3008', '古代汉语', '5.50', '20199', '1003');

-- ----------------------------
-- Table structure for t_teach
-- ----------------------------
DROP TABLE IF EXISTS `t_teach`;
CREATE TABLE `t_teach` (
  `t_id` int(255) NOT NULL,
  `l_id` varchar(255) NOT NULL,
  PRIMARY KEY (`t_id`,`l_id`),
  KEY `l_id` (`l_id`),
  CONSTRAINT `t_teach_ibfk_1` FOREIGN KEY (`t_id`) REFERENCES `t_teacher` (`u_id`),
  CONSTRAINT `t_teach_ibfk_2` FOREIGN KEY (`l_id`) REFERENCES `t_lesson` (`l_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teach
-- ----------------------------
INSERT INTO `t_teach` VALUES ('2', '4001');
INSERT INTO `t_teach` VALUES ('6', '4001');
INSERT INTO `t_teach` VALUES ('2', '4002');
INSERT INTO `t_teach` VALUES ('3', '4003');
INSERT INTO `t_teach` VALUES ('4', '4004');
INSERT INTO `t_teach` VALUES ('4', '4005');
INSERT INTO `t_teach` VALUES ('2', '4006');
INSERT INTO `t_teach` VALUES ('4', '4006');
INSERT INTO `t_teach` VALUES ('5', '4007');

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `u_id` int(11) DEFAULT NULL,
  `t_name` varchar(255) DEFAULT NULL,
  `t_college` varchar(255) DEFAULT NULL,
  KEY `t_college` (`t_college`),
  KEY `u_id` (`u_id`),
  CONSTRAINT `t_teacher_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `t_user` (`u_id`),
  CONSTRAINT `t_teacher_ibfk_1` FOREIGN KEY (`t_college`) REFERENCES `t_college` (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('2', '林黛玉', '1001');
INSERT INTO `t_teacher` VALUES ('3', '薛宝钗', '1001');
INSERT INTO `t_teacher` VALUES ('4', '贾元春', '1001');
INSERT INTO `t_teacher` VALUES ('5', '贾探春', '1001');
INSERT INTO `t_teacher` VALUES ('6', '贾迎春', '1001');
INSERT INTO `t_teacher` VALUES ('7', '贾惜春', '1001');
INSERT INTO `t_teacher` VALUES ('8', '李纨', '1002');
INSERT INTO `t_teacher` VALUES ('9', '妙玉', '1002');
INSERT INTO `t_teacher` VALUES ('10', '史湘云', '1002');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'uid',
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT '123456',
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT '1' COMMENT '用户状态',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '123456', null, null, '1', '1');
INSERT INTO `t_user` VALUES ('2', '200001', '123456', null, null, '2', '1');
INSERT INTO `t_user` VALUES ('3', '200002', '123456', null, null, '2', '1');
INSERT INTO `t_user` VALUES ('4', '200003', '123456', null, null, '2', '1');
INSERT INTO `t_user` VALUES ('5', '200004', '123456', null, null, '2', '1');
INSERT INTO `t_user` VALUES ('6', '200005', '123456', null, null, '2', '1');
INSERT INTO `t_user` VALUES ('7', '200006', '123456', null, null, '2', '1');
INSERT INTO `t_user` VALUES ('8', '200007', '123456', null, null, '2', '1');
INSERT INTO `t_user` VALUES ('9', '200008', '123456', null, null, '2', '1');
INSERT INTO `t_user` VALUES ('10', '200009', '123456', null, null, '2', '1');
INSERT INTO `t_user` VALUES ('11', '300001', '123456', null, null, '3', '1');
INSERT INTO `t_user` VALUES ('12', '300002', '123456', null, null, '3', '1');
INSERT INTO `t_user` VALUES ('13', '300003', '123456', null, null, '3', '1');
INSERT INTO `t_user` VALUES ('14', '300004', '123456', null, null, '3', '1');
INSERT INTO `t_user` VALUES ('15', '300005', '123456', null, null, '3', '1');
INSERT INTO `t_user` VALUES ('16', '300006', '123456', null, null, '3', '1');
INSERT INTO `t_user` VALUES ('17', '300007', '123456', null, null, '3', '1');
INSERT INTO `t_user` VALUES ('18', '300008', '123456', null, null, '3', '1');
INSERT INTO `t_user` VALUES ('19', '300009', '123456', null, null, '3', '1');
INSERT INTO `t_user` VALUES ('20', 'aaa', '123456', null, null, '1', '1');
INSERT INTO `t_user` VALUES ('21', 'bbb', '123456', null, null, '1', '1');
INSERT INTO `t_user` VALUES ('22', 'ccc', '123456', null, null, '1', '1');
INSERT INTO `t_user` VALUES ('23', 'ddd', '123456', null, null, '1', '1');
INSERT INTO `t_user` VALUES ('24', 'eee', '123456', null, null, '1', '1');

-- ----------------------------
-- View structure for v_class
-- ----------------------------
DROP VIEW IF EXISTS `v_class`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `v_class` AS SELECT
t_class.c_id,
t_class.c_name,
t_class.c_type,
t_class.c_term,
t_major.m_name,
t_college.g_name
FROM
t_class
INNER JOIN t_major ON t_class.m_id = t_major.m_id
INNER JOIN t_college ON t_major.g_id = t_college.g_id ;

-- ----------------------------
-- View structure for v_learn
-- ----------------------------
DROP VIEW IF EXISTS `v_learn`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_learn` AS SELECT
t_lesson_class.l_id,
t_class.c_name,
t_class.c_type,
t_class.c_id
FROM
t_class
INNER JOIN t_lesson_class ON t_lesson_class.c_id = t_class.c_id ;

-- ----------------------------
-- View structure for v_lesson
-- ----------------------------
DROP VIEW IF EXISTS `v_lesson`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_lesson` AS SELECT
t_lesson.l_id,
t_subject.b_name AS l_subject,
t_subject.b_crs AS l_crs,
t_period.p_name AS l_term,
t_lesson.l_name,
t_lesson.l_place,
t_lesson.l_time
FROM
t_lesson
INNER JOIN t_period ON t_lesson.l_term = t_period.p_id
INNER JOIN t_subject ON t_lesson.b_id = t_subject.b_id ;

-- ----------------------------
-- View structure for v_student
-- ----------------------------
DROP VIEW IF EXISTS `v_student`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_student` AS SELECT
t_student.u_id,
t_student.s_name,
t_user.account s_id,
t_class.c_name s_class,
t_major.m_name s_major,
t_college.g_name s_college
FROM
t_student
INNER JOIN t_user ON t_student.u_id = t_user.u_id
INNER JOIN t_class ON t_student.s_class = t_class.c_id
INNER JOIN t_major ON t_class.m_id = t_major.m_id
INNER JOIN t_college ON t_major.g_id = t_college.g_id ;

-- ----------------------------
-- View structure for v_subject
-- ----------------------------
DROP VIEW IF EXISTS `v_subject`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `v_subject` AS SELECT
t_subject.b_id,
t_subject.b_name,
t_subject.b_crs,
t_college.g_name b_college,
t_period.p_name b_period
FROM
t_subject
INNER JOIN t_period ON t_subject.b_period = t_period.p_id
INNER JOIN t_college ON t_subject.g_id = t_college.g_id ;

-- ----------------------------
-- View structure for v_teach
-- ----------------------------
DROP VIEW IF EXISTS `v_teach`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `v_teach` AS SELECT t_teach.l_id,
t_teacher.t_name,
t_teacher.u_id

FROM
t_teacher
INNER JOIN t_teach ON t_teach.t_id = t_teacher.u_id ;

-- ----------------------------
-- View structure for v_teacher
-- ----------------------------
DROP VIEW IF EXISTS `v_teacher`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_teacher` AS SELECT
t_teacher.u_id,
t_teacher.t_name,
t_user.account AS t_id,
t_college.g_name t_college
FROM
t_teacher
INNER JOIN t_user ON t_teacher.u_id = t_user.u_id
INNER JOIN t_college ON t_teacher.t_college = t_college.g_id ;
