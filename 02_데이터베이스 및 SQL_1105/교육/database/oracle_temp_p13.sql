select * from dict;
select * from dictionary;

select * from dba_users where username= 'SYSTEM';

-- 13-02
create index idx_emp_sal on emp(sal);
select * from user_ind_columns;

drop index idx_emp_sal;


-- 13-03
grant create view to system;
create view vw_emp20 as (select empno, ename, job, deptno from emp where deptno=20);

select * from user_views;
select * from vw_emp20;
drop view vw_emp20;

-- 13-04
select rownum, emp.* from emp;
select rownum, emp.* from (select * from emp order by sal desc) emp;
select rownum, emp_select.* from (select * from emp order by sal desc) emp_select;
with emp_ as (select * from emp order by sal desc) select rownum, emp_.* from emp_;


select rownum, e.* from (select * from emp order by sal desc) e where rownum <= 3;
create table dept_sequence as select * from dept where 1<>1;

create sequence seq_dept_sequence
increment by 10
start with 20
maxvalue 90
minvalue 0
nocycle
cache 2;

insert into dept_sequence(deptno, dname, loc)
values(seq_dept_sequence.nextval, 'DATABASE', 'BUSAN');
select * from dept_sequence order by deptno;

select seq_dept_sequence.currval from dual;
--select seq_dept_sequence.nextval from dual; -- 한번 보기만 해도 넘어가버리니까 체크용으로는 사용금지

alter sequence seq_dept_sequence
increment by 3 -- alter 실행시 alter 이전 currval에서 한번 increase한 값이 currval이 됨. ex. 30 --> 33
maxvalue 99
cycle; -- 99까지 다 쓰면 3번으로 다시 돌아가서 번호줌. nocycle은 안주고 오류

