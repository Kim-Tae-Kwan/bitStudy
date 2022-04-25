use test01;

create table ex20(
	num1 int,
    num2 int,
    name1 varchar(3),
    primary key (num1)
);

insert into ex20 values(1111, 1000,'aaa');
insert into ex20 values(2222, 2000,'aaa');
insert into ex20 values(3333, 3000,'aaa');

create table if not exists ex21 (
	num3 int,
    num4 int,
    name2 varchar(4),
    constraint pk_ex21_num3 primary key (num3),
    constraint fk_ex21_num4 foreign key (num4) references ex20 (num1)
);

create table if not exists ex22 (
	num3 int,
    num4 int,
    name2 varchar(4),
    constraint pk_ex21_num3 primary key (num3)
);

alter table ex22 add foreign key (num4) references ex20 (num1);

create table if not exists ex23 (
	num3 int,
    num4 int,
    name2 varchar(4),
    constraint pk_ex21_num3 primary key (num3)
);
insert into ex23 values (1, 100,'aaa');

alter table ex23 add constraint fk_ex23_num4 foreign key (num4) references ex20 (num1);
alter table ex23 drop constraint fk_ex23_num4;

drop table ex23;
drop table ex22;
drop table ex21;
drop table ex20;

create table if not exists ex23 (
	num1 int primary key,
    num2 int default 1111,
    num3 varchar(4) default '이름없음'
);

insert into ex23 values (1,1000,'aaa');
insert into ex23 values (2,null,null);
insert into ex23 (num1) values (3);
select * from ex23;

create table if not exists ex24 (
	num1 int primary key,
    num2 int default 1111,
    num3 varchar(4) default '이름없음',
    num4 int not null default 2222,
    num5 datetime default now()
);

insert into ex24 values (1,1000,'aaa',1000,now());
insert into ex24 values (1,null,null,null,null);
insert into ex24 (num1) values (4);
select * from ex24;

create table if not exists ex25 (
	num1 int primary key,
    num2 int,
    constraint ch_ex25_num2 check (num2<10)
);

insert into ex25 values(1,1);
insert into ex25 values(2,2);
insert into ex25 values(3,10);

create table if not exists ex26PRIMARY (
	num1 int primary key,
    num2 char(1),
    constraint ch_ex26_num2 check (num2 in ('남','여'))
);
insert into ex26 values(1,'남');
insert into ex26 values(2,'여');
insert into ex26 values(3,'몰');