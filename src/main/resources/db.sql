/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Version : 50630
 Source Host           : localhost
 Source Database       : gif

 Target Server Version : 50630
 File Encoding         : utf-8

 Date: 12/22/2017 15:25:13 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`c_date` datetime DEFAULT NULL,
	`comment_num` bigint(20) NOT NULL,
	`grelease` bit(1) NOT NULL,
	`pic_path` varchar(128) DEFAULT NULL,
	`head_path` varchar(128) DEFAULT NULL,
	`keywords` varchar(128) DEFAULT NULL,
	`love_num` bigint(20) NOT NULL,
	`show_num` bigint(20) NOT NULL,
	`tag_id` bigint(20) NOT NULL,
	`title` varchar(256) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ROW_FORMAT=COMPACT CHECKSUM=0 DELAY_KEY_WRITE=0;

-- ----------------------------
--  Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`article_id` bigint(20) NOT NULL,
	`c_date` datetime DEFAULT NULL,
	`content` varchar(512) DEFAULT NULL,
	`floor` bigint(20) NOT NULL,
	`ip` varchar(16) NOT NULL,
	`love_num` bigint(20) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ROW_FORMAT=COMPACT CHECKSUM=0 DELAY_KEY_WRITE=0;

-- ----------------------------
--  Table structure for `comment_love`
-- ----------------------------
DROP TABLE IF EXISTS `comment_love`;
CREATE TABLE `comment_love` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`comment_id` bigint(20) NOT NULL,
	`ip` varchar(16) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ROW_FORMAT=COMPACT CHECKSUM=0 DELAY_KEY_WRITE=0;

-- ----------------------------
--  Table structure for `love`
-- ----------------------------
DROP TABLE IF EXISTS `love`;
CREATE TABLE `love` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`article_id` bigint(20) NOT NULL,
	`ip` varchar(16) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ROW_FORMAT=COMPACT CHECKSUM=0 DELAY_KEY_WRITE=0;

-- ----------------------------
--  Table structure for `tag`
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`name_py` varchar(64) NOT NULL,
	`show_num` bigint(20) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE `name` (name)
) ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ROW_FORMAT=COMPACT CHECKSUM=0 DELAY_KEY_WRITE=0;


-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`created_date` datetime DEFAULT NULL,
	`email` varchar(64) NOT NULL,
	`name` varchar(64) NOT NULL,
	`password` varchar(64) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE `email` (email),
	UNIQUE `name` (`name`)
) ENGINE=`InnoDB` AUTO_INCREMENT=1 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ROW_FORMAT=COMPACT CHECKSUM=0 DELAY_KEY_WRITE=0;


SET FOREIGN_KEY_CHECKS = 1;
