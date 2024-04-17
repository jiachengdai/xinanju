-- MySQL dump 10.13  Distrib 8.1.0, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: old_care
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `article_id` mediumint unsigned NOT NULL AUTO_INCREMENT COMMENT '文章id：[0,8388607]',
  `title` varchar(125) NOT NULL DEFAULT '' COMMENT '标题：[0,125]用于文章和html的title标签中',
  `type` varchar(64) NOT NULL DEFAULT '0' COMMENT '文章分类：[0,1000]用来搜索指定类型的文章',
  `hits` int unsigned NOT NULL DEFAULT '0' COMMENT '点击数：[0,1000000000]访问这篇文章的人次',
  `praise_len` int NOT NULL DEFAULT '0' COMMENT '点赞数',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间：',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间：',
  `source` varchar(255) DEFAULT NULL COMMENT '来源：[0,255]文章的出处',
  `url` varchar(255) DEFAULT NULL COMMENT '来源地址：[0,255]用于跳转到发布该文章的网站',
  `tag` varchar(255) DEFAULT NULL COMMENT '标签：[0,255]用于标注文章所属相关内容，多个标签用空格隔开',
  `content` longtext COMMENT '正文：文章的主体内容',
  `img` varchar(255) DEFAULT NULL COMMENT '封面图',
  `description` text COMMENT '文章描述',
  PRIMARY KEY (`article_id`,`title`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='文章：用于内容管理系统的文章';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (16,'热力十足！从清明小长假看“春日经济”的打开方式','经济',0,0,'2024-04-07 08:19:08','2024-04-07 08:19:08','新华网','http://www.news.cn/fortune/20240407/1079633c77524b23808460bf905fb50c/c.html','旅游；经济','文化和旅游部4月6日数据显示，今年清明节假期，人们出游热情持续高涨。全国国内旅游出游1.19亿人次，按可比口径较2019年同期增长11.5%；国内游客出游花费539.5亿元，较2019年同期增长12.7%。','http://big-event0713.oss-cn-shanghai.aliyuncs.com/4bf223da-d0bc-4118-9684-f7e2957a4858.jpeg',''),(17,'乡村新“茶道”丨文化润茶，“中国茶业百强县第一名”的新风景','时政',0,0,'2024-04-07 08:20:35','2024-04-07 08:20:35','新华网','http://www.news.cn/politics/20240407/87196a76709a4538a413bcefe50f1d78/c.html','经济',' 新华社贵阳4月7日电（记者汪军、李凡）“旧说天下山,半在黔中青。”唐代诗人孟郊在《赠黔府王中丞楚》一诗中，如此赞叹贵州青山。对于这“青”色，“茶青”功不可没。','http://big-event0713.oss-cn-shanghai.aliyuncs.com/3e18e5f7-46b9-49fb-9652-2186589a45f0.jpg',''),(18,'南水滋润十年 南北协作双赢','时政',0,0,'2024-04-07 08:21:54','2024-04-07 08:21:54','新华网','http://www.news.cn/politics/20240407/87196a76709a4538a413bcefe50f1d78/c.html','','　　2014年12月12日，河南南阳陶岔渠首大闸开启，蓄势已久的南水奔涌而出，标志着南水北调中线一期工程全线建成通水。半个月后，汉江水流至北京。  　　通水近十年，南水北调入京水量超96亿立方米，本市直接受益人口超过1500万。以水结缘，北京与水源区结对协作取得实效。截至目前，本市共安排资金50亿元，实施项目1177个，助力河南、湖北水源区16县市区生态环境改善，推动绿色生态产业发展，基本形成','http://big-event0713.oss-cn-shanghai.aliyuncs.com/e603ed87-3b40-4966-9bcd-72a110464402.jpg','');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_type`
--

DROP TABLE IF EXISTS `article_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_type` (
  `type_id` smallint unsigned NOT NULL AUTO_INCREMENT COMMENT '分类ID：[0,10000]',
  `display` smallint unsigned NOT NULL DEFAULT '100' COMMENT '显示顺序：[0,1000]决定分类显示的先后顺序',
  `name` varchar(16) NOT NULL DEFAULT '' COMMENT '分类名称：[2,16]',
  `father_id` smallint unsigned NOT NULL DEFAULT '0' COMMENT '上级分类ID：[0,32767]',
  `description` varchar(255) DEFAULT NULL COMMENT '描述：[0,255]描述该分类的作用',
  `icon` text COMMENT '分类图标：',
  `url` varchar(255) DEFAULT NULL COMMENT '外链地址：[0,255]如果该分类是跳转到其他网站的情况下，就在该URL上设置',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间：',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间：',
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='文章频道：用于汇总浏览文章，在不同频道下展示不同文章。';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_type`
--

LOCK TABLES `article_type` WRITE;
/*!40000 ALTER TABLE `article_type` DISABLE KEYS */;
INSERT INTO `article_type` VALUES (3,100,'科技',0,'关于科技的文章','http://example.com/tech-icon.png','http://example.com/tech-articles','2024-03-30 05:34:13','2024-03-30 05:34:13');
/*!40000 ALTER TABLE `article_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collect`
--

DROP TABLE IF EXISTS `collect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `collect` (
  `collect_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '收藏ID：',
  `user_id` int unsigned NOT NULL DEFAULT '0' COMMENT '收藏人ID：',
  `source_table` varchar(255) DEFAULT NULL COMMENT '来源表：',
  `source_field` varchar(255) DEFAULT NULL COMMENT '来源字段：',
  `source_id` int unsigned NOT NULL DEFAULT '0' COMMENT '来源ID：',
  `title` varchar(255) DEFAULT NULL COMMENT '标题：',
  `img` varchar(255) DEFAULT NULL COMMENT '封面：',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间：',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间：',
  PRIMARY KEY (`collect_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='收藏：';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collect`
--

LOCK TABLES `collect` WRITE;
/*!40000 ALTER TABLE `collect` DISABLE KEYS */;
/*!40000 ALTER TABLE `collect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `comment_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '评论ID：',
  `user_id` int unsigned NOT NULL DEFAULT '0' COMMENT '评论人ID：',
  `reply_to_id` int unsigned NOT NULL DEFAULT '0' COMMENT '回复评论ID：空为0',
  `content` longtext COMMENT '内容：',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称：',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像地址：[0,255]',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间：',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间：',
  `source_table` varchar(255) DEFAULT NULL COMMENT '来源表：',
  `source_field` varchar(255) DEFAULT NULL COMMENT '来源字段：',
  `source_id` int unsigned NOT NULL DEFAULT '0' COMMENT '来源ID：',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='评论：';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (5,1,0,'这是一条评论。','NULL',NULL,'2024-03-30 05:34:31','2024-03-30 05:34:31','forum','forum_id',56),(3,10,0,'这是一条评论。','asdmin','http://www.baidu.com','2024-03-20 13:37:37','2024-03-20 13:37:37','forum','forum_id',56),(4,1,0,'这是一条评论。','NULL',NULL,'2024-03-30 03:31:47','2024-03-30 03:31:47','forum','forum_id',56);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `competency_assessment`
--

DROP TABLE IF EXISTS `competency_assessment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `competency_assessment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '类型',
  `count` int DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COMMENT='能力评估表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `competency_assessment`
--

LOCK TABLES `competency_assessment` WRITE;
/*!40000 ALTER TABLE `competency_assessment` DISABLE KEYS */;
INSERT INTO `competency_assessment` VALUES (1,'能力完好或轻度失能',121,'2024-04-06 14:04:55'),(2,'中度失能',423,'2024-04-08 19:20:20'),(3,'重度失能',89,'2024-04-08 19:20:22'),(4,'总和',634,'2024-04-08 19:20:22');
/*!40000 ALTER TABLE `competency_assessment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drug_management`
--

DROP TABLE IF EXISTS `drug_management`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drug_management` (
  `drug_management_id` int NOT NULL AUTO_INCREMENT COMMENT '药品管理ID',
  `drug_no` varchar(64) DEFAULT NULL COMMENT '药品编号',
  `drug_name` varchar(64) DEFAULT NULL COMMENT '药品名称',
  `picture` varchar(255) DEFAULT NULL COMMENT '图片',
  `effect` varchar(64) DEFAULT NULL COMMENT '功效',
  `price` int DEFAULT '0' COMMENT '价格',
  `inventory_quantity` int DEFAULT '0' COMMENT '库存数量',
  `remarks` varchar(64) DEFAULT NULL COMMENT '备注',
  `recommend` int NOT NULL DEFAULT '0' COMMENT '智能推荐',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`drug_management_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COMMENT='药品管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drug_management`
--

LOCK TABLES `drug_management` WRITE;
/*!40000 ALTER TABLE `drug_management` DISABLE KEYS */;
INSERT INTO `drug_management` VALUES (3,'药品编号3','药品名称3','/api/upload/1563709236850982912.jpg','功效3',3,3,'备注3',0,'2024-04-13 12:06:28','2024-04-13 04:06:22'),(4,'药品编号4','药品名称4','/api/upload/1563709763286466560.jpg','功效4',4,4,'备注4s',0,'2024-04-13 12:06:28','2024-04-13 04:06:23'),(6,'药品编号6','药品名称6','/api/upload/1563707705934217217.jpg','功效6',6,6,'备注6',0,'2024-04-13 12:06:30','2024-04-13 04:06:24'),(7,'药品编号7','药品名称7','','功效7',7,7,'备注7',0,'2024-04-13 12:06:31','2024-04-13 04:06:25'),(8,'药品编号8','药品名称8','','功效8',8,8,'备注8',0,'2024-04-13 12:06:31','2024-04-13 04:06:26'),(9,NULL,'sdaf',NULL,'ssss',123,123,'ssss',0,'2024-04-14 11:22:32','2024-04-14 03:22:32'),(10,NULL,'sfa',NULL,'dadf',121,123,'adfa',0,'2024-04-14 11:23:50','2024-04-14 03:23:50');
/*!40000 ALTER TABLE `drug_management` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elderly_type`
--

DROP TABLE IF EXISTS `elderly_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `elderly_type` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '类型',
  `count` int DEFAULT NULL COMMENT '数量',
  `date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COMMENT='老人类型统计表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elderly_type`
--

LOCK TABLES `elderly_type` WRITE;
/*!40000 ALTER TABLE `elderly_type` DISABLE KEYS */;
INSERT INTO `elderly_type` VALUES (1,'低保老人',754,'2024-04-08 19:18:29'),(2,'离休干部',642,'2024-04-08 19:18:43'),(3,'失能老人',522,'2024-04-08 19:19:29'),(4,'失独老人',421,'2024-04-08 19:19:28'),(5,'高龄老人',313,'2024-04-08 19:19:31'),(6,'普通老人',168,'2024-04-08 19:19:30');
/*!40000 ALTER TABLE `elderly_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `family_members`
--

DROP TABLE IF EXISTS `family_members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `family_members` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '家属ID',
  `family_number` varchar(64) NOT NULL COMMENT '家属编号',
  `full_name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(64) DEFAULT NULL COMMENT '性别',
  `user_id` bigint DEFAULT '0' COMMENT '用户ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `the_elderly_id` int DEFAULT NULL COMMENT '对应老人的编号',
  `phone_number` varchar(32) NOT NULL COMMENT '手机号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `family_members_phone_number_uindex` (`phone_number`),
  UNIQUE KEY `family_number` (`family_number`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COMMENT='家属';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `family_members`
--

LOCK TABLES `family_members` WRITE;
/*!40000 ALTER TABLE `family_members` DISABLE KEYS */;
INSERT INTO `family_members` VALUES (1,'12','法大大1','1',0,'2024-04-06 15:25:49','2024-04-06 07:35:43',1,'12222222222'),(2,'fafafafa','二分法','',44,'2024-04-06 16:04:10','2024-04-06 08:04:10',NULL,'13230302223'),(5,'fadf','adfaf','',47,'2024-04-06 16:07:38','2024-04-06 08:07:38',NULL,'fadfaf'),(7,'fadfafadf','asdfafa','',54,'2024-04-06 16:13:53','2024-04-06 08:13:53',NULL,'1323232323'),(8,'fff','1212','',55,'2024-04-06 16:14:53','2024-04-06 08:14:53',NULL,'121212'),(9,'faadfaf','1212fa','',56,'2024-04-06 16:15:21','2024-04-06 08:15:21',NULL,'13023111919'),(10,'fafa','adfaf','',57,'2024-04-06 16:15:40','2024-04-06 08:15:40',NULL,'adfaf');
/*!40000 ALTER TABLE `family_members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `family_needs`
--

DROP TABLE IF EXISTS `family_needs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `family_needs` (
  `family_needs_id` int NOT NULL AUTO_INCREMENT COMMENT '家属需求ID',
  `family_number` int DEFAULT '0' COMMENT '家属编号',
  `full_name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `title` varchar(64) DEFAULT NULL COMMENT '标题',
  `details` text COMMENT '详情',
  `submission_time` date DEFAULT NULL COMMENT '提交时间',
  `remarks` varchar(64) DEFAULT NULL COMMENT '备注',
  `examine_state` varchar(16) NOT NULL DEFAULT '未审核' COMMENT '审核状态',
  `examine_reply` varchar(16) DEFAULT '' COMMENT '审核回复',
  `recommend` int NOT NULL DEFAULT '0' COMMENT '智能推荐',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`family_needs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COMMENT='家属需求';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `family_needs`
--

LOCK TABLES `family_needs` WRITE;
/*!40000 ALTER TABLE `family_needs` DISABLE KEYS */;
INSERT INTO `family_needs` VALUES (1,0,'姓名1','标题1','此处可上传文字、图片、视频、超链接、表格等内容区1','2022-11-10','备注1','未审核','afafa',0,'2024-04-13 12:05:01','2024-04-14 05:55:57'),(2,0,'姓名2','标题2','此处可上传文字、图片、视频、超链接、表格等内容区2','2022-11-10','备注2','未审核','dfa',0,'2024-04-13 12:05:02','2024-04-14 05:55:57'),(3,0,'姓名3','标题3','此处可上传文字、图片、视频、超链接、表格等内容区3','2022-11-10','备注3','未审核','fafaf',0,'2024-04-13 12:05:03','2024-04-14 05:55:57'),(4,0,'姓名4','标题4','此处可上传文字、图片、视频、超链接、表格等内容区4','2022-11-10','备注4','未审核','af',0,'2024-04-13 12:05:04','2024-04-14 05:55:57'),(5,0,'姓名5','标题5','此处可上传文字、图片、视频、超链接、表格等内容区5','2022-11-10','备注5','未审核','afdaf',0,'2024-04-13 12:05:06','2024-04-14 05:55:57'),(6,0,'姓名6','标题6','此处可上传文字、图片、视频、超链接、表格等内容区6','2022-11-10','备注6','未审核','faf',0,'2024-04-13 12:05:05','2024-04-14 05:55:57'),(7,0,'姓名7','标题7','此处可上传文字、图片、视频、超链接、表格等内容区7','2022-11-10','备注7','未审核','adfaf',0,'2024-04-13 12:05:07','2024-04-14 05:55:57'),(8,0,'姓名8','标题8','此处可上传文字、图片、视频、超链接、表格等内容区8','2022-11-10','备注8','未审核','fafd',0,'2024-04-13 12:05:08','2024-04-14 05:55:57'),(9,0,'发的发',NULL,'大幅度发',NULL,'打发放大','未审核','',0,'2024-04-14 14:00:12','2024-04-14 06:00:12');
/*!40000 ALTER TABLE `family_needs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum`
--

DROP TABLE IF EXISTS `forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forum` (
  `forum_id` mediumint unsigned NOT NULL AUTO_INCREMENT COMMENT '论坛id',
  `display` smallint unsigned NOT NULL DEFAULT '100' COMMENT '排序',
  `user_id` mediumint unsigned NOT NULL DEFAULT '0' COMMENT '用户ID',
  `nickname` varchar(16) DEFAULT '' COMMENT '昵称：[0,16]',
  `praise_len` int DEFAULT '0' COMMENT '点赞数',
  `hits` int unsigned NOT NULL DEFAULT '0' COMMENT '访问数',
  `title` varchar(125) NOT NULL DEFAULT '' COMMENT '标题',
  `keywords` varchar(125) DEFAULT NULL COMMENT '关键词',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `url` varchar(255) DEFAULT NULL COMMENT '来源地址',
  `tag` varchar(255) DEFAULT NULL COMMENT '标签',
  `img` text COMMENT '封面图',
  `content` longtext COMMENT '正文',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间：',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间：',
  `avatar` varchar(255) DEFAULT NULL COMMENT '发帖人头像：',
  `type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '论坛分类：[0,1000]用来搜索指定类型的论坛帖',
  PRIMARY KEY (`forum_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='论坛：';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum`
--

LOCK TABLES `forum` WRITE;
/*!40000 ALTER TABLE `forum` DISABLE KEYS */;
INSERT INTO `forum` VALUES (22,1,123,'赵胜利',0,0,'晚饭怎么吃更健康',NULL,'晚饭怎么吃更健康',NULL,NULL,'http://big-event0713.oss-cn-shanghai.aliyuncs.com/c4a1dc23-9de1-4b63-98dc-065a65a38736.jpg','大家晚饭都是怎么吃的，怎么搭配更健康','2024-04-07 09:16:01','2024-04-07 09:25:09',NULL,'讨论'),(23,1,123,'赵胜利',0,0,'如何防治高血压',NULL,'如何防治高血压',NULL,NULL,'http://big-event0713.oss-cn-shanghai.aliyuncs.com/e58c62c3-d400-4602-bed3-a998c9d9f602.jpg','怎么才能预防高血压','2024-04-07 09:17:34','2024-04-07 09:25:09',NULL,'讨论'),(24,1,123,'赵胜利',NULL,0,'如何防治高血压',NULL,'如何防治高血压',NULL,NULL,'http://big-event0713.oss-cn-shanghai.aliyuncs.com/d172a688-3fba-4783-9811-21e2b926181e.png','怎么才能预防糖尿病','2024-04-07 09:20:38','2024-04-07 09:25:09',NULL,''),(25,1,123,'赵胜利',0,0,'如何预防腰间盘突出',NULL,NULL,NULL,NULL,'http://big-event0713.oss-cn-shanghai.aliyuncs.com/029b6db9-21b4-4a90-8eeb-20f12fa0d428.png','怎么才能预防呢','2024-04-07 09:23:12','2024-04-07 09:23:12',NULL,''),(20,1,123,NULL,1,0,'早餐怎么吃更健康',' ','早餐怎么吃更健康',NULL,NULL,'http://big-event0713.oss-cn-shanghai.aliyuncs.com/dd2d62e5-b8f4-4d9d-9d64-80d0857a1f76.png','大家的早餐都吃什么，怎么搭配更健康','2024-04-07 09:10:50','2024-04-07 09:25:14',NULL,'讨论'),(21,1,123,'赵胜利',0,0,'午饭怎么吃更健康',NULL,'午饭怎么吃更健康',NULL,NULL,'http://big-event0713.oss-cn-shanghai.aliyuncs.com/9f3854ca-4ef6-47ea-9aa9-7efbeffc4b45.jpg','大家午饭都是怎么吃的，如何搭配更营养','2024-04-07 09:14:30','2024-04-07 09:25:09',NULL,'讨论');
/*!40000 ALTER TABLE `forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum_type`
--

DROP TABLE IF EXISTS `forum_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forum_type` (
  `type_id` smallint unsigned NOT NULL AUTO_INCREMENT COMMENT '分类ID：[0,10000]',
  `name` varchar(16) NOT NULL DEFAULT '' COMMENT '分类名称：[2,16]',
  `description` varchar(255) DEFAULT NULL COMMENT '描述：[0,255]描述该分类的作用',
  `url` varchar(255) DEFAULT NULL COMMENT '外链地址：[0,255]如果该分类是跳转到其他网站的情况下，就在该URL上设置',
  `father_id` smallint unsigned NOT NULL DEFAULT '0' COMMENT '上级分类ID：[0,32767]',
  `icon` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '分类图标：',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间：',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间：',
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='论坛频道：用于汇总浏览论坛，在不同频道下展示不同论坛。';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum_type`
--

LOCK TABLES `forum_type` WRITE;
/*!40000 ALTER TABLE `forum_type` DISABLE KEYS */;
INSERT INTO `forum_type` VALUES (1,'分类一','分类一','/article/list?type_id=1',0,NULL,'2022-12-01 14:56:32','2022-12-31 07:17:02'),(2,'分类二','分类二','/article/list?type_id=2',0,NULL,'2022-12-01 14:56:32','2022-12-31 07:17:08'),(3,'分类三','分类三','/article/list?type_id=3',0,NULL,'2022-12-01 14:56:32','2022-12-31 07:17:19');
/*!40000 ALTER TABLE `forum_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `health_records`
--

DROP TABLE IF EXISTS `health_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `health_records` (
  `health_records_id` int NOT NULL AUTO_INCREMENT COMMENT '健康记录ID',
  `nurse_no` varchar(64) DEFAULT '0' COMMENT '护工编号',
  `senior_citizen_number` varchar(64) DEFAULT '0' COMMENT '老人编号',
  `name_of_the_elderly` varchar(64) DEFAULT NULL COMMENT '老人姓名',
  `age` int DEFAULT '0' COMMENT '年龄',
  `weight` varchar(64) DEFAULT NULL COMMENT '体重',
  `blood_pressure` varchar(64) DEFAULT NULL COMMENT '血压',
  `pulse` varchar(64) DEFAULT NULL COMMENT '脉搏',
  `temperature` varchar(64) DEFAULT NULL COMMENT '体温',
  `record_time` date DEFAULT NULL COMMENT '记录时间',
  `health` varchar(64) DEFAULT NULL COMMENT '健康状况',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`health_records_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='健康记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `health_records`
--

LOCK TABLES `health_records` WRITE;
/*!40000 ALTER TABLE `health_records` DISABLE KEYS */;
INSERT INTO `health_records` VALUES (1,'1','71','赵胜利',89,'1111','300pa','63次/分钟','37°C','2024-04-14','良好','2024-04-14 13:07:06','2024-04-14 08:24:29');
/*!40000 ALTER TABLE `health_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hits`
--

DROP TABLE IF EXISTS `hits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hits` (
  `hits_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '点赞ID：',
  `user_id` int unsigned NOT NULL DEFAULT '0' COMMENT '点赞人：',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间：',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间：',
  `source_table` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '来源表：',
  `source_field` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '来源字段：',
  `source_id` int unsigned NOT NULL DEFAULT '0' COMMENT '来源ID：',
  PRIMARY KEY (`hits_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hits`
--

LOCK TABLES `hits` WRITE;
/*!40000 ALTER TABLE `hits` DISABLE KEYS */;
INSERT INTO `hits` VALUES (1,10,'2024-03-14 08:37:21','2024-03-14 08:37:21','articles','article_id',456),(2,10,'2024-03-14 09:03:07','2024-03-14 09:03:07','article','article_id',2),(3,10,'2024-03-14 10:09:32','2024-03-14 10:09:32','forum','forum_id',2),(4,10,'2024-03-14 10:12:21','2024-03-14 10:12:21','forum','forum_id',2),(5,10,'2024-03-14 14:07:02','2024-03-14 14:07:02','forum','forum_id',2),(6,10,'2024-03-14 14:07:56','2024-03-14 14:07:56','forum','forum_id',2),(7,10,'2024-03-14 14:09:27','2024-03-14 14:09:27','forum','forum_id',2),(8,10,'2024-03-14 14:10:16','2024-03-14 14:10:16','forum','forum_id',2),(9,10,'2024-03-14 14:11:00','2024-03-14 14:11:00','forum','forum_id',2),(10,10,'2024-03-14 14:11:07','2024-03-14 14:11:07','forum','forum_id',2),(11,10,'2024-03-14 14:11:33','2024-03-14 14:11:33','forum','forum_id',3),(12,10,'2024-03-14 14:11:44','2024-03-14 14:11:44','forum','forum_id',4),(13,10,'2024-03-14 14:13:18','2024-03-14 14:13:18','forum','forum_id',4),(14,10,'2024-03-14 14:14:46','2024-03-14 14:14:46','article','article_id',2),(15,10,'2024-03-14 14:18:18','2024-03-14 14:18:18','article','article_id',2),(16,10,'2024-03-14 14:21:45','2024-03-14 14:21:45','article','article_id',2),(17,10,'2024-03-14 14:21:46','2024-03-14 14:21:46','article','article_id',2),(18,10,'2024-03-14 14:21:47','2024-03-14 14:21:47','article','article_id',2),(19,10,'2024-03-14 14:21:48','2024-03-14 14:21:48','article','article_id',2),(20,10,'2024-03-14 14:21:58','2024-03-14 14:21:58','forum','forum_id',4),(21,10,'2024-03-14 14:22:05','2024-03-14 14:22:05','forum','forum_id',4),(22,10,'2024-03-14 14:22:15','2024-03-14 14:22:15','forum','forum_id',4),(23,10,'2024-03-14 14:22:17','2024-03-14 14:22:17','forum','forum_id',4),(24,10,'2024-03-20 13:38:30','2024-03-20 13:38:30','forum','forum_id',4),(25,1,'2024-03-30 03:17:43','2024-03-30 03:17:43','article','article_id',2),(26,1,'2024-03-30 03:26:29','2024-03-30 03:26:29','article','article_id',2),(27,1,'2024-03-30 03:33:51','2024-03-30 03:33:51','forum','forum_id',4),(28,1,'2024-03-30 04:49:34','2024-03-30 04:49:34','article','article_id',2),(29,1,'2024-03-30 04:49:44','2024-03-30 04:49:44','article','article_id',2),(30,1,'2024-03-30 04:49:56','2024-03-30 04:49:56','article','article_id',3),(31,1,'2024-03-30 05:17:23','2024-03-30 05:17:23','article','article_id',3),(32,1,'2024-03-30 05:19:27','2024-03-30 05:19:27','article','article_id',3),(33,1,'2024-03-30 05:34:00','2024-03-30 05:34:00','article','article_id',3),(34,1,'2024-03-30 05:35:30','2024-03-30 05:35:30','forum','forum_id',4),(35,1,'2024-03-30 05:37:52','2024-03-30 05:37:52','article','article_id',3),(36,1,'2024-03-30 05:41:39','2024-03-30 05:41:39','forum','forum_id',4),(37,1,'2024-03-30 05:47:08','2024-03-30 05:47:08','forum','forum_id',4),(38,1,'2024-04-02 05:34:02','2024-04-02 05:34:02','forum','forum_id',4);
/*!40000 ALTER TABLE `hits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `needs_of_the_elderly`
--

DROP TABLE IF EXISTS `needs_of_the_elderly`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `needs_of_the_elderly` (
  `needs_of_the_elderly_id` int NOT NULL AUTO_INCREMENT COMMENT '老人需求ID',
  `senior_citizen_number` int DEFAULT '0' COMMENT '老人编号',
  `full_name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `need_id` int DEFAULT NULL COMMENT '需求id',
  `details` text COMMENT '详情',
  `submission_time` date DEFAULT NULL COMMENT '提交时间',
  `remarks` varchar(64) DEFAULT NULL COMMENT '备注',
  `examine_state` varchar(16) NOT NULL DEFAULT '未审核' COMMENT '审核状态',
  `examine_reply` varchar(16) DEFAULT '' COMMENT '审核回复',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`needs_of_the_elderly_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COMMENT='老人需求';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `needs_of_the_elderly`
--

LOCK TABLES `needs_of_the_elderly` WRITE;
/*!40000 ALTER TABLE `needs_of_the_elderly` DISABLE KEYS */;
INSERT INTO `needs_of_the_elderly` VALUES (1,1,'zhangsna',1,'打分','2024-04-06',NULL,'未审核','dafafa','2024-04-06 21:46:04','2024-04-14 05:53:26'),(2,2,'李四',2,'啊发发发',NULL,NULL,'未审核','fadfaf','2024-04-14 13:32:30','2024-04-14 05:53:26'),(3,0,'afdafafd',NULL,'afafafd',NULL,'adfafaf','未审核','adfaf','2024-04-14 13:41:41','2024-04-14 05:53:26'),(4,0,'dlajf',1,NULL,NULL,'1','未审核','','2024-04-14 14:32:16','2024-04-14 06:32:16'),(5,0,'啊啊啊',3,NULL,NULL,'阿打发','未审核','','2024-04-14 15:03:48','2024-04-14 07:03:48'),(6,0,'',6,NULL,NULL,'dadad','未审核','','2024-04-14 16:32:19','2024-04-14 08:32:19'),(7,0,'',1,NULL,NULL,'a','未审核','','2024-04-15 20:13:24','2024-04-15 12:13:24'),(8,0,'',1,NULL,NULL,'福达坊','未审核','','2024-04-15 21:52:46','2024-04-15 13:52:46'),(9,0,'',6,NULL,NULL,'想','未审核','','2024-04-16 17:15:03','2024-04-16 09:15:03'),(10,0,'',6,NULL,NULL,'是','未审核','','2024-04-16 17:15:14','2024-04-16 09:15:14'),(11,0,'',5,NULL,NULL,'是','未审核','','2024-04-16 17:36:38','2024-04-16 09:36:38');
/*!40000 ALTER TABLE `needs_of_the_elderly` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice` (
  `notice_id` mediumint unsigned NOT NULL AUTO_INCREMENT COMMENT '公告id：',
  `title` varchar(125) NOT NULL DEFAULT '' COMMENT '标题：',
  `content` longtext COMMENT '正文：',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间：',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间：',
  PRIMARY KEY (`notice_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COMMENT='公告：';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (7,'XX养老院人员信息公示','XX养老院人员信息公示','2024-04-16 08:29:56','2024-04-16 08:29:56'),(6,'XX养老院3月份菜品公示','XX养老院3月份菜品','2024-04-15 14:39:24','2024-04-15 14:39:24'),(8,'XX养老院导航信息一览','','2024-04-16 08:33:53','2024-04-16 08:33:53'),(9,'XX养老院停电通知','通知：1022房间因故修整停电，送电时间另行通知','2024-04-16 10:53:51','2024-04-16 10:53:51');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nursing_workers`
--

DROP TABLE IF EXISTS `nursing_workers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nursing_workers` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '护工ID',
  `nurse_no` varchar(64) NOT NULL COMMENT '护工编号',
  `full_name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(64) DEFAULT NULL COMMENT '性别',
  `user_id` bigint DEFAULT '0' COMMENT '用户ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nurse_no` (`nurse_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COMMENT='护工';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nursing_workers`
--

LOCK TABLES `nursing_workers` WRITE;
/*!40000 ALTER TABLE `nursing_workers` DISABLE KEYS */;
INSERT INTO `nursing_workers` VALUES (1,'1','小李s','1',0,'2024-04-06 16:51:30','2024-04-06 08:51:32');
/*!40000 ALTER TABLE `nursing_workers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `praise`
--

DROP TABLE IF EXISTS `praise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `praise` (
  `praise_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '点赞ID：',
  `user_id` int unsigned NOT NULL DEFAULT '0' COMMENT '点赞人：',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间：',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间：',
  `source_table` varchar(255) DEFAULT NULL COMMENT '来源表：',
  `source_field` varchar(255) DEFAULT NULL COMMENT '来源字段：',
  `source_id` int unsigned NOT NULL DEFAULT '0' COMMENT '来源ID：',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '点赞状态:1为点赞，0已取消',
  PRIMARY KEY (`praise_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='点赞：';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `praise`
--

LOCK TABLES `praise` WRITE;
/*!40000 ALTER TABLE `praise` DISABLE KEYS */;
INSERT INTO `praise` VALUES (1,10,'2024-03-14 10:42:55','2024-03-14 14:04:44','article','article_id',2,1),(4,10,'2024-03-14 13:26:06','2024-03-14 13:51:53','forum','forum_id',3,0),(3,10,'2024-03-14 10:47:58','2024-03-14 14:22:02','forum','forum_id',2,1),(5,10,'2024-03-14 13:52:27','2024-03-20 13:41:23','forum','forum_id',4,1),(6,10,'2024-03-14 13:52:38','2024-03-14 13:52:38','forum','forum_id',5,1),(7,10,'2024-03-14 13:52:49','2024-03-14 13:52:49','forum','forum_id',9,1),(8,10,'2024-03-14 14:04:27','2024-03-14 14:04:37','article','article_id',3,0),(9,1,'2024-03-30 03:32:22','2024-03-30 03:32:41','forum','forum_id',4,0),(10,1,'2024-03-30 03:33:01','2024-03-30 03:33:16','article','article_id',4,1),(11,1,'2024-03-30 03:33:23','2024-03-30 05:41:02','article','article_id',3,1);
/*!40000 ALTER TABLE `praise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `enable` tinyint(1) DEFAULT '1' COMMENT '是否启用',
  `del_flag` int DEFAULT '0' COMMENT 'del_flag',
  `create_by` bigint DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN',1,0,NULL,NULL,NULL,NULL,NULL),(2,'THEELDLY',1,0,NULL,NULL,NULL,NULL,NULL),(3,'FAMILY',1,0,NULL,NULL,NULL,NULL,NULL),(4,'NURSE',1,0,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary_of_nursing_workers`
--

DROP TABLE IF EXISTS `salary_of_nursing_workers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary_of_nursing_workers` (
  `salary_of_nursing_workers_id` int NOT NULL AUTO_INCREMENT COMMENT '护工工资ID',
  `nurse_no` int DEFAULT '0' COMMENT '护工编号',
  `full_name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `month` varchar(64) DEFAULT NULL COMMENT '月份',
  `base_pay` int DEFAULT '0' COMMENT '基本工资',
  `bonus` int DEFAULT '0' COMMENT '奖金',
  `subsidy` int DEFAULT '0' COMMENT '补贴',
  `total` varchar(64) DEFAULT NULL COMMENT '合计',
  `remarks` varchar(64) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`salary_of_nursing_workers_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COMMENT='护工工资';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_of_nursing_workers`
--

LOCK TABLES `salary_of_nursing_workers` WRITE;
/*!40000 ALTER TABLE `salary_of_nursing_workers` DISABLE KEYS */;
INSERT INTO `salary_of_nursing_workers` VALUES (1,0,'姓名1','月份1',1,1,1,'合计1','备注1','2024-04-13 12:02:53','2024-04-13 04:03:06'),(2,0,'姓名2','月份2',2,2,2,'合计2','备注2','2024-04-13 12:03:22','2024-04-13 04:03:12'),(3,0,'姓名3','月份3',3,3,3,'合计3','备注3','2024-04-13 12:03:27','2024-04-13 04:03:31'),(4,0,'姓名4','月份4',4,4,4,'合计4','备注4','2024-04-13 12:03:38','2024-04-13 04:03:35'),(5,0,'姓名5','月份5',5,5,5,'合计5','备注5','2024-04-13 12:03:41','2024-04-13 04:03:44'),(6,0,'姓名6','月份6',6,6,6,'合计6','备注6','2024-04-13 12:03:51','2024-04-13 04:03:47'),(7,0,'姓名7','月份7',7,7,7,'合计7','备注7','2024-04-13 12:03:53','2024-04-13 04:03:57'),(8,0,'姓名8','月份8',8,8,8,'合计8','备注8','2024-04-13 12:04:03','2024-04-13 04:04:06');
/*!40000 ALTER TABLE `salary_of_nursing_workers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_number`
--

DROP TABLE IF EXISTS `service_number`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_number` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '种类',
  `count` int DEFAULT NULL COMMENT '数量',
  `data` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COMMENT='服务工单数及满意度';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_number`
--

LOCK TABLES `service_number` WRITE;
/*!40000 ALTER TABLE `service_number` DISABLE KEYS */;
INSERT INTO `service_number` VALUES (1,'医疗护理',4135,'2024-04-08 19:21:28'),(2,'家政服务',62453,'2024-04-08 19:21:30'),(3,'法律维权',436,'2024-04-08 19:21:31'),(4,'老年教育',5342,'2024-04-08 19:21:32'),(5,'理发',64760,'2024-04-08 19:21:33'),(6,'康复训练',537,'2024-04-08 19:21:34');
/*!40000 ALTER TABLE `service_number` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slides`
--

DROP TABLE IF EXISTS `slides`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `slides` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '轮播图ID：',
  `title` varchar(64) DEFAULT NULL COMMENT '标题：',
  `content` varchar(255) DEFAULT NULL COMMENT '内容：',
  `url` varchar(255) DEFAULT NULL COMMENT '链接：',
  `tourl` varchar(255) DEFAULT NULL COMMENT '轮播图：',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slides`
--

LOCK TABLES `slides` WRITE;
/*!40000 ALTER TABLE `slides` DISABLE KEYS */;
INSERT INTO `slides` VALUES (6,'aa','aa','http://big-event0713.oss-cn-shanghai.aliyuncs.com/923a813a-e928-486f-9008-8afb968c5245.png','aa'),(8,'cc','cc','http://big-event0713.oss-cn-shanghai.aliyuncs.com/e8a08a40-6d7f-455e-ab67-55a6b5409a76.jpg','cc'),(9,'cccc','cccc','http://big-event0713.oss-cn-shanghai.aliyuncs.com/39883930-b5fd-4acd-b372-39f5c87d1cf5.jpeg','cc'),(10,'s','s','http://big-event0713.oss-cn-shanghai.aliyuncs.com/157ba4fb-9d6f-4bd0-9133-490d38b81d8c.jpg','s');
/*!40000 ALTER TABLE `slides` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `the_elderly`
--

DROP TABLE IF EXISTS `the_elderly`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `the_elderly` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '老人ID',
  `senior_citizen_number` varchar(64) NOT NULL COMMENT '老人编号',
  `full_name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(64) DEFAULT NULL COMMENT '性别',
  `family_members_id` int DEFAULT NULL COMMENT '家属id',
  `user_id` bigint DEFAULT '0' COMMENT '用户ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `phone_number` varchar(32) NOT NULL COMMENT '手机号',
  `bed_id` int NOT NULL,
  `dis_degree` int DEFAULT NULL COMMENT '失能评级',
  PRIMARY KEY (`id`),
  UNIQUE KEY `senior_citizen_number` (`senior_citizen_number`),
  UNIQUE KEY `the_elderly_bed_id_uindex` (`bed_id`),
  UNIQUE KEY `the_elderly_phone_number_uindex` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COMMENT='老人';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `the_elderly`
--

LOCK TABLES `the_elderly` WRITE;
/*!40000 ALTER TABLE `the_elderly` DISABLE KEYS */;
INSERT INTO `the_elderly` VALUES (10,'zhaozhoa','赵忠','',12,71,'2024-04-07 22:18:23','2024-04-07 14:18:23','12213131131',12,1),(13,'zhaoguoqing','赵国庆','',1,79,'2024-04-17 11:06:20','2024-04-17 03:06:20','13020301010',1,1),(14,'liufangyan','刘芳妍','',2,80,'2024-04-17 11:22:28','2024-04-17 03:22:28','13928281717',1001,1),(15,'liuqingguo','刘庆国','',3,82,'2024-04-17 11:26:45','2024-04-17 03:26:45','13928271618',2,1);
/*!40000 ALTER TABLE `the_elderly` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upload`
--

DROP TABLE IF EXISTS `upload`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `upload` (
  `upload_id` int NOT NULL AUTO_INCREMENT COMMENT '上传ID',
  `name` varchar(64) DEFAULT NULL COMMENT '文件名',
  `path` varchar(255) DEFAULT NULL COMMENT '访问路径',
  `file` varchar(255) DEFAULT NULL COMMENT '文件路径',
  `display` varchar(255) DEFAULT NULL COMMENT '显示顺序',
  `father_id` int DEFAULT '0' COMMENT '父级ID',
  `dir` varchar(255) DEFAULT NULL COMMENT '文件夹',
  `type` varchar(32) DEFAULT NULL COMMENT '文件类型',
  PRIMARY KEY (`upload_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upload`
--

LOCK TABLES `upload` WRITE;
/*!40000 ALTER TABLE `upload` DISABLE KEYS */;
INSERT INTO `upload` VALUES (1,'movie.mp4','/upload/movie.mp4','',NULL,0,NULL,'video');
/*!40000 ALTER TABLE `upload` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(64) NOT NULL DEFAULT 'NULL' COMMENT '用户名',
  `nick_name` varchar(64) NOT NULL DEFAULT 'NULL' COMMENT '昵称',
  `password` varchar(64) NOT NULL DEFAULT 'NULL' COMMENT '密码',
  `enable` tinyint(1) DEFAULT '1' COMMENT '用户是否启用',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `phonenumber` varchar(32) DEFAULT NULL COMMENT '手机号',
  `sex` char(1) DEFAULT NULL COMMENT '用户性别（0男，1女，2未知）',
  `avatar` varchar(128) DEFAULT NULL COMMENT '头像',
  `create_by` bigint DEFAULT NULL COMMENT '创建人的用户id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` int DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
  `role_id` bigint NOT NULL,
  `roles` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_user_name_uindex` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (18,'administor','代佳诚','$2a$10$CEzobb6eb8QvXI9qCNbvHeaBVk9NvO0KcUaW70WhV/1/IWx.tcJdG',1,'221310411@mail.dhu.edu.com','13023111691','0','http://big-event0713.oss-cn-shanghai.aliyuncs.com/b57ae31c-e48f-4d6e-801e-d08be66e757c.jpeg',NULL,NULL,NULL,'2024-04-06 23:47:57',0,1,'admin'),(71,'jiaxin','jaixinix','$2a$10$y.q0qbwQ8rJENpszDv7eSu.9RzRINCNrASOz.Usjw/UcXNVhoeWb.',1,NULL,NULL,'1',NULL,NULL,'2024-04-07 22:22:01',NULL,'2024-04-08 10:11:35',0,2,'editor'),(79,'zhaoguoqing','赵国庆','$2a$10$PLZ9q/rbwTpN6GbvhVB.Hu0kra13nQ6.Mn266xJKLCCJBMK9ZM4Ly',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,2,'editor'),(80,'liufangyan','刘芳妍','$2a$10$OUJvF4I0u0C3doZiGAwCj.70MRYxouDdBGBFlTN5UL7qDMfXexMj.',1,NULL,NULL,NULL,NULL,NULL,'2024-04-17 11:22:28',NULL,NULL,0,2,'editor'),(81,'superadmin','djcc','$2a$10$4HEDDoMHVDp6MBtExgw02OusN0L.3beHzqWPu1iEN5XdpoialEaqa',1,NULL,NULL,NULL,NULL,NULL,'2024-04-17 11:24:15',NULL,NULL,0,1,'admin'),(82,'liuqingguo','刘庆国','$2a$10$NSPuopJoV5a0bO0oTkWGMOooMUHyZvo03H0XUHN.aSEX6sNUFjwLG',1,NULL,NULL,NULL,NULL,NULL,'2024-04-17 11:26:45',NULL,NULL,0,2,'editor');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-17 16:02:17
