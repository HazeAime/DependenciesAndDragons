drop database if exists dnddb;
create database dnddb;
use dnddb;

create table `user` (
	id int primary key auto_increment,
    username varchar(30) not null unique,
    `password` varchar(100) not null,
    enabled boolean not null
);

create table `role` (
	id int primary key auto_increment,
	`role` varchar(30) not null
);

create table user_role (
	userid int not null,
    roleid int not null,
    primary key (userid, roleid),
    foreign key (userid) references user(id),
    foreign key (roleid) references role(id)
);

insert into `user` (username, `password`, enabled)
values
	('Admin', 'password', 1),
    ('DM1', 'password', 1),
    ('Player1', 'password', 1);
    
insert into `role` (`role`)
values
	('ROLE_ADMIN'),
    ('ROLE_DM'),
    ('ROLE_PLAYER');
    
insert into user_role (userid, roleid)
values
	(1, 1),
    (2, 2),
    (3, 3);
    
UPDATE user SET password = '$2a$10$S8nFUMB8YIEioeWyap24/ucX.dC6v9tXCbpHjJVQUkrXlrH1VLaAS' WHERE id = 1;
UPDATE user SET password = '$2a$10$S8nFUMB8YIEioeWyap24/ucX.dC6v9tXCbpHjJVQUkrXlrH1VLaAS' WHERE id = 2;
UPDATE user SET password = '$2a$10$S8nFUMB8YIEioeWyap24/ucX.dC6v9tXCbpHjJVQUkrXlrH1VLaAS' WHERE id = 3;