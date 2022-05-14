/*
Navicat MySQL Data Transfer

Source Server         : myconnection
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : f&c clothing

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2022-05-07 22:49:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `clothing`
-- ----------------------------
DROP TABLE IF EXISTS `clothing`;
CREATE TABLE `clothing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_id` bigint(20) DEFAULT NULL,
  `clothing_category_id` bigint(20) DEFAULT NULL,
  `clothing_attribute_category_id` bigint(20) DEFAULT NULL,
  `name` varchar(64) NOT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `clothing_sn` varchar(64) NOT NULL COMMENT '货号',
  `delete_status` int(1) DEFAULT NULL COMMENT '删除状态：0->未删除；1->已删除',
  `publish_status` int(1) DEFAULT NULL COMMENT '上架状态：0->下架；1->上架',
  `new_status` int(1) DEFAULT NULL COMMENT '新品状态:0->不是新品；1->新品',
  `recommand_status` int(1) DEFAULT NULL COMMENT '推荐状态；0->不推荐；1->推荐',
  `verify_status` int(1) DEFAULT NULL COMMENT '审核状态：0->未审核；1->审核通过',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `sale` int(11) DEFAULT NULL COMMENT '销量',
  `price` decimal(10,2) DEFAULT NULL,
  `promotion_price` decimal(10,2) DEFAULT NULL COMMENT '促销价格',
  `gift_growth` int(11) DEFAULT '0' COMMENT '赠送的成长值',
  `gift_point` int(11) DEFAULT '0' COMMENT '赠送的积分',
  `use_point_limit` int(11) DEFAULT NULL COMMENT '限制使用的积分数',
  `sub_title` varchar(255) DEFAULT NULL COMMENT '副标题',
  `description` text COMMENT '商品描述',
  `original_price` decimal(10,2) DEFAULT NULL COMMENT '市场价',
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  `low_stock` int(11) DEFAULT NULL COMMENT '库存预警值',
  `unit` varchar(16) DEFAULT NULL COMMENT '单位',
  `weight` decimal(10,2) DEFAULT NULL COMMENT '商品重量，默认为克',
  `preview_status` int(1) DEFAULT NULL COMMENT '是否为预告商品：0->不是；1->是',
  `service_ids` varchar(64) DEFAULT NULL COMMENT '以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮',
  `keywords` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `album_pics` varchar(255) DEFAULT NULL COMMENT '画册图片，连产品图片限制为5张，以逗号分割',
  `detail_title` varchar(255) DEFAULT NULL,
  `promotion_start_time` datetime DEFAULT NULL COMMENT '促销开始时间',
  `promotion_end_time` datetime DEFAULT NULL COMMENT '促销结束时间',
  `promotion_per_limit` int(11) DEFAULT NULL COMMENT '活动限购数量',
  `promotion_type` int(1) DEFAULT NULL COMMENT '促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购',
  `brand_name` varchar(255) DEFAULT NULL COMMENT '品牌名称',
  `clothing_category_name` varchar(255) DEFAULT NULL COMMENT '商品分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COMMENT='商品信息';

-- ----------------------------
-- Records of clothing
-- ----------------------------
INSERT INTO `clothing` VALUES ('1', '6', '8', '1', '潮牌T恤', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-02-14/gaolin01.jpg', '', '0', '1', '0', '0', '0', '0', '0', '100.00', null, '0', '0', '0', '好看', '', '100.00', '100', '0', '', '0.00', '0', '3,2', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-02-18/kuzi.jpg,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-02-18/4.png', '', null, null, '0', '1', '香奈儿', 'T恤');
INSERT INTO `clothing` VALUES ('2', '6', '7', '1', '银色星芒刺绣网纱底裤2', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-03-16/u=2395477863,2115259135&fm=253&fmt=auto&app=138&f=JPEG.webp', 'No86578', '1', '1', '1', '1', '1', '1', '0', '100.00', null, '0', '100', null, '111', '111', '120.00', '100', '20', '件', '1000.00', '0', '1,2,3', '银色星芒刺绣网纱底裤2', '银色星芒刺绣网纱底裤', '', '银色星芒刺绣网纱底裤', null, null, null, '0', '七匹狼', '外套');
INSERT INTO `clothing` VALUES ('3', '21', '7', null, '中国风潮牌帅气外套', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-04-27/u=4058912048,3059922512&fm=253&fmt=auto&app=138&f=JPEG.webp', '', '1', '1', '1', '1', '0', '0', '0', '888.00', null, '0', '0', '0', '中国风潮牌帅气外套', '', '888.00', '100', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', '优衣库', '外套');
INSERT INTO `clothing` VALUES ('4', '1', '7', '0', '银色星芒刺绣网纱底裤4', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86580', '1', '1', '1', '1', '1', '1', '0', '100.00', null, '0', '100', null, '111', '111', '120.00', '100', '20', '件', '1000.00', '0', null, '银色星芒刺绣网纱底裤4', '银色星芒刺绣网纱底裤', null, '银色星芒刺绣网纱底裤', null, null, null, '0', '万和', '外套');
INSERT INTO `clothing` VALUES ('5', '1', '7', '0', '银色星芒刺绣网纱底裤5', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86581', '1', '0', '1', '1', '1', '1', '0', '100.00', null, '0', '100', null, '111', '111', '120.00', '100', '20', '件', '1000.00', '0', null, '银色星芒刺绣网纱底裤5', '银色星芒刺绣网纱底裤', null, '银色星芒刺绣网纱底裤', null, null, null, '0', '万和', '外套');
INSERT INTO `clothing` VALUES ('6', '1', '7', '0', '银色星芒刺绣网纱底裤6', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86582', '1', '1', '1', '1', '1', '1', '0', '100.00', null, '0', '100', null, '111', '111', '120.00', '100', '20', '件', '1000.00', '0', null, '银色星芒刺绣网纱底裤6', '银色星芒刺绣网纱底裤', null, '银色星芒刺绣网纱底裤', null, null, null, '0', '万和', '外套');
INSERT INTO `clothing` VALUES ('7', '1', '7', '1', '女式超柔软拉毛运动开衫', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '0', '0', '0', '0', '0', '0', '249.00', '0.00', '0', '100', '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', '299.00', '100', '0', '件', '0.00', '0', 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', '万和', '外套');
INSERT INTO `clothing` VALUES ('8', '1', '7', '1', '女式超柔软拉毛运动开衫1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '0', '0', '0', '0', '0', '0', '249.00', '0.00', '0', '100', '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', '299.00', '100', '0', '件', '0.00', '0', 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', '万和', '外套');
INSERT INTO `clothing` VALUES ('9', '1', '7', '1', '女式超柔软拉毛运动开衫1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '0', '0', '0', '0', '0', '0', '249.00', '0.00', '0', '100', '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', '299.00', '100', '0', '件', '0.00', '0', 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', '万和', '外套');
INSERT INTO `clothing` VALUES ('10', '1', '7', '1', '女式超柔软拉毛运动开衫1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '0', '0', '0', '0', '0', '0', '249.00', '0.00', '0', '100', '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', '299.00', '100', '0', '件', '0.00', '0', 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', '万和', '外套');
INSERT INTO `clothing` VALUES ('11', '1', '7', '1', '女式超柔软拉毛运动开衫1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '1', '0', '1', '0', '0', '0', '249.00', '0.00', '0', '100', '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', '299.00', '100', '0', '件', '0.00', '0', 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', '万和', '外套');
INSERT INTO `clothing` VALUES ('12', '1', '7', '1', '女式超柔软拉毛运动开衫2', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '1', '0', '1', '0', '0', '0', '249.00', '0.00', '0', '100', '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', '299.00', '100', '0', '件', '0.00', '0', 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', '万和', '外套');
INSERT INTO `clothing` VALUES ('13', '1', '7', '1', '女式超柔软拉毛运动开衫3', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '1', '0', '1', '0', '0', '0', '249.00', '0.00', '0', '100', '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', '299.00', '100', '0', '件', '0.00', '0', 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', '万和', '外套');
INSERT INTO `clothing` VALUES ('14', '1', '7', '1', '女式超柔软拉毛运动开衫3', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '0', '0', '1', '0', '0', '0', '249.00', '0.00', '0', '100', '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', '299.00', '100', '0', '件', '0.00', '0', 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', '万和', '外套');
INSERT INTO `clothing` VALUES ('18', '1', '7', '1', '女式超柔软拉毛运动开衫3', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '0', '0', '1', '0', '0', '0', '249.00', '0.00', '0', '100', '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', '299.00', '100', '0', '件', '0.00', '0', 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', '万和', '外套');
INSERT INTO `clothing` VALUES ('22', '6', '7', '1', 'test', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', '', '1', '1', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', 'test', '', '0.00', '100', '0', '', '0.00', '1', '1,2', '', '', '', '', null, null, '0', '0', '香奈儿', '外套');
INSERT INTO `clothing` VALUES ('23', '6', '19', '1', '毛衫测试', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', 'NO.1098', '1', '1', '1', '1', '0', '0', '0', '99.00', null, '99', '99', '1000', '毛衫测试11', 'xxx', '109.00', '100', '0', '件', '1000.00', '1', '1,2,3', '毛衫测试', '毛衫测试', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg,http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', '毛衫测试', null, null, '0', '2', '香奈儿', '手机数码');
INSERT INTO `clothing` VALUES ('24', '6', '7', null, 'xxx', '', '', '1', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', 'xxx', '', '0.00', '100', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', '香奈儿', '外套');
INSERT INTO `clothing` VALUES ('26', '3', '7', '3', '华为 HUAWEI P20', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', '6946605', '1', '1', '1', '1', '0', '100', '0', '3788.00', null, '3788', '3788', '0', 'AI智慧全面屏 6GB +64GB 亮黑色 全网通版 移动联通电信4G手机 双卡双待手机 双卡双待', '', '4288.00', '1000', '0', '件', '0.00', '1', '2,3,1', '', '', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ab46a3cN616bdc41.jpg,http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf5fN2522b9dc.jpg', '', null, null, '0', '1', '华为', '外套');
INSERT INTO `clothing` VALUES ('27', '6', '19', '3', '小米8 全面屏游戏智能手机 6GB+64GB 黑色 全网通4G 双卡双特', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', '7437788', '1', '1', '1', '1', '0', '0', '0', '2699.00', null, '2699', '2699', '0', '骁龙845处理器，红外人脸解锁，AI变焦双摄，AI语音助手小米6X低至1299，点击抢购', '小米8 全面屏游戏智能手机 6GB+64GB 黑色 全网通4G 双卡双待', '2699.00', '100', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '3', '香奈儿', '手机数码');
INSERT INTO `clothing` VALUES ('28', '6', '19', '3', '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '7437789', '1', '1', '1', '1', '0', '0', '0', '649.00', null, '649', '649', '0', '8天超长待机，137g轻巧机身，高通骁龙处理器小米6X低至1299，点击抢购', '', '649.00', '100', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '4', '香奈儿', '手机数码');
INSERT INTO `clothing` VALUES ('29', '51', '19', '3', 'Apple iPhone 8 Plus 64GB 红色特别版 移动联通电信4G手机', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5acc5248N6a5f81cd.jpg', '7437799', '1', '1', '1', '1', '0', '0', '0', '5499.00', null, '5499', '5499', '0', '【限时限量抢购】Apple产品年中狂欢节，好物尽享，美在智慧！速来 >> 勾选[保障服务][原厂保2年]，获得AppleCare+全方位服务计划，原厂延保售后无忧。', '', '5499.00', '100', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', '苹果', '手机数码');
INSERT INTO `clothing` VALUES ('30', '50', '8', '1', 'HLA海澜之家简约动物印花短袖T恤', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5ad83a4fN6ff67ecd.jpg!cc_350x449.jpg', 'HNTBJ2E042A', '1', '1', '1', '1', '0', '0', '0', '98.00', null, '0', '0', '0', '2018夏季新品微弹舒适新款短T男生 6月6日-6月20日，满300减30，参与互动赢百元礼券，立即分享赢大奖', '', '98.00', '100', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', '海澜之家', 'T恤');
INSERT INTO `clothing` VALUES ('31', '50', '8', '1', 'HLA海澜之家蓝灰花纹圆领针织布短袖T恤', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5ac98b64N70acd82f.jpg!cc_350x449.jpg', 'HNTBJ2E080A', '1', '1', '0', '0', '0', '0', '0', '98.00', null, '0', '0', '0', '2018夏季新品短袖T恤男HNTBJ2E080A 蓝灰花纹80 175/92A/L80A 蓝灰花纹80 175/92A/L', '', '98.00', '100', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', '海澜之家', 'T恤');
INSERT INTO `clothing` VALUES ('32', '50', '8', null, 'HLA海澜之家短袖T恤男基础款', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a51eb88Na4797877.jpg', 'HNTBJ2E153A', '1', '1', '0', '0', '0', '0', '0', '68.00', null, '0', '0', '0', 'HLA海澜之家短袖T恤男基础款简约圆领HNTBJ2E153A藏青(F3)175/92A(50)', '', '68.00', '100', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', '海澜之家', 'T恤');
INSERT INTO `clothing` VALUES ('33', '6', '35', null, '小米（MI）小米电视4A ', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b02804dN66004d73.jpg', '4609652', '1', '1', '0', '0', '0', '0', '0', '2499.00', null, '0', '0', '0', '小米（MI）小米电视4A 55英寸 L55M5-AZ/L55M5-AD 2GB+8GB HDR 4K超高清 人工智能网络液晶平板电视', '', '2499.00', '100', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', '香奈儿', '手机数码');
INSERT INTO `clothing` VALUES ('34', '6', '35', null, '小米（MI）小米电视4A 65英寸', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b028530N51eee7d4.jpg', '4609660', '1', '1', '0', '0', '0', '0', '0', '3999.00', null, '0', '0', '0', ' L65M5-AZ/L65M5-AD 2GB+8GB HDR 4K超高清 人工智能网络液晶平板电视', '', '3999.00', '100', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', '香奈儿', '手机数码');
INSERT INTO `clothing` VALUES ('35', '58', '29', '11', '耐克NIKE 男子 休闲鞋 ROSHE RUN 运动鞋 511881-010黑色41码', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b235bb9Nf606460b.jpg', '6799342', '1', '1', '0', '0', '0', '0', '0', '369.00', null, '0', '0', '0', '耐克NIKE 男子 休闲鞋 ROSHE RUN 运动鞋 511881-010黑色41码', '', '369.00', '100', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', 'NIKE', '男鞋');
INSERT INTO `clothing` VALUES ('36', '58', '29', '11', '耐克NIKE 男子 气垫 休闲鞋 AIR MAX 90 ESSENTIAL 运动鞋 AJ1285-101白色41码', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b19403eN9f0b3cb8.jpg', '6799345', '1', '1', '1', '1', '0', '0', '0', '499.00', null, '0', '0', '0', '耐克NIKE 男子 气垫 休闲鞋 AIR MAX 90 ESSENTIAL 运动鞋 AJ1285-101白色41码', '', '499.00', '100', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', 'NIKE', '男鞋');
INSERT INTO `clothing` VALUES ('37', '4', '7', null, 'aaaa', '', '1111', '1', '0', '0', '0', '0', '1111', '0', '111.00', null, '0', '0', '0', 'aaaa', '', '111.00', '111', '0', '111', '111.00', '0', '', '', '', '', '', null, null, '0', '0', '格力', '外套');
INSERT INTO `clothing` VALUES ('38', '6', '7', null, 'aaaa', '', '1111', '1', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', 'aaaa', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', '香奈儿', '外套');
INSERT INTO `clothing` VALUES ('39', '6', '7', null, '111', '', '', '1', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '111', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', '香奈儿', '外套');
INSERT INTO `clothing` VALUES ('40', '6', '7', null, '111', '', '', '1', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '111', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', '香奈儿', '外套');
INSERT INTO `clothing` VALUES ('41', '6', '7', null, '111', '', '', '1', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '111', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', '香奈儿', '外套');
INSERT INTO `clothing` VALUES ('42', '6', '7', null, '111', '', '', '1', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '111', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', '香奈儿', '外套');
INSERT INTO `clothing` VALUES ('43', '6', '7', null, 'hhh', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-02-14/car.jpeg', '', '1', '1', '0', '1', '0', '0', '0', '0.00', null, '0', '0', '0', 'xixixi', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-02-14/壁纸.jpg', '', null, null, '0', '0', '香奈儿', '外套');
INSERT INTO `clothing` VALUES ('45', '49', '7', '0', '银色星芒刺绣网纱底裤', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '1', '1', '1', '1', '100', '0', '100.00', null, '0', '100', null, '111', '111', '120.00', '100', '20', '件', '1000.00', '0', null, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', null, '银色星芒刺绣网纱底裤', null, null, null, '0', '七匹狼', '外套');
INSERT INTO `clothing` VALUES ('46', '6', '7', null, 'hahahah', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-03-06/1.png', '', '1', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', 'xixixix', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-03-06/2.png', '', null, null, '0', '0', '香奈儿', '外套');
INSERT INTO `clothing` VALUES ('47', '49', '7', '1', '嘻哈潮流', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-03-10/xiezi.jpg', '', '1', '0', '0', '0', '0', '0', '0', '88.00', null, '0', '0', '0', '嘻哈风格', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-03-10/index1.jpg,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-03-10/9E1A391CB4FB45D324A9ECC240C1F8B9.jpg', '', null, null, '0', '0', '欧时力', '外套');
INSERT INTO `clothing` VALUES ('48', '49', '8', '1', '潮牌短袖', '', '', '1', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '短袖', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', '欧时力', 'T恤');
INSERT INTO `clothing` VALUES ('49', '51', '9', '1', '超酷', '', '', '1', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '超酷', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', 'LV', '休闲裤');
INSERT INTO `clothing` VALUES ('50', '49', '29', '1', '运动服', '', '', '1', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '运动', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', '欧时力', '长袖');
INSERT INTO `clothing` VALUES ('51', '5', '35', '1', '超舒适服装', '', '', '1', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '舒适', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', '太平鸟', '外套');
INSERT INTO `clothing` VALUES ('52', '6', '7', '1', '超好看', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-03-11/u=493215035,498812095&fm=253&fmt=auto&app=138&f=JPEG.webp', '', '1', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '好看', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', '香奈儿', '外套');
INSERT INTO `clothing` VALUES ('53', '49', '7', '1', '超美丽', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-03-11/u=2672542651,2398413923&fm=253&fmt=auto&app=138&f=JPEG.webp', '', '1', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '魅力', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', '欧时力', '外套');
INSERT INTO `clothing` VALUES ('60', '1', '7', '0', '银色星芒刺绣网纱底裤3', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86579', '1', '1', '1', '1', '1', '1', '0', '100.00', null, '0', '100', null, '111', '111', '120.00', '100', '20', '件', '1000.00', '0', null, '银色星芒刺绣网纱底裤3', '银色星芒刺绣网纱底裤', null, '银色星芒刺绣网纱底裤', null, null, null, '0', '万和', '外套');
INSERT INTO `clothing` VALUES ('61', '51', '7', '1', '潮牌飞行员夹克外套男士春秋季', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/71ae321f90950059.jpg.avif', '0001', '0', '1', '0', '0', '0', '0', '0', '138.00', null, '0', '0', '0', '潮牌飞行员夹克外套男士春秋季', '', '138.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/1d836829facade2c.jpg.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/010e64e388410ca3.jpg.avif', '', null, null, '0', '0', 'LV', '外套');
INSERT INTO `clothing` VALUES ('62', '2', '8', '1', '短袖t恤男夏季潮牌2021新款半袖纯棉', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/6a6b9657910293f4.jpg.avif', '', '0', '1', '1', '0', '0', '0', '0', '68.00', null, '0', '0', '0', '短袖t恤男夏季潮牌2021新款半袖纯棉', '', '68.00', '68', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/ab4bd0346bb4e21f.jpg.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/f65c31b19c0fe97c.jpg.avif', '', null, null, '0', '0', '阿迪达斯', 'T恤');
INSERT INTO `clothing` VALUES ('63', '49', '10', '2', '直筒牛仔裤男2022春夏季新款潮牌休闲裤', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/b276c9ab778e8f19.jpg.avif', '', '0', '1', '1', '0', '0', '0', '0', '59.00', null, '0', '0', '0', '直筒牛仔裤男2022春夏季新款潮牌休闲裤', '', '59.00', '59', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/b3602a4b579b2512.jpg.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/c7e0944ab662e272.jpg.avif', '', null, null, '0', '0', '欧时力', '牛仔裤');
INSERT INTO `clothing` VALUES ('64', '6', '8', '1', '香港潮牌时尚轻熟风减龄女短款', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/6f4b31b5cbeb08e2.jpg.avif', '', '0', '1', '0', '0', '0', '0', '0', '396.00', null, '0', '0', '0', '香港潮牌时尚轻熟风减龄女短款', '', '396.00', '396', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/be89817bc9ec03e7.jpg.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/e79035cf3023f3ff.jpg.avif', '', null, null, '0', '0', '香奈儿', 'T恤');
INSERT INTO `clothing` VALUES ('65', '49', '10', '2', '香港潮牌韩版高腰微喇牛仔裤女', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/9ca2da5182b24b6a.jpg.avif', '', '0', '1', '1', '0', '0', '0', '0', '499.00', null, '0', '0', '0', '香港潮牌韩版高腰微喇牛仔裤女', '', '499.00', '499', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/f8d598a386c4f2df.jpg.avif', '', null, null, '0', '0', '欧时力', '牛仔裤');
INSERT INTO `clothing` VALUES ('66', '2', '30', '1', '夹克男夏季外套男士连帽简约时尚长袖', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/5f8c4eb3210ce2c1.jpg.avif', '', '0', '1', '0', '0', '0', '0', '0', '69.00', null, '0', '0', '0', '夹克男夏季外套男士连帽简约时尚长袖', '', '69.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/8648c87baf8d24a8.jpg.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/f4c731318b3e015b.jpg.avif', '', null, null, '0', '0', '阿迪达斯', '外套');
INSERT INTO `clothing` VALUES ('67', '1', '31', '1', '100%纯棉短袖t恤男简约百搭宽松港风五分袖', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/435cf2884e175db7.jpg.avif', '0007', '0', '1', '0', '0', '0', '0', '0', '58.00', null, '0', '0', '0', '100%纯棉短袖t恤男简约百搭宽松港风五分袖', '', '58.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/979e107741b89486.jpg.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/fdfd3acbc495e166.jpg.avif', '', null, null, '0', '0', '耐克', 'T恤');
INSERT INTO `clothing` VALUES ('68', '50', '31', '1', '南极人短袖T恤男夏季薄款男装新款港风韩版', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/64be08b96cbacf26.jpg.avif', '0008', '0', '1', '0', '0', '0', '0', '0', '49.00', null, '0', '0', '0', '南极人短袖T恤男夏季薄款男装新款港风韩版', '', '49.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/89daa5d4a191d539.jpg.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/b310d7d3fd330c5a.jpg.avif', '', null, null, '0', '0', '阿玛施', 'T恤');
INSERT INTO `clothing` VALUES ('69', '21', '33', '2', '途中雨休闲裤男士夏季中裤大码男装七分裤', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/2927a2a62ece884a.jpg.avif', '', '0', '1', '0', '0', '0', '0', '0', '89.00', null, '0', '0', '0', '途中雨休闲裤男士夏季中裤大码男装七分裤', '', '89.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/cc1ba6e8e36755e1.jpg.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/6ebe9879a1347a92.jpg.avif', '', null, null, '0', '0', '优衣库', '短裤');
INSERT INTO `clothing` VALUES ('70', '5', '32', '2', '休闲裤男韩版简约纯色九分裤百搭舒适宽松休闲直筒裤', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/9ac6a0d523beca6a.jpg.avif', '0010', '0', '1', '0', '0', '0', '0', '0', '69.00', null, '0', '0', '0', '休闲裤男韩版简约纯色九分裤百搭舒适宽松休闲直筒裤', '', '69.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/f1a5deb434265539.jpg.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/f8395b37af38f698.jpg.avif', '', null, null, '0', '0', '太平鸟', '长裤');
INSERT INTO `clothing` VALUES ('71', '51', '35', '1', '健身服男跑步运动套装篮球秋冬速干衣高弹训练装备晨跑服', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/a173973b38c37580.jpg.avif', '0011', '0', '1', '0', '0', '0', '0', '0', '123.00', null, '0', '0', '0', '健身服男跑步运动套装篮球秋冬速干衣高弹训练装备晨跑服', '', '123.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/0de47125d39dd5bc.jpg.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/f5f8281986ed62c7.jpg.avif', '', null, null, '0', '0', 'LV', '外套');
INSERT INTO `clothing` VALUES ('72', '1', '35', '1', '外套男卫衣春秋季衣服运动服跑步服健身服', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/6eb7a21a5f1abde4.jpg.avif', '0012', '0', '1', '0', '0', '0', '0', '0', '159.00', null, '0', '0', '0', '外套男卫衣春秋季衣服运动服跑步服健身服', '', '159.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/272951704eb30374.jpg.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/d94e98f8eda6ce68.jpg.avif', '', null, null, '0', '0', '耐克', '外套');
INSERT INTO `clothing` VALUES ('73', '5', '37', '1', '运动套装男士夏季中老年休闲套装男纯棉跑步服', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/15147ee9391d08f0.jpg.avif', '0013', '0', '1', '0', '0', '0', '0', '0', '168.00', null, '0', '0', '0', '运动套装男士夏季中老年休闲套装男纯棉跑步服', '', '168.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/b4b4823f6851eb1c.jpg.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/80d8a5099aa6ec5a.jpg.avif', '', null, null, '0', '0', '太平鸟', '短袖');
INSERT INTO `clothing` VALUES ('74', '4', '37', '1', '广场舞服装女套装夏季新款舞蹈服短袖棉健身运动服套装', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/056566067e5491ee.jpg.avif', '0017', '0', '1', '0', '0', '0', '0', '0', '68.00', null, '0', '0', '0', '广场舞服装女套装夏季新款舞蹈服短袖棉健身运动服套装', '', '68.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/4379bded74bb77aa.jpg.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/bf6602b3a642e29e.jpg.avif', '', null, null, '0', '0', '新百伦', '短袖');
INSERT INTO `clothing` VALUES ('75', '58', '39', '2', '运动套装女t恤短裤女士衣服春夏季休闲运动服饰', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/9352360d11581852.jpg.avif', '0015', '0', '1', '0', '0', '0', '0', '0', '127.00', null, '0', '0', '0', '运动套装女t恤短裤女士衣服春夏季休闲运动服饰', '', '127.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/d2bce8755ce73f54.jpg.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/0ae7552d9ffa6b98.jpg.avif', '', null, null, '0', '0', 'Vans', '短裤');
INSERT INTO `clothing` VALUES ('76', '5', '35', '1', '卫衣女装套装2022年春季新款韩版宽松上衣服外套女', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/2fbf628d0cf59469.jpg.avif', '0016', '0', '1', '0', '0', '0', '0', '0', '159.00', null, '0', '0', '0', '卫衣女装套装2022年春季新款韩版宽松上衣服外套女', '', '159.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/8b10e13715557733.jpg.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/8e6e1d343636bbcd.jpg.avif', '', null, null, '0', '0', '太平鸟', '外套');
INSERT INTO `clothing` VALUES ('77', '49', '35', '1', '卫衣女装运动套装女2022年夏季新款韩版宽松休闲装', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/2c8775ad73b51a25.jpg.avif', '0014', '0', '1', '0', '0', '0', '0', '0', '118.00', null, '0', '0', '0', '卫衣女装运动套装女2022年夏季新款韩版宽松休闲装', '', '118.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/45f53f65f5c89b33.jpg.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/793c366bd66620f7.jpg.avif', '', null, null, '0', '0', '欧时力', '外套');
INSERT INTO `clothing` VALUES ('78', '58', '43', '1', '花花公子中式唐装改良汉服羽织中国风道袍古风男装', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/11a3bbd28a80b955.jpg!cc_350x467.avif', '0018', '0', '1', '0', '0', '0', '0', '0', '163.00', null, '0', '0', '0', '花花公子中式唐装改良汉服羽织中国风道袍古风男装', '', '163.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/18b8465065740083.jpg!cc_350x467.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/f8246605d1d7691c.jpg!cc_350x467.avif', '', null, null, '0', '0', 'Vans', '男装');
INSERT INTO `clothing` VALUES ('79', '50', '45', '1', '鼎毳貂汉服古装男生新款原创汉服中国古风服装', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/06ad176a01d56374.jpg.avif', '0019', '0', '1', '0', '0', '0', '0', '0', '119.00', null, '0', '0', '0', '鼎毳貂汉服古装男生新款原创汉服中国古风服装', '', '119.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/6de39aac76e570b4.jpg.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/b7e7c54a1b446d4d.jpg.avif', '', null, null, '0', '0', '阿玛施', '外套');
INSERT INTO `clothing` VALUES ('80', '1', '43', '1', '花花公子三件套道袍男士中国风套装潮流汉服冰丝夏天唐装', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/e96601f8de4bc720.jpg!cc_350x467.avif', '0020', '0', '1', '0', '0', '0', '0', '0', '258.00', null, '0', '0', '0', '花花公子三件套道袍男士中国风套装潮流汉服冰丝夏天唐装', '', '258.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/222378aeb6d2e9da.jpg!cc_350x467.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/84fa4fb8199f9cfb.jpg!cc_350x467.avif', '', null, null, '0', '0', '耐克', '男装');
INSERT INTO `clothing` VALUES ('81', '5', '47', '2', '亚麻中国风套装夏季棉麻潮牌帅气唐装男汉服潮流米白色裤子', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/0f24b9f461f9d061.jpg.avif', '0021', '0', '1', '0', '0', '0', '0', '0', '99.00', null, '0', '0', '0', '亚麻中国风套装夏季棉麻潮牌帅气唐装男汉服潮流米白色裤子', '', '99.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/9cf328468f094051.jpg.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/8385f7861cd54862.jpg.avif', '', null, null, '0', '0', '太平鸟', '紧身裤');
INSERT INTO `clothing` VALUES ('82', '49', '44', '1', '旗袍连衣裙女2022年新款夏季短款复古中国风礼服裙子', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/3c3faf42a7ea2c51.jpg!cc_350x467.avif', '0022', '1', '1', '0', '0', '0', '0', '0', '455.00', null, '0', '0', '0', '旗袍连衣裙女2022年新款夏季短款复古中国风礼服裙子', '', '455.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/47eb004c7c5799a2.jpg!cc_350x467.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/d1ac5a3847d6404d.jpg!cc_350x467.avif', '', null, null, '0', '0', '欧时力', '女装');
INSERT INTO `clothing` VALUES ('83', '49', '44', '1', '汉服女埠陡寸2022女装春夏装新品复古改良民族风中式短袖', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/0.jpg!cc_350x467.avif', '0022', '0', '1', '0', '0', '0', '0', '0', '168.00', null, '0', '0', '0', '汉服女埠陡寸2022女装春夏装新品复古改良民族风中式短袖', '', '168.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/1.jpg!cc_350x467.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/2.jpg!cc_350x467.avif', '', null, null, '0', '0', '欧时力', '女装');
INSERT INTO `clothing` VALUES ('84', '6', '44', '1', '妖妮旗袍汉服女成人年轻款改良薄款棉麻套装', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/ac6785c9313d02d8.jpg!cc_350x467.avif', '0023', '0', '1', '0', '0', '0', '0', '0', '139.00', null, '0', '0', '0', '妖妮旗袍汉服女成人年轻款改良薄款棉麻套装', '', '139.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/caa1abd5d0a7576a.jpg!cc_350x467.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/db4d91524ad70f07.jpg!cc_350x467.avif', '', null, null, '0', '0', '香奈儿', '女装');
INSERT INTO `clothing` VALUES ('85', '6', '44', '1', '复古日记国风女装2022春秋新款仿桑蚕丝中式国风长袖', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/0ae0966ffd8da2c1.jpg.avif', '0024', '0', '1', '0', '0', '0', '0', '0', '118.00', null, '0', '0', '0', '复古日记国风女装2022春秋新款仿桑蚕丝中式国风长袖', '', '118.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/3a27458f13c227d9.jpg.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/bc9c5ec7417416de.jpg.avif', '', null, null, '0', '0', '香奈儿', '女装');
INSERT INTO `clothing` VALUES ('86', '4', '44', '1', '2022创古法倒大袖旗袍改良纯棉提花夏季国风宽松', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/7a9ae70949af97bc.jpg.avif', '0025', '0', '1', '0', '0', '0', '0', '0', '178.00', null, '0', '0', '0', '2022创古法倒大袖旗袍改良纯棉提花夏季国风宽松', '', '178.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/23eaf37a4af4d666.jpg.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/058e82124bedbc74.jpg.avif', '', null, null, '0', '0', '新百伦', '女装');
INSERT INTO `clothing` VALUES ('87', '6', '44', '1', '复古日记国风女装新款雅致矜贵中国风仿真丝改良连衣裙', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/30d8a4f577d74319.jpg.avif', '0026', '0', '1', '0', '0', '0', '0', '0', '119.00', null, '0', '0', '0', '复古日记国风女装新款雅致矜贵中国风仿真丝改良连衣裙', '', '118.00', '1000', '0', '', '0.00', '0', '1,2,3', '', '', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/c8f6860b18f40e83.jpg.avif,https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/c884d40bee8ce834.jpg.avif', '', null, null, '0', '0', '香奈儿', '女装');
INSERT INTO `clothing` VALUES ('94', '50', '7', null, '11122', '', '', '1', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '11122', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', '阿玛施', '外套');
INSERT INTO `clothing` VALUES ('95', '49', '7', null, '111222', '', '', '1', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '111', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', '欧时力', '外套');
INSERT INTO `clothing` VALUES ('96', '2', '7', null, '111222', '', '', '1', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '111', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', null, null, '0', '0', '阿迪达斯', '外套');

-- ----------------------------
-- Table structure for `clothing_attribute`
-- ----------------------------
DROP TABLE IF EXISTS `clothing_attribute`;
CREATE TABLE `clothing_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `clothing_attribute_category_id` bigint(20) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `select_type` int(1) DEFAULT NULL COMMENT '属性选择类型：0->唯一；1->单选；2->多选',
  `input_type` int(1) DEFAULT NULL COMMENT '属性录入方式：0->手工录入；1->从列表中选取',
  `input_list` varchar(255) DEFAULT NULL COMMENT '可选值列表，以逗号隔开',
  `sort` int(11) DEFAULT NULL COMMENT '排序字段：最高的可以单独上传图片',
  `filter_type` int(1) DEFAULT NULL COMMENT '分类筛选样式：1->普通；1->颜色',
  `search_type` int(1) DEFAULT NULL COMMENT '检索类型；0->不需要进行检索；1->关键字检索；2->范围检索',
  `related_status` int(1) DEFAULT NULL COMMENT '相同属性产品是否关联；0->不关联；1->关联',
  `hand_add_status` int(1) DEFAULT NULL COMMENT '是否支持手动新增；0->不支持；1->支持',
  `type` int(1) DEFAULT NULL COMMENT '属性的类型；0->规格；1->参数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='商品属性参数表';

-- ----------------------------
-- Records of clothing_attribute
-- ----------------------------
INSERT INTO `clothing_attribute` VALUES ('1', '1', '尺寸', '2', '1', 'S,M,L,XL,2XL,3XL', '0', '0', '0', '0', '0', '0');
INSERT INTO `clothing_attribute` VALUES ('7', '1', '颜色', '2', '1', '黑色,红色,白色,粉色', '100', '0', '0', '0', '1', '0');
INSERT INTO `clothing_attribute` VALUES ('24', '1', '商品编号', '1', '0', '', '0', '0', '0', '0', '0', '1');
INSERT INTO `clothing_attribute` VALUES ('25', '1', '适用季节', '1', '1', '春季,夏季,秋季,冬季', '0', '0', '0', '0', '0', '1');
INSERT INTO `clothing_attribute` VALUES ('32', '2', '适用人群', '0', '1', '老年,青年,中年', '0', '0', '0', '0', '0', '1');
INSERT INTO `clothing_attribute` VALUES ('33', '2', '风格', '0', '1', '嘻哈风格,基础大众,商务正装', '0', '0', '0', '0', '0', '1');
INSERT INTO `clothing_attribute` VALUES ('35', '2', '颜色', '0', '0', '', '100', '0', '0', '0', '1', '0');
INSERT INTO `clothing_attribute` VALUES ('37', '1', '适用人群', '1', '1', '儿童,青年,中年,老年', '0', '0', '0', '0', '0', '1');
INSERT INTO `clothing_attribute` VALUES ('38', '1', '上市时间', '1', '1', '2022年秋,2022年冬,2022年春,2022年夏', '0', '0', '0', '0', '0', '1');
INSERT INTO `clothing_attribute` VALUES ('39', '1', '袖长', '1', '1', '短袖,长袖,中袖', '0', '0', '0', '0', '0', '1');
INSERT INTO `clothing_attribute` VALUES ('40', '2', '尺码', '0', '1', '29,30,31,32,33,34', '0', '0', '0', '0', '0', '0');
INSERT INTO `clothing_attribute` VALUES ('41', '2', '适用场景', '0', '1', '居家,运动,正装', '0', '0', '0', '0', '0', '1');
INSERT INTO `clothing_attribute` VALUES ('42', '2', '上市时间', '0', '1', '2018年春,2018年夏', '0', '0', '0', '0', '0', '1');

-- ----------------------------
-- Table structure for `clothing_attribute_category`
-- ----------------------------
DROP TABLE IF EXISTS `clothing_attribute_category`;
CREATE TABLE `clothing_attribute_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `attribute_count` int(11) DEFAULT '0' COMMENT '属性数量',
  `param_count` int(11) DEFAULT '0' COMMENT '参数数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='产品属性分类表';

-- ----------------------------
-- Records of clothing_attribute_category
-- ----------------------------
INSERT INTO `clothing_attribute_category` VALUES ('1', '服装-上衣', '2', '5');
INSERT INTO `clothing_attribute_category` VALUES ('2', '服装-裤装', '2', '4');

-- ----------------------------
-- Table structure for `clothing_attribute_value`
-- ----------------------------
DROP TABLE IF EXISTS `clothing_attribute_value`;
CREATE TABLE `clothing_attribute_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `clothing_id` bigint(20) DEFAULT NULL,
  `clothing_attribute_id` bigint(20) DEFAULT NULL,
  `value` varchar(64) DEFAULT NULL COMMENT '手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=658 DEFAULT CHARSET=utf8 COMMENT='存储产品参数信息的表';

-- ----------------------------
-- Records of clothing_attribute_value
-- ----------------------------
INSERT INTO `clothing_attribute_value` VALUES ('1', '9', '1', 'X');
INSERT INTO `clothing_attribute_value` VALUES ('2', '10', '1', 'X');
INSERT INTO `clothing_attribute_value` VALUES ('3', '11', '1', 'X');
INSERT INTO `clothing_attribute_value` VALUES ('4', '12', '1', 'X');
INSERT INTO `clothing_attribute_value` VALUES ('5', '13', '1', 'X');
INSERT INTO `clothing_attribute_value` VALUES ('6', '14', '1', 'X');
INSERT INTO `clothing_attribute_value` VALUES ('7', '18', '1', 'X');
INSERT INTO `clothing_attribute_value` VALUES ('8', '7', '1', 'X');
INSERT INTO `clothing_attribute_value` VALUES ('9', '7', '1', 'XL');
INSERT INTO `clothing_attribute_value` VALUES ('10', '7', '1', 'XXL');
INSERT INTO `clothing_attribute_value` VALUES ('11', '22', '7', 'x,xx');
INSERT INTO `clothing_attribute_value` VALUES ('12', '22', '24', 'no110');
INSERT INTO `clothing_attribute_value` VALUES ('13', '22', '25', '春季');
INSERT INTO `clothing_attribute_value` VALUES ('14', '22', '37', '青年');
INSERT INTO `clothing_attribute_value` VALUES ('15', '22', '38', '2018年春');
INSERT INTO `clothing_attribute_value` VALUES ('16', '22', '39', '长袖');
INSERT INTO `clothing_attribute_value` VALUES ('124', '23', '7', '米白色,浅黄色');
INSERT INTO `clothing_attribute_value` VALUES ('125', '23', '24', 'no1098');
INSERT INTO `clothing_attribute_value` VALUES ('126', '23', '25', '春季');
INSERT INTO `clothing_attribute_value` VALUES ('127', '23', '37', '青年');
INSERT INTO `clothing_attribute_value` VALUES ('128', '23', '38', '2018年春');
INSERT INTO `clothing_attribute_value` VALUES ('129', '23', '39', '长袖');
INSERT INTO `clothing_attribute_value` VALUES ('198', '30', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('199', '30', '25', '夏季');
INSERT INTO `clothing_attribute_value` VALUES ('200', '30', '37', '青年');
INSERT INTO `clothing_attribute_value` VALUES ('201', '30', '38', '2018年夏');
INSERT INTO `clothing_attribute_value` VALUES ('202', '30', '39', '短袖');
INSERT INTO `clothing_attribute_value` VALUES ('218', '28', '43', '金色,银色');
INSERT INTO `clothing_attribute_value` VALUES ('219', '28', '45', '5.0');
INSERT INTO `clothing_attribute_value` VALUES ('220', '28', '46', '4G');
INSERT INTO `clothing_attribute_value` VALUES ('221', '28', '47', 'Android');
INSERT INTO `clothing_attribute_value` VALUES ('222', '28', '48', '2800ml');
INSERT INTO `clothing_attribute_value` VALUES ('223', '29', '43', '金色,银色');
INSERT INTO `clothing_attribute_value` VALUES ('224', '29', '45', '4.7');
INSERT INTO `clothing_attribute_value` VALUES ('225', '29', '46', '4G');
INSERT INTO `clothing_attribute_value` VALUES ('226', '29', '47', 'IOS');
INSERT INTO `clothing_attribute_value` VALUES ('227', '29', '48', '1960ml');
INSERT INTO `clothing_attribute_value` VALUES ('238', '31', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('239', '31', '25', '夏季');
INSERT INTO `clothing_attribute_value` VALUES ('240', '31', '37', '青年');
INSERT INTO `clothing_attribute_value` VALUES ('241', '31', '38', '2018年夏');
INSERT INTO `clothing_attribute_value` VALUES ('242', '31', '39', '短袖');
INSERT INTO `clothing_attribute_value` VALUES ('272', '48', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('273', '48', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('274', '48', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('275', '48', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('276', '48', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('301', '49', '7', '黄色');
INSERT INTO `clothing_attribute_value` VALUES ('302', '49', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('303', '49', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('304', '49', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('305', '49', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('306', '49', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('307', '50', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('308', '50', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('309', '50', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('310', '50', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('311', '50', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('312', '51', '7', '黑色,白色');
INSERT INTO `clothing_attribute_value` VALUES ('313', '51', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('314', '51', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('315', '51', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('316', '51', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('317', '51', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('318', '52', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('319', '52', '25', '春季');
INSERT INTO `clothing_attribute_value` VALUES ('320', '52', '37', '儿童');
INSERT INTO `clothing_attribute_value` VALUES ('321', '52', '38', '2022年冬');
INSERT INTO `clothing_attribute_value` VALUES ('322', '52', '39', '长袖');
INSERT INTO `clothing_attribute_value` VALUES ('337', '53', '7', '红色,蓝色');
INSERT INTO `clothing_attribute_value` VALUES ('338', '53', '1', 'M,X,XL');
INSERT INTO `clothing_attribute_value` VALUES ('339', '53', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('340', '53', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('341', '53', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('342', '53', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('343', '53', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('421', '1', '7', '蓝色,红色,绿色');
INSERT INTO `clothing_attribute_value` VALUES ('422', '1', '1', 'S,M,L,XL,2XL');
INSERT INTO `clothing_attribute_value` VALUES ('423', '1', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('424', '1', '25', '春季');
INSERT INTO `clothing_attribute_value` VALUES ('425', '1', '37', '儿童');
INSERT INTO `clothing_attribute_value` VALUES ('426', '1', '38', '2022年秋');
INSERT INTO `clothing_attribute_value` VALUES ('427', '1', '39', '短袖');
INSERT INTO `clothing_attribute_value` VALUES ('428', '47', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('429', '47', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('430', '47', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('431', '47', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('432', '47', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('454', '2', '7', '黑色,白色,红色,蓝色');
INSERT INTO `clothing_attribute_value` VALUES ('455', '2', '1', 'S,L,XL,M');
INSERT INTO `clothing_attribute_value` VALUES ('456', '2', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('457', '2', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('458', '2', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('459', '2', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('460', '2', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('461', '61', '7', '卡其色,黑色,浅蓝色');
INSERT INTO `clothing_attribute_value` VALUES ('462', '61', '1', 'S,M,L,XL,2XL');
INSERT INTO `clothing_attribute_value` VALUES ('463', '61', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('464', '61', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('465', '61', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('466', '61', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('467', '61', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('468', '62', '7', '白色,黑色,深灰色');
INSERT INTO `clothing_attribute_value` VALUES ('469', '62', '1', 'S,XL,L,2XL');
INSERT INTO `clothing_attribute_value` VALUES ('470', '62', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('471', '62', '25', '夏季');
INSERT INTO `clothing_attribute_value` VALUES ('472', '62', '37', '青年');
INSERT INTO `clothing_attribute_value` VALUES ('473', '62', '38', '2022年夏');
INSERT INTO `clothing_attribute_value` VALUES ('474', '62', '39', '短袖');
INSERT INTO `clothing_attribute_value` VALUES ('475', '63', '35', '中蓝色,宝蓝色,黑色');
INSERT INTO `clothing_attribute_value` VALUES ('476', '63', '40', '30,29,31,32,33');
INSERT INTO `clothing_attribute_value` VALUES ('477', '63', '32', null);
INSERT INTO `clothing_attribute_value` VALUES ('478', '63', '33', null);
INSERT INTO `clothing_attribute_value` VALUES ('479', '63', '41', null);
INSERT INTO `clothing_attribute_value` VALUES ('480', '63', '42', null);
INSERT INTO `clothing_attribute_value` VALUES ('481', '64', '7', '大红,叶绿色,黑色');
INSERT INTO `clothing_attribute_value` VALUES ('482', '64', '1', 'S,M,L,XL');
INSERT INTO `clothing_attribute_value` VALUES ('483', '64', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('484', '64', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('485', '64', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('486', '64', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('487', '64', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('488', '65', '35', '黑色,深蓝色');
INSERT INTO `clothing_attribute_value` VALUES ('489', '65', '40', '29,30');
INSERT INTO `clothing_attribute_value` VALUES ('490', '65', '32', null);
INSERT INTO `clothing_attribute_value` VALUES ('491', '65', '33', null);
INSERT INTO `clothing_attribute_value` VALUES ('492', '65', '41', null);
INSERT INTO `clothing_attribute_value` VALUES ('493', '65', '42', null);
INSERT INTO `clothing_attribute_value` VALUES ('494', '66', '7', '黑色,深蓝色,灰色');
INSERT INTO `clothing_attribute_value` VALUES ('495', '66', '1', 'M,L,XL,2XL,3XL');
INSERT INTO `clothing_attribute_value` VALUES ('496', '66', '24', '0006');
INSERT INTO `clothing_attribute_value` VALUES ('497', '66', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('498', '66', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('499', '66', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('500', '66', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('501', '67', '7', '白色,黑色,橙色');
INSERT INTO `clothing_attribute_value` VALUES ('502', '67', '1', 'L,XL,2XL,3XL');
INSERT INTO `clothing_attribute_value` VALUES ('503', '67', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('504', '67', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('505', '67', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('506', '67', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('507', '67', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('508', '68', '7', '白色,黑色,粉色');
INSERT INTO `clothing_attribute_value` VALUES ('509', '68', '1', 'L,XL,2XL,3XL');
INSERT INTO `clothing_attribute_value` VALUES ('510', '68', '24', '0008');
INSERT INTO `clothing_attribute_value` VALUES ('511', '68', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('512', '68', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('513', '68', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('514', '68', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('515', '69', '35', '黑色,灰色');
INSERT INTO `clothing_attribute_value` VALUES ('516', '69', '40', '29,30,31,32');
INSERT INTO `clothing_attribute_value` VALUES ('517', '69', '32', null);
INSERT INTO `clothing_attribute_value` VALUES ('518', '69', '33', null);
INSERT INTO `clothing_attribute_value` VALUES ('519', '69', '41', null);
INSERT INTO `clothing_attribute_value` VALUES ('520', '69', '42', null);
INSERT INTO `clothing_attribute_value` VALUES ('521', '70', '35', '黑色,灰色,深灰色');
INSERT INTO `clothing_attribute_value` VALUES ('522', '70', '40', '30,31,29,32');
INSERT INTO `clothing_attribute_value` VALUES ('523', '70', '32', null);
INSERT INTO `clothing_attribute_value` VALUES ('524', '70', '33', null);
INSERT INTO `clothing_attribute_value` VALUES ('525', '70', '41', null);
INSERT INTO `clothing_attribute_value` VALUES ('526', '70', '42', null);
INSERT INTO `clothing_attribute_value` VALUES ('527', '71', '7', '黑色,灰色');
INSERT INTO `clothing_attribute_value` VALUES ('528', '71', '1', 'M,L,XL,2XL');
INSERT INTO `clothing_attribute_value` VALUES ('529', '71', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('530', '71', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('531', '71', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('532', '71', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('533', '71', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('534', '72', '7', '黑色,蓝色');
INSERT INTO `clothing_attribute_value` VALUES ('535', '72', '1', 'M,L,XL,2XL,3XL');
INSERT INTO `clothing_attribute_value` VALUES ('536', '72', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('537', '72', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('538', '72', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('539', '72', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('540', '72', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('541', '73', '7', '黑色,深灰色,白色');
INSERT INTO `clothing_attribute_value` VALUES ('542', '73', '1', 'L,M,XL,2XL');
INSERT INTO `clothing_attribute_value` VALUES ('543', '73', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('544', '73', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('545', '73', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('546', '73', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('547', '73', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('548', '74', '7', '白色,黑色,蓝色');
INSERT INTO `clothing_attribute_value` VALUES ('549', '74', '1', 'M,L,XL,2XL');
INSERT INTO `clothing_attribute_value` VALUES ('550', '74', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('551', '74', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('552', '74', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('553', '74', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('554', '74', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('555', '75', '35', '黑色,浅蓝色');
INSERT INTO `clothing_attribute_value` VALUES ('556', '75', '40', '29,30,31,32');
INSERT INTO `clothing_attribute_value` VALUES ('557', '75', '32', null);
INSERT INTO `clothing_attribute_value` VALUES ('558', '75', '33', null);
INSERT INTO `clothing_attribute_value` VALUES ('559', '75', '41', null);
INSERT INTO `clothing_attribute_value` VALUES ('560', '75', '42', null);
INSERT INTO `clothing_attribute_value` VALUES ('561', '76', '7', '黑色,咖啡色');
INSERT INTO `clothing_attribute_value` VALUES ('562', '76', '1', 'M,L,XL,2XL');
INSERT INTO `clothing_attribute_value` VALUES ('563', '76', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('564', '76', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('565', '76', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('566', '76', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('567', '76', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('568', '77', '7', '白色,绿色,黑色,橘色');
INSERT INTO `clothing_attribute_value` VALUES ('569', '77', '1', 'S,M,L,XL');
INSERT INTO `clothing_attribute_value` VALUES ('570', '77', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('571', '77', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('572', '77', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('573', '77', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('574', '77', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('575', '78', '7', '黑色,灰色,白色');
INSERT INTO `clothing_attribute_value` VALUES ('576', '78', '1', 'M,L,XL,2XL');
INSERT INTO `clothing_attribute_value` VALUES ('577', '78', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('578', '78', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('579', '78', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('580', '78', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('581', '78', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('582', '79', '7', '褐色,黑色');
INSERT INTO `clothing_attribute_value` VALUES ('583', '79', '1', 'M,S,L,XL');
INSERT INTO `clothing_attribute_value` VALUES ('584', '79', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('585', '79', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('586', '79', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('587', '79', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('588', '79', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('596', '80', '7', '白色,黑色,白蓝色');
INSERT INTO `clothing_attribute_value` VALUES ('597', '80', '1', 'M,L,XL,2XL');
INSERT INTO `clothing_attribute_value` VALUES ('598', '80', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('599', '80', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('600', '80', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('601', '80', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('602', '80', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('603', '81', '35', '米白色');
INSERT INTO `clothing_attribute_value` VALUES ('604', '81', '40', '29,30,31,32,33');
INSERT INTO `clothing_attribute_value` VALUES ('605', '81', '32', null);
INSERT INTO `clothing_attribute_value` VALUES ('606', '81', '33', null);
INSERT INTO `clothing_attribute_value` VALUES ('607', '81', '41', null);
INSERT INTO `clothing_attribute_value` VALUES ('608', '81', '42', null);
INSERT INTO `clothing_attribute_value` VALUES ('609', '82', '7', '白色');
INSERT INTO `clothing_attribute_value` VALUES ('610', '82', '1', 'S,M,L,XL,2XL,3XL');
INSERT INTO `clothing_attribute_value` VALUES ('611', '82', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('612', '82', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('613', '82', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('614', '82', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('615', '82', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('616', '83', '7', '白色,米白色');
INSERT INTO `clothing_attribute_value` VALUES ('617', '83', '1', 'S,M,L,XL,2XL');
INSERT INTO `clothing_attribute_value` VALUES ('618', '83', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('619', '83', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('620', '83', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('621', '83', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('622', '83', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('623', '84', '7', '白色,灰色');
INSERT INTO `clothing_attribute_value` VALUES ('624', '84', '1', 'M,L,XL,2XL');
INSERT INTO `clothing_attribute_value` VALUES ('625', '84', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('626', '84', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('627', '84', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('628', '84', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('629', '84', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('630', '85', '7', '白色,金色');
INSERT INTO `clothing_attribute_value` VALUES ('631', '85', '1', 'S,M,L,XL,2XL');
INSERT INTO `clothing_attribute_value` VALUES ('632', '85', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('633', '85', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('634', '85', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('635', '85', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('636', '85', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('637', '86', '7', '灰色');
INSERT INTO `clothing_attribute_value` VALUES ('638', '86', '1', 'S,M,L,XL');
INSERT INTO `clothing_attribute_value` VALUES ('639', '86', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('640', '86', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('641', '86', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('642', '86', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('643', '86', '39', null);
INSERT INTO `clothing_attribute_value` VALUES ('651', '87', '7', '黑色');
INSERT INTO `clothing_attribute_value` VALUES ('652', '87', '1', 'S,M,L,XL,2XL');
INSERT INTO `clothing_attribute_value` VALUES ('653', '87', '24', null);
INSERT INTO `clothing_attribute_value` VALUES ('654', '87', '25', null);
INSERT INTO `clothing_attribute_value` VALUES ('655', '87', '37', null);
INSERT INTO `clothing_attribute_value` VALUES ('656', '87', '38', null);
INSERT INTO `clothing_attribute_value` VALUES ('657', '87', '39', null);

-- ----------------------------
-- Table structure for `clothing_brand`
-- ----------------------------
DROP TABLE IF EXISTS `clothing_brand`;
CREATE TABLE `clothing_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `first_letter` varchar(8) DEFAULT NULL COMMENT '首字母',
  `sort` int(11) DEFAULT NULL,
  `factory_status` int(1) DEFAULT NULL COMMENT '是否为品牌制造商：0->不是；1->是',
  `show_status` int(1) DEFAULT NULL,
  `clothing_count` int(11) DEFAULT NULL COMMENT '产品数量',
  `clothing_comment_count` int(11) DEFAULT NULL COMMENT '产品评论数量',
  `logo` varchar(255) DEFAULT NULL COMMENT '品牌logo',
  `big_pic` varchar(255) DEFAULT NULL COMMENT '专区大图',
  `brand_story` text COMMENT '品牌故事',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='品牌表';

-- ----------------------------
-- Records of clothing_brand
-- ----------------------------
INSERT INTO `clothing_brand` VALUES ('1', '耐克', 'N', '0', '1', '1', '100', '100', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/brand/clothing-brand/nike.jpg\r\nhttps://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/brand/clothing-brand/nike.jpg\r\n', '', null);
INSERT INTO `clothing_brand` VALUES ('2', '阿迪达斯', 'A', '100', '1', '1', '100', '100', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/brand/clothing-brand/adidas.jpg', null, null);
INSERT INTO `clothing_brand` VALUES ('3', '彪马', 'B', '100', '1', '0', '100', '100', '\r\nhttps://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/brand/clothing-brand/puma.jpg', null, null);
INSERT INTO `clothing_brand` VALUES ('4', '新百伦', 'X', '30', '1', '0', '100', '100', '\r\nhttps://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/brand/clothing-brand/new-balance.jpg', null, null);
INSERT INTO `clothing_brand` VALUES ('5', '太平鸟', 'T', '20', '1', '0', '100', '100', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg (4).jpg', null, null);
INSERT INTO `clothing_brand` VALUES ('6', '香奈儿', 'X', '500', '1', '1', '100', '100', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/brand/clothing-brand/CHANEL.jpg', '', null);
INSERT INTO `clothing_brand` VALUES ('21', '优衣库', 'Y', '0', '1', '1', '88', '500', '\r\nhttps://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/brand/clothing-brand/UNIQLO.jpg', '', null);
INSERT INTO `clothing_brand` VALUES ('49', '欧时力', 'O', '200', '1', '1', '77', '400', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/brand/clothing-brand/ochirly.jpg', null, null);
INSERT INTO `clothing_brand` VALUES ('50', '阿玛施', 'A', '200', '1', '1', '66', '300', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/LOGO1024.png', '', null);
INSERT INTO `clothing_brand` VALUES ('51', 'LV', 'L', '200', '1', '1', '55', '200', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg', null, null);
INSERT INTO `clothing_brand` VALUES ('58', 'Vans', 'V', '0', '1', '1', '33', '100', '\r\nhttps://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/brand/clothing-brand/VANS.jpg', '', null);

-- ----------------------------
-- Table structure for `clothing_cart`
-- ----------------------------
DROP TABLE IF EXISTS `clothing_cart`;
CREATE TABLE `clothing_cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '购物车id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `clothing_id` bigint(20) NOT NULL COMMENT '服装id',
  `clothing_num` bigint(20) DEFAULT '1' COMMENT '服装数量',
  `clothing_color` varchar(64) DEFAULT NULL COMMENT '服装颜色',
  `clothing_size` varchar(64) DEFAULT NULL COMMENT '服装尺码',
  `entry_time` datetime DEFAULT NULL COMMENT '加入时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clothing_cart
-- ----------------------------
INSERT INTO `clothing_cart` VALUES ('27', '7', '1', '1', '红色', 'L', '2022-03-24 09:31:31');
INSERT INTO `clothing_cart` VALUES ('28', '7', '61', '1', '卡其色', 'L', '2022-05-02 12:07:16');
INSERT INTO `clothing_cart` VALUES ('29', '7', '68', '1', '白色', 'XL', '2022-05-02 12:08:03');
INSERT INTO `clothing_cart` VALUES ('30', '7', '72', '1', '黑色', 'XL', '2022-05-02 12:12:07');
INSERT INTO `clothing_cart` VALUES ('31', '7', '63', '1', '', '', '2022-05-02 12:12:39');
INSERT INTO `clothing_cart` VALUES ('32', '7', '62', '1', '黑色', 'XL', '2022-05-02 12:13:04');
INSERT INTO `clothing_cart` VALUES ('33', '7', '69', '1', '灰色', '30', '2022-05-03 10:22:54');
INSERT INTO `clothing_cart` VALUES ('35', '7', '66', '1', '深蓝色', '2XL', '2022-05-07 12:46:20');
INSERT INTO `clothing_cart` VALUES ('37', '7', '64', '1', '叶绿色', 'L', '2022-05-07 12:51:01');

-- ----------------------------
-- Table structure for `clothing_category`
-- ----------------------------
DROP TABLE IF EXISTS `clothing_category`;
CREATE TABLE `clothing_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上机分类的编号：0表示一级分类',
  `name` varchar(64) DEFAULT NULL,
  `level` int(1) DEFAULT NULL COMMENT '分类级别：0->1级；1->2级',
  `clothing_count` int(11) DEFAULT NULL,
  `clothing_unit` varchar(64) DEFAULT NULL,
  `nav_status` int(1) DEFAULT NULL COMMENT '是否显示在导航栏：0->不显示；1->显示',
  `show_status` int(1) DEFAULT NULL COMMENT '显示状态：0->不显示；1->显示',
  `sort` int(11) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `keywords` varchar(255) DEFAULT NULL,
  `description` text COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COMMENT='产品分类';

-- ----------------------------
-- Records of clothing_category
-- ----------------------------
INSERT INTO `clothing_category` VALUES ('1', '0', '潮牌服饰', '0', '100', '件', '1', '1', '1', null, '服装', '服装分类');
INSERT INTO `clothing_category` VALUES ('2', '0', '简约舒适', '0', '100', '件', '1', '1', '1', null, '服装', '服装分类');
INSERT INTO `clothing_category` VALUES ('3', '0', '运动服饰', '0', '100', '件', '1', '1', '1', null, '服装', '服装分类');
INSERT INTO `clothing_category` VALUES ('4', '0', '国风潮流', '0', '100', '件', '1', '1', '1', null, '服装', '服装分类');
INSERT INTO `clothing_category` VALUES ('5', '0', '其他', '0', '100', '件', '1', '1', '1', null, '服装', '服装分类');
INSERT INTO `clothing_category` VALUES ('7', '1', '外套', '1', '100', '件', '1', '1', '0', '', '服装', '外套');
INSERT INTO `clothing_category` VALUES ('8', '1', 'T恤', '1', '100', '件', '1', '1', '0', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', '服装', 'T恤');
INSERT INTO `clothing_category` VALUES ('9', '1', '休闲裤', '1', '100', '件', '1', '1', '0', null, '服装', '休闲裤');
INSERT INTO `clothing_category` VALUES ('10', '1', '牛仔裤', '1', '100', '件', '1', '1', '0', null, '服装', '牛仔裤');
INSERT INTO `clothing_category` VALUES ('11', '1', '衬衫', '1', '100', '件', '1', '1', '0', null, '服装', null);
INSERT INTO `clothing_category` VALUES ('12', '1', '短裤', '1', '100', '件', '0', '0', '0', '', '服装', null);
INSERT INTO `clothing_category` VALUES ('29', '2', '长袖', '1', '100', '件', '0', '0', '0', '', '服装', '');
INSERT INTO `clothing_category` VALUES ('30', '2', '外套', '1', '100', '件', '0', '0', '0', '', '服装', null);
INSERT INTO `clothing_category` VALUES ('31', '2', 'T恤', '1', '100', '件', '0', '0', '0', '', '服装', '');
INSERT INTO `clothing_category` VALUES ('32', '2', '长裤', '1', '100', '件', '0', '0', '0', '', '服装', '');
INSERT INTO `clothing_category` VALUES ('33', '2', '短裤', '1', '100', '件', '0', '0', '0', '', '服装', '');
INSERT INTO `clothing_category` VALUES ('34', '2', '短袖', '1', '100', '件', '0', '0', '0', '', '服装', '');
INSERT INTO `clothing_category` VALUES ('35', '3', '外套', '1', '100', '件', '0', '0', '0', '', '服装', '');
INSERT INTO `clothing_category` VALUES ('36', '3', '长袖', '1', '100', '件', '0', '0', '0', '', '服装', '');
INSERT INTO `clothing_category` VALUES ('37', '3', '短袖', '1', '0', '', '0', '0', '0', '', '', '');
INSERT INTO `clothing_category` VALUES ('38', '3', '长裤', '1', '0', '', '0', '0', '0', '', '', '');
INSERT INTO `clothing_category` VALUES ('39', '3', '短裤', '1', '0', '', '0', '0', '0', '', '', '');
INSERT INTO `clothing_category` VALUES ('40', '3', '高领', '1', '0', '', '0', '0', '0', '', '', '');
INSERT INTO `clothing_category` VALUES ('41', '3', '短外套', '1', '0', '', '0', '0', '0', '', '', '');
INSERT INTO `clothing_category` VALUES ('43', '4', '男装', '1', '0', '', '0', '0', '0', '', '', '');
INSERT INTO `clothing_category` VALUES ('44', '4', '女装', '1', '0', '', '0', '0', '0', '', '', '');
INSERT INTO `clothing_category` VALUES ('45', '4', '外套', '1', '0', '', '0', '0', '0', '', '', '');
INSERT INTO `clothing_category` VALUES ('46', '4', '高领帅气', '1', '0', '', '0', '0', '0', '', '', '');
INSERT INTO `clothing_category` VALUES ('47', '4', '裤子', '1', '0', '', '0', '0', '0', '', '', '');
INSERT INTO `clothing_category` VALUES ('48', '5', '破洞裤', '1', '0', '', '0', '0', '0', '', '', '');
INSERT INTO `clothing_category` VALUES ('49', '5', '外套', '1', '0', '', '0', '0', '0', '', '', '');
INSERT INTO `clothing_category` VALUES ('50', '5', '毛衣', '1', '0', '', '0', '0', '0', '', '', '');
INSERT INTO `clothing_category` VALUES ('51', '5', '牛仔裤', '1', '0', '', '0', '0', '0', '', '', '');
INSERT INTO `clothing_category` VALUES ('52', '5', '短袖', '1', '100', '件', '0', '0', '0', null, '服装', null);

-- ----------------------------
-- Table structure for `clothing_category_attribute_relation`
-- ----------------------------
DROP TABLE IF EXISTS `clothing_category_attribute_relation`;
CREATE TABLE `clothing_category_attribute_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `clothing_category_id` bigint(20) DEFAULT NULL,
  `clothing_attribute_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类）';

-- ----------------------------
-- Records of clothing_category_attribute_relation
-- ----------------------------
INSERT INTO `clothing_category_attribute_relation` VALUES ('1', '24', '24');
INSERT INTO `clothing_category_attribute_relation` VALUES ('5', '26', '24');
INSERT INTO `clothing_category_attribute_relation` VALUES ('7', '28', '24');
INSERT INTO `clothing_category_attribute_relation` VALUES ('9', '25', '24');
INSERT INTO `clothing_category_attribute_relation` VALUES ('10', '25', '25');
INSERT INTO `clothing_category_attribute_relation` VALUES ('11', '53', '24');

-- ----------------------------
-- Table structure for `clothing_full_reduction`
-- ----------------------------
DROP TABLE IF EXISTS `clothing_full_reduction`;
CREATE TABLE `clothing_full_reduction` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `clothing_id` bigint(20) DEFAULT NULL,
  `full_price` decimal(10,2) DEFAULT NULL,
  `reduce_price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=158 DEFAULT CHARSET=utf8 COMMENT='产品满减表(只针对同商品)';

-- ----------------------------
-- Records of clothing_full_reduction
-- ----------------------------
INSERT INTO `clothing_full_reduction` VALUES ('1', '7', '100.00', '20.00');
INSERT INTO `clothing_full_reduction` VALUES ('2', '8', '100.00', '20.00');
INSERT INTO `clothing_full_reduction` VALUES ('3', '9', '100.00', '20.00');
INSERT INTO `clothing_full_reduction` VALUES ('4', '10', '100.00', '20.00');
INSERT INTO `clothing_full_reduction` VALUES ('5', '11', '100.00', '20.00');
INSERT INTO `clothing_full_reduction` VALUES ('6', '12', '100.00', '20.00');
INSERT INTO `clothing_full_reduction` VALUES ('7', '13', '100.00', '20.00');
INSERT INTO `clothing_full_reduction` VALUES ('8', '14', '100.00', '20.00');
INSERT INTO `clothing_full_reduction` VALUES ('9', '18', '100.00', '20.00');
INSERT INTO `clothing_full_reduction` VALUES ('10', '7', '200.00', '50.00');
INSERT INTO `clothing_full_reduction` VALUES ('11', '7', '300.00', '100.00');
INSERT INTO `clothing_full_reduction` VALUES ('14', '22', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('16', '24', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('34', '23', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('46', '32', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('48', '33', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('55', '34', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('56', '30', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('60', '28', '500.00', '50.00');
INSERT INTO `clothing_full_reduction` VALUES ('61', '28', '1000.00', '120.00');
INSERT INTO `clothing_full_reduction` VALUES ('62', '29', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('78', '36', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('79', '35', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('86', '27', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('87', '37', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('88', '38', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('91', '39', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('92', '40', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('95', '41', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('96', '42', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('97', '43', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('98', '44', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('100', '26', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('101', '46', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('102', '31', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('104', '48', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('105', '49', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('106', '50', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('107', '51', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('108', '52', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('111', '53', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('112', '47', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('114', '54', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('117', '61', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('118', '62', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('119', '63', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('120', '64', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('121', '65', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('122', '66', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('123', '67', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('124', '68', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('125', '69', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('126', '70', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('127', '71', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('128', '72', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('129', '73', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('130', '74', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('131', '75', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('132', '76', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('133', '77', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('134', '78', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('135', '79', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('137', '80', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('138', '81', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('139', '82', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('140', '83', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('141', '84', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('142', '85', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('143', '86', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('145', '88', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('146', '89', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('147', '90', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('148', '91', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('149', '92', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('150', '93', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('152', '94', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('153', '87', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('155', '95', '0.00', '0.00');
INSERT INTO `clothing_full_reduction` VALUES ('157', '96', '0.00', '0.00');

-- ----------------------------
-- Table structure for `clothing_ladder`
-- ----------------------------
DROP TABLE IF EXISTS `clothing_ladder`;
CREATE TABLE `clothing_ladder` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `clothing_id` bigint(20) DEFAULT NULL,
  `count` int(11) DEFAULT NULL COMMENT '满足的商品数量',
  `discount` decimal(10,2) DEFAULT NULL COMMENT '折扣',
  `price` decimal(10,2) DEFAULT NULL COMMENT '折后价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=170 DEFAULT CHARSET=utf8 COMMENT='产品阶梯价格表(只针对同商品)';

-- ----------------------------
-- Records of clothing_ladder
-- ----------------------------
INSERT INTO `clothing_ladder` VALUES ('1', '7', '3', '0.70', '0.00');
INSERT INTO `clothing_ladder` VALUES ('2', '8', '3', '0.70', '0.00');
INSERT INTO `clothing_ladder` VALUES ('3', '9', '3', '0.70', '0.00');
INSERT INTO `clothing_ladder` VALUES ('4', '10', '3', '0.70', '0.00');
INSERT INTO `clothing_ladder` VALUES ('5', '11', '3', '0.70', '0.00');
INSERT INTO `clothing_ladder` VALUES ('6', '12', '3', '0.70', '0.00');
INSERT INTO `clothing_ladder` VALUES ('7', '13', '3', '0.70', '0.00');
INSERT INTO `clothing_ladder` VALUES ('8', '14', '3', '0.70', '0.00');
INSERT INTO `clothing_ladder` VALUES ('12', '18', '3', '0.70', '0.00');
INSERT INTO `clothing_ladder` VALUES ('14', '7', '4', '0.60', '0.00');
INSERT INTO `clothing_ladder` VALUES ('15', '7', '5', '0.50', '0.00');
INSERT INTO `clothing_ladder` VALUES ('18', '22', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('20', '24', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('38', '23', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('50', '32', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('52', '33', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('59', '34', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('60', '30', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('66', '28', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('67', '29', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('83', '36', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('84', '35', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('97', '27', '2', '0.80', '0.00');
INSERT INTO `clothing_ladder` VALUES ('98', '27', '3', '0.75', '0.00');
INSERT INTO `clothing_ladder` VALUES ('99', '37', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('100', '38', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('103', '39', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('104', '40', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('107', '41', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('108', '42', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('109', '43', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('110', '44', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('112', '26', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('113', '46', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('114', '31', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('116', '48', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('117', '49', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('118', '50', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('119', '51', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('120', '52', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('123', '53', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('124', '47', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('126', '54', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('129', '61', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('130', '62', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('131', '63', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('132', '64', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('133', '65', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('134', '66', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('135', '67', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('136', '68', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('137', '69', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('138', '70', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('139', '71', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('140', '72', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('141', '73', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('142', '74', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('143', '75', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('144', '76', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('145', '77', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('146', '78', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('147', '79', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('149', '80', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('150', '81', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('151', '82', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('152', '83', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('153', '84', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('154', '85', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('155', '86', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('157', '88', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('158', '89', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('159', '90', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('160', '91', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('161', '92', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('162', '93', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('164', '94', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('165', '87', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('167', '95', '0', '0.00', '0.00');
INSERT INTO `clothing_ladder` VALUES ('169', '96', '0', '0.00', '0.00');

-- ----------------------------
-- Table structure for `company_address`
-- ----------------------------
DROP TABLE IF EXISTS `company_address`;
CREATE TABLE `company_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address_name` varchar(200) DEFAULT NULL COMMENT '地址名称',
  `send_status` int(1) DEFAULT NULL COMMENT '默认发货地址：0->否；1->是',
  `receive_status` int(1) DEFAULT NULL COMMENT '是否默认收货地址：0->否；1->是',
  `name` varchar(64) DEFAULT NULL COMMENT '收发货人姓名',
  `phone` varchar(64) DEFAULT NULL COMMENT '收货人电话',
  `province` varchar(64) DEFAULT NULL COMMENT '省/直辖市',
  `city` varchar(64) DEFAULT NULL COMMENT '市',
  `region` varchar(64) DEFAULT NULL COMMENT '区',
  `detail_address` varchar(200) DEFAULT NULL COMMENT '详细地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='公司收发货地址表';

-- ----------------------------
-- Records of company_address
-- ----------------------------
INSERT INTO `company_address` VALUES ('1', '深圳发货点', '1', '1', '大梨', '18000000000', '广东省', '深圳市', '南山区', '科兴科学园');
INSERT INTO `company_address` VALUES ('2', '北京发货点', '0', '0', '大梨', '18000000000', '北京市', null, '南山区', '科兴科学园');
INSERT INTO `company_address` VALUES ('3', '南京发货点', '0', '0', '大梨', '18000000000', '江苏省', '南京市', '南山区', '科兴科学园');

-- ----------------------------
-- Table structure for `member_price`
-- ----------------------------
DROP TABLE IF EXISTS `member_price`;
CREATE TABLE `member_price` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `clothing_id` bigint(20) DEFAULT NULL,
  `member_level_id` bigint(20) DEFAULT NULL,
  `member_price` decimal(10,2) DEFAULT NULL COMMENT '会员价格',
  `member_level_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=288 DEFAULT CHARSET=utf8 COMMENT='商品会员价格表';

-- ----------------------------
-- Records of member_price
-- ----------------------------
INSERT INTO `member_price` VALUES ('26', '7', '1', '500.00', null);
INSERT INTO `member_price` VALUES ('27', '8', '1', '500.00', null);
INSERT INTO `member_price` VALUES ('28', '9', '1', '500.00', null);
INSERT INTO `member_price` VALUES ('29', '10', '1', '500.00', null);
INSERT INTO `member_price` VALUES ('30', '11', '1', '500.00', null);
INSERT INTO `member_price` VALUES ('31', '12', '1', '500.00', null);
INSERT INTO `member_price` VALUES ('32', '13', '1', '500.00', null);
INSERT INTO `member_price` VALUES ('33', '14', '1', '500.00', null);
INSERT INTO `member_price` VALUES ('37', '18', '1', '500.00', null);
INSERT INTO `member_price` VALUES ('44', '7', '2', '480.00', null);
INSERT INTO `member_price` VALUES ('45', '7', '3', '450.00', null);
INSERT INTO `member_price` VALUES ('52', '22', '1', null, null);
INSERT INTO `member_price` VALUES ('53', '22', '2', null, null);
INSERT INTO `member_price` VALUES ('54', '22', '3', null, null);
INSERT INTO `member_price` VALUES ('58', '24', '1', null, null);
INSERT INTO `member_price` VALUES ('59', '24', '2', null, null);
INSERT INTO `member_price` VALUES ('60', '24', '3', null, null);
INSERT INTO `member_price` VALUES ('112', '23', '1', '88.00', '黄金会员');
INSERT INTO `member_price` VALUES ('113', '23', '2', '88.00', '白金会员');
INSERT INTO `member_price` VALUES ('114', '23', '3', '66.00', '钻石会员');
INSERT INTO `member_price` VALUES ('148', '32', '1', null, '黄金会员');
INSERT INTO `member_price` VALUES ('149', '32', '2', null, '白金会员');
INSERT INTO `member_price` VALUES ('150', '32', '3', null, '钻石会员');
INSERT INTO `member_price` VALUES ('154', '33', '1', null, '黄金会员');
INSERT INTO `member_price` VALUES ('155', '33', '2', null, '白金会员');
INSERT INTO `member_price` VALUES ('156', '33', '3', null, '钻石会员');
INSERT INTO `member_price` VALUES ('175', '34', '1', null, '黄金会员');
INSERT INTO `member_price` VALUES ('176', '34', '2', null, '白金会员');
INSERT INTO `member_price` VALUES ('177', '34', '3', null, '钻石会员');
INSERT INTO `member_price` VALUES ('178', '30', '1', null, '黄金会员');
INSERT INTO `member_price` VALUES ('179', '30', '2', null, '白金会员');
INSERT INTO `member_price` VALUES ('180', '30', '3', null, '钻石会员');
INSERT INTO `member_price` VALUES ('195', '28', '1', null, '黄金会员');
INSERT INTO `member_price` VALUES ('196', '28', '2', null, '白金会员');
INSERT INTO `member_price` VALUES ('197', '28', '3', null, '钻石会员');
INSERT INTO `member_price` VALUES ('198', '29', '1', null, '黄金会员');
INSERT INTO `member_price` VALUES ('199', '29', '2', null, '白金会员');
INSERT INTO `member_price` VALUES ('200', '29', '3', null, '钻石会员');
INSERT INTO `member_price` VALUES ('246', '36', '1', null, '黄金会员');
INSERT INTO `member_price` VALUES ('247', '36', '2', null, '白金会员');
INSERT INTO `member_price` VALUES ('248', '36', '3', null, '钻石会员');
INSERT INTO `member_price` VALUES ('249', '35', '1', null, '黄金会员');
INSERT INTO `member_price` VALUES ('250', '35', '2', null, '白金会员');
INSERT INTO `member_price` VALUES ('251', '35', '3', null, '钻石会员');
INSERT INTO `member_price` VALUES ('270', '27', '1', null, '黄金会员');
INSERT INTO `member_price` VALUES ('271', '27', '2', null, '白金会员');
INSERT INTO `member_price` VALUES ('272', '27', '3', null, '钻石会员');
INSERT INTO `member_price` VALUES ('282', '26', '1', null, '黄金会员');
INSERT INTO `member_price` VALUES ('283', '26', '2', null, '白金会员');
INSERT INTO `member_price` VALUES ('284', '26', '3', null, '钻石会员');
INSERT INTO `member_price` VALUES ('285', '31', '1', null, '黄金会员');
INSERT INTO `member_price` VALUES ('286', '31', '2', null, '白金会员');
INSERT INTO `member_price` VALUES ('287', '31', '3', null, '钻石会员');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `member_id` bigint(20) DEFAULT NULL,
  `coupon_id` bigint(20) DEFAULT NULL,
  `order_sn` varchar(64) DEFAULT NULL COMMENT '订单编号',
  `create_time` datetime DEFAULT NULL COMMENT '提交时间',
  `member_username` varchar(64) DEFAULT NULL COMMENT '用户帐号',
  `total_amount` decimal(10,2) DEFAULT NULL COMMENT '订单总金额',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '应付金额（实际支付金额）',
  `freight_amount` decimal(10,2) DEFAULT NULL COMMENT '运费金额',
  `promotion_amount` decimal(10,2) DEFAULT '0.00' COMMENT '促销优化金额（促销价、满减、阶梯价）',
  `integration_amount` decimal(10,2) DEFAULT '0.00' COMMENT '积分抵扣金额',
  `coupon_amount` decimal(10,2) DEFAULT NULL COMMENT '优惠券抵扣金额',
  `discount_amount` decimal(10,2) DEFAULT '0.00' COMMENT '管理员后台调整订单使用的折扣金额',
  `pay_type` int(1) DEFAULT NULL COMMENT '支付方式：0->未支付；1->支付宝；2->微信',
  `source_type` int(1) DEFAULT NULL COMMENT '订单来源：0->PC订单；1->app订单',
  `status` int(1) DEFAULT NULL COMMENT '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
  `order_type` int(1) DEFAULT NULL COMMENT '订单类型：0->正常订单；1->秒杀订单',
  `delivery_company` varchar(64) DEFAULT NULL COMMENT '物流公司(配送方式)',
  `delivery_sn` varchar(64) DEFAULT NULL COMMENT '物流单号',
  `auto_confirm_day` int(11) DEFAULT NULL COMMENT '自动确认时间（天）',
  `integration` int(11) DEFAULT NULL COMMENT '可以获得的积分',
  `growth` int(11) DEFAULT NULL COMMENT '可以活动的成长值',
  `promotion_info` varchar(100) DEFAULT NULL COMMENT '活动信息',
  `bill_type` int(1) DEFAULT NULL COMMENT '发票类型：0->不开发票；1->电子发票；2->纸质发票',
  `bill_header` varchar(200) DEFAULT NULL COMMENT '发票抬头',
  `bill_content` varchar(200) DEFAULT NULL COMMENT '发票内容',
  `bill_receiver_phone` varchar(32) DEFAULT NULL COMMENT '收票人电话',
  `bill_receiver_email` varchar(64) DEFAULT NULL COMMENT '收票人邮箱',
  `receiver_name` varchar(100) NOT NULL COMMENT '收货人姓名',
  `receiver_phone` varchar(32) NOT NULL COMMENT '收货人电话',
  `receiver_post_code` varchar(32) DEFAULT NULL COMMENT '收货人邮编',
  `receiver_province` varchar(32) DEFAULT NULL COMMENT '省份/直辖市',
  `receiver_city` varchar(32) DEFAULT NULL COMMENT '城市',
  `receiver_region` varchar(32) DEFAULT NULL COMMENT '区',
  `receiver_detail_address` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `note` varchar(500) DEFAULT NULL COMMENT '订单备注',
  `confirm_status` int(1) DEFAULT NULL COMMENT '确认收货状态：0->未确认；1->已确认',
  `delete_status` int(1) NOT NULL DEFAULT '0' COMMENT '删除状态：0->未删除；1->已删除',
  `use_integration` int(11) DEFAULT NULL COMMENT '下单时使用的积分',
  `payment_time` datetime DEFAULT NULL COMMENT '支付时间',
  `delivery_time` datetime DEFAULT NULL COMMENT '发货时间',
  `receive_time` datetime DEFAULT NULL COMMENT '确认收货时间',
  `comment_time` datetime DEFAULT NULL COMMENT '评价时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('12', '0', '1', '2', '201809150101000001', '2018-09-15 12:24:27', 'test', '18732.00', '16377.75', '20.00', '2344.25', '0.00', '10.00', '10.00', '0', '0', '4', '0', '', '', '15', '13284', '13284', '单品促销,打折优惠：满3件，打7.50折,满减优惠：满1000.00元，减120.00元,满减优惠：满1000.00元，减120.00元,无优惠', null, null, null, null, null, '大梨', '18033441849', '518000', '江苏省', '常州市', '天宁区', '东晓街道', '111', '0', '1', null, null, null, null, null, '2019-11-09 16:50:28');
INSERT INTO `order` VALUES ('13', '0', '1', '2', '201809150102000002', '2018-09-15 14:24:29', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '1', '0', '2', '0', '顺丰快递', '42312341', '15', '13284', '13284', '单品促销,打折优惠：满3件，打7.50折,满减优惠：满1000.00元，减120.00元,满减优惠：满1000.00元，减120.00元,无优惠', null, null, null, null, null, '大梨', '18033441849', '518000', '广东省', '深圳市', '福田区', '东晓街道', null, '0', '0', '1000', '2018-10-11 14:04:19', '2022-01-12 11:07:48', null, null, null);
INSERT INTO `order` VALUES ('14', '0', '1', '2', '201809130101000001', '2018-09-13 16:57:40', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '2', '0', '2', '0', '顺丰快递', '201707196398345', '15', '13284', '13284', '单品促销,打折优惠：满3件，打7.50折,满减优惠：满1000.00元，减120.00元,满减优惠：满1000.00元，减120.00元,无优惠', null, null, null, null, null, '大梨', '18033441849', '518000', '广东省', '深圳市', '福田区', '东晓街道', null, '0', '0', null, '2018-10-13 13:44:04', '2018-10-16 13:43:41', null, null, null);
INSERT INTO `order` VALUES ('15', '0', '1', '2', '201809130102000002', '2018-09-13 17:03:00', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '1', '0', '3', '0', '顺丰快递', '201707196398346', '15', '13284', '13284', '单品促销,打折优惠：满3件，打7.50折,满减优惠：满1000.00元，减120.00元,满减优惠：满1000.00元，减120.00元,无优惠', null, null, null, null, null, '大梨', '18033441849', '518000', '广东省', '深圳市', '福田区', '东晓街道', null, '1', '0', null, '2018-10-13 13:44:54', '2018-10-16 13:45:01', '2018-10-18 14:05:31', null, null);
INSERT INTO `order` VALUES ('16', '0', '1', '2', '201809140101000001', '2018-09-14 16:16:16', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '2', '0', '4', '0', null, null, '15', '13284', '13284', '单品促销,打折优惠：满3件，打7.50折,满减优惠：满1000.00元，减120.00元,满减优惠：满1000.00元，减120.00元,无优惠', null, null, null, null, null, '大梨', '18033441849', '518000', '广东省', '深圳市', '福田区', '东晓街道', null, '0', '1', null, null, null, null, null, null);
INSERT INTO `order` VALUES ('17', '0', '1', '2', '201809150101000003', '2018-09-15 12:24:27', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '0', '0', '4', '0', '顺丰快递', '201707196398345', '15', null, null, '单品促销,打折优惠：满3件，打7.50折,满减优惠：满1000.00元，减120.00元,满减优惠：满1000.00元，减120.00元,无优惠', null, null, null, null, null, '大梨', '18033441849', '518000', '广东省', '深圳市', '福田区', '东晓街道', null, '0', '0', null, null, '2018-10-12 14:01:28', null, null, null);
INSERT INTO `order` VALUES ('18', '0', '1', '2', '201809150102000004', '2018-09-15 14:24:29', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '1', '0', '1', '0', '圆通快递', 'xx', '15', null, null, '单品促销,打折优惠：满3件，打7.50折,满减优惠：满1000.00元，减120.00元,满减优惠：满1000.00元，减120.00元,无优惠', null, null, null, null, null, '大梨', '18033441849', '518000', '广东省', '深圳市', '福田区', '东晓街道', null, '0', '0', '1000', null, '2018-10-16 14:42:17', null, null, null);
INSERT INTO `order` VALUES ('19', '0', '1', '2', '201809130101000003', '2018-09-13 16:57:40', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '2', '0', '4', '0', null, null, '15', null, null, '单品促销,打折优惠：满3件，打7.50折,满减优惠：满1000.00元，减120.00元,满减优惠：满1000.00元，减120.00元,无优惠', null, null, null, null, null, '大梨', '18033441849', '518000', '广东省', '深圳市', '福田区', '东晓街道', null, '0', '0', null, null, null, null, null, null);
INSERT INTO `order` VALUES ('20', '0', '1', '2', '201809130102000004', '2018-09-13 17:03:00', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '1', '0', '3', '0', null, null, '15', null, null, '单品促销,打折优惠：满3件，打7.50折,满减优惠：满1000.00元，减120.00元,满减优惠：满1000.00元，减120.00元,无优惠', null, null, null, null, null, '大梨', '18033441849', '518000', '广东省', '深圳市', '福田区', '东晓街道', null, '0', '0', null, null, null, null, null, null);
INSERT INTO `order` VALUES ('21', '0', '1', '2', '201809140101000002', '2018-09-14 16:16:16', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '2', '0', '4', '0', null, null, '15', '18682', '18682', '单品促销,打折优惠：满3件，打7.50折,满减优惠：满1000.00元，减120.00元,满减优惠：满1000.00元，减120.00元,无优惠', null, null, null, null, null, '大梨', '18033441849', '518000', '广东省', '深圳市', '福田区', '东晓街道', null, '0', '1', null, null, null, null, null, null);
INSERT INTO `order` VALUES ('22', '0', '1', '2', '201809150101000005', '2018-09-15 12:24:27', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '0', '0', '4', '0', '顺丰快递', '201707196398345', '15', '0', '0', '单品促销,打折优惠：满3件，打7.50折,满减优惠：满1000.00元，减120.00元,满减优惠：满1000.00元，减120.00元,无优惠', null, null, null, null, null, '大梨', '18033441849', '518000', '广东省', '深圳市', '福田区', '东晓街道', null, '0', '0', null, null, '2018-10-12 14:01:28', null, null, null);
INSERT INTO `order` VALUES ('23', '0', '1', '2', '201809150102000006', '2018-09-15 14:24:29', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '1', '0', '1', '0', '顺丰快递', 'xxx', '15', '0', '0', '单品促销,打折优惠：满3件，打7.50折,满减优惠：满1000.00元，减120.00元,满减优惠：满1000.00元，减120.00元,无优惠', null, null, null, null, null, '大梨', '18033441849', '518000', '广东省', '深圳市', '福田区', '东晓街道', null, '0', '0', '1000', null, '2018-10-16 14:41:28', null, null, null);
INSERT INTO `order` VALUES ('24', '0', '1', '2', '201809130101000005', '2018-09-13 16:57:40', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '2', '0', '2', '0', null, null, '15', '18682', '18682', '单品促销,打折优惠：满3件，打7.50折,满减优惠：满1000.00元，减120.00元,满减优惠：满1000.00元，减120.00元,无优惠', null, null, null, null, null, '大梨', '18033441849', '518000', '广东省', '深圳市', '福田区', '东晓街道', null, '0', '0', null, null, null, null, null, null);
INSERT INTO `order` VALUES ('25', '0', '1', '2', '201809130102000006', '2018-09-13 17:03:00', 'test', '18732.00', '16377.75', '10.00', '2344.25', '0.00', '10.00', '5.00', '1', '0', '4', '0', null, null, '15', '18682', '18682', '单品促销,打折优惠：满3件，打7.50折,满减优惠：满1000.00元，减120.00元,满减优惠：满1000.00元，减120.00元,无优惠', null, null, null, null, null, '大梨22', '18033441849', '518000', '北京市', '北京城区', '东城区', '东城街道', 'xxx', '0', '1', null, null, null, null, null, '2018-10-30 15:08:31');
INSERT INTO `order` VALUES ('26', '0', '1', '2', '201809140101000003', '2018-09-14 16:16:16', 'test', '18732.00', '16377.75', '0.00', '2344.25', '0.00', '10.00', '0.00', '2', '0', '4', '0', null, null, '15', '18682', '18682', '单品促销,打折优惠：满3件，打7.50折,满减优惠：满1000.00元，减120.00元,满减优惠：满1000.00元，减120.00元,无优惠', null, null, null, null, null, '大梨', '18033441849', '518000', '广东省', '深圳市', '福田区', '东晓街道', null, '0', '1', null, null, null, null, null, null);
INSERT INTO `order` VALUES ('27', '0', '1', null, '202002250100000001', '2020-02-25 15:59:20', 'test', '540.00', '540.00', '0.00', '0.00', '0.00', '0.00', '0.00', '0', '0', '0', '0', null, null, null, '0', '0', '无优惠,无优惠', null, null, null, null, null, '大梨', '18033441849', '518000', '广东省', '深圳市', '南山区', '科兴科学园', null, '0', '1', null, null, null, null, null, null);
INSERT INTO `order` VALUES ('28', '0', '1', null, '202002250100000002', '2020-02-25 16:05:47', 'test', '540.00', '540.00', '0.00', '0.00', '0.00', '0.00', '0.00', '0', '0', '0', '0', null, null, null, '0', '0', '无优惠,无优惠', null, null, null, null, null, '大梨', '18033441849', '518000', '广东省', '深圳市', '南山区', '科兴科学园', null, '0', '1', null, null, null, null, null, null);
INSERT INTO `order` VALUES ('29', '0', '1', null, '202002250100000003', '2020-02-25 16:07:58', 'test', '540.00', '540.00', '0.00', '0.00', '0.00', '0.00', '0.00', '0', '0', '0', '0', null, null, null, '0', '0', '无优惠,无优惠', null, null, null, null, null, '大梨', '18033441849', '518000', '广东省', '深圳市', '南山区', '科兴科学园', null, '0', '0', null, null, null, null, null, null);
INSERT INTO `order` VALUES ('30', '0', '1', null, '202002250100000004', '2020-02-25 16:50:13', 'test', '240.00', '240.00', '20.00', '0.00', '0.00', '0.00', '10.00', '0', '0', '2', '0', '顺丰快递', '12333333', null, '0', '0', '无优惠', null, null, null, null, null, '大梨', '18033441849', '518000', '广东省', '深圳市', '南山区', '科兴科学园', null, '0', '0', null, '2020-02-25 16:53:29', '2020-02-25 16:54:03', null, null, '2020-02-25 16:52:51');
INSERT INTO `order` VALUES ('46', '7', null, null, '202203216458104820', '2022-03-21 05:50:14', '小哈猫', '100.00', '100.00', null, null, null, null, null, '1', '0', '1', '3', '邮政快递', null, '15', '5', '20', '无', null, null, null, null, null, '小辰辰', '15362999697', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, '2022-03-22 05:34:42', null, null, null, null);
INSERT INTO `order` VALUES ('47', '7', null, null, '202203215774266108', '2022-03-21 05:50:48', '小哈猫', '100.00', '100.00', null, null, null, null, null, '0', '0', '0', '0', '邮政快递', null, '15', '5', '20', '无', null, null, null, null, null, '小辰辰', '15362999697', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, '2022-03-23 06:10:16', null, null, null, null);
INSERT INTO `order` VALUES ('48', '7', null, null, '202203215008146200', '2022-03-21 06:43:28', '小哈猫', '100.00', '100.00', null, null, null, null, null, '2', '0', '6', '2', '邮政快递', null, '15', '5', '20', '无', null, null, null, null, null, '小辰辰', '15362999697', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '可以发顺丰快递吗', null, '0', null, '2022-05-02 12:14:12', null, null, null, null);
INSERT INTO `order` VALUES ('59', '7', null, null, '202203233317122057', '2022-03-23 06:07:56', '小哈猫', '100.00', '100.00', null, null, null, null, null, '2', '0', '2', '0', '顺丰快递', '5316', '15', '5', '20', '无', null, null, null, null, null, '冯小驾', '15362758697', '528400', '广东省', '广州市', '天河区', '18号', '', null, '0', null, '2022-03-23 06:30:48', '2022-03-23 14:08:43', null, null, null);
INSERT INTO `order` VALUES ('73', '7', null, null, '202203248933566790', '2022-03-24 05:46:25', '小哈猫', '2.00', '200.00', null, null, null, null, null, '0', '0', '0', '0', '顺丰快递  |  圆通快递  |  中通快递  |  韵达快递', null, '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, null, null, null, null, null);
INSERT INTO `order` VALUES ('75', '7', null, null, '202203246555658494', '2022-03-24 08:32:39', '小哈猫', '1.00', '100.00', null, null, null, null, null, '0', '0', '0', '0', '顺丰快递  |  圆通快递  |  中通快递  |  韵达快递', null, '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, null, null, null, null, null);
INSERT INTO `order` VALUES ('77', '7', null, null, '202203249072977252', '2022-03-24 08:38:20', '小哈猫', '1.00', '100.00', null, null, null, null, null, '1', '0', '1', '0', '顺丰快递  |  圆通快递  |  中通快递  |  韵达快递', null, '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, '2022-03-24 08:38:24', null, null, null, null);
INSERT INTO `order` VALUES ('79', '7', null, null, '202203248031894712', '2022-03-24 10:07:16', '小哈猫', '700.00', '700.00', null, null, null, null, null, '1', '0', '1', '0', '顺丰快递  |  圆通快递  |  中通快递  |  韵达快递', null, '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '太好看了', null, '0', null, '2022-03-24 10:07:22', null, null, null, null);
INSERT INTO `order` VALUES ('82', '6', null, null, '202203302196508701', '2022-03-30 14:50:31', 'erha', '100.00', '100.00', null, null, null, null, null, '0', '0', '0', '0', '顺丰快递  |  圆通快递  |  中通快递  |  韵达快递', null, '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, null, null, null, null, null);
INSERT INTO `order` VALUES ('83', '6', null, null, '202203305688647277', '2022-03-30 14:51:05', 'erha', '100.00', '100.00', null, null, null, null, null, '0', '0', '0', '0', '顺丰快递  |  圆通快递  |  中通快递  |  韵达快递', null, '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, null, null, null, null, null);
INSERT INTO `order` VALUES ('84', '7', null, null, '202205028690982308', '2022-05-02 12:07:29', '小哈猫', '138.00', '138.00', null, null, null, null, null, '2', '0', '2', '0', '顺丰快递', '49130481034', '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, '2022-05-02 12:07:33', '2022-05-02 20:09:40', null, null, null);
INSERT INTO `order` VALUES ('85', '7', null, null, '202205029268806336', '2022-05-02 12:08:20', '小哈猫', '89.00', '89.00', null, null, null, null, null, '1', '0', '1', '0', '顺丰快递  |  圆通快递  |  中通快递  |  韵达快递', null, '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, '2022-05-02 12:08:24', null, null, null, null);
INSERT INTO `order` VALUES ('86', '7', null, null, '202205029853138027', '2022-05-02 12:08:45', '小哈猫', '68.00', '68.00', null, null, null, null, null, '2', '0', '1', '0', '顺丰快递  |  圆通快递  |  中通快递  |  韵达快递', null, '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, '2022-05-02 12:08:49', null, null, null, null);
INSERT INTO `order` VALUES ('87', '7', null, null, '202205029343575016', '2022-05-02 12:10:58', '小哈猫', '159.00', '159.00', null, null, null, null, null, '1', '0', '1', '0', '顺丰快递  |  圆通快递  |  中通快递  |  韵达快递', null, '15', '5', '20', '无', null, null, null, null, null, 'xixi', '15326817241', '528400', '北京市', '北京市', '丰台区', '1231号', '', null, '0', null, '2022-05-02 12:11:03', null, null, null, null);
INSERT INTO `order` VALUES ('88', '7', null, null, '202205024540334439', '2022-05-02 12:11:38', '小哈猫', '357.00', '357.00', null, null, null, null, null, '1', '0', '1', '0', '顺丰快递  |  圆通快递  |  中通快递  |  韵达快递', null, '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, '2022-05-02 12:11:42', null, null, null, null);
INSERT INTO `order` VALUES ('89', '7', null, null, '202205022996338031', '2022-05-02 12:13:12', '小哈猫', '68.00', '68.00', null, null, null, null, null, '2', '0', '2', '0', '圆通快递', null, '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, '2022-05-02 12:13:15', '2022-05-02 20:13:39', null, null, null);
INSERT INTO `order` VALUES ('90', '7', null, null, '202205039528704028', '2022-05-03 10:23:31', '小哈猫', '68.00', '68.00', null, null, null, null, null, '2', '0', '1', '0', '顺丰快递  |  圆通快递  |  中通快递  |  韵达快递', null, '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, '2022-05-03 10:23:38', null, null, null, null);
INSERT INTO `order` VALUES ('93', '7', null, null, '202205071951288291', '2022-05-07 12:51:10', '小哈猫', '396.00', '396.00', null, null, null, null, null, '2', '0', '6', '0', '顺丰快递', '1224141', '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, '2022-05-07 12:54:13', '2022-05-07 20:53:50', null, null, null);
INSERT INTO `order` VALUES ('94', '7', null, null, '202205073918465322', '2022-05-07 12:54:55', '小哈猫', '1.00', '100.00', null, null, null, null, null, '2', '0', '1', '0', '顺丰快递  |  圆通快递  |  中通快递  |  韵达快递', null, '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, '2022-05-07 12:54:59', null, null, null, null);
INSERT INTO `order` VALUES ('95', '7', null, null, '202205075417163226', '2022-05-07 12:54:55', '小哈猫', '1.00', '100.00', null, null, null, null, null, '2', '0', '1', '0', '顺丰快递  |  圆通快递  |  中通快递  |  韵达快递', null, '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, '2022-05-07 12:54:59', null, null, null, null);
INSERT INTO `order` VALUES ('96', '7', null, null, '202205076695234227', '2022-05-07 12:54:55', '小哈猫', '1.00', '100.00', null, null, null, null, null, '2', '0', '1', '0', '顺丰快递  |  圆通快递  |  中通快递  |  韵达快递', null, '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, '2022-05-07 12:54:59', null, null, null, null);
INSERT INTO `order` VALUES ('97', '7', null, null, '202205072298256715', '2022-05-07 12:54:55', '小哈猫', '1.00', '100.00', null, null, null, null, null, '2', '0', '1', '0', '顺丰快递  |  圆通快递  |  中通快递  |  韵达快递', null, '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, '2022-05-07 12:54:59', null, null, null, null);
INSERT INTO `order` VALUES ('98', '7', null, null, '202205073706777129', '2022-05-07 12:54:55', '小哈猫', '1.00', '100.00', null, null, null, null, null, '2', '0', '1', '0', '顺丰快递  |  圆通快递  |  中通快递  |  韵达快递', null, '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, '2022-05-07 12:54:59', null, null, null, null);
INSERT INTO `order` VALUES ('99', '7', null, null, '202205072726611373', '2022-05-07 12:54:55', '小哈猫', '1.00', '100.00', null, null, null, null, null, '2', '0', '1', '0', '顺丰快递  |  圆通快递  |  中通快递  |  韵达快递', null, '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, '2022-05-07 12:54:59', null, null, null, null);
INSERT INTO `order` VALUES ('100', '7', null, null, '202205072326342902', '2022-05-07 12:54:55', '小哈猫', '1.00', '100.00', null, null, null, null, null, '2', '0', '1', '0', '顺丰快递  |  圆通快递  |  中通快递  |  韵达快递', null, '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, '2022-05-07 12:54:59', null, null, null, null);
INSERT INTO `order` VALUES ('101', '7', null, null, '202205072207571194', '2022-05-07 12:54:55', '小哈猫', '1.00', '100.00', null, null, null, null, null, '2', '0', '1', '0', '顺丰快递  |  圆通快递  |  中通快递  |  韵达快递', null, '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, '2022-05-07 12:54:59', null, null, null, null);
INSERT INTO `order` VALUES ('102', '7', null, null, '202205070358574455', '2022-05-07 12:54:55', '小哈猫', '1.00', '100.00', null, null, null, null, null, '2', '0', '1', '0', '顺丰快递  |  圆通快递  |  中通快递  |  韵达快递', null, '15', '5', '20', '无', null, null, null, null, null, '陈小哈', '15362999695', '528400', '广东省', '中山市', '石岐区街道办事处', '学院路1号', '', null, '0', null, '2022-05-07 12:54:59', null, null, null, null);

-- ----------------------------
-- Table structure for `order_item`
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单id',
  `order_sn` varchar(64) DEFAULT NULL COMMENT '订单编号',
  `clothing_id` bigint(20) DEFAULT NULL,
  `clothing_pic` varchar(500) DEFAULT NULL,
  `clothing_name` varchar(200) DEFAULT NULL,
  `clothing_brand` varchar(200) DEFAULT NULL,
  `clothing_sn` varchar(64) DEFAULT NULL,
  `clothing_price` decimal(10,2) DEFAULT NULL COMMENT '销售价格',
  `clothing_quantity` int(11) DEFAULT NULL COMMENT '购买数量',
  `clothing_sku_id` bigint(20) DEFAULT NULL COMMENT '商品sku编号',
  `clothing_sku_code` varchar(50) DEFAULT NULL COMMENT '商品sku条码',
  `clothing_category_id` bigint(20) DEFAULT NULL COMMENT '商品分类id',
  `promotion_name` varchar(200) DEFAULT NULL COMMENT '商品促销名称',
  `promotion_amount` decimal(10,2) DEFAULT NULL COMMENT '商品促销分解金额',
  `coupon_amount` decimal(10,2) DEFAULT NULL COMMENT '优惠券优惠分解金额',
  `integration_amount` decimal(10,2) DEFAULT NULL COMMENT '积分优惠分解金额',
  `real_amount` decimal(10,2) DEFAULT NULL COMMENT '该商品经过优惠后的分解金额',
  `gift_integration` int(11) DEFAULT '0',
  `gift_growth` int(11) DEFAULT '0',
  `clothing_attr` varchar(500) DEFAULT NULL COMMENT '商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8 COMMENT='订单中所包含的商品';

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES ('21', '12', '201809150101000001', '26', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', '华为 HUAWEI P20', '华为', '6946605', '3788.00', '1', '90', '201806070026001', '19', '单品促销', '200.00', '2.02', '0.00', '3585.98', '3788', '3788', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('22', '12', '201809150101000001', '27', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', '小米8', '小米', '7437788', '2699.00', '3', '98', '201808270027001', '19', '打折优惠：满3件，打7.50折', '674.75', '1.44', '0.00', '2022.81', '2699', '2699', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('23', '12', '201809150101000001', '28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '红米5A', '小米', '7437789', '649.00', '1', '102', '201808270028001', '19', '满减优惠：满1000.00元，减120.00元', '57.60', '0.35', '0.00', '591.05', '649', '649', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('24', '12', '201809150101000001', '28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '红米5A', '小米', '7437789', '699.00', '1', '103', '201808270028001', '19', '满减优惠：满1000.00元，减120.00元', '62.40', '0.37', '0.00', '636.23', '649', '649', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('25', '12', '201809150101000001', '29', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5acc5248N6a5f81cd.jpg', 'Apple iPhone 8 Plus', '苹果', '7437799', '5499.00', '1', '106', '201808270029001', '19', '无优惠', '0.00', '2.94', '0.00', '5496.06', '5499', '5499', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('26', '13', '201809150102000002', '26', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', '华为 HUAWEI P20', '华为', '6946605', '3788.00', '1', '90', '201806070026001', '19', '单品促销', '200.00', '2.02', '0.00', '3585.98', '3788', '3788', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('27', '13', '201809150102000002', '27', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', '小米8', '小米', '7437788', '2699.00', '3', '98', '201808270027001', '19', '打折优惠：满3件，打7.50折', '674.75', '1.44', '0.00', '2022.81', '2699', '2699', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('28', '13', '201809150102000002', '28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '红米5A', '小米', '7437789', '649.00', '1', '102', '201808270028001', '19', '满减优惠：满1000.00元，减120.00元', '57.60', '0.35', '0.00', '591.05', '649', '649', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('29', '13', '201809150102000002', '28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '红米5A', '小米', '7437789', '699.00', '1', '103', '201808270028001', '19', '满减优惠：满1000.00元，减120.00元', '62.40', '0.37', '0.00', '636.23', '649', '649', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('30', '13', '201809150102000002', '29', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5acc5248N6a5f81cd.jpg', 'Apple iPhone 8 Plus', '苹果', '7437799', '5499.00', '1', '106', '201808270029001', '19', '无优惠', '0.00', '2.94', '0.00', '5496.06', '5499', '5499', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('31', '14', '201809130101000001', '26', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', '华为 HUAWEI P20', '华为', '6946605', '3788.00', '1', '90', '201806070026001', '19', '单品促销', '200.00', '2.02', '0.00', '3585.98', '3788', '3788', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('32', '14', '201809130101000001', '27', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', '小米8', '小米', '7437788', '2699.00', '3', '98', '201808270027001', '19', '打折优惠：满3件，打7.50折', '674.75', '1.44', '0.00', '2022.81', '2699', '2699', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('33', '14', '201809130101000001', '28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '红米5A', '小米', '7437789', '649.00', '1', '102', '201808270028001', '19', '满减优惠：满1000.00元，减120.00元', '57.60', '0.35', '0.00', '591.05', '649', '649', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('34', '14', '201809130101000001', '28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '红米5A', '小米', '7437789', '699.00', '1', '103', '201808270028001', '19', '满减优惠：满1000.00元，减120.00元', '62.40', '0.37', '0.00', '636.23', '649', '649', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('35', '14', '201809130101000001', '29', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5acc5248N6a5f81cd.jpg', 'Apple iPhone 8 Plus', '苹果', '7437799', '5499.00', '1', '106', '201808270029001', '19', '无优惠', '0.00', '2.94', '0.00', '5496.06', '5499', '5499', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('36', '15', '201809130101000001', '26', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', '华为 HUAWEI P20', '华为', '6946605', '3788.00', '1', '90', '201806070026001', '19', '单品促销', '200.00', '2.02', '0.00', '3585.98', '3788', '3788', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('37', '15', '201809130101000001', '27', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', '小米8', '小米', '7437788', '2699.00', '3', '98', '201808270027001', '19', '打折优惠：满3件，打7.50折', '674.75', '1.44', '0.00', '2022.81', '2699', '2699', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('38', '15', '201809130101000001', '28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '红米5A', '小米', '7437789', '649.00', '1', '102', '201808270028001', '19', '满减优惠：满1000.00元，减120.00元', '57.60', '0.35', '0.00', '591.05', '649', '649', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('39', '15', '201809130101000001', '28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '红米5A', '小米', '7437789', '699.00', '1', '103', '201808270028001', '19', '满减优惠：满1000.00元，减120.00元', '62.40', '0.37', '0.00', '636.23', '649', '649', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('40', '15', '201809130101000001', '29', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5acc5248N6a5f81cd.jpg', 'Apple iPhone 8 Plus', '苹果', '7437799', '5499.00', '1', '106', '201808270029001', '19', '无优惠', '0.00', '2.94', '0.00', '5496.06', '5499', '5499', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('41', '16', '201809140101000001', '26', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', '华为 HUAWEI P20', '华为', '6946605', '3788.00', '1', '90', '201806070026001', '19', '单品促销', '200.00', '2.02', '0.00', '3585.98', '3788', '3788', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('42', '16', '201809140101000001', '27', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', '小米8', '小米', '7437788', '2699.00', '3', '98', '201808270027001', '19', '打折优惠：满3件，打7.50折', '674.75', '1.44', '0.00', '2022.81', '2699', '2699', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('43', '16', '201809140101000001', '28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '红米5A', '小米', '7437789', '649.00', '1', '102', '201808270028001', '19', '满减优惠：满1000.00元，减120.00元', '57.60', '0.35', '0.00', '591.05', '649', '649', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('44', '16', '201809140101000001', '28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '红米5A', '小米', '7437789', '699.00', '1', '103', '201808270028001', '19', '满减优惠：满1000.00元，减120.00元', '62.40', '0.37', '0.00', '636.23', '649', '649', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('45', '16', '201809140101000001', '29', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5acc5248N6a5f81cd.jpg', 'Apple iPhone 8 Plus', '苹果', '7437799', '5499.00', '1', '106', '201808270029001', '19', '无优惠', '0.00', '2.94', '0.00', '5496.06', '5499', '5499', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('46', '27', '202002250100000001', '36', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b19403eN9f0b3cb8.jpg', '耐克NIKE 男子 气垫 休闲鞋 AIR MAX 90 ESSENTIAL 运动鞋 AJ1285-101白色41码', 'NIKE', '6799345', '100.00', '3', '163', '202002210036001', '29', '无优惠', '0.00', '0.00', '0.00', '100.00', '0', '0', null);
INSERT INTO `order_item` VALUES ('47', '27', '202002250100000001', '36', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b19403eN9f0b3cb8.jpg', '耐克NIKE 男子 气垫 休闲鞋 AIR MAX 90 ESSENTIAL 运动鞋 AJ1285-101白色41码', 'NIKE', '6799345', '120.00', '2', '164', '202002210036001', '29', '无优惠', '0.00', '0.00', '0.00', '120.00', '0', '0', null);
INSERT INTO `order_item` VALUES ('48', '28', '202002250100000002', '36', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b19403eN9f0b3cb8.jpg', '耐克NIKE 男子 气垫 休闲鞋 AIR MAX 90 ESSENTIAL 运动鞋 AJ1285-101白色41码', 'NIKE', '6799345', '100.00', '3', '163', '202002210036001', '29', '无优惠', '0.00', '0.00', '0.00', '100.00', '0', '0', null);
INSERT INTO `order_item` VALUES ('49', '28', '202002250100000002', '36', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b19403eN9f0b3cb8.jpg', '耐克NIKE 男子 气垫 休闲鞋 AIR MAX 90 ESSENTIAL 运动鞋 AJ1285-101白色41码', 'NIKE', '6799345', '120.00', '2', '164', '202002210036001', '29', '无优惠', '0.00', '0.00', '0.00', '120.00', '0', '0', null);
INSERT INTO `order_item` VALUES ('50', '29', '202002250100000003', '36', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b19403eN9f0b3cb8.jpg', '耐克NIKE 男子 气垫 休闲鞋 AIR MAX 90 ESSENTIAL 运动鞋 AJ1285-101白色41码', 'NIKE', '6799345', '100.00', '3', '163', '202002210036001', '29', '无优惠', '0.00', '0.00', '0.00', '100.00', '0', '0', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"38\"},{\"key\":\"风格\",\"value\":\"秋季\"}]');
INSERT INTO `order_item` VALUES ('51', '29', '202002250100000003', '36', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b19403eN9f0b3cb8.jpg', '耐克NIKE 男子 气垫 休闲鞋 AIR MAX 90 ESSENTIAL 运动鞋 AJ1285-101白色41码', 'NIKE', '6799345', '120.00', '2', '164', '202002210036001', '29', '无优惠', '0.00', '0.00', '0.00', '120.00', '0', '0', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"38\"},{\"key\":\"风格\",\"value\":\"夏季\"}]');
INSERT INTO `order_item` VALUES ('52', '30', '202002250100000004', '36', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b19403eN9f0b3cb8.jpg', '耐克NIKE 男子 气垫 休闲鞋 AIR MAX 90 ESSENTIAL 运动鞋 AJ1285-101白色41码', 'NIKE', '6799345', '120.00', '2', '164', '202002210036001', '29', '无优惠', '0.00', '0.00', '0.00', '120.00', '0', '0', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"38\"},{\"key\":\"风格\",\"value\":\"夏季\"}]');
INSERT INTO `order_item` VALUES ('53', '46', '202203216458104820', '1', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-02-14/gaolin01.jpg', '潮牌T恤', '香奈儿', '', '100.00', '1', null, null, '8', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('54', '47', '202203215774266108', '1', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-02-14/gaolin01.jpg', '潮牌T恤', '香奈儿', '', '100.00', '1', null, null, '8', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"38\"},{\"key\":\"风格\",\"value\":\"夏季\"}]');
INSERT INTO `order_item` VALUES ('55', '48', '202203215008146200', '1', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-02-14/gaolin01.jpg', '潮牌T恤', '香奈儿', '', '100.00', '1', null, null, '8', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('66', '59', '202203233317122057', '1', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-02-14/gaolin01.jpg', '潮牌T恤', '香奈儿', '', '100.00', '1', null, null, '8', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('78', '73', '202203248933566790', '1', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-02-14/gaolin01.jpg', '潮牌T恤', '香奈儿', '', '100.00', '2', null, null, '8', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('80', '75', '202203246555658494', '1', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-02-14/gaolin01.jpg', '潮牌T恤', '香奈儿', '', '100.00', '1', null, null, '8', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('82', '77', '202203249072977252', '1', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-02-14/gaolin01.jpg', '潮牌T恤', '香奈儿', '', '100.00', '1', null, null, '8', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('84', '79', '202203248031894712', '1', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-02-14/gaolin01.jpg', '潮牌T恤', '香奈儿', '', '100.00', '7', null, null, '8', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"蓝色\"},{\"key\":\"尺寸\",\"value\":\"XL\"}]');
INSERT INTO `order_item` VALUES ('87', '82', '202203302196508701', '1', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-02-14/gaolin01.jpg', '潮牌T恤', '香奈儿', '', '100.00', '1', null, null, '8', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"\"},{\"key\":\"尺寸\",\"value\":\"\"}]');
INSERT INTO `order_item` VALUES ('88', '83', '202203305688647277', '1', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-02-14/gaolin01.jpg', '潮牌T恤', '香奈儿', '', '100.00', '1', null, null, '8', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"\"},{\"key\":\"尺寸\",\"value\":\"\"}]');
INSERT INTO `order_item` VALUES ('89', '84', '202205028690982308', '61', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/71ae321f90950059.jpg.avif', '潮牌飞行员夹克外套男士春秋季', 'LV', '0001', '138.00', '1', null, null, '7', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"卡其色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('90', '85', '202205029268806336', '69', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/2927a2a62ece884a.jpg.avif', '途中雨休闲裤男士夏季中裤大码男装七分裤', '优衣库', '', '89.00', '1', null, null, '33', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"黑色\"},{\"key\":\"尺寸\",\"value\":\"30\"}]');
INSERT INTO `order_item` VALUES ('91', '86', '202205029853138027', '74', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/056566067e5491ee.jpg.avif', '广场舞服装女套装夏季新款舞蹈服短袖棉健身运动服套装', '新百伦', '0017', '68.00', '1', null, null, '37', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"蓝色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('92', '87', '202205029343575016', '76', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/2fbf628d0cf59469.jpg.avif', '卫衣女装套装2022年春季新款韩版宽松上衣服外套女', '太平鸟', '0016', '159.00', '1', null, null, '35', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"黑色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('93', '88', '202205024540334439', '79', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/06ad176a01d56374.jpg.avif', '鼎毳貂汉服古装男生新款原创汉服中国古风服装', '阿玛施', '0019', '119.00', '3', null, null, '45', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"黑色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('94', '89', '202205022996338031', '62', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/6a6b9657910293f4.jpg.avif', '短袖t恤男夏季潮牌2021新款半袖纯棉', '阿迪达斯', '', '68.00', '1', null, null, '8', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"黑色\"},{\"key\":\"尺寸\",\"value\":\"XL\"}]');
INSERT INTO `order_item` VALUES ('95', '90', '202205039528704028', '62', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/6a6b9657910293f4.jpg.avif', '短袖t恤男夏季潮牌2021新款半袖纯棉', '阿迪达斯', '', '68.00', '1', null, null, '8', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"黑色\"},{\"key\":\"尺寸\",\"value\":\"XL\"}]');
INSERT INTO `order_item` VALUES ('98', '93', '202205071951288291', '64', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/6f4b31b5cbeb08e2.jpg.avif', '香港潮牌时尚轻熟风减龄女短款', '香奈儿', '', '396.00', '1', null, null, '8', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"叶绿色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('99', '94', '202205073918465322', '64', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/6f4b31b5cbeb08e2.jpg.avif', '香港潮牌时尚轻熟风减龄女短款', '香奈儿', '', '396.00', '1', null, null, '8', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"叶绿色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('100', '95', '202205075417163226', '66', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/5f8c4eb3210ce2c1.jpg.avif', '夹克男夏季外套男士连帽简约时尚长袖', '阿迪达斯', '', '69.00', '1', null, null, '30', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"深蓝色\"},{\"key\":\"尺寸\",\"value\":\"2XL\"}]');
INSERT INTO `order_item` VALUES ('101', '96', '202205076695234227', '69', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/2927a2a62ece884a.jpg.avif', '途中雨休闲裤男士夏季中裤大码男装七分裤', '优衣库', '', '89.00', '1', null, null, '33', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"灰色\"},{\"key\":\"尺寸\",\"value\":\"30\"}]');
INSERT INTO `order_item` VALUES ('102', '97', '202205072298256715', '62', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/6a6b9657910293f4.jpg.avif', '短袖t恤男夏季潮牌2021新款半袖纯棉', '阿迪达斯', '', '68.00', '1', null, null, '8', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"黑色\"},{\"key\":\"尺寸\",\"value\":\"XL\"}]');
INSERT INTO `order_item` VALUES ('103', '98', '202205073706777129', '63', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/b276c9ab778e8f19.jpg.avif', '直筒牛仔裤男2022春夏季新款潮牌休闲裤', '欧时力', '', '59.00', '1', null, null, '10', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"\"},{\"key\":\"尺寸\",\"value\":\"\"}]');
INSERT INTO `order_item` VALUES ('104', '99', '202205072726611373', '72', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/6eb7a21a5f1abde4.jpg.avif', '外套男卫衣春秋季衣服运动服跑步服健身服', '耐克', '0012', '159.00', '1', null, null, '35', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"黑色\"},{\"key\":\"尺寸\",\"value\":\"XL\"}]');
INSERT INTO `order_item` VALUES ('105', '100', '202205072326342902', '68', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/64be08b96cbacf26.jpg.avif', '南极人短袖T恤男夏季薄款男装新款港风韩版', '阿玛施', '0008', '49.00', '1', null, null, '31', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"白色\"},{\"key\":\"尺寸\",\"value\":\"XL\"}]');
INSERT INTO `order_item` VALUES ('106', '101', '202205072207571194', '61', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-05-02/71ae321f90950059.jpg.avif', '潮牌飞行员夹克外套男士春秋季', 'LV', '0001', '138.00', '1', null, null, '7', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"卡其色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');
INSERT INTO `order_item` VALUES ('107', '102', '202205070358574455', '1', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-02-14/gaolin01.jpg', '潮牌T恤', '香奈儿', '', '100.00', '1', null, null, '8', null, null, null, null, null, null, null, '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"L\"}]');

-- ----------------------------
-- Table structure for `order_operate_history`
-- ----------------------------
DROP TABLE IF EXISTS `order_operate_history`;
CREATE TABLE `order_operate_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单id',
  `operate_man` varchar(100) DEFAULT NULL COMMENT '操作人：用户；系统；后台管理员',
  `create_time` datetime DEFAULT NULL COMMENT '操作时间',
  `order_status` int(1) DEFAULT NULL COMMENT '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='订单操作历史记录';

-- ----------------------------
-- Records of order_operate_history
-- ----------------------------
INSERT INTO `order_operate_history` VALUES ('5', '12', '后台管理员', '2018-10-12 14:01:29', '2', '完成发货');
INSERT INTO `order_operate_history` VALUES ('6', '13', '后台管理员', '2018-10-12 14:01:29', '2', '完成发货');
INSERT INTO `order_operate_history` VALUES ('7', '12', '后台管理员', '2018-10-12 14:13:10', '4', '订单关闭:买家退货');
INSERT INTO `order_operate_history` VALUES ('8', '13', '后台管理员', '2018-10-12 14:13:10', '4', '订单关闭:买家退货');
INSERT INTO `order_operate_history` VALUES ('9', '22', '后台管理员', '2018-10-15 16:31:48', '4', '订单关闭:xxx');
INSERT INTO `order_operate_history` VALUES ('10', '22', '后台管理员', '2018-10-15 16:35:08', '4', '订单关闭:xxx');
INSERT INTO `order_operate_history` VALUES ('11', '22', '后台管理员', '2018-10-15 16:35:59', '4', '订单关闭:xxx');
INSERT INTO `order_operate_history` VALUES ('12', '17', '后台管理员', '2018-10-15 16:43:40', '4', '订单关闭:xxx');
INSERT INTO `order_operate_history` VALUES ('13', '25', '后台管理员', '2018-10-15 16:52:14', '4', '订单关闭:xxx');
INSERT INTO `order_operate_history` VALUES ('14', '26', '后台管理员', '2018-10-15 16:52:14', '4', '订单关闭:xxx');
INSERT INTO `order_operate_history` VALUES ('15', '23', '后台管理员', '2018-10-16 14:41:28', '2', '完成发货');
INSERT INTO `order_operate_history` VALUES ('16', '13', '后台管理员', '2018-10-16 14:42:17', '2', '完成发货');
INSERT INTO `order_operate_history` VALUES ('17', '18', '后台管理员', '2018-10-16 14:42:17', '2', '完成发货');
INSERT INTO `order_operate_history` VALUES ('18', '26', '后台管理员', '2018-10-30 14:37:44', '4', '订单关闭:关闭订单');
INSERT INTO `order_operate_history` VALUES ('19', '25', '后台管理员', '2018-10-30 15:07:01', '0', '修改收货人信息');
INSERT INTO `order_operate_history` VALUES ('20', '25', '后台管理员', '2018-10-30 15:08:13', '0', '修改费用信息');
INSERT INTO `order_operate_history` VALUES ('21', '25', '后台管理员', '2018-10-30 15:08:31', '0', '修改备注信息：xxx');
INSERT INTO `order_operate_history` VALUES ('22', '25', '后台管理员', '2018-10-30 15:08:39', '4', '订单关闭:2222');
INSERT INTO `order_operate_history` VALUES ('23', '12', '后台管理员', '2019-11-09 16:50:28', '4', '修改备注信息：111');
INSERT INTO `order_operate_history` VALUES ('24', '30', '后台管理员', '2020-02-25 16:52:37', '0', '修改费用信息');
INSERT INTO `order_operate_history` VALUES ('25', '30', '后台管理员', '2020-02-25 16:52:51', '0', '修改费用信息');
INSERT INTO `order_operate_history` VALUES ('26', '30', '后台管理员', '2020-02-25 16:54:03', '2', '完成发货');
INSERT INTO `order_operate_history` VALUES ('27', '13', '后台管理员', '2022-01-12 11:07:49', '2', '完成发货');
INSERT INTO `order_operate_history` VALUES ('28', '19', '后台管理员', '2022-01-12 11:08:38', '4', '订单关闭:已发货');
INSERT INTO `order_operate_history` VALUES ('29', '49', '后台管理员', '2022-03-22 08:56:01', '2', '完成发货');
INSERT INTO `order_operate_history` VALUES ('30', '50', '后台管理员', '2022-03-22 12:27:41', '2', '完成发货');
INSERT INTO `order_operate_history` VALUES ('31', '59', '后台管理员', '2022-03-23 06:08:44', '2', '完成发货');
INSERT INTO `order_operate_history` VALUES ('32', '58', '后台管理员', '2022-03-23 06:09:08', '2', '完成发货');
INSERT INTO `order_operate_history` VALUES ('33', '54', '后台管理员', '2022-03-23 06:09:19', '2', '完成发货');
INSERT INTO `order_operate_history` VALUES ('34', '84', '后台管理员', '2022-05-02 12:09:41', '2', '完成发货');
INSERT INTO `order_operate_history` VALUES ('35', '89', '后台管理员', '2022-05-02 12:13:39', '2', '完成发货');
INSERT INTO `order_operate_history` VALUES ('36', '91', '后台管理员', '2022-05-07 12:35:18', '2', '完成发货');
INSERT INTO `order_operate_history` VALUES ('37', '93', '后台管理员', '2022-05-07 12:53:51', '2', '完成发货');

-- ----------------------------
-- Table structure for `order_return_apply`
-- ----------------------------
DROP TABLE IF EXISTS `order_return_apply`;
CREATE TABLE `order_return_apply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单id',
  `company_address_id` bigint(20) DEFAULT NULL COMMENT '收货地址表id',
  `clothing_id` bigint(20) DEFAULT NULL COMMENT '退货商品id',
  `order_sn` varchar(64) DEFAULT NULL COMMENT '订单编号',
  `create_time` datetime DEFAULT NULL COMMENT '申请时间',
  `member_username` varchar(64) DEFAULT NULL COMMENT '会员用户名',
  `return_amount` decimal(10,2) DEFAULT NULL COMMENT '退款金额',
  `return_name` varchar(100) DEFAULT NULL COMMENT '退货人姓名',
  `return_phone` varchar(100) DEFAULT NULL COMMENT '退货人电话',
  `status` int(1) DEFAULT NULL COMMENT '申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝',
  `handle_time` datetime DEFAULT NULL COMMENT '处理时间',
  `clothing_pic` varchar(500) DEFAULT NULL COMMENT '商品图片',
  `clothing_name` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `clothing_brand` varchar(200) DEFAULT NULL COMMENT '商品品牌',
  `clothing_attr` varchar(500) DEFAULT NULL COMMENT '商品销售属性：颜色：红色；尺码：xl;',
  `clothing_count` int(11) DEFAULT NULL COMMENT '退货数量',
  `clothing_price` decimal(10,2) DEFAULT NULL COMMENT '商品单价',
  `clothing_real_price` decimal(10,2) DEFAULT NULL COMMENT '商品实际支付单价',
  `reason` varchar(200) DEFAULT NULL COMMENT '原因',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `proof_pics` varchar(1000) DEFAULT NULL COMMENT '凭证图片，以逗号隔开',
  `handle_note` varchar(500) DEFAULT NULL COMMENT '处理备注',
  `handle_man` varchar(100) DEFAULT NULL COMMENT '处理人员',
  `receive_man` varchar(100) DEFAULT NULL COMMENT '收货人',
  `receive_time` datetime DEFAULT NULL COMMENT '收货时间',
  `receive_note` varchar(500) DEFAULT NULL COMMENT '收货备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='订单退货申请';

-- ----------------------------
-- Records of order_return_apply
-- ----------------------------
INSERT INTO `order_return_apply` VALUES ('3', '12', '1', '26', '201809150101000001', '2018-10-17 14:34:57', 'test', '0.00', '大梨', '18000000000', '2', '2022-03-21 12:28:56', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', '华为 HUAWEI P20', '华为', '颜色：金色;内存：16G', '1', '3788.00', '3585.98', '质量问题', '老是卡', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg,http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', null, 'admin', 'admin', '2022-03-21 12:29:06', null);
INSERT INTO `order_return_apply` VALUES ('4', '12', '2', '27', '201809150101000001', '2018-10-17 14:40:21', 'test', '3585.98', '大梨', '18000000000', '1', '2018-10-18 13:54:10', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', '小米8', '小米', '颜色：黑色;内存：32G', '1', '2699.00', '2022.81', '质量问题', '不够高端', '', '已经处理了', 'admin', null, null, null);
INSERT INTO `order_return_apply` VALUES ('5', '12', '3', '28', '201809150101000001', '2018-10-17 14:44:18', 'test', '3585.98', '大梨', '18000000000', '2', '2018-10-18 13:55:28', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '红米5A', '小米', '颜色：金色;内存：16G', '1', '649.00', '591.05', '质量问题', '颜色太土', '', '已经处理了', 'admin', 'admin', '2018-10-18 13:55:58', '已经处理了');
INSERT INTO `order_return_apply` VALUES ('8', '13', null, '28', '201809150102000002', '2018-10-17 14:44:18', 'test', null, '大梨', '18000000000', '3', '2018-10-18 13:57:12', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '红米5A', '小米', '颜色：金色;内存：16G', '1', '649.00', '591.05', '质量问题', '颜色太土', '', '理由不够充分', 'admin', null, null, null);
INSERT INTO `order_return_apply` VALUES ('9', '14', '2', '26', '201809130101000001', '2018-10-17 14:34:57', 'test', '3500.00', '大梨', '18000000000', '2', '2018-10-24 15:44:56', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', '华为 HUAWEI P20', '华为', '颜色：金色;内存：16G', '1', '3788.00', '3585.98', '质量问题', '老是卡', '', '呵呵', 'admin', 'admin', '2018-10-24 15:46:35', '收货了');
INSERT INTO `order_return_apply` VALUES ('10', '14', null, '27', '201809130101000001', '2018-10-17 14:40:21', 'test', null, '大梨', '18000000000', '3', '2018-10-24 15:46:57', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', '小米8', '小米', '颜色：黑色;内存：32G', '1', '2699.00', '2022.81', '质量问题', '不够高端', '', '就是不退', 'admin', null, null, null);
INSERT INTO `order_return_apply` VALUES ('11', '14', '2', '28', '201809130101000001', '2018-10-17 14:44:18', 'test', '591.05', '大梨', '18000000000', '1', '2018-10-24 17:09:04', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '红米5A', '小米', '颜色：金色;内存：16G', '1', '649.00', '591.05', '质量问题', '颜色太土', '', '可以退款', 'admin', null, null, null);
INSERT INTO `order_return_apply` VALUES ('12', '15', '3', '26', '201809130102000002', '2018-10-17 14:34:57', 'test', '3500.00', '大梨', '18000000000', '2', '2018-10-24 17:22:54', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', '华为 HUAWEI P20', '华为', '颜色：金色;内存：16G', '1', '3788.00', '3585.98', '质量问题', '老是卡', '', '退货了', 'admin', 'admin', '2018-10-24 17:23:06', '收货了');
INSERT INTO `order_return_apply` VALUES ('13', '15', null, '27', '201809130102000002', '2018-10-17 14:40:21', 'test', null, '大梨', '18000000000', '3', '2018-10-24 17:23:30', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', '小米8', '小米', '颜色：黑色;内存：32G', '1', '2699.00', '2022.81', '质量问题', '不够高端', '', '无法退货', 'admin', null, null, null);
INSERT INTO `order_return_apply` VALUES ('15', '16', '1', '26', '201809140101000001', '2018-10-17 14:34:57', 'test', '0.00', '大梨', '18000000000', '2', '2022-03-21 12:29:34', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', '华为 HUAWEI P20', '华为', '颜色：金色;内存：16G', '1', '3788.00', '3585.98', '质量问题', '老是卡', '', null, 'admin', 'admin', '2022-03-22 03:28:31', null);
INSERT INTO `order_return_apply` VALUES ('16', '16', null, '27', '201809140101000001', '2018-10-17 14:40:21', 'test', null, '大梨', '18000000000', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', '小米8', '小米', '颜色：黑色;内存：32G', '1', '2699.00', '2022.81', '质量问题', '不够高端', '', null, null, null, null, null);
INSERT INTO `order_return_apply` VALUES ('17', '16', null, '28', '201809140101000001', '2018-10-17 14:44:18', 'test', null, '大梨', '18000000000', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '红米5A', '小米', '颜色：金色;内存：16G', '1', '649.00', '591.05', '质量问题', '颜色太土', '', null, null, null, null, null);
INSERT INTO `order_return_apply` VALUES ('18', '17', null, '26', '201809150101000003', '2018-10-17 14:34:57', 'test', null, '大梨', '18000000000', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', '华为 HUAWEI P20', '华为', '颜色：金色;内存：16G', '1', '3788.00', '3585.98', '质量问题', '老是卡', '', null, null, null, null, null);
INSERT INTO `order_return_apply` VALUES ('19', '17', null, '27', '201809150101000003', '2018-10-17 14:40:21', 'test', null, '大梨', '18000000000', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', '小米8', '小米', '颜色：黑色;内存：32G', '1', '2699.00', '2022.81', '质量问题', '不够高端', '', null, null, null, null, null);
INSERT INTO `order_return_apply` VALUES ('20', '17', null, '28', '201809150101000003', '2018-10-17 14:44:18', 'test', null, '大梨', '18000000000', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '红米5A', '小米', '颜色：金色;内存：16G', '1', '649.00', '591.05', '质量问题', '颜色太土', '', null, null, null, null, null);
INSERT INTO `order_return_apply` VALUES ('21', '18', null, '26', '201809150102000004', '2018-10-17 14:34:57', 'test', null, '大梨', '18000000000', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', '华为 HUAWEI P20', '华为', '颜色：金色;内存：16G', '1', '3788.00', '3585.98', '质量问题', '老是卡', '', null, null, null, null, null);
INSERT INTO `order_return_apply` VALUES ('22', '18', null, '27', '201809150102000004', '2018-10-17 14:40:21', 'test', null, '大梨', '18000000000', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', '小米8', '小米', '颜色：黑色;内存：32G', '1', '2699.00', '2022.81', '质量问题', '不够高端', '', null, null, null, null, null);
INSERT INTO `order_return_apply` VALUES ('23', '18', null, '28', '201809150102000004', '2018-10-17 14:44:18', 'test', null, '大梨', '18000000000', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '红米5A', '小米', '颜色：金色;内存：16G', '1', '649.00', '591.05', '质量问题', '颜色太土', '', null, null, null, null, null);
INSERT INTO `order_return_apply` VALUES ('24', '19', null, '26', '201809130101000003', '2018-10-17 14:34:57', 'test', null, '大梨', '18000000000', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', '华为 HUAWEI P20', '华为', '颜色：金色;内存：16G', '1', '3788.00', '3585.98', '质量问题', '老是卡', '', null, null, null, null, null);
INSERT INTO `order_return_apply` VALUES ('25', '19', null, '27', '201809130101000003', '2018-10-17 14:40:21', 'test', null, '大梨', '18000000000', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', '小米8', '小米', '颜色：黑色;内存：32G', '1', '2699.00', '2022.81', '质量问题', '不够高端', '', null, null, null, null, null);
INSERT INTO `order_return_apply` VALUES ('26', '19', null, '28', '201809130101000003', '2018-10-17 14:44:18', 'test', null, '大梨', '18000000000', '0', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '红米5A', '小米', '颜色：金色;内存：16G', '1', '649.00', '591.05', '质量问题', '颜色太土', '', null, null, null, null, null);
INSERT INTO `order_return_apply` VALUES ('37', '46', '1', '1', '202203216458104820', '2022-03-22 05:34:42', '小哈猫', '0.00', '小哈猫', '13502584597', '1', '2022-03-22 05:51:48', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-02-14/gaolin01.jpg', '潮牌T恤', '香奈儿', '颜色：红色；尺寸：L', '1', '100.00', '100.00', '质量问题', '就是不喜欢', null, null, 'admin', null, null, null);
INSERT INTO `order_return_apply` VALUES ('38', '51', '1', '2', '202203227560273860', '2022-03-22 12:28:39', '小哈猫', '400.00', '小哈猫', '13502584597', '0', null, 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-03-16/u=2395477863,2115259135&fm=253&fmt=auto&app=138&f=JPEG.webp', '银色星芒刺绣网纱底裤2', '七匹狼', '颜色：黑色；尺寸：L', '4', '100.00', '400.00', '其他问题', '买多了', null, null, null, null, null, null);
INSERT INTO `order_return_apply` VALUES ('39', '48', '1', '1', '202203215008146200', '2022-05-02 12:14:12', '小哈猫', '100.00', '小哈猫', '13502584597', '0', null, 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/images/2022-02-14/gaolin01.jpg', '潮牌T恤', '香奈儿', '颜色：红色；尺寸：L', '1', '100.00', '100.00', '尺码太大', '', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `order_return_reason`
-- ----------------------------
DROP TABLE IF EXISTS `order_return_reason`;
CREATE TABLE `order_return_reason` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '退货类型',
  `sort` int(11) DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '状态：0->不启用；1->启用',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='退货原因表';

-- ----------------------------
-- Records of order_return_reason
-- ----------------------------
INSERT INTO `order_return_reason` VALUES ('1', '质量问题', '1', '1', '2018-10-17 10:00:45');
INSERT INTO `order_return_reason` VALUES ('2', '尺码太大', '1', '1', '2018-10-17 10:01:03');
INSERT INTO `order_return_reason` VALUES ('3', '颜色不喜欢', '1', '1', '2018-10-17 10:01:13');
INSERT INTO `order_return_reason` VALUES ('4', '7天无理由退货', '1', '1', '2018-10-17 10:01:47');
INSERT INTO `order_return_reason` VALUES ('5', '价格问题', '1', '0', '2018-10-17 10:01:57');
INSERT INTO `order_return_reason` VALUES ('12', '发票问题', '0', '1', '2018-10-19 16:28:36');
INSERT INTO `order_return_reason` VALUES ('13', '其他问题', '0', '1', '2018-10-19 16:28:51');
INSERT INTO `order_return_reason` VALUES ('14', '物流问题', '0', '1', '2018-10-19 16:29:01');
INSERT INTO `order_return_reason` VALUES ('15', '售后问题', '0', '1', '2018-10-19 16:29:11');

-- ----------------------------
-- Table structure for `prefrence_area_clothing_relation`
-- ----------------------------
DROP TABLE IF EXISTS `prefrence_area_clothing_relation`;
CREATE TABLE `prefrence_area_clothing_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prefrence_area_id` bigint(20) DEFAULT NULL,
  `clothing_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='优选专区和产品关系表';

-- ----------------------------
-- Records of prefrence_area_clothing_relation
-- ----------------------------
INSERT INTO `prefrence_area_clothing_relation` VALUES ('1', '1', '12');
INSERT INTO `prefrence_area_clothing_relation` VALUES ('2', '1', '13');
INSERT INTO `prefrence_area_clothing_relation` VALUES ('3', '1', '14');
INSERT INTO `prefrence_area_clothing_relation` VALUES ('4', '1', '18');
INSERT INTO `prefrence_area_clothing_relation` VALUES ('5', '1', '7');
INSERT INTO `prefrence_area_clothing_relation` VALUES ('6', '2', '7');
INSERT INTO `prefrence_area_clothing_relation` VALUES ('7', '1', '22');
INSERT INTO `prefrence_area_clothing_relation` VALUES ('24', '1', '23');

-- ----------------------------
-- Table structure for `receiver`
-- ----------------------------
DROP TABLE IF EXISTS `receiver`;
CREATE TABLE `receiver` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户-地址表id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `receiver_name` varchar(64) DEFAULT NULL COMMENT '收货人名称',
  `receiver_phone` varchar(64) DEFAULT NULL COMMENT '收货人电话',
  `receiver_province` varchar(64) DEFAULT NULL COMMENT '收货人省份',
  `receiver_city` varchar(64) DEFAULT NULL COMMENT '收货人城市',
  `receiver_region` varchar(64) DEFAULT NULL COMMENT '收货人区/县/乡',
  `receiver_detail_address` varchar(255) DEFAULT NULL COMMENT '收货人详细地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of receiver
-- ----------------------------
INSERT INTO `receiver` VALUES ('1', '7', '陈小哈', '15362999695', '广东省', '中山市', '石岐区街道办事处', '学院路1号');

-- ----------------------------
-- Table structure for `resource`
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `name` varchar(200) DEFAULT NULL COMMENT '资源名称',
  `url` varchar(200) DEFAULT NULL COMMENT '资源URL',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `category_id` bigint(20) DEFAULT NULL COMMENT '资源分类ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='后台资源表';

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '2020-02-04 17:04:55', '商品品牌管理', '/brand/**', null, '1');
INSERT INTO `resource` VALUES ('2', '2020-02-04 17:05:35', '商品属性分类管理', '/productAttribute/**', null, '1');
INSERT INTO `resource` VALUES ('3', '2020-02-04 17:06:13', '商品属性管理', '/productAttribute/**', null, '1');
INSERT INTO `resource` VALUES ('4', '2020-02-04 17:07:15', '商品分类管理', '/productCategory/**', null, '1');
INSERT INTO `resource` VALUES ('5', '2020-02-04 17:09:16', '商品管理', '/product/**', null, '1');
INSERT INTO `resource` VALUES ('6', '2020-02-04 17:09:53', '商品库存管理', '/sku/**', null, '1');
INSERT INTO `resource` VALUES ('8', '2020-02-05 14:43:37', '订单管理', '/order/**', '', '2');
INSERT INTO `resource` VALUES ('9', '2020-02-05 14:44:22', ' 订单退货申请管理', '/returnApply/**', '', '2');
INSERT INTO `resource` VALUES ('10', '2020-02-05 14:45:08', '退货原因管理', '/returnReason/**', '', '2');
INSERT INTO `resource` VALUES ('11', '2020-02-05 14:45:43', '订单设置管理', '/orderSetting/**', '', '2');
INSERT INTO `resource` VALUES ('12', '2020-02-05 14:46:23', '收货地址管理', '/companyAddress/**', '', '2');
INSERT INTO `resource` VALUES ('13', '2020-02-07 16:37:22', '优惠券管理', '/coupon/**', '', '3');
INSERT INTO `resource` VALUES ('14', '2020-02-07 16:37:59', '优惠券领取记录管理', '/couponHistory/**', '', '3');
INSERT INTO `resource` VALUES ('15', '2020-02-07 16:38:28', '限时购活动管理', '/flash/**', '', '3');
INSERT INTO `resource` VALUES ('16', '2020-02-07 16:38:59', '限时购商品关系管理', '/flashProductRelation/**', '', '3');
INSERT INTO `resource` VALUES ('17', '2020-02-07 16:39:22', '限时购场次管理', '/flashSession/**', '', '3');
INSERT INTO `resource` VALUES ('18', '2020-02-07 16:40:07', '首页轮播广告管理', '/home/advertise/**', '', '3');
INSERT INTO `resource` VALUES ('19', '2020-02-07 16:40:34', '首页品牌管理', '/home/brand/**', '', '3');
INSERT INTO `resource` VALUES ('20', '2020-02-07 16:41:06', '首页新品管理', '/home/newProduct/**', '', '3');
INSERT INTO `resource` VALUES ('21', '2020-02-07 16:42:16', '首页人气推荐管理', '/home/recommendProduct/**', '', '3');
INSERT INTO `resource` VALUES ('22', '2020-02-07 16:42:48', '首页专题推荐管理', '/home/recommendSubject/**', '', '3');
INSERT INTO `resource` VALUES ('23', '2020-02-07 16:44:56', ' 商品优选管理', '/prefrenceArea/**', '', '5');
INSERT INTO `resource` VALUES ('24', '2020-02-07 16:45:39', '商品专题管理', '/subject/**', '', '5');
INSERT INTO `resource` VALUES ('25', '2020-02-07 16:47:34', '后台用户管理', '/admin/**', '', '4');
INSERT INTO `resource` VALUES ('26', '2020-02-07 16:48:24', '后台用户角色管理', '/role/**', '', '4');
INSERT INTO `resource` VALUES ('27', '2020-02-07 16:48:48', '后台菜单管理', '/menu/**', '', '4');
INSERT INTO `resource` VALUES ('28', '2020-02-07 16:49:18', '后台资源分类管理', '/resourceCategory/**', '', '4');
INSERT INTO `resource` VALUES ('29', '2020-02-07 16:49:45', '后台资源管理', '/resource/**', '', '4');

-- ----------------------------
-- Table structure for `roles`
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', '超级管理员', '管理所有，操作所有', '2022-03-24 23:12:34', '1');
INSERT INTO `roles` VALUES ('2', '普通用户', '前台的可操作', '2022-03-24 23:12:54', '1');
INSERT INTO `roles` VALUES ('3', '测试角色1', '前台的可操作', '2022-03-24 23:12:55', '1');
INSERT INTO `roles` VALUES ('4', '测试角色2', '前台的可操作', '2022-03-24 23:12:56', '1');
INSERT INTO `roles` VALUES ('5', '测试角色3', '前台的可操作', '2022-03-24 23:12:56', '1');
INSERT INTO `roles` VALUES ('7', '111', '111', '2022-03-25 05:45:40', '1');
INSERT INTO `roles` VALUES ('8', '222', '222', '2022-03-25 05:47:18', '0');
INSERT INTO `roles` VALUES ('9', '333', '333', '2022-03-25 06:24:28', '1');
INSERT INTO `roles` VALUES ('10', '444', '444', '2022-03-25 06:24:36', '1');

-- ----------------------------
-- Table structure for `roles_user`
-- ----------------------------
DROP TABLE IF EXISTS `roles_user`;
CREATE TABLE `roles_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT '2',
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`),
  KEY `roles_user_ibfk_2` (`uid`),
  CONSTRAINT `roles_user_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `roles` (`id`),
  CONSTRAINT `roles_user_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles_user
-- ----------------------------
INSERT INTO `roles_user` VALUES ('8', '2', '7');
INSERT INTO `roles_user` VALUES ('106', '2', '14');
INSERT INTO `roles_user` VALUES ('108', '2', '16');
INSERT INTO `roles_user` VALUES ('109', '2', '17');
INSERT INTO `roles_user` VALUES ('110', '2', '18');
INSERT INTO `roles_user` VALUES ('111', '2', '19');
INSERT INTO `roles_user` VALUES ('119', '2', '15');
INSERT INTO `roles_user` VALUES ('120', '5', '15');
INSERT INTO `roles_user` VALUES ('123', '2', '13');
INSERT INTO `roles_user` VALUES ('124', '3', '13');
INSERT INTO `roles_user` VALUES ('133', '1', '6');
INSERT INTO `roles_user` VALUES ('135', '1', '10');
INSERT INTO `roles_user` VALUES ('148', '2', '43');
INSERT INTO `roles_user` VALUES ('149', '2', '44');
INSERT INTO `roles_user` VALUES ('150', '2', '27');

-- ----------------------------
-- Table structure for `sku_stock`
-- ----------------------------
DROP TABLE IF EXISTS `sku_stock`;
CREATE TABLE `sku_stock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `clothing_id` bigint(20) DEFAULT NULL,
  `sku_code` varchar(64) NOT NULL COMMENT 'sku编码',
  `price` decimal(10,2) DEFAULT NULL,
  `stock` int(11) DEFAULT '0' COMMENT '库存',
  `low_stock` int(11) DEFAULT NULL COMMENT '预警库存',
  `pic` varchar(255) DEFAULT NULL COMMENT '展示图片',
  `sale` int(11) DEFAULT NULL COMMENT '销量',
  `promotion_price` decimal(10,2) DEFAULT NULL COMMENT '单品促销价格',
  `lock_stock` int(11) DEFAULT '0' COMMENT '锁定库存',
  `sp_data` varchar(500) DEFAULT NULL COMMENT '商品销售属性，json格式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=179 DEFAULT CHARSET=utf8 COMMENT='sku的库存';

-- ----------------------------
-- Records of sku_stock
-- ----------------------------
INSERT INTO `sku_stock` VALUES ('98', '27', '201808270027001', '2699.00', '97', null, null, null, null, '-24', '[{\"key\":\"颜色\",\"value\":\"黑色\"},{\"key\":\"容量\",\"value\":\"32G\"}]');
INSERT INTO `sku_stock` VALUES ('99', '27', '201808270027002', '2999.00', '100', null, null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"黑色\"},{\"key\":\"容量\",\"value\":\"64G\"}]');
INSERT INTO `sku_stock` VALUES ('100', '27', '201808270027003', '2699.00', '100', null, null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"蓝色\"},{\"key\":\"容量\",\"value\":\"32G\"}]');
INSERT INTO `sku_stock` VALUES ('101', '27', '201808270027004', '2999.00', '100', null, null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"蓝色\"},{\"key\":\"容量\",\"value\":\"64G\"}]');
INSERT INTO `sku_stock` VALUES ('102', '28', '201808270028001', '649.00', '99', null, null, null, null, '-8', '[{\"key\":\"颜色\",\"value\":\"金色\"},{\"key\":\"容量\",\"value\":\"16G\"}]');
INSERT INTO `sku_stock` VALUES ('103', '28', '201808270028002', '699.00', '99', null, null, null, null, '-8', '[{\"key\":\"颜色\",\"value\":\"金色\"},{\"key\":\"容量\",\"value\":\"32G\"}]');
INSERT INTO `sku_stock` VALUES ('104', '28', '201808270028003', '649.00', '100', null, null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"银色\"},{\"key\":\"容量\",\"value\":\"16G\"}]');
INSERT INTO `sku_stock` VALUES ('105', '28', '201808270028004', '699.00', '100', null, null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"银色\"},{\"key\":\"容量\",\"value\":\"32G\"}]');
INSERT INTO `sku_stock` VALUES ('106', '29', '201808270029001', '5499.00', '99', null, null, null, null, '-8', '[{\"key\":\"颜色\",\"value\":\"金色\"},{\"key\":\"容量\",\"value\":\"32G\"}]');
INSERT INTO `sku_stock` VALUES ('107', '29', '201808270029002', '6299.00', '100', null, null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"金色\"},{\"key\":\"容量\",\"value\":\"64G\"}]');
INSERT INTO `sku_stock` VALUES ('108', '29', '201808270029003', '5499.00', '100', null, null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"银色\"},{\"key\":\"容量\",\"value\":\"32G\"}]');
INSERT INTO `sku_stock` VALUES ('109', '29', '201808270029004', '6299.00', '100', null, null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"银色\"},{\"key\":\"容量\",\"value\":\"64G\"}]');
INSERT INTO `sku_stock` VALUES ('110', '26', '201806070026001', '3788.00', '499', null, null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"金色\"},{\"key\":\"容量\",\"value\":\"16G\"}]');
INSERT INTO `sku_stock` VALUES ('111', '26', '201806070026002', '3999.00', '500', null, null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"金色\"},{\"key\":\"容量\",\"value\":\"32G\"}]');
INSERT INTO `sku_stock` VALUES ('112', '26', '201806070026003', '3788.00', '500', null, null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"银色\"},{\"key\":\"容量\",\"value\":\"16G\"}]');
INSERT INTO `sku_stock` VALUES ('113', '26', '201806070026004', '3999.00', '500', null, null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"银色\"},{\"key\":\"容量\",\"value\":\"32G\"}]');
INSERT INTO `sku_stock` VALUES ('163', '36', '202002210036001', '100.00', '100', '25', null, null, null, '9', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"38\"},{\"key\":\"风格\",\"value\":\"秋季\"}]');
INSERT INTO `sku_stock` VALUES ('164', '36', '202002210036002', '120.00', '98', '20', null, null, null, '6', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"38\"},{\"key\":\"风格\",\"value\":\"夏季\"}]');
INSERT INTO `sku_stock` VALUES ('165', '36', '202002210036003', '100.00', '100', '20', null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"39\"},{\"key\":\"风格\",\"value\":\"秋季\"}]');
INSERT INTO `sku_stock` VALUES ('166', '36', '202002210036004', '100.00', '100', '20', null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"39\"},{\"key\":\"风格\",\"value\":\"夏季\"}]');
INSERT INTO `sku_stock` VALUES ('167', '36', '202002210036005', '100.00', '100', '20', null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"蓝色\"},{\"key\":\"尺寸\",\"value\":\"38\"},{\"key\":\"风格\",\"value\":\"秋季\"}]');
INSERT INTO `sku_stock` VALUES ('168', '36', '202002210036006', '100.00', '100', '20', null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"蓝色\"},{\"key\":\"尺寸\",\"value\":\"38\"},{\"key\":\"风格\",\"value\":\"夏季\"}]');
INSERT INTO `sku_stock` VALUES ('169', '36', '202002210036007', '100.00', '100', '20', null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"蓝色\"},{\"key\":\"尺寸\",\"value\":\"39\"},{\"key\":\"风格\",\"value\":\"秋季\"}]');
INSERT INTO `sku_stock` VALUES ('170', '36', '202002210036008', '100.00', '100', '20', null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"蓝色\"},{\"key\":\"尺寸\",\"value\":\"39\"},{\"key\":\"风格\",\"value\":\"夏季\"}]');
INSERT INTO `sku_stock` VALUES ('171', '35', '202002250035001', '200.00', '100', '50', null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"38\"},{\"key\":\"风格\",\"value\":\"夏季\"}]');
INSERT INTO `sku_stock` VALUES ('172', '35', '202002250035002', '240.00', '100', '50', null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"38\"},{\"key\":\"风格\",\"value\":\"秋季\"}]');
INSERT INTO `sku_stock` VALUES ('173', '35', '202002250035003', '200.00', '100', '50', null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"39\"},{\"key\":\"风格\",\"value\":\"夏季\"}]');
INSERT INTO `sku_stock` VALUES ('174', '35', '202002250035004', '200.00', '100', '50', null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"红色\"},{\"key\":\"尺寸\",\"value\":\"39\"},{\"key\":\"风格\",\"value\":\"秋季\"}]');
INSERT INTO `sku_stock` VALUES ('175', '35', '202002250035005', '200.00', '100', '50', null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"蓝色\"},{\"key\":\"尺寸\",\"value\":\"38\"},{\"key\":\"风格\",\"value\":\"夏季\"}]');
INSERT INTO `sku_stock` VALUES ('176', '35', '202002250035006', '200.00', '100', '50', null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"蓝色\"},{\"key\":\"尺寸\",\"value\":\"38\"},{\"key\":\"风格\",\"value\":\"秋季\"}]');
INSERT INTO `sku_stock` VALUES ('177', '35', '202002250035007', '200.00', '100', '50', null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"蓝色\"},{\"key\":\"尺寸\",\"value\":\"39\"},{\"key\":\"风格\",\"value\":\"夏季\"}]');
INSERT INTO `sku_stock` VALUES ('178', '35', '202002250035008', '200.00', '100', '50', null, null, null, '0', '[{\"key\":\"颜色\",\"value\":\"蓝色\"},{\"key\":\"尺寸\",\"value\":\"39\"},{\"key\":\"风格\",\"value\":\"秋季\"}]');

-- ----------------------------
-- Table structure for `subject_clothing_relation`
-- ----------------------------
DROP TABLE IF EXISTS `subject_clothing_relation`;
CREATE TABLE `subject_clothing_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `subject_id` bigint(20) DEFAULT NULL,
  `clothing_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8 COMMENT='专题商品关系表';

-- ----------------------------
-- Records of subject_clothing_relation
-- ----------------------------
INSERT INTO `subject_clothing_relation` VALUES ('1', '1', '12');
INSERT INTO `subject_clothing_relation` VALUES ('2', '1', '13');
INSERT INTO `subject_clothing_relation` VALUES ('3', '1', '14');
INSERT INTO `subject_clothing_relation` VALUES ('4', '1', '18');
INSERT INTO `subject_clothing_relation` VALUES ('5', '1', '7');
INSERT INTO `subject_clothing_relation` VALUES ('6', '2', '7');
INSERT INTO `subject_clothing_relation` VALUES ('7', '1', '22');
INSERT INTO `subject_clothing_relation` VALUES ('29', '1', '23');
INSERT INTO `subject_clothing_relation` VALUES ('30', '4', '23');
INSERT INTO `subject_clothing_relation` VALUES ('31', '5', '23');
INSERT INTO `subject_clothing_relation` VALUES ('59', '2', '26');
INSERT INTO `subject_clothing_relation` VALUES ('60', '3', '26');
INSERT INTO `subject_clothing_relation` VALUES ('61', '6', '26');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `nickname` varchar(64) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `phone` varchar(64) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(64) DEFAULT NULL,
  `sex` varchar(64) DEFAULT NULL COMMENT '性别',
  `userface` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `reg_time` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('6', 'erha', '二哈', 'e10adc3949ba59abbe56e057f20f883e', '0', '13502584598', 'erha@qq.com', '男', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/user/u%3D3097645041%2C4008336372%26fm%3D253%26fmt%3Dauto%26app%3D138%26f%3DJPEG.png', '1', '2022-03-17 15:31:34');
INSERT INTO `user` VALUES ('7', '小哈猫', '小陈陈', '202cb962ac59075b964b07152d234b70', '0', '13502584597', 'xhm123@qq.com', '男', 'https://clothing-xhm.oss-cn-shenzhen.aliyuncs.com/clothing/user/wx-xhm.jpg', '1', '2022-03-01 15:31:38');
INSERT INTO `user` VALUES ('10', 'qiaofeng', '乔峰', 'e10adc3949ba59abbe56e057f20f883e', '0', '13502584598', 'qiaofeng@qq.com', '男', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', '1', '2022-03-17 15:31:44');
INSERT INTO `user` VALUES ('13', 'duanzhengchun', '段正淳', '202cb962ac59075b964b07152d234b70', '0', '13502584598', 'duanzhengchun@qq.com', '女', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', '1', '2022-03-17 15:31:48');
INSERT INTO `user` VALUES ('14', 'chenjialuo', '陈家洛', '202cb962ac59075b964b07152d234b70', '0', '13502584598', 'chenjialuo@qq.com', '男', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', '1', '2022-03-17 15:31:52');
INSERT INTO `user` VALUES ('15', 'yuanchengzhi', '袁承志', '202cb962ac59075b964b07152d234b70', '1', '13502584598', 'yuanchengzhi@qq.com', '女', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', '1', '2022-03-17 15:31:56');
INSERT INTO `user` VALUES ('16', 'chuliuxiang', '楚留香', '202cb962ac59075b964b07152d234b70', '1', '13502584598', 'chuliuxiang@qq.com', '男', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', '1', '2022-03-17 15:32:00');
INSERT INTO `user` VALUES ('17', 'baizhantang', '白展堂', '202cb962ac59075b964b07152d234b70', '0', '13502584598', 'baizhantang@qq.com', '男', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', '1', '2022-03-17 15:32:03');
INSERT INTO `user` VALUES ('18', 'renwoxing', '任我行', '202cb962ac59075b964b07152d234b70', '1', '13502584598', 'renwoxing@qq.com', '女', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', '1', '2022-03-17 15:32:07');
INSERT INTO `user` VALUES ('19', 'zuolengchan', '左冷禅', '202cb962ac59075b964b07152d234b70', '1', '13502584598', 'zuolengchan@qq.com', '女', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', '1', '2022-03-17 15:32:11');
INSERT INTO `user` VALUES ('26', '222', '222', 'bcbe3365e6ac95ea2c0343a2395834dd', '0', '15362748759', '222', '男', null, '1', '2022-03-25 05:08:43');
INSERT INTO `user` VALUES ('27', '333', '333', '310dcbbf4cce62f762a2aaa148d556bd', '0', '333333', '333', '', null, '1', '2022-03-25 06:11:07');
INSERT INTO `user` VALUES ('43', '999', '999', 'b706835de79a2b4e80506f582af3676a', '0', '999', '999', '女', null, '1', '2022-04-01 02:55:49');
INSERT INTO `user` VALUES ('44', '666', '666', 'fae0b27c451c728867a567e8c1bb4e53', '0', '666', '666', '男', null, '1', '2022-04-01 02:56:40');

-- ----------------------------
-- Procedure structure for `addDep`
-- ----------------------------
DROP PROCEDURE IF EXISTS `addDep`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addDep`(in depName varchar(32),in parentId int,in enabled boolean,out result int,out result2 int)
begin
  declare did int;
  declare pDepPath varchar(64);
  insert into department set name=depName,parentId=parentId,enabled=enabled;
  select row_count() into result;
  select last_insert_id() into did;
  set result2=did;
  select depPath into pDepPath from department where id=parentId;
  update department set depPath=concat(pDepPath,'.',did) where id=did;
  update department set isParent=true where id=parentId;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `deleteDep`
-- ----------------------------
DROP PROCEDURE IF EXISTS `deleteDep`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteDep`(in did int,out result int)
begin
  declare ecount int;
  declare pid int;
  declare pcount int;
  declare a int;
  select count(*) into a from department where id=did and isParent=false;
  if a=0 then set result=-2;
  else
  select count(*) into ecount from employee where departmentId=did;
  if ecount>0 then set result=-1;
  else
  select parentId into pid from department where id=did;
  delete from department where id=did and isParent=false;
  select row_count() into result;
  select count(*) into pcount from department where parentId=pid;
  if pcount=0 then update department set isParent=false where id=pid;
  end if;
  end if;
  end if;
end
;;
DELIMITER ;
