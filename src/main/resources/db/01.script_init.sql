create database db_vod_dev;
use db_vod_dev;
create table USER(
	Id int AUTO_INCREMENT,
	Email varchar(255),
	Password varchar(255),
	Firstname varchar(255),
	Lastname varchar(255),
	Gender varchar(1),
	Phone varchar(20),
	ProfileCode varchar(10),
	primary key (Id)
);
create table CATEGORY(
	Id int AUTO_INCREMENT,
	Name varchar(255),
	primary key (Id)
);
create table VIDEO(
	Id int AUTO_INCREMENT,
	Title varchar(255),
	Description text,
	Filename text,
	CategoryFK_CATEGORY int,
	primary key (Id),
	constraint FK_VIDEO_CATEGORY foreign key (CategoryFK_CATEGORY) references CATEGORY(Id)
);
create table USER_VIDEO_LIKE(
	VideoFK_VIDEO int,
	UserFK_USER int,
	constraint FK_LIKE_VIDEO foreign key (VideoFK_VIDEO) references VIDEO(Id),
	constraint FK_LIKE_USER foreign key (UserFK_USER) references USER(Id),
	primary key (VideoFK_VIDEO,UserFK_USER)
);
create table USER_VIDEO_COMMENT(
	Id int AUTO_INCREMENT,
	VideoFK_VIDEO int,
	UserFK_USER int,
	Comment text,
	constraint FK_COMMENT_VIDEO foreign key (VideoFK_VIDEO) references VIDEO(Id),
	constraint FK_COMMENT_USER foreign key (UserFK_USER) references USER(Id),
	primary key (Id)
);
insert into CATEGORY(Name) values ('Ma categorie 1');
insert into CATEGORY(Name) values ('Ma categorie VB');
insert into CATEGORY(Name) values ('Ma categorie Autre');
insert into USER(Email,Password,Firstname,Lastname,Gender,Phone,ProfileCode)
values ('contact@my-vod.com','passwd','SA','ROOT','A','0123456789','ADMIN');