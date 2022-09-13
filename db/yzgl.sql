/*
Navicat MySQL Data Transfer

Source Server         : conn
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : yzgl

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2022-09-13 22:30:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `animalbuyfromrecord`
-- ----------------------------
DROP TABLE IF EXISTS `animalbuyfromrecord`;
CREATE TABLE `animalbuyfromrecord` (
  `id` varchar(50) NOT NULL,
  `animal_id` varchar(100) DEFAULT NULL COMMENT '动物id（外键）',
  `buyfrom_user_name` varchar(100) DEFAULT NULL COMMENT '卖家名称',
  `buyfrom_user_phone` varchar(100) DEFAULT NULL COMMENT '卖家联系方式',
  `buyfrom_user_location` varchar(100) DEFAULT NULL COMMENT '卖家地址',
  `buyfrom_price` decimal(10,2) DEFAULT NULL COMMENT '买入时价格',
  `buyfrom_time` varchar(100) DEFAULT NULL COMMENT '买入时间',
  `buyfrom_weight` decimal(10,2) DEFAULT NULL COMMENT '买入时体重(单位：kg)',
  `buyfrom_type` varchar(100) DEFAULT NULL COMMENT '买入方式（自行派车，卖家运送）',
  `buyfrom_car_id` varchar(100) DEFAULT NULL COMMENT '车辆派遣记录id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of animalbuyfromrecord
-- ----------------------------
INSERT INTO `animalbuyfromrecord` VALUES ('f714bbee26d74523b90eb5b86c2786ec', '08f34ad734d043858a1a2e1702c6cd4a', '1', '1', '1', '12000.20', '1', '0.00', '卖家运送', null);

-- ----------------------------
-- Table structure for `animals`
-- ----------------------------
DROP TABLE IF EXISTS `animals`;
CREATE TABLE `animals` (
  `id` varchar(50) NOT NULL COMMENT '主键id',
  `animal_name` varchar(100) DEFAULT NULL COMMENT '动物名称（通俗易懂，口头白话取得名字，如果没有就不录入）',
  `animal_logo_code` varchar(100) DEFAULT NULL COMMENT '动物照片地址码（需要调用照片上传接口）',
  `animal_code` varchar(100) DEFAULT NULL COMMENT '动物编号（人为自定义动物编号）',
  `animal_location` varchar(100) DEFAULT NULL COMMENT '动物位置（在家里圈养的位置  例如：一号棚左手侧中间位置）',
  `animal_type` varchar(100) DEFAULT NULL COMMENT '动物类型（牛，马，骡子..）',
  `animal_sex` varchar(100) DEFAULT NULL COMMENT '动物性别（公，母）',
  `animal_color` varchar(100) DEFAULT NULL COMMENT '动物毛色',
  `animal_age` varchar(100) DEFAULT NULL COMMENT '动物年龄',
  `animal_health` varchar(100) DEFAULT NULL COMMENT '动物健康状况（健康，生病，残疾，死亡）',
  `is_delete` int(1) unsigned zerofill DEFAULT '0',
  `animal_weight` decimal(10,2) DEFAULT NULL COMMENT '动物最近测试体重 kg',
  `animal_weight_time` varchar(255) DEFAULT NULL COMMENT '动物最近测试体重时间',
  `animal_buyfrom_time` varchar(255) DEFAULT NULL COMMENT '动物买入时间',
  `animal_buyfrom_price` decimal(10,2) DEFAULT NULL COMMENT '买入时价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of animals
-- ----------------------------
INSERT INTO `animals` VALUES ('08f34ad734d043858a1a2e1702c6cd4a', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', '0', '0.00', '12.00', '12.00', '12000.20');
INSERT INTO `animals` VALUES ('e81d2b5ec2c9451499ad2c3e728a7409', '大黄牛', '1.jpg', '1', '一号棚左侧中间栏位', '牛', '公', '黄白花', '1年', '健康', '0', null, null, null, null);

-- ----------------------------
-- Table structure for `cars`
-- ----------------------------
DROP TABLE IF EXISTS `cars`;
CREATE TABLE `cars` (
  `id` varchar(50) NOT NULL,
  `car_name` varchar(100) DEFAULT NULL COMMENT '车辆名称',
  `car_type` varchar(100) DEFAULT NULL COMMENT '车辆类型（配置到字典表中（小型车，中型车，大型车））',
  `car_user` varchar(100) DEFAULT NULL COMMENT '车主姓名',
  `car_code` varchar(100) DEFAULT NULL COMMENT '车牌号',
  `car_buy_time` varchar(100) DEFAULT NULL,
  `car_weight` decimal(10,2) DEFAULT NULL COMMENT '车辆吨位（单位吨）',
  `car_oil` varchar(100) DEFAULT NULL COMMENT '车辆油料型号 （92号，95号，98号汽油，10#柴油、5＃柴油、0＃柴油、-10＃柴油、 -20＃柴油、-35＃柴油和-50＃柴油',
  `car_price` decimal(10,2) DEFAULT NULL COMMENT '车辆价格',
  `is_use` int(1) unsigned zerofill NOT NULL DEFAULT '0',
  `car_color` varchar(100) DEFAULT NULL COMMENT '车辆颜色',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cars
-- ----------------------------
INSERT INTO `cars` VALUES ('2755df9010e845f78ca825f44113928a', null, null, null, null, null, '3.40', null, '104230.36', '0', null, null);
INSERT INTO `cars` VALUES ('a47aaea6b97946deb45bbc7b8b68b785', '皮卡车', null, null, null, null, null, null, null, '1', null, null);
INSERT INTO `cars` VALUES ('af3f6b8032ba4196b6b0a788b55e6e1f', null, null, null, null, null, '3.48', null, '104230.36', '0', null, null);

-- ----------------------------
-- Table structure for `carsrecord`
-- ----------------------------
DROP TABLE IF EXISTS `carsrecord`;
CREATE TABLE `carsrecord` (
  `id` varchar(50) NOT NULL,
  `car_id` varchar(50) NOT NULL COMMENT '车辆id（外键）',
  `driver_name` varchar(100) DEFAULT NULL COMMENT '司机姓名',
  `driver_phone` varchar(100) DEFAULT NULL COMMENT '司机联系方式',
  `driver_home` varchar(200) DEFAULT NULL COMMENT '司机家庭住址（简单描述）',
  `car_location` varchar(200) DEFAULT NULL COMMENT '车辆派遣地点（用户手动录入）',
  `car_use_time` varchar(100) DEFAULT NULL COMMENT '车辆派遣时间',
  `car_use_type` varchar(100) DEFAULT NULL COMMENT '车辆派遣类型（购买牲畜，运送牲畜，农活，清理粪便）四种情况走四种接口',
  `car_back_time` varchar(100) DEFAULT NULL COMMENT '车辆返回时间',
  `car_pay` decimal(4,0) DEFAULT NULL COMMENT '车辆支出费用（包括路费，餐饮费，油费等等）',
  `car_status` varchar(100) DEFAULT NULL COMMENT '车辆运载情况（空载，小有收获，满载而归）',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carsrecord
-- ----------------------------
INSERT INTO `carsrecord` VALUES ('2fcdfd52559f452988992f125d3324fe', 'a47aaea6b97946deb45bbc7b8b68b785', 'Jerry', '1111', null, null, null, null, null, null, null, null);
INSERT INTO `carsrecord` VALUES ('958351e96d1c4ae99c1b7ca9789c5973', 'a47aaea6b97946deb45bbc7b8b68b785', 'Jerry', '444444', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `dic`
-- ----------------------------
DROP TABLE IF EXISTS `dic`;
CREATE TABLE `dic` (
  `id` varchar(50) NOT NULL COMMENT '主键id',
  `dic_name` varchar(100) DEFAULT NULL COMMENT '字典名称',
  `dic_code` varchar(100) DEFAULT NULL COMMENT '字典码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dic
-- ----------------------------
INSERT INTO `dic` VALUES ('2bf243d38cdf4fb69ab13098c41196c9', '牲畜健康状况', 'health');
INSERT INTO `dic` VALUES ('48d741d42df64d129cb4b06b3adb3d51', '牲畜性别', 'sex');
INSERT INTO `dic` VALUES ('8039b2fe10e444c48e97e5b1ce250b2e', '车辆类型', 'carType');
INSERT INTO `dic` VALUES ('a2edc70246284f42abaa35eae5d194a7', '牲畜类型', 'type');
INSERT INTO `dic` VALUES ('b1c742d4f2014de4a40dd431029a2ef8', '车辆派遣类型', 'carUseType');
INSERT INTO `dic` VALUES ('c5830a4ce98549d89000f291bc3e1400', '拉回车辆运载情况', 'carStatus');
INSERT INTO `dic` VALUES ('d889ab174a9f4084992794b7dbc9dd6c', '牛圈栏位', 'location');
INSERT INTO `dic` VALUES ('e3f989a0232d4ca89bc5879da2986c38', '车辆油料型号', 'carOil');

-- ----------------------------
-- Table structure for `dicitem`
-- ----------------------------
DROP TABLE IF EXISTS `dicitem`;
CREATE TABLE `dicitem` (
  `id` varchar(50) NOT NULL,
  `dicitem_name` varchar(100) DEFAULT NULL COMMENT '字典描述',
  `dicitem_code` varchar(100) DEFAULT NULL COMMENT '字典码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `register_time` varchar(100) DEFAULT NULL COMMENT '用户注册时间',
  `phone` varchar(100) DEFAULT NULL COMMENT '联系方式',
  `org_name` varchar(100) DEFAULT NULL COMMENT '公司名称',
  `login_time` varchar(100) DEFAULT NULL COMMENT '上次登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;


