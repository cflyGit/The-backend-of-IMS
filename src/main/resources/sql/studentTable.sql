create table student(
student_id bigint(10) auto_increment not null,
name varchar(24) not null,
password varchar(64) not null,
academy varchar(48),
tutor bigint(10),
age integer,
phone varchar(11),
qq varchar(16),
wechat varchar(64),
email varchar(64),
register_time timestamp,
primary key(student_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;