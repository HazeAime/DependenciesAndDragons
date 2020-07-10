drop database if exists dnddbTest;
create database dnddbTest;
use dnddbTest;

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
	userId int not null,
    roleId int not null,
    primary key (userId, roleId),
    foreign key (userId) references user(id),
    foreign key (roleId) references role(id)
);

create table characterClass (
	id int primary key auto_increment,
    `name` varchar(20) not null,
    hitDie varchar(3) not null,
    primaryAbility varchar(20) not null,
    saves varchar(30) not null
    );
    
create table item (
	id int primary key auto_increment,
    `name` varchar(20) not null,
    `description` varchar(100)
    );
    
create table skill (
	id int primary key auto_increment,
    `name` varchar(30) not null,
    `description` varchar(100) not null
    );
    
create table attackOrSpell (
	id int primary key auto_increment,
    `name` varchar(30) not null,
    `description` varchar(30) not null,
    damage int not null
    );

create table race (
	id int primary key auto_increment,
    `name` varchar(30) not null,
    `description` varchar(100) not null
    );
    
create table alignment (
	id int primary key auto_increment,
    `name` varchar(20) not null
    );
    
create table dndCampaign (
	id int primary key auto_increment,
    map varchar(100) not null,
    `description` varchar(200) not null,
    userId int not null,
    foreign key (userId)
		references `user`(id)
    );
   
create table dndCharacter (
	id int primary key auto_increment,
    characterName varchar(30) not null,
    playerName varchar(30) not null,
    alignmentId int not null,
    xp int not null,
    characterLvl int not null,
    raceId int not null,
    classId int not null,
    strength int not null,
    dexterity int not null,
    constitution int not null,
    intelligence int not null,
    wisdom int not null,
    charisma int not null,
    stStrength int not null,
    stDexterity int not null,
	stConstitution int not null,
    stIntelligence int not null,
    stWisdom int not null,
    stCharisma int not null,
    money int not null,
    backstory varchar(200),
    hitDice int not null,
    armorClass int not null,
    campaignId int not null,
    foreign key (campaignId)
		references dndCampaign(id),
    foreign key (classId)
		references characterClass(id),
	foreign key (alignmentId)
		references alignment(id),
	foreign key (raceId)
		references race(id)
    );
 
create table character_item (
	characterId int not null,
    itemId int not null,
    primary key(characterId, itemId),
    foreign key (characterId)
		references dndCharacter(id),
	foreign key (itemId)
		references item(id)
	);
    
create table character_skill (
	characterId int not null,
    skillId int not null,
    primary key(characterId, skillId),
    foreign key (characterId)
		references dndCharacter(id),
	foreign key (skillId)
		references skill(id)
	);
    
create table character_attackOrSpell (
	characterId int not null,
    attackOrSpellId int not null,
    primary key(characterId, attackOrSpellId),
    foreign key (characterId)
		references dndCharacter(id),
	foreign key (attackOrSpellId)
		references attackOrSpell(id)
	);
    
insert into `user` (username, `password`, enabled) values
	('Admin', 'password', 1),
    ('DM1', 'password', 1),
    ('Player1', 'password', 1);
    
insert into `role` (`role`) values
	('ROLE_ADMIN'),
    ('ROLE_DM'),
    ('ROLE_PLAYER');
    
insert into user_role (userId, roleId) values
	(1, 1),
    (2, 2),
    (3, 3);
    
UPDATE user SET password = '$2a$10$S8nFUMB8YIEioeWyap24/ucX.dC6v9tXCbpHjJVQUkrXlrH1VLaAS' WHERE id = 1;
UPDATE user SET password = '$2a$10$S8nFUMB8YIEioeWyap24/ucX.dC6v9tXCbpHjJVQUkrXlrH1VLaAS' WHERE id = 2;
UPDATE user SET password = '$2a$10$S8nFUMB8YIEioeWyap24/ucX.dC6v9tXCbpHjJVQUkrXlrH1VLaAS' WHERE id = 3;