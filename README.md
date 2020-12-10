# BookStore

 最近刚学完Java web，找了这个实战项目练练手，跟着【学习猿地】视频做的。
 
## 开发环境

- deepin 20

- Eclipse IDE for Enterprise Java Developers. Version: 2019-03 (4.11.0)

- MySQL 5.7
- jdk 1.8
- Tomcat 9.0
- navicat for mysql 11.1.13
- 用到的jar包
  - c3p0-0.9.2.1.jar
  - mchange-commons-java-0.2.20.jar
  - mysql-connector-java-5.1.46-bin.jar
  - taglibs-standard-impl-1.2.5.jar
  - taglibs-standard-spec-1.2.5.jar

## 项目介绍

- 基于servlet+jsp+mysql的Java web网上书店项目
- 目前实现的功能有添加/修改/删除用户、分类、商品
- 由于时间原因，目前未能实现购物车和订单功能

### 数据库

数据库的设计不是很合理，仅作参考。

- user - 用户表
- category - 分类表
- product - 商品表

```mysql
/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2020-12-10 07:42:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `CATE_ID` int(10) NOT NULL AUTO_INCREMENT,
  `CATE_NAME` varchar(20) NOT NULL,
  `CATE_PARENT_ID` decimal(10,0) NOT NULL,
  PRIMARY KEY (`CATE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `PRODUCT_ID` int(10) NOT NULL AUTO_INCREMENT,
  `PRODUCT_NAME` varchar(128) NOT NULL,
  `PRODUCT_DESCRIPTION` varchar(512) DEFAULT NULL,
  `PRODUCT_PRICE` decimal(10,2) NOT NULL,
  `PRODUCT_STOCK` decimal(10,0) DEFAULT NULL,
  `PRODUCT_FID` decimal(10,0) DEFAULT NULL,
  `PRODUCT_CID` decimal(10,0) DEFAULT NULL,
  `PRODUCT_FILENAME` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`PRODUCT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `USER_ID` varchar(32) NOT NULL,
  `USER_NAME` varchar(20) NOT NULL,
  `USER_PASSWORD` varchar(20) NOT NULL,
  `USER_SEX` varchar(1) NOT NULL,
  `USER_BIRTHDAY` date DEFAULT '1970-01-01',
  `USER_IDENITY_CODE` varchar(60) DEFAULT NULL,
  `USER_MAIL` varchar(60) NOT NULL,
  `USER_MOBILE` varchar(11) DEFAULT NULL,
  `USER_ADDRESS` varchar(200) DEFAULT NULL,
  `USER_STATUS` decimal(6,0) NOT NULL,
  `USER_REGTIME` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

```



### 目录介绍

#### java

- dao 数据库连接与关闭
- entity 存放实体类
- filter 过滤器
- home 前端servlet
- service 数据表增删改查操作
- servlet 主要的控制器servlet
- utils 工具包

#### web

- manage 后台网页
- css 样式
- img 图片
- js javascript



### 图片预览

[![rPhiYF.png](https://s3.ax1x.com/2020/12/10/rPhiYF.png)](https://imgchr.com/i/rPhiYF)
[![rPhFW4.png](https://s3.ax1x.com/2020/12/10/rPhFW4.png)](https://imgchr.com/i/rPhFW4)
[![rPhEl9.png](https://s3.ax1x.com/2020/12/10/rPhEl9.png)](https://imgchr.com/i/rPhEl9)
[![rPhPFU.png](https://s3.ax1x.com/2020/12/10/rPhPFU.png)](https://imgchr.com/i/rPhPFU)
[![rPh9oT.png](https://s3.ax1x.com/2020/12/10/rPh9oT.png)](https://imgchr.com/i/rPh9oT)
[![rPhASJ.png](https://s3.ax1x.com/2020/12/10/rPhASJ.png)](https://imgchr.com/i/rPhASJ)
