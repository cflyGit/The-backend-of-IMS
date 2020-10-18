create table itemList(
order_id bigint(10) not null auto_increment,
project_id bigint(10),
student_id bigint(10),
file varchar(128),
time timestamp,
-- 实习进行到的状态
status int,
primary key(order_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;