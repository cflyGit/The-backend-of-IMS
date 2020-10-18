create table project(
project_id bigint(10) auto_increment not null,
name varchar(128) not null,
base bigint(10) not null,
leader varchar(64) not null,
address varchar(128) not null,
number int not null,
recorded int,
tags varchar(255),
info varchar(2048),
file varchar(128),
application_time timestamp,
audit_time timestamp,
signed_time timestamp,
publish_time timestamp,
finished_time timestamp,
status int,
primary key(project_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;