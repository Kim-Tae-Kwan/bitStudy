# 안쪽부터 실행
select ename, (select ename from emp B where A.mgr=B.empno) as '사수' from emp A;
select * from (select * from dept) A;
select * from dept where deptno=(select deptno from dept where deptno=10);

select dname, (select loc from dept where deptno=10) from dept; 
select * from (select loc, dname from dept) A;
select * from dept where deptno in (select deptno from dept);

create table dept2(
	deptno int,
    dname varchar(45),
    loc varchar(45)
);

insert into dept2 (select * from dept);
select * from dept2;

# 제약조건 제외, 데이터만 들어감.
create table dept3 as (select * from dept);
select * from dept3;

# 스키마 복제, 데이터 없음.
create table dept4 as (select * from dept where 0=1);
select * from dept4;