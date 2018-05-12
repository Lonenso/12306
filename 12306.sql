/*
Navicat MySQL Data Transfer

Source Server         : mydatabase
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : 12306

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-05-12 12:27:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for station
-- ----------------------------
DROP TABLE IF EXISTS `station`;
CREATE TABLE `station` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `train_id` varchar(255) NOT NULL COMMENT '站点id 例：3505',
  `station_name` varchar(255) NOT NULL COMMENT '站点名 例：泉州',
  `timeofArrival` time DEFAULT NULL,
  `timeofStart` time DEFAULT NULL,
  `_date` int(1) NOT NULL DEFAULT '0' COMMENT '0当天，1次日，2两日',
  `_cost` double(6,0) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of station
-- ----------------------------
INSERT INTO `station` VALUES ('3', 'G7321', '上海', '09:13:00', '09:23:00', '0', '73');
INSERT INTO `station` VALUES ('4', 'G7321', '南京', '10:59:00', '11:09:00', '0', '212');
INSERT INTO `station` VALUES ('5', 'G7321', '济南', '13:45:00', '13:55:00', '0', '491');
INSERT INTO `station` VALUES ('6', 'G7321', '天津', '15:11:00', '15:21:00', '0', '631');
INSERT INTO `station` VALUES ('7', 'G7321', '北京', '15:56:00', null, '0', '685');
INSERT INTO `station` VALUES ('8', 'G7661', '长沙', null, '13:00:00', '0', '0');
INSERT INTO `station` VALUES ('9', 'G7661', '武汉', '14:26:00', '14:36:00', '0', '164');
INSERT INTO `station` VALUES ('10', 'G7661', '郑州', '16:45:00', '16:55:00', '0', '408');
INSERT INTO `station` VALUES ('11', 'G7661', '天津', '20:19:00', '20:29:00', '0', '717');
INSERT INTO `station` VALUES ('12', 'G7661', '沈阳', '00:23:00', null, '1', '957');
INSERT INTO `station` VALUES ('13', 'K67', '成都', null, '09:00:00', '0', '0');
INSERT INTO `station` VALUES ('14', 'K67', '重庆', '12:58:00', '13:08:00', '0', '46');
INSERT INTO `station` VALUES ('15', 'K67', '西安', '00:27:00', '00:37:00', '1', '151');
INSERT INTO `station` VALUES ('16', 'K67', '太原', '09:07:00', '09:17:00', '1', '253');
INSERT INTO `station` VALUES ('17', 'K67', '北京', '19:20:00', '19:30:00', '1', '331');
INSERT INTO `station` VALUES ('18', 'K67', '沈阳', '05:17:00', '05:27:00', '2', '443');
INSERT INTO `station` VALUES ('19', 'K67', '长春', '09:04:00', '09:14:00', '2', '490');
INSERT INTO `station` VALUES ('20', 'K67', '哈尔滨', '12:04:00', null, '2', '527');
INSERT INTO `station` VALUES ('21', 'D3235', '南京', '16:50:00', '17:00:00', '0', '134');
INSERT INTO `station` VALUES ('22', 'D3235', '郑州', '20:27:00', '20:37:00', '0', '317');
INSERT INTO `station` VALUES ('23', 'D3235', '西安', '23:07:00', '23:17:00', '0', '556');
INSERT INTO `station` VALUES ('24', 'D3235', '兰州', '02:34:00', '02:44:00', '1', '731');
INSERT INTO `station` VALUES ('25', 'D3235', '西宁', '04:14:00', '04:24:00', '1', '792');
INSERT INTO `station` VALUES ('26', 'D3235', '乌鲁木齐', '19:24:00', null, '1', '990');
INSERT INTO `station` VALUES ('27', 'D3235', '杭州', null, '15:00:00', '0', '0');
INSERT INTO `station` VALUES ('28', 'D3235', '上海', '16:07:00', '16:17:00', '0', '73');
INSERT INTO `station` VALUES ('200', 'G7321', '杭州', null, '08:00:00', '0', '0');

-- ----------------------------
-- Table structure for train
-- ----------------------------
DROP TABLE IF EXISTS `train`;
CREATE TABLE `train` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `train_id` varchar(255) NOT NULL COMMENT '首字母大写+编号（例:K7871)',
  `first_class` int(3) unsigned NOT NULL DEFAULT '0' COMMENT '一等座，大于0表示余量，0代表无票',
  `second_class` int(3) unsigned DEFAULT '0' COMMENT '二等座余量，0代表无',
  `state_cabins` int(3) unsigned DEFAULT NULL,
  `hard` int(3) unsigned DEFAULT NULL,
  `soft` int(3) unsigned DEFAULT NULL,
  `_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of train
-- ----------------------------
INSERT INTO `train` VALUES ('1', 'G7321', '100', '200', '100', '100', '100', '2018-01-08');
INSERT INTO `train` VALUES ('3', 'G7321', '100', '200', '100', '100', '100', '2018-01-10');
INSERT INTO `train` VALUES ('4', 'G7661', '100', '200', '100', '100', '100', '2018-01-08');
INSERT INTO `train` VALUES ('5', 'G7661', '100', '200', '100', '100', '100', '2018-01-09');
INSERT INTO `train` VALUES ('6', 'G7661', '100', '200', '100', '100', '100', '2018-01-10');
INSERT INTO `train` VALUES ('7', 'D3235', '120', '220', '120', '120', '120', '2018-01-08');
INSERT INTO `train` VALUES ('8', 'D3235', '120', '220', '120', '120', '120', '2018-01-09');
INSERT INTO `train` VALUES ('9', 'D3235', '120', '220', '120', '120', '120', '2018-01-10');
INSERT INTO `train` VALUES ('10', 'K67', '80', '180', '80', '80', '80', '2018-01-08');
INSERT INTO `train` VALUES ('11', 'K67', '80', '180', '80', '80', '80', '2018-01-09');
INSERT INTO `train` VALUES ('12', 'K67', '80', '180', '80', '80', '80', '2018-01-10');
INSERT INTO `train` VALUES ('13', 'K67', '80', '180', '80', '80', '80', '2018-01-07');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `permission` int(1) DEFAULT NULL,
  `phonenum` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('hhhhhh', 'zyh12138', '1', '15968812005', 'xll');
INSERT INTO `user` VALUES ('Lonenso', '15478xx', '1', '15968812003', 'zyh');
INSERT INTO `user` VALUES ('Lonensoo', '15478xx', '1', null, null);
INSERT INTO `user` VALUES ('xllxll', '123xll', '2', '13126543514', 'zrh');
