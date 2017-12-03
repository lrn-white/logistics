/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.11 : Database - logistics
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`logistics` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `logistics`;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cityName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `city` */

insert  into `city`(`id`,`cityName`) values (1,'杭州'),(2,'上海'),(3,'南京');

/*Table structure for table `distributive` */

DROP TABLE IF EXISTS `distributive`;

CREATE TABLE `distributive` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `distributiveName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `distributive` */

insert  into `distributive`(`id`,`distributiveName`) values (1,'杭州集散中心'),(2,'上海集散中心'),(3,'南京集散中心');

/*Table structure for table `driver` */

DROP TABLE IF EXISTS `driver`;

CREATE TABLE `driver` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `driverName` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET latin1 DEFAULT NULL,
  `licenseNumber` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `driverState` varchar(11) CHARACTER SET latin1 DEFAULT NULL,
  `driverCity` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `driver` */

insert  into `driver`(`id`,`driverName`,`gender`,`licenseNumber`,`driverState`,`driverCity`) values (1,'祭斯伯','1','520203198708085811','0','3'),(2,'燕文翰','0','370983198605253212','0','1'),(3,'蒙又香','1','975026763394984404','0','1'),(4,'覃修伟','0','550834881141781821','0','1'),(5,'洋半青','1','434823624906096150','0','2'),(6,'聂晶辉','1','075324669327773183','0','2'),(7,'康翰采','1','403822008507173258','0','2'),(8,'李俊达','0','470555126713968591','0','2'),(9,'王新竹','1','984645891698853571','0','1'),(10,'李语梦','0','260651452094129114','0','1'),(11,'王源源','0','845613663712656982','0','2'),(12,'刘子默','1','319007538829733460','0','1');

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `consignor` varchar(50) DEFAULT NULL,
  `consignee` varchar(50) DEFAULT NULL,
  `consignorPhone` varchar(50) DEFAULT NULL,
  `consigneePhone` varchar(50) DEFAULT NULL,
  `consigneeAdress` varchar(50) DEFAULT NULL,
  `consignorAdress` varchar(50) DEFAULT NULL,
  `currentAddress` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`id`,`consignor`,`consignee`,`consignorPhone`,`consigneePhone`,`consigneeAdress`,`consignorAdress`,`currentAddress`,`state`) values (1,'林兴贤','汪听枫','13895264785','15942698715','上海市浦东新区金杨路308弄22号401室','南京市玄武区苏宁大道1号','1','2'),(2,'孙夏菡','叶问枫','17310549668','10777913139','杭州市秋涛北路120号','南京市玄武区中央路238号','1','0'),(3,'粟幼安','荆志义','18519544270','11279792049','上海浦东通园路潼港一村25号','南京市栖霞区杉湖西路8号','3','0'),(4,'习元化','慕雪兰','12383319574','19017508527','杭州市拱墅区湖州街51号','南京市鼓楼区汉口路22号','1','0'),(5,'邱兰蕙','宛静枫','12772221134','11952618432','杭州市余杭区文一西路969号','上海市浦东新区迎春路324','1','2'),(6,'文幻翠','登才艺','13986244255','18605892320','杭州市西湖区南山路7号','南京市栖霞区马群环陵路1号','1','0'),(7,'蒿梦华','章景福','14981735933','13993263462','南京市玄武区苏宁大道(徐庄软件园)1号','杭州市江干区高教园区学林街188号','3','0'),(8,'司海凡','宗思怡','14952873568','18071322893','杭州市环城北路288号','上海市闵行区莘松路808号','2','0'),(9,'严飞文','苏涵容','11230206403','16694397621','上海市卢湾区局门路340弄37号402室','南京市浦口区沿江街道京新628号','2','0'),(10,'军古兰','达凌春','12156558291','18766106580','南京市白下区汉中路1号','杭州江城路402号','1','2');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `role` */

insert  into `role`(`id`,`roleName`) values (1,'系统管理员'),(2,'操作员');

/*Table structure for table `truck` */

DROP TABLE IF EXISTS `truck`;

CREATE TABLE `truck` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plateNumber` varchar(50) DEFAULT NULL,
  `truckState` varchar(11) CHARACTER SET latin1 DEFAULT NULL,
  `truckCity` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `truck` */

insert  into `truck`(`id`,`plateNumber`,`truckState`,`truckCity`) values (1,'浙A22222','0','3'),(2,'沪A50555','0','1'),(3,'苏A50A2E','0','2'),(4,'浙B52D25','0','2'),(5,'沪A1256E','0','2'),(6,'苏A48E45','0','2'),(7,'浙A45R78','0','1'),(8,'浙A78Q45','0','3'),(9,'浙AWE785','0','1'),(10,'苏A789R5','0','2');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `latestDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`account`,`password`,`createDate`,`latestDate`) values (1,'张三','123456','2017-11-02 16:52:52','2017-11-20 13:43:35'),(2,'李四','147852','2017-11-28 15:20:37','2017-11-28 15:20:37'),(4,'王五','159753','2017-11-30 14:54:39','2017-11-30 14:54:39');

/*Table structure for table `userrole` */

DROP TABLE IF EXISTS `userrole`;

CREATE TABLE `userrole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) DEFAULT NULL,
  `roleID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `userrole` */

insert  into `userrole`(`id`,`userID`,`roleID`) values (1,1,1),(2,2,1),(5,4,2);

/*Table structure for table `waybill` */

DROP TABLE IF EXISTS `waybill`;

CREATE TABLE `waybill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `truckID` int(11) DEFAULT NULL,
  `driverID` int(11) DEFAULT NULL,
  `goodsID` int(11) DEFAULT NULL,
  `departureCity` varchar(50) DEFAULT NULL,
  `arriveCity` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `waybill` */

insert  into `waybill`(`id`,`truckID`,`driverID`,`goodsID`,`departureCity`,`arriveCity`) values (10,3,3,10,'1','2'),(11,6,8,5,'1','2'),(12,8,9,1,'1','2');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
