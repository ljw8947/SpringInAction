/*
Navicat MySQL Data Transfer

Source Server         : localdb
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2017-12-08 14:01:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for studentinfo
-- ----------------------------
DROP TABLE IF EXISTS `studentinfo`;
CREATE TABLE `studentinfo` (
  `StudentID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Name` varchar(10) NOT NULL DEFAULT '',
  `Birthday` date NOT NULL DEFAULT '1900-01-01',
  `Gender` smallint(1) NOT NULL DEFAULT '0',
  `CreateTime` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `UpdateTime` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`StudentID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
