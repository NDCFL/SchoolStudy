select * from stu;

create table stu
(
  stuId varchar(40) primary key not null,
  stuName varchar(20) ,
  stuAge int,
  stuMajor varchar(20),
  birthday datetime 
);