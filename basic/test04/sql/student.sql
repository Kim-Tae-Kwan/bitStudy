use scott;

create table stu01(
	num int,
	name varchar(5) not null,
	kor int check(kor>=0 and kor<=100),
	eng int check(kor>=0 and kor<=100),
	math int check(kor>=0 and kor<=100),
	primary key(num)
);

insert into stu01 values (1,'user1',90,80,70);
insert into stu01 values (2,'user2',91,81,71);
insert into stu01 values (3,'user3',92,82,72);
select num, name, kor, eng, math, truncate((kor+eng+math)/3, 2) from stu01;