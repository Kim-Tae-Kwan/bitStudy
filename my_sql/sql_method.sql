use scott;

# null일 경우 값 추가
select sal, comm, sal + comm from emp;
select sal, comm, sal + ifnull(comm,0) from emp;

select if (0!=1, '참', '거짓') from dual;
select comm, ifnull(comm, 0), nullif(comm, 1000) from emp;

# length() -> byte
# char_length() -> 글자수
# bit_lenght() -> bit
select 'abcd', length('abcd'), char_length('abcd'), bit_length('abcd') from dual;
select '한글', length('한글'), char_length('한글'), bit_length('한글') from dual;

# 문자열 조합
select '문자'+'열' from dual;
select concat('문자', '열') from dual;
select concat('문', '자', '열', '로') from dual;
select concat_ws('@','문', '자', '열', '로') from dual;

select 3.14, ceil(3.14) as '올림', floor(3.14) as '내림', round(3.14) as '반올림' from dual;
# 자리 수 지정 truncate(숫자, 자리수)
select truncate(12345.65432, 5) as '원단위 절삭' from dual;

select * from emp;
# 이전 쿼리의 수행 결과 카운트
select found_rows() from dual;
select count(*) from emp;

select * from dept4;
insert into dept4 values(100,'test','test');
delete from dept4 where deptno=100;
truncate dept4;
alter table dept4 add constraint pk_dept4_deptno primary key (deptno);
update dept4 set dname='edit' where deptno=100;
select row_count() from dual;

# case
select * from dept;
select empno, ename,
   case deptno
   when 10 then 'accounting'
    when 20 then 'research'
    when 30 then 'sales'
    when 40 then 'operations'
    else '몰라'
    end as "부서명"
    from emp;
select * from emp;

select empno, ename,
   case 
   when deptno=10 then 'accounting'
    when deptno=20 then 'research'
    when deptno=30 then 'sales'
    when deptno=40 then 'operations'
    else '몰라'
    end as "부서명"
    from emp;
select * from emp;

select empno,ename,dname from emp inner join dept using (deptno);
select empno,ename,(select dname from dept B where A.deptno = B.deptno) from emp A;

#지역 변수
set @var1 = 10;
set @var2 = 40;
select @var1 from dual;

prepare query1 from 'select * from dept where deptno>? and deptno < ?';
execute query1 using @var1, @var2;