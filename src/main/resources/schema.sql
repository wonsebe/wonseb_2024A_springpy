-- schema.sql
--[1] Db 생성, DB 명은 mysql workbench
--drop databasse if exists springpy;
--create databasse springpy;
--use springpy;

-- [2] 테이블 생성
drop table if exists user;
create table user (
    id int auto_increment ,
    name varchar(20),
    age int,
    primary key (id)
);

drop table if exists houseaccount;
create table houseaccount (
     hno int not null auto_increment,
     hinfo varchar(300),
     hprice int ,
     hdate datetime,
     PRIMARY KEY (hno)
     );



