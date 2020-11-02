-- 创建数据库 ims
create database imsdb_v1;

use imsdb_v1;

-- 创建admin（研究生院）用户表
create table admin(
    admin_id varchar(32) not null,
    name varchar(24),
    email varchar(64),
    primary key(admin_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into admin(admin_id, name, email) values(1000, "cfly", "ims@ims.com");

-- 创建student（学生）用户表
create table student(
    student_id varchar(32) not null,
    name varchar(24) not null,
    academy varchar(48),
    tutor varchar(32),
    tutor1 varchar(32),
    age integer,
    phone varchar(11),
    qq varchar(16),
    wechat varchar(64),
    email varchar(64),
    register_time timestamp,
    primary key(student_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建 tutor（导师）用户表
create table tutor(
    tutor_id varchar(32) not null,
    name varchar(24),
    academy varchar(48),
    age integer,
    phone varchar(11),
    qq varchar(16),
    wechat varchar(64),
    email varchar(64),
    register_time timestamp,
    primary key(tutor_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 创建base(基地）用户表
create table base(
    base_id varchar(32) not null,
    name varchar(128) not null,
    phone varchar(11) not null,
    address varchar(128) not null,
    register_time timestamp,
    primary key(base_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- =================== 用户-角色-权限表 ======================== --
-- ----------------------- 用户表 ----------------------------------
create table user(
    username varchar(32) not null,
    password varchar(64) not null,
    primary key(username)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ------------------------- 用户表 -----------------------------

-- ----------------------- 用户角色关系表 --------------------------
create table user_role(
    username varchar(32) not null,
    role_id varchar(64) not null,
    primary key(username, role_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into user(username, password) values(1000, "$2a$10$sKPm1Jf7P9ACcy25TFH8OuOJXIFNaQtJoNx2Bxe9sdDHxlcNIp7lq");
insert into user_role(username, role_id) values(1000, "Admin");
-- ---------------------- 用户角色表 -------------------------------

-- --------------------- 角色权限表 --------------------------------
create table role_permission(
    role_id varchar(64) not null,
    permission_id bigint(10) not null,
    primary key(role_id, permission_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into role_permission(role_id, permission_id) values("Admin", 1), ("Admin", 2), ("Admin", 3), ("Admin", 4),
("Tutor", 2), ("Base", 3), ("Student", 4);
-- --------------------- 角色权限表 --------------------------------

-- ---------------------- 权限表 -----------------------------------
create table permission (
    permission_id bigint(10) not null,
    code varchar(32) not null comment '权限标识符',
    url varchar(128) default null comment '请求地址',
    primary key(permission_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into permission(permission_id, code, url)
values(1, "p1", "/**"), (2, "p2", "/tutor/**"), (3, "p3", "/base/**"), (4, "p4", "/student/**");
-- --------------------- 权限表 ------------------------------------
-- =================== 用户-角色-权限表 ======================== --

-- 创建工程信息表
create table project(
    project_id bigint(10) auto_increment not null,
    name varchar(128) not null,
    base varchar (32) not null,
    leader varchar(64) not null,
    address varchar(128) not null,
    number int not null,
    recorded int,
    tags varchar(255),
    info varchar(2048),
    file varchar(128),
    application_time timestamp,
    audit_time timestamp NULL,
    signed_time timestamp NULL,
    publish_time timestamp NULL,
    finished_time timestamp NULL,
    status int,
    primary key(project_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建审核信息表
create table audit(
    project_id bigint(10) not null,
    application_comments varchar(1024),
    application_reviewer varchar(24),
    audit_comments varchar(1024),
    audit_reviewer varchar(24),
    signed_comments varchar(1024),
    signed_reviewer varchar(24),
    publish_comments varchar(1024),
    publish_reviewer varchar(24),
    finished_comments varchar(1024),
    finished_reviewer varchar(24),
    primary key(project_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;



