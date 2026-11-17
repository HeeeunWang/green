-- 12-02
create table emp_ddl(
    empno number(4),
    ename varchar2(10),
    job varchar2(9),
    mgr number(4),
    hiredate date,
    sal number(7,2),
    comm number(7,2),
    deptno number(2)
);
desc emp_ddl;

create table dept_ddl as select * from dept;
desc dept_ddl;
select * from dept_ddl;

create table emp_ddl_30
as select * from emp
where deptno = 30;
select * from emp_ddl_30;

create table empdept_ddl
as select emp.empno, emp.ename, emp.job, emp.mgr, emp.hiredate, emp.sal, emp.comm,
    dept.deptno, dept.dname, dept.loc from emp, dept
where 1<>1;  

select * from empdept_ddl;


-- 12-03: ALTER
create table emp_alter as select * from emp;
select * from emp_alter;

alter table emp_alter 
add hp varchar2(20);
select * from emp_alter;

alter table emp_alter
rename column hp to tel;
select * from emp_alter;

desc emp_alter;
alter table emp_alter
modify mgr number(10);
desc emp_alter;
-- emp의 empno는 number라서 열에 내용이 있는 상태에서 number(5)로 바꿀 수 없음(축소라서 안됨)

alter table emp_alter
drop column hp;
select * from emp_alter;

create table emp_copy as select * from emp_alter;
truncate table emp_copy;
-- truncate는 테이블의 구조를 남겨주고 데이터만 삭제!

rollback;
-- create, alter, drop, tuncate는 ddl이라 rollback 불가
-- DML(INSERT, UPDATE, DELETE)만 rollback 가능!