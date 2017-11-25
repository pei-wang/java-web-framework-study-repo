CREATE DATABASE demo;
use demo;
create TABLE `customer` (
  `id` bigint(20) not null auto_increment,
  `name` varchar(255) default null,
  `contact` varchar(255) default null,
  `telephone` varchar(255) default null,
  `email` varchar(255) default null,
  `remark` text,
  primary key (`id`)
) engine=InnoDB default charset=utf8;

INSERT INTO `customer` VALUE ('1', 'customer1', 'Jack', '13512345678','jack@gmail.com',NULL);
INSERT INTO `customer` VALUE ('2', 'customer2', 'Rose', '13512345678','Rose@gmail.com',NULL);
