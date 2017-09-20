/*
navicat mysql data transfer

source server         : mysql连接
source server version : 50717
source host           : 127.0.0.1:3306
source database       : springmvc

target server type    : mysql
target server version : 50717
file encoding         : 65001

date: 2017-09-13 11:48:44
*/

set foreign_key_checks=0;

-- ----------------------------
-- table structure for orders
-- ----------------------------
drop table if exists `orders`;
create table `orders` (
  `id` varchar(36) not null,
  `name` varchar(20) default null,
  `price` decimal(10,0) default null,
  `productid` varchar(36) default null,
  `userid` varchar(36) default null,
  `createtime` datetime default null,
  primary key (`id`)
) engine=innodb default charset=utf8;

-- ----------------------------
-- records of orders
-- ----------------------------
insert into `orders` values ('1', '苹果销售', '4000', '1', '1', '2017-09-13 11:40:00');

-- ----------------------------
-- table structure for orders_items
-- ----------------------------
drop table if exists ordersitems;
create table `orders_items` (
  `id` varchar(36) not null,
  `orderid` varchar(36) default null,
  `count` int(11) default null,
  `price` decimal(10,0) default null,
  `summoney` decimal(10,0) default null,
  `createtime` datetime default null,
  primary key (`id`)
) engine=innodb default charset=utf8;

-- ----------------------------
-- records of orders_items
-- ----------------------------
insert into ordersitems values ('1', '1', '2', '3800', '7600', '2017-09-13 11:42:03');

-- ----------------------------
-- table structure for product
-- ----------------------------
drop table if exists `product`;
create table `product` (
  `id` varchar(36) not null,
  `name` varchar(20) default null,
  `price` decimal(10,0) default null,
  primary key (`id`)
) engine=innodb default charset=utf8;

-- ----------------------------
-- records of product
-- ----------------------------
insert into `product` values ('1', 'iphone6sp', '4000');
insert into `product` values ('2', 'iphone7s', '6000');
insert into `product` values ('3', 'oppo', '3000');

-- ----------------------------
-- table structure for student
-- ----------------------------
drop table if exists `student`;
create table `student` (
  `id` varchar(36) not null,
  `name` varchar(20) default null,
  `age` int(11) default null,
  `sex` int(11) default null,
  `classno` int(11) default null,
  primary key (`id`)
) engine=innodb default charset=utf8;

-- ----------------------------
-- records of student
-- ----------------------------
insert into `student` values ('10', '条件修改', '12', '1', '4');
insert into `student` values ('11', '阿斯蒂芬', '23', '1', '3');
insert into `student` values ('16', '撒地和托管费', '17', '1', '4');
insert into `student` values ('17', '合格后', '19', '0', '6');
insert into `student` values ('1b93eae4982811e799662c56dc7feae4', '测试', '12', '1', '4');
insert into `student` values ('1f487a3396c411e78dcc2c56dc7feae4', '454654', '45', '1', '2');
insert into `student` values ('4', '那边吗', '23', '1', '5');
insert into `student` values ('4842925696ed11e78dcc2c56dc7feae4', 'sghf', '34', '0', '1');
insert into `student` values ('5', '梵蒂冈和', '24', '0', '3');
insert into `student` values ('6e2f618296c411e78dcc2c56dc7feae4', '4646', '45', '0', '5');
insert into `student` values ('7', '染发个人', '27', '0', '6');
insert into `student` values ('9', '吗你们', '20', '0', '1');
insert into `student` values ('946271b396c511e78dcc2c56dc7feae4', '婆婆婆婆', '23', '1', '1');

-- ----------------------------
-- table structure for user
-- ----------------------------
drop table if exists `user`;
create table `user` (
  `id` varchar(36) not null,
  `name` varchar(20) default null,
  `age` int(11) default null,
  primary key (`id`)
) engine=innodb default charset=utf8;

-- ----------------------------
-- records of user
-- ----------------------------
insert into `user` values ('1', '张三', '21');
select ifnull(sum(money),0.0) from money where play_id=1

select * from student limit 0,5