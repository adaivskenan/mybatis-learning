/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : mybatis

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 11/26/2017 12:36:03 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `country`
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `countryname` varchar(255) DEFAULT NULL,
  `countrycode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `country`
-- ----------------------------
BEGIN;
INSERT INTO `country` VALUES ('1', '中国', 'CN'), ('2', '美国', 'US'), ('3', '俄罗斯', 'RU'), ('4', '英国', 'GB'), ('5', '法国', 'FR');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
