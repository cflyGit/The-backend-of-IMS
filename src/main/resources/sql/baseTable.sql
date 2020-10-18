create table base(
base_id bigint(10) not null auto_increment,
name varchar(128) not null,
phone varchar(11) not null,
address varchar(128) not null,
register_time timestamp,
primary key(base_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;