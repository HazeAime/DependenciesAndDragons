drop database if exists dnddb;
create database dnddb;
use dnddb;

create table `User` (
	id int primary key auto_increment,
    username varchar(30) not null unique,
    `password` varchar(100) not null,
    enabled boolean not null
);

create table `Role` (
	id int primary key auto_increment,
	`role` varchar(30) not null
);

create table User_Role (
	userId int not null,
    roleId int not null,
    primary key (userId, roleId),
    foreign key (userId) references `User`(id),
    foreign key (roleId) references `Role`(id)
);

create table CharacterClass (
	id int primary key auto_increment,
    `name` varchar(20) not null,
    hitDie varchar(3) not null,
    primaryAbility varchar(20) not null,
    saves varchar(30) not null
    );
    
create table Item (
	id int primary key auto_increment,
    `name` varchar(100) not null,
    `description` varchar(250)
    );
    
create table Skill (
	id int primary key auto_increment,
    `name` varchar(30) not null,
    `description` varchar(250) not null
    );
    
create table AttackOrSpell (
	id int primary key auto_increment,
    `name` varchar(30) not null,
    `description` varchar(250) not null,
    damage varchar(5) not null
    );

create table Race (
	id int primary key auto_increment,
    `name` varchar(30) not null,
    `description` varchar(250) not null
    );
    
create table Alignment (
	id int primary key auto_increment,
    `name` varchar(20) not null
    );
    
create table DndCampaign (
	id int primary key auto_increment,
    map varchar(100) not null,
    `description` varchar(250) not null,
    userId int not null,
    foreign key (userId)
		references `User`(id)
    );
   
create table DndCharacter (
	id int primary key auto_increment,
    approval boolean default false not null,
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
		references DndCampaign(id),
    foreign key (classId)
		references CharacterClass(id),
	foreign key (alignmentId)
		references Alignment(id),
	foreign key (raceId)
		references Race(id)
    );
 
create table Character_Item (
	characterId int not null,
    itemId int not null,
    primary key(characterId, itemId),
    foreign key (characterId)
		references DndCharacter(id),
	foreign key (itemId)
		references Item(id)
	);
    
create table Character_Skill (
	characterId int not null,
    skillId int not null,
    primary key(characterId, skillId),
    foreign key (characterId)
		references DndCharacter(id),
	foreign key (skillId)
		references Skill(id)
	);
    
create table Character_AttackOrSpell (
	characterId int not null,
    attackOrSpellId int not null,
    primary key(characterId, attackOrSpellId),
    foreign key (characterId)
		references DndCharacter(id),
	foreign key (attackOrSpellId)
		references AttackOrSpell(id)
	);
    
insert into `User` (username, `password`, enabled) values
	('Admin', 'password', 1),
    ('DM1', 'password', 1),
    ('Player1', 'password', 1);
    
insert into `Role` (`role`) values
	('ROLE_ADMIN'),
    ('ROLE_DM'),
    ('ROLE_PLAYER');
    
insert into User_Role (userId, roleId) values
	(1, 1),
    (2, 2),
    (3, 3);
    
insert into CharacterClass (`name`, hitDie, primaryAbility, saves) values
	('Ranger', 'd10', 'Dexterity & Wisdom', 'Strength & Dexterity'),
    ('Barbarian', 'd12', 'Strength', 'Strength & Constitution'),
    ('Rogue', 'd8', 'Dexterity', 'Dexterity & Intelligence'),
    ('Wizard', 'd6', 'Intelligence', 'Intelligence & Wisdom'),
    ('Cleric', 'd8', 'Wisdom', 'Wisdom & Charisma');
    
insert into Item (`name`, `description`) values
	('Backpack', 'Adventuring gear (container)'),
    ('Candle', 'Adventuring gear (Duration: 1 HourRange: 5/10)'),
    ('Grappling Hook', 'Adventuring gear (Item Rarity: Standard, Weight: 4)'),
    ('Ring of Acid Resistance', 'Ring'),
    ('Blanket', 'Adventuring gear (Weight: 3)');
    
insert into Skill (`name`, `description`) values
	('Acrobatics', 'Acrobatics covers your attempts to stay on your feet. Climbing sheer objects, 
    navigating slippery terrain or doing flips are some examples.'),
    
    ('Medicine', 'Medicine lets you try to stabilize a dying companion or diagnose an illness.'),
    
    ('Perception', 'Perception lets you spot, hear, or otherwise detect the presence of something. 
    It measures your general awareness of your surroundings and the keenness of your senses.');
    
insert into AttackOrSpell (`name`, `description`, damage) values
	('Cause Fear', 'Costs 1 action, Duration: 1 minute, Range: 60ft, WISDOM Save, inflicts Frightened', 0),
    ('Charm Person', 'Costs 1 action, Duration: 1 hour, Range: 30ft, WISDOM Save, inflicts Charmed', 0),
    ('Sneak Attack', 'Costs 1 action, Duration: instantaneous, Range: 10ft, PERCEPTION Save, inflicts Ranged Force', '1d6'),
    ('Sword Burst', 'Costs 1 action, Duration: instantaneous, Range: 5ft, DEXTERITY Save, inflicts Melee Force', '1d8');
    
    
insert into Race (`name`, `description`) values
	('Elf', 'Magical people of otherworldy grace. They live in our world, but are not entirely part of it. 
    (+2 Dexterity, Darkvision, Keen Senses, Fey Ancestry, Trance)'),
    
    ('Dragonborn', 'Akin to dragons standing in humanoid form, but lacking wings or a tail. 
    (+2 Strength, +1 Charisma, Draconic Ancestry, Breath Weapon, Damage Resistance)'),
    
    ('Dwarf', 'Bold and hardy, dwarves are known as skilled warriors, miners, and workers of stone and metal.
    (+2 Constitution, Darkvision, Dwarven Resilience, Dwarven Combat Training, Stonecunning)');
    
insert Alignment (`name`) values
	('Lawful Good'),
	('Neutral Good'),
	('Chaotic Good'),
	('Lawful Neutral'),
	('True Neutral'),
	('Chaotic Neutral'),
	('Lawful Evil'),
	('Neutral Evil'),
	('Chaotic Evil');
    
    insert into DndCampaign (map, `description`, userId) values
	('linktomap', 'This is a test description of my amazing campaign', 2);
    
    insert into DndCharacter (
		approval,
        characterName,
        playerName,
        alignmentId,
        xp,
        characterLvl,
        raceId,
        classId,
        strength,
        dexterity,
        constitution,
        intelligence,
        wisdom,
        charisma,
        stStrength,
        stDexterity,
        stConstitution,
        stIntelligence,
        stWisdom,
        stCharisma,
        money,
        backstory,
        hitDice,
        armorClass,
        campaignId
    ) values
		(true, 'Legolas', 'David Smelser', 1, 0, 1, 1, 1, );
    
    

UPDATE `User` SET `password` = '$2a$10$S8nFUMB8YIEioeWyap24/ucX.dC6v9tXCbpHjJVQUkrXlrH1VLaAS' WHERE id = 1;
UPDATE `User` SET `password` = '$2a$10$S8nFUMB8YIEioeWyap24/ucX.dC6v9tXCbpHjJVQUkrXlrH1VLaAS' WHERE id = 2;
UPDATE `User` SET `password` = '$2a$10$S8nFUMB8YIEioeWyap24/ucX.dC6v9tXCbpHjJVQUkrXlrH1VLaAS' WHERE id = 3;