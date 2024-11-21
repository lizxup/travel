/*
 Navicat Premium Dump SQL

 Source Server         : peanut
 Source Server Type    : MySQL
 Source Server Version : 80402 (8.4.2)
 Source Host           : localhost:3306
 Source Schema         : travel

 Target Server Type    : MySQL
 Target Server Version : 80402 (8.4.2)
 File Encoding         : 65001

 Date: 22/11/2024 05:39:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '姓名',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像',
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '管理员表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (3, 'admin', '123456', 'lzx', 'http://localhost:9091/files/download/1732045422040-444d5ab63463413859f05ec2d39d174.jpg', 'ADMIN', '17788889999', 'lizxup@outlook.com');

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标题',
  `descr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '描述',
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '封面',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '内容',
  `read_count` int NULL DEFAULT NULL COMMENT '阅读量',
  `date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '发布日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '旅游攻略信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (4, '玉龙山', '爬雪山', NULL, NULL, 0, '2024-11-22 00:58:53');
INSERT INTO `article` VALUES (5, '玉龙雪山', '嘀嘀嘀嘀嘀', NULL, '<p><img src=\"http://localhost:9091/files/download/1732212192366-2a2e9d66-b41d-4645-87bd-95f2cfeed218.jpg\" alt=\"\" data-href=\"\" style=\"\"/></p>', 0, '2024-11-22 01:00:30');
INSERT INTO `article` VALUES (9, '泰山', '日出', NULL, NULL, 0, '2024-11-22 01:02:01');
INSERT INTO `article` VALUES (10, '华山', '令狐冲', NULL, NULL, 0, '2024-11-22 01:05:29');
INSERT INTO `article` VALUES (13, '111', '222', 'http://localhost:9091/files/download/1732210639156-2a50628e-7758-4c51-9fbb-d37c61cdacad.jpg', '<p>我们见过</p><pre><code class=\"language-python\">print(\"hello!\")</code></pre><p><strong>四川腊肠值得品尝！</strong></p><p><img src=\"http://localhost:9091/files/download/1732212640472-2a50628e-7758-4c51-9fbb-d37c61cdacad.jpg\" alt=\"\" data-href=\"\" style=\"\"/></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p>w nia </p><p><br></p>', 0, '2024-11-22 01:37:22');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '公告标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '公告内容',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '系统公告表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (4, '不能说的秘密', '你说把爱渐渐放下会走更远\n', '2024-11-20 18:01:53');
INSERT INTO `notice` VALUES (5, '搁浅', '我只能永远的读着依赖\n读着我给你的伤害\n我原谅不了我\n就请你当作为已不在\n我睁开双眼看着空白\n忘记你对我的期待\n读完了依赖\n我很快就离开', '2024-11-20 18:04:42');
INSERT INTO `notice` VALUES (6, '黑色幽默', '不懂你的黑色幽默\n想通却又再考打我\n说散你想很久了吧\n我不想拆穿你\n当作是你开的玩笑', '2024-11-20 18:06:12');

-- ----------------------------
-- Table structure for routes
-- ----------------------------
DROP TABLE IF EXISTS `routes`;
CREATE TABLE `routes`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `days` int NULL DEFAULT NULL COMMENT '天数',
  `tips` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '小提示',
  `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '路线内容',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图片',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地点',
  `longitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '经度',
  `latitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '纬度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '旅游路线信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of routes
-- ----------------------------
INSERT INTO `routes` VALUES (11, '伊犁环线7天6晚这样玩❗', 7, '新疆伊犁7日游，快带你的小伙伴一起来玩！', '<p><span style=\"color: rgb(96, 98, 102); background-color: rgb(255, 255, 255); font-size: 14px;\">这个季节一定要去北疆❗ 去看蓝色湖泊💦、郁郁葱葱的草原🌿、漫山遍野的花海🌸、随手一拍就是大片📸 🌈路线参考： Day1：抵达乌鲁木齐--自由活动--住乌鲁木齐 Day2：乌鲁木齐--赛里木湖--赛里木湖帆船--住赛里木湖 Day3：赛里木湖日出+环湖自驾--果子沟大桥--琼库什台村--住琼库什台 Day4：琼库什台--恰西草原--住巩留/新源 Day5：巩留/新源--那拉提草原--住那拉提 Day6：那拉提--独库公路--独库公路下午茶--住乌鲁木齐 Day7：乌鲁木齐--返程</span></p>', 'http://localhost:9091/files/download/1732221623312-lx1.webp', NULL, NULL, NULL);
INSERT INTO `routes` VALUES (13, '拉萨', 60, '带好氧气瓶', '<p>我们一起去拉萨 具体的路线图 在下面</p><p><img src=\"http://localhost:9091/files/download/1732221734562-lx4.webp\" alt=\"\" data-href=\"\" style=\"\"/></p>', 'http://localhost:9091/files/download/1732221711232-lx4.webp', '拉萨', NULL, NULL);

-- ----------------------------
-- Table structure for travels
-- ----------------------------
DROP TABLE IF EXISTS `travels`;
CREATE TABLE `travels`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标题',
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '封面',
  `descr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '简介',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '内容',
  `user_id` int NULL DEFAULT NULL COMMENT '发布人',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '发布时间',
  `read_count` int NULL DEFAULT NULL COMMENT '阅读量',
  `start_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '出行日期',
  `money` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '费用',
  `days` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '出行时长',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '出行地点',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '审核状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '游记信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of travels
-- ----------------------------
INSERT INTO `travels` VALUES (1, 'zheshi', NULL, 'sadfsdaf', 'adsfasdfmmmmmmmmmmmmmm', NULL, '', NULL, NULL, NULL, NULL, NULL, '拒绝');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像',
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
