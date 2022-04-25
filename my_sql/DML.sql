create table ex01(
	num1 int,
    num2 float,
    msg1 char(6),
    msg2 varchar(6),
	msg3 text,
    date1 date,
    date2 datetime,
    date3 timestamp
);

select * from ex01;

insert into ex01 values(1,1.0,'aaaaaa','bbbbb','text',now(),now(),now());
insert into ex01 values(2.0, 3.14, 'aaaaaa', 'bbbbb', 'text',now(),now(),now());
insert into ex01 values(2.2, 3.14, 'aaaaaa', 'bbbbb12', 'text',now(),now(),now());
insert into ex01 values(5, 5, '한글로작성', '한글로작성', 'text',now(),now(),now());
insert into ex01 values(5, 5, '한글로작성6', '한글로작성6', 'text', now(), now(), now());
insert into ex01 values(7, 7, '한글로작성6', '한글로작성6', 'text', '2022-04-12', now(), now());
insert into ex01 values(8, 8, '한글로작성6', '한글로작성6', 'text', cast('2022-04-12' as date), now(), now());
insert into ex01 values(9, 9, '한글로작성6', '한글로작성6', 'text', cast('2022-04-12' as date), now(), now());

drop table if exists ex01;

create table if not exists ex02(
	num int,
    name varchar(3)
);
desc ex02;
insert into ex02 values(1, 'test1');
insert into ex02 values(2, 'test2');
insert into ex02 values(3, 'test3');
insert into ex02 values(3, 'test3', now());
select * from ex02;

delete from ex02 where name='test1';

alter table ex02 add date1 date;
alter table ex02 drop date1;
alter table ex02 modify column name varchar(4);