create table admin(
    admin_id bigint(10) not null auto_increment,
    name varchar(24),
    password varchar(20) not null,
    email varchar(64),
    primary key(admin_id)
)

-- 测试
insert into admin(admin_id, name, password, email)
values(1000, 'admin', '12345', 'ims_test@bupt.com');