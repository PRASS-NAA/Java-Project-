Tables needed for tommorow(22-04-2024)


create database javaproject;
use javaproject;

Admin
create table Admin(id int primary key,username varchar(30) not null,password varchar(30) not null);

Customer
create table Customer(name varchar(30),phoneNo varchar(11) primary key,points int,member varchar(5) default 'NO');

Cashier
create table Cashier(id int primary key,username varchar(20) unique,password varchar(20),cname varchar(30));


complete admin operations by this sunday pls
