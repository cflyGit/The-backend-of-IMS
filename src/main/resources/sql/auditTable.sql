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