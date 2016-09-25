/*
Navicat MySQL Data Transfer

Source Server         : localhost-3306
Source Server Version : 50171
Source Host           : localhost:3306
Source Database       : battcn2

Target Server Type    : MYSQL
Target Server Version : 50171
File Encoding         : 65001

Date: 2016-09-25 13:19:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_sys_logs
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_logs`;
CREATE TABLE `t_sys_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) DEFAULT NULL,
  `title` varchar(40) DEFAULT NULL,
  `methods` varchar(128) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `optime` datetime DEFAULT NULL,
  `ip` varchar(15) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `params` longtext,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_logs
-- ----------------------------
INSERT INTO `t_sys_logs` VALUES ('11', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 15:37:35', '0:0:0:0:0:0:0:1', '0', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('12', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 15:38:39', '0:0:0:0:0:0:0:1', '0', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('13', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 15:45:04', '0:0:0:0:0:0:0:1', '7', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('14', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 15:53:56', '0:0:0:0:0:0:0:1', '0', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('15', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 15:56:00', '0:0:0:0:0:0:0:1', '0', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('7', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 15:37:17', '0:0:0:0:0:0:0:1', '8', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('8', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 15:37:19', '0:0:0:0:0:0:0:1', '0', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('9', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 15:37:20', '0:0:0:0:0:0:0:1', '0', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('10', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 15:37:21', '0:0:0:0:0:0:0:1', '0', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('16', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 16:00:41', '0:0:0:0:0:0:0:1', '0', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('17', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 16:00:47', '0:0:0:0:0:0:0:1', '0', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('18', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 16:01:01', '0:0:0:0:0:0:0:1', '0', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('19', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 16:05:13', '0:0:0:0:0:0:0:1', '0', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('20', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 16:05:51', '0:0:0:0:0:0:0:1', '0', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('21', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 16:07:41', '0:0:0:0:0:0:0:1', '0', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('22', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 16:11:14', '0:0:0:0:0:0:0:1', '7', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('23', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 16:29:19', '0:0:0:0:0:0:0:1', '8', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('24', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 16:32:05', '0:0:0:0:0:0:0:1', '9', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('25', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 16:32:33', '0:0:0:0:0:0:0:1', '7', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('26', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 16:35:28', '0:0:0:0:0:0:0:1', '8', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('27', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 16:38:40', '0:0:0:0:0:0:0:1', '7', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('28', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 16:39:12', '0:0:0:0:0:0:0:1', '7', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('29', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 16:40:31', '0:0:0:0:0:0:0:1', '8', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('30', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 16:43:16', '0:0:0:0:0:0:0:1', '8', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('31', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 16:45:19', '0:0:0:0:0:0:0:1', '8', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('32', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 16:50:27', '0:0:0:0:0:0:0:1', '7', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('33', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 16:55:04', '0:0:0:0:0:0:0:1', '9', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('34', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 16:58:29', '0:0:0:0:0:0:0:1', '8', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('35', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 16:59:38', '0:0:0:0:0:0:0:1', '8', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('36', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 17:01:16', '0:0:0:0:0:0:0:1', '7', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('37', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 17:01:30', '0:0:0:0:0:0:0:1', '0', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('38', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 17:02:10', '0:0:0:0:0:0:0:1', '8', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('39', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 17:02:58', '0:0:0:0:0:0:0:1', '8', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('40', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 17:03:44', '0:0:0:0:0:0:0:1', '8', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('41', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 17:10:16', '0:0:0:0:0:0:0:1', '7', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('42', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 17:13:22', '0:0:0:0:0:0:0:1', '7', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('43', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 17:15:51', '0:0:0:0:0:0:0:1', '9', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('44', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 17:16:49', '0:0:0:0:0:0:0:1', '0', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('45', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 17:17:30', '0:0:0:0:0:0:0:1', '9', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('46', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 17:18:20', '0:0:0:0:0:0:0:1', '0', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('47', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-15 17:19:19', '0:0:0:0:0:0:0:1', '8', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('48', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-25 08:43:27', '0:0:0:0:0:0:0:1', '7', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('49', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-25 08:48:11', '0:0:0:0:0:0:0:1', '9', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('50', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-25 08:50:23', '0:0:0:0:0:0:0:1', '8', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('51', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-25 08:52:14', '0:0:0:0:0:0:0:1', '8', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('52', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-25 08:53:13', '0:0:0:0:0:0:0:1', '8', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('53', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-25 08:53:54', '0:0:0:0:0:0:0:1', '7', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('54', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-25 08:54:52', '0:0:0:0:0:0:0:1', '8', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('55', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-25 08:55:30', '0:0:0:0:0:0:0:1', '9', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('56', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-25 08:55:54', '0:0:0:0:0:0:0:1', '7', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('57', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-25 08:56:27', '0:0:0:0:0:0:0:1', '9', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('58', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-25 09:00:04', '0:0:0:0:0:0:0:1', '7', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('59', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-25 10:14:16', '0:0:0:0:0:0:0:1', '8', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('60', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-25 10:49:25', '0:0:0:0:0:0:0:1', '8', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('61', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-25 11:46:38', '127.0.0.1', '8', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('62', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-25 12:04:39', '0:0:0:0:0:0:0:1', '8', null, '/pub/logs/list.shtml');
INSERT INTO `t_sys_logs` VALUES ('63', 'admin', '日志模块', '日志list', '进入日志查询的页面', '2016-09-25 12:08:29', '127.0.0.1', '7', null, '/pub/logs/list.shtml');

-- ----------------------------
-- Table structure for t_sys_manager
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_manager`;
CREATE TABLE `t_sys_manager` (
  `managerid` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) NOT NULL COMMENT '账号',
  `password` varchar(50) NOT NULL,
  `role` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `lastloginip` varchar(15) DEFAULT NULL COMMENT '登陆IP',
  `lastlogintime` datetime DEFAULT NULL COMMENT '最后一次登陆时间',
  `credentialsSalt` varchar(100) DEFAULT NULL COMMENT '验证凭证',
  `locked` varchar(3) DEFAULT '0' COMMENT '是否启用 0=禁用 1=启用',
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `photo` varchar(266) DEFAULT NULL,
  PRIMARY KEY (`managerid`),
  UNIQUE KEY `AK_ACCOUNT` (`account`),
  KEY `FK_Reference_13` (`role`),
  CONSTRAINT `t_sys_manager_ibfk_1` FOREIGN KEY (`role`) REFERENCES `t_sys_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_manager
-- ----------------------------
INSERT INTO `t_sys_manager` VALUES ('1', 'admin', 'a122080ba7afebf036ed3c811c7880f9', '1', '秋殇', '0:0:0:0:0:0:0:1', '2016-09-25 12:34:30', '9c6c9e22ae8c773c8f07a75b28563152', '1', null, null, '男', null, null);
INSERT INTO `t_sys_manager` VALUES ('3', 'memmsc', 'ffaf9b705d272055372cc3995ce2d448', '2', '唐亚峰', '0:0:0:0:0:0:0:1', '2016-07-21 16:20:46', '1da611f87449065cb4ea69e6a432d1af', '1', null, null, '女', null, null);

-- ----------------------------
-- Table structure for t_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_menu`;
CREATE TABLE `t_sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `remark` varchar(2000) DEFAULT NULL,
  `img` varchar(100) DEFAULT NULL,
  `channel` varchar(100) DEFAULT NULL,
  `param` varchar(200) DEFAULT NULL,
  `addtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  `state` int(1) NOT NULL,
  `pid` int(11) DEFAULT NULL,
  `ordno` int(11) DEFAULT NULL,
  `nlevel` int(11) DEFAULT NULL,
  `scort` varchar(8000) DEFAULT NULL,
  `is_auto_expand_` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_17` (`pid`),
  CONSTRAINT `t_sys_menu_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `t_sys_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_menu
-- ----------------------------
INSERT INTO `t_sys_menu` VALUES ('2', '帐号管理', '1', 'fa fa-sun-o', '/pub/manager', 'pub:manager', '2012-10-11 17:16:15', '2012-10-29 13:48:32', '1', '18', '1', '1', ',18,2,', null);
INSERT INTO `t_sys_menu` VALUES ('4', '菜单管理', '2', 'fa fa-server', '/pub/menu', 'pub:menu', '2012-10-12 09:41:54', '2012-10-17 14:12:00', '1', '18', '2', '1', ',18,4,', null);
INSERT INTO `t_sys_menu` VALUES ('5', '操作管理', '3', 'fa fa-hand-lizard-o', '/pub/operate', 'pub:operate', '2012-10-12 13:11:38', '2012-10-16 09:17:23', '1', '18', '3', '1', ',18,5,', null);
INSERT INTO `t_sys_menu` VALUES ('8', '角色管理', '4', 'fa fa-sitemap', '/pub/role', 'pub:role', '2012-10-15 10:24:38', '2012-10-16 09:17:18', '1', '18', '4', '1', ',18,8,', null);
INSERT INTO `t_sys_menu` VALUES ('15', '字典管理', '11111', 'fa fa-newspaper-o', '/pub/dict', 'pub:dict', '2012-10-15 11:41:06', '2016-09-15 13:55:33', '0', '18', '5', '1', ',18,15,', null);
INSERT INTO `t_sys_menu` VALUES ('18', '系统管理', '6', 'fa fa fa-home', '/pub/sys', 'pub:sys', '2012-10-16 09:15:27', '2012-10-23 10:10:07', '1', null, '6', '0', ',18,', null);
INSERT INTO `t_sys_menu` VALUES ('29', '日志管理', '7', 'fa fa-comments-o', '/pub/logs', 'pub:logs', '2012-10-29 14:08:44', '2012-10-31 18:23:18', '1', '18', '7', '1', ',18,29,', null);
INSERT INTO `t_sys_menu` VALUES ('30', '监控管理', '', 'fa fa-cogs', '/monitor', 'monitor:manager', '2016-09-25 11:40:36', '2016-09-25 11:41:22', '1', null, null, '0', ',30,', null);
INSERT INTO `t_sys_menu` VALUES ('31', '连接池监控', '', 'fa fa-database', '/system/druid', 'druid:monitor', '2016-09-25 11:42:42', '2016-09-25 11:43:51', '1', '30', '1', '1', ',30,31,', null);
INSERT INTO `t_sys_menu` VALUES ('32', '系统监控', '', 'fa fa-gear', '/system/monitor', 'system:monitor', '2016-09-25 11:43:34', '2016-09-25 11:43:34', '1', '30', '1', '1', ',30,32,', null);

-- ----------------------------
-- Table structure for t_sys_operate
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_operate`;
CREATE TABLE `t_sys_operate` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu` int(11) NOT NULL COMMENT '菜单ID',
  `op` varchar(50) NOT NULL COMMENT '选项',
  `name` varchar(100) NOT NULL COMMENT '名字',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `remark` varchar(2000) DEFAULT NULL COMMENT '备注',
  `ordno` int(11) DEFAULT NULL COMMENT '排序号',
  `isshow` int(1) NOT NULL COMMENT '是否显示出来',
  PRIMARY KEY (`id`),
  UNIQUE KEY `menu` (`menu`,`op`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_operate
-- ----------------------------
INSERT INTO `t_sys_operate` VALUES ('1', '2', 'add', '新增', 'plus', '', '2', '1');
INSERT INTO `t_sys_operate` VALUES ('2', '2', 'edit', '编辑', 'edit', '', '3', '1');
INSERT INTO `t_sys_operate` VALUES ('3', '2', 'list', '查看', 'list', '', '1', '0');
INSERT INTO `t_sys_operate` VALUES ('4', '2', 'remove', '删除', 'remove', '', '4', '1');
INSERT INTO `t_sys_operate` VALUES ('5', '2', 'save', '保存', 'save', '', '5', '0');
INSERT INTO `t_sys_operate` VALUES ('6', '4', 'add', '新增', 'plus', '', '2', '1');
INSERT INTO `t_sys_operate` VALUES ('7', '4', 'edit', '编辑', 'edit', '', '3', '1');
INSERT INTO `t_sys_operate` VALUES ('8', '4', 'list', '查看', 'list', '', '1', '0');
INSERT INTO `t_sys_operate` VALUES ('9', '4', 'remove', '删除', 'remove', '', '4', '1');
INSERT INTO `t_sys_operate` VALUES ('10', '4', 'save', '保存', 'save', '', '5', '0');
INSERT INTO `t_sys_operate` VALUES ('11', '5', 'add', '新增', 'plus', '', '2', '1');
INSERT INTO `t_sys_operate` VALUES ('12', '5', 'edit', '编辑', 'edit', '', '3', '1');
INSERT INTO `t_sys_operate` VALUES ('13', '5', 'list', '查看', 'list', '', '1', '0');
INSERT INTO `t_sys_operate` VALUES ('14', '5', 'remove', '删除', 'remove', '', '4', '1');
INSERT INTO `t_sys_operate` VALUES ('15', '5', 'save', '保存', 'save', '', '5', '0');
INSERT INTO `t_sys_operate` VALUES ('16', '8', 'add', '新增', 'plus', '', '2', '1');
INSERT INTO `t_sys_operate` VALUES ('17', '8', 'edit', '编辑', 'edit', '', '3', '1');
INSERT INTO `t_sys_operate` VALUES ('18', '8', 'list', '查看', 'list', '', '1', '0');
INSERT INTO `t_sys_operate` VALUES ('19', '8', 'remove', '删除', 'remove', '', '4', '1');
INSERT INTO `t_sys_operate` VALUES ('20', '8', 'save', '保存', 'save', '', '5', '0');
INSERT INTO `t_sys_operate` VALUES ('21', '15', 'add', '新增', 'plus', '', '2', '1');
INSERT INTO `t_sys_operate` VALUES ('22', '15', 'edit', '编辑', 'edit', '测试一下把', '3', '1');
INSERT INTO `t_sys_operate` VALUES ('23', '15', 'list', '查看', 'list', '', '1', '0');
INSERT INTO `t_sys_operate` VALUES ('24', '15', 'remove', '删除', 'remove', '', '4', '1');
INSERT INTO `t_sys_operate` VALUES ('25', '15', 'save', '保存', 'save', '', '5', '0');
INSERT INTO `t_sys_operate` VALUES ('26', '29', 'list', '查看', 'list', '', '1', '0');
INSERT INTO `t_sys_operate` VALUES ('27', '29', 'remove', '删除', 'remove', '', '2', '0');
INSERT INTO `t_sys_operate` VALUES ('35', '29', 'export', '导出日志', 'file-excel-o', '导出日志功能', '1', '1');
INSERT INTO `t_sys_operate` VALUES ('37', '31', 'list', '查询', null, null, null, '1');
INSERT INTO `t_sys_operate` VALUES ('38', '32', 'list', '查询', null, null, null, '1');

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `code` varchar(50) DEFAULT NULL,
  `remark` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('1', '超级管理员', 'manager', '超级管理员,不听话就封号');
INSERT INTO `t_sys_role` VALUES ('2', '测试管理员', 'test', '专门测试没有权限的时候1');
INSERT INTO `t_sys_role` VALUES ('5', '开发管理员', 'code', '我是开发不服删数据库');

-- ----------------------------
-- Table structure for t_sys_role_operate
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_operate`;
CREATE TABLE `t_sys_role_operate` (
  `role` int(11) NOT NULL,
  `op_id` int(8) NOT NULL COMMENT 'op_id',
  PRIMARY KEY (`role`,`op_id`),
  KEY `op_id` (`op_id`),
  CONSTRAINT `t_sys_role_operate_ibfk_1` FOREIGN KEY (`role`) REFERENCES `t_sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_sys_role_operate_ibfk_2` FOREIGN KEY (`op_id`) REFERENCES `t_sys_operate` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_role_operate
-- ----------------------------
INSERT INTO `t_sys_role_operate` VALUES ('1', '1');
INSERT INTO `t_sys_role_operate` VALUES ('5', '1');
INSERT INTO `t_sys_role_operate` VALUES ('1', '2');
INSERT INTO `t_sys_role_operate` VALUES ('5', '2');
INSERT INTO `t_sys_role_operate` VALUES ('1', '3');
INSERT INTO `t_sys_role_operate` VALUES ('5', '3');
INSERT INTO `t_sys_role_operate` VALUES ('1', '4');
INSERT INTO `t_sys_role_operate` VALUES ('5', '4');
INSERT INTO `t_sys_role_operate` VALUES ('1', '5');
INSERT INTO `t_sys_role_operate` VALUES ('5', '5');
INSERT INTO `t_sys_role_operate` VALUES ('1', '6');
INSERT INTO `t_sys_role_operate` VALUES ('5', '6');
INSERT INTO `t_sys_role_operate` VALUES ('1', '7');
INSERT INTO `t_sys_role_operate` VALUES ('5', '7');
INSERT INTO `t_sys_role_operate` VALUES ('1', '8');
INSERT INTO `t_sys_role_operate` VALUES ('5', '8');
INSERT INTO `t_sys_role_operate` VALUES ('1', '9');
INSERT INTO `t_sys_role_operate` VALUES ('5', '9');
INSERT INTO `t_sys_role_operate` VALUES ('1', '10');
INSERT INTO `t_sys_role_operate` VALUES ('5', '10');
INSERT INTO `t_sys_role_operate` VALUES ('1', '11');
INSERT INTO `t_sys_role_operate` VALUES ('5', '11');
INSERT INTO `t_sys_role_operate` VALUES ('1', '12');
INSERT INTO `t_sys_role_operate` VALUES ('5', '12');
INSERT INTO `t_sys_role_operate` VALUES ('1', '13');
INSERT INTO `t_sys_role_operate` VALUES ('5', '13');
INSERT INTO `t_sys_role_operate` VALUES ('1', '14');
INSERT INTO `t_sys_role_operate` VALUES ('5', '14');
INSERT INTO `t_sys_role_operate` VALUES ('1', '15');
INSERT INTO `t_sys_role_operate` VALUES ('5', '15');
INSERT INTO `t_sys_role_operate` VALUES ('1', '16');
INSERT INTO `t_sys_role_operate` VALUES ('5', '16');
INSERT INTO `t_sys_role_operate` VALUES ('1', '17');
INSERT INTO `t_sys_role_operate` VALUES ('5', '17');
INSERT INTO `t_sys_role_operate` VALUES ('1', '18');
INSERT INTO `t_sys_role_operate` VALUES ('5', '18');
INSERT INTO `t_sys_role_operate` VALUES ('1', '19');
INSERT INTO `t_sys_role_operate` VALUES ('5', '19');
INSERT INTO `t_sys_role_operate` VALUES ('1', '20');
INSERT INTO `t_sys_role_operate` VALUES ('5', '20');
INSERT INTO `t_sys_role_operate` VALUES ('5', '21');
INSERT INTO `t_sys_role_operate` VALUES ('5', '22');
INSERT INTO `t_sys_role_operate` VALUES ('5', '23');
INSERT INTO `t_sys_role_operate` VALUES ('5', '24');
INSERT INTO `t_sys_role_operate` VALUES ('5', '25');
INSERT INTO `t_sys_role_operate` VALUES ('1', '26');
INSERT INTO `t_sys_role_operate` VALUES ('2', '26');
INSERT INTO `t_sys_role_operate` VALUES ('5', '26');
INSERT INTO `t_sys_role_operate` VALUES ('1', '27');
INSERT INTO `t_sys_role_operate` VALUES ('2', '27');
INSERT INTO `t_sys_role_operate` VALUES ('5', '27');
INSERT INTO `t_sys_role_operate` VALUES ('1', '35');
INSERT INTO `t_sys_role_operate` VALUES ('2', '35');
INSERT INTO `t_sys_role_operate` VALUES ('1', '37');
INSERT INTO `t_sys_role_operate` VALUES ('1', '38');

-- ----------------------------
-- Procedure structure for showTreeNodes_menu
-- ----------------------------
DROP PROCEDURE IF EXISTS `showTreeNodes_menu`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `showTreeNodes_menu`()
BEGIN
 DECLARE Level int ;
 Set Level=0 ;
 update t_sys_menu a inner join (SELECT id,Level,concat(',',ID,',') scort FROM t_sys_menu WHERE pid is null) b on a.id=b.id
 set a.nlevel=b.level,a.scort=b.scort;
 WHILE FOUND_ROWS()>0 DO
  SET Level=Level+1;
update t_sys_menu a inner join (
   SELECT ID,Level,scort FROM t_sys_menu 
    WHERE nLevel=Level-1) b on a.pid=b.id
 set a.nlevel=b.level,a.scort=concat(b.scort,a.ID,',');
 END WHILE;
  
END
;;
DELIMITER ;
