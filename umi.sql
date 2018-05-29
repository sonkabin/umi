-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: umi
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `content` text NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`article_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'MySQL字符集','2018-05-25 18:45:00','在MySQL客户端设置默认字符集\r\nmysql> charset utf8\r\n\r\n查看MySQL所有字符集\r\nshow character set [like \"utf%\"]；\r\n\r\n设置数据库编码\r\nCREATE DATABASE db_name\r\n    [[DEFAULT] CHARACTER SET charset_name]\r\n    [[DEFAULT] COLLATE collation_name]\r\n\r\nALTER DATABASE db_name\r\n    [[DEFAULT] CHARACTER SET charset_name]\r\n    [[DEFAULT] COLLATE collation_name]\r\n\r\n查看数据库编码\r\nUSE db_name;\r\nSELECT @@character_set_database, @@collation_database;\r\n\r\n设置表编码\r\nCREATE TABLE tbl_name (column_list)\r\n    [[DEFAULT] CHARACTER SET charset_name]\r\n    [COLLATE collation_name]]\r\n\r\nALTER TABLE tbl_name\r\n    [[DEFAULT] CHARACTER SET charset_name]\r\n    [COLLATE collation_name]\r\n\r\n设置列编码\r\nCREATE TABLE t1\r\n(\r\n    col1 VARCHAR(5)\r\n      [CHARACTER SET latin1]\r\n      [COLLATE latin1_german1_ci]\r\n);\r\n\r\nALTER TABLE t1 MODIFY\r\n    col1 VARCHAR(5)\r\n      [CHARACTER SET latin1]\r\n      [COLLATE latin1_swedish_ci];\r\n\r\n查看MySQL的整体字符设置\r\nSHOW VARIABLES LIKE \'character_set%\';\r\nSHOW VARIABLES LIKE \'collation%\';',1),(2,'Ubuntu eclipse dash启动','2018-05-29 15:52:42','切换到~/.local/share/applications/目录下\r\ncd ~/.local/share/applications/\r\n\r\n编辑文件\r\nvim eclipse.desktop\r\n\r\n将下列数据复制到其中\r\n[Desktop Entry]\r\nEncoding=UTF-8\r\nVersion=1.0\r\nType=Application\r\nName=eclipse \r\nIcon=/opt/devinstall/eclipse/icon.xpm\r\nPath=/opt/devinstall/eclipse\r\nExec=/opt/devinstall/eclipse/eclipse\r\nStartupNotify=false\r\nStartupWMClass=Eclipse\r\nOnlyShowIn=Unity;\r\nX-UnityGenerated=true\r\n\r\n完成',1),(3,'Java 自顶向下归并排序实现(int类型)','2018-05-29 15:58:53','如果算法能将两个子数组排序,那么它能够通过归并两个子数组来将整个数组排序。\r\n时间复杂度:NlogN,空间复杂度:N\r\n\r\n     public class MergeTD {\r\n	\r\n		public static void main(String[] args) {\r\n			int[] a = { 2, 10, 7, 4, 8, 5, 9, 0, 1, 3, 6 };\r\n			sort(a);\r\n			System.out.println(Arrays.toString(a));\r\n			a = new int[] {3,2,1,0};\r\n			sort(a);\r\n			System.out.println(Arrays.toString(a));\r\n		}\r\n	\r\n		public static void sort(int[] a) {\r\n			int[] aux = new int[a.length];\r\n			sort(a, 0, a.length - 1,aux);\r\n		}\r\n	\r\n		private static void sort(int[] a, int lo, int hi,int[] aux) {\r\n			if (hi <= lo)\r\n				return;\r\n			int mid = lo + (hi - lo) / 2;\r\n			sort(a, lo, mid,aux);//左边部分排序\r\n			sort(a, mid + 1, hi,aux);//右边部分排序\r\n			merge(a, lo, mid, hi,aux);//合并结果\r\n		}\r\n	\r\n		public static void merge(int[] a, int lo, int mid, int hi, int[] aux) {\r\n			int i = lo;//左指针\r\n			int j = mid + 1;//右指针\r\n			//复制数组\r\n			for (int k = lo; k <= hi; k++) {\r\n				aux[k] = a[k];\r\n			}\r\n			\r\n			for (int k = lo; k <= hi; k++) {\r\n				if (j > hi) {//右半边用尽\r\n					a[k] = aux[i++];\r\n				} else if (i > mid) {//左半边用尽\r\n					a[k] = aux[j++];\r\n				} else if (aux[i] < aux[j]) {//左半边元素小于右半边元素\r\n					a[k] = aux[i++];//取左半边\r\n				} else {//右半边元素小于左半边元素\r\n					a[k] = aux[j++];//取右半边\r\n				}\r\n			}\r\n		}\r\n	}\r\n\r\n改进:去掉merge方法中内循环判断某半边是否用尽的代码。即按降序将a[]中后半边按降序复制到辅助数组中,这样排序产生的结果是不稳定的。\r\n	public static void merge(int[] a, int lo, int mid, int hi, int[] aux) {\r\n		int i = lo;// 左指针\r\n		int j = hi;// 右指针\r\n		for (int k = lo; k <= mid; k++) {\r\n			aux[k] = a[k];\r\n		}\r\n\r\n		// 后半部分降序复制到辅助数组中\r\n		for (int k = mid + 1; k <= hi; k++) {\r\n			aux[hi - k + mid + 1] = a[k];\r\n		}\r\n		\r\n		for (int k = lo; k <= hi; k++) {\r\n			if (aux[i] < aux[j]) {\r\n				a[k] = aux[i++];\r\n			} else {\r\n				a[k] = aux[j--];\r\n			}\r\n		}\r\n	}',1),(4,'nginx访问静态文件404问题','2018-05-29 16:02:27','操作系统是Ubuntu16.04LST\r\n\r\n**初始配置**\r\n\r\n	server {\r\n         location /images/ {\r\n               root /home/username/picture;\r\n         }\r\n    }\r\n\r\n访问localhost，成功，然而，访问静态资源，出现404\r\nemmmmmm，修改要访问目录的权限，没用；修改nginx.conf配置文件的user为root，没用。\r\n经过多个小时的折磨，在**修改了listen不为默认的80端口**，成功解决。\r\n**修改后的配置**\r\n\r\n	server{\r\n		listen 81;\r\n		location /images/ {\r\n			root /home/username/picture;\r\n		}\r\n	}\r\n\r\n至于为什么使用80端口不行呢？网上说法不一，我暂时也没想明白。嗯，但成功解决了问题还是挺开心的:-D。\r\n\r\n#2018-4-8更新\r\n80端口不能使用的原因是在/etc/nginx/sites-available目录下的default配置了80端口的监听,将其注释即可。这个文件中还有许多有用的信息O(∩_∩)O',1);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_label`
--

DROP TABLE IF EXISTS `article_label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article_label` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NOT NULL,
  `labels` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `article_id` (`article_id`),
  CONSTRAINT `article_label_ibfk_3` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_label`
--

LOCK TABLES `article_label` WRITE;
/*!40000 ALTER TABLE `article_label` DISABLE KEYS */;
INSERT INTO `article_label` VALUES (1,1,'MySQL,'),(2,2,'Linux,'),(3,3,'Java,'),(4,4,'Nginx,');
/*!40000 ALTER TABLE `article_label` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_setting`
--

DROP TABLE IF EXISTS `blog_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog_setting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `notice` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_setting`
--

LOCK TABLES `blog_setting` WRITE;
/*!40000 ALTER TABLE `blog_setting` DISABLE KEYS */;
INSERT INTO `blog_setting` VALUES (1,'umi','分享所思所想','网站将于2018-6-20维护');
/*!40000 ALTER TABLE `blog_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `create_time` datetime NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `article_id` int(11) NOT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `article_id` (`article_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'不错','2018-05-28 17:00:20','refx','refx@qq.com',1),(2,'不错','2018-05-28 17:00:20','sedwick','sedwick@gmail.com',1),(3,'不错','2018-05-28 17:00:20','joshua','joshua@gmail.com',1),(4,'不错','2018-05-28 17:00:20','qqq','1014066888@qq.com',1),(5,'有用','2018-05-29 16:04:43','doug','doug@gmail.com',2),(6,'写的不错','2018-05-29 16:07:34','doug','doug@gmail.com',3),(7,'很好','2018-05-29 16:10:58','doug','doug@gmail.com',4),(8,'很好','2018-05-29 16:13:19','david','david@gmail.com',2),(9,'挺有帮助的，谢谢','2018-05-29 16:13:42','david','david@gmail.com',3),(10,'666，帮我解决问题了','2018-05-29 16:14:06','david','david@gmail.com',4);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guest_book`
--

DROP TABLE IF EXISTS `guest_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guest_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `create_time` datetime NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guest_book`
--

LOCK TABLES `guest_book` WRITE;
/*!40000 ALTER TABLE `guest_book` DISABLE KEYS */;
INSERT INTO `guest_book` VALUES (1,'加油加油','2018-05-25 16:09:01','refx','refx@qq.com'),(2,'加油加油','2018-05-25 16:10:01','qkas','1014066000@qq.com'),(3,'加油加油','2018-05-25 16:11:01','swdwick','sedwick@gmail.com'),(4,'加油加油','2018-05-25 16:12:01','joshua','joshua@gmail.com'),(5,'加油加油','2018-05-25 16:13:01','refx','refx@qq.com'),(6,'加油加油','2018-05-25 16:14:01','refx','refx@qq.com'),(7,'加油加油','2018-05-25 16:15:01','refx','refx@qq.com'),(8,'加油加油','2018-05-25 16:16:01','refx','refx@qq.com'),(9,'加油加油','2018-05-25 16:17:01','refx','refx@qq.com'),(10,'加油加油','2018-05-25 16:18:01','refx','refx@qq.com'),(11,'加油加油','2018-05-25 16:19:01','refx','refx@qq.com'),(12,'有点强','2018-05-29 16:18:36','youke','925962838@qq.com'),(13,'厉害','2018-05-29 16:19:16','zzm','zzm@126.com'),(14,'666','2018-05-29 16:21:40','tim','tim@163.com'),(15,'加油','2018-05-29 16:22:01','小王同学','xiaowang@163.com');
/*!40000 ALTER TABLE `guest_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `label`
--

DROP TABLE IF EXISTS `label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `label` (
  `label_id` int(11) NOT NULL AUTO_INCREMENT,
  `label_name` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`label_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `label_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `label`
--

LOCK TABLES `label` WRITE;
/*!40000 ALTER TABLE `label` DISABLE KEYS */;
INSERT INTO `label` VALUES (1,'MySQL',1),(2,'Nginx',1),(3,'Java',1),(4,'Linux',1);
/*!40000 ALTER TABLE `label` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'sonkabin','1234','sonkabin@163.com','2018-05-09 19:44:35'),(2,'refx','1234','refx@qq.com','2018-05-23 19:46:52'),(3,'sedwick','1234','sedwick@gmail.com','2018-05-23 19:47:37'),(4,'joshua','1234','joshua@gmail.com','2018-05-23 19:49:13'),(5,'doug','1234','doug@gmail.com','2018-05-23 19:52:09'),(6,'tim','1234','tim@163.com','2018-05-23 19:56:23'),(7,'brain','1234','brain@126.com','2018-05-23 19:56:47'),(8,'zzm','1234','zzm@126.com','2018-05-23 20:08:33'),(9,'msdn','1234','msdn@qq.com','2018-05-23 20:09:04'),(10,'david','1234','david@gmail.com','2018-05-23 20:10:04');
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

-- Dump completed on 2018-05-29 16:26:52
