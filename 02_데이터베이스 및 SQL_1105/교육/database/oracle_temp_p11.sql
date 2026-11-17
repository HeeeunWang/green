create table dept_tcl as select * from dept;
select * from dept_tcl;

insert into dept_tcl values(50, 'DATABASE', 'SEOUL');
update dept_tcl set loc= 'BUSAN' where deptno= 40;
delete from dept_tcl where dname = 'RESEARCH';
select * from dept_tcl;

rollback;
-- 묶어서 실행하면 묶인 단위로 롤백 가능한가봄



-- 종합 연습~~~~~
create table dept_tcl as select * from dept;
select * from dept_tcl;

insert into dept_tcl values(50, 'DATABASE', 'SEOUL');
update dept_tcl set loc = 'BUSAN' where deptno = 40;
delete from dept_tcl where dname = 'RESEARCH';
select * from dept_tcl;

rollback;
select * from dept_tcl;

insert into dept_tcl values(50, 'NETWORK', 'SEOUL');
update dept_tcl set loc = 'BUSAN' where deptno = 20;
delete from dept_tcl where deptno = 40;
select * from dept_tcl;

rollback;
select * from dept_tcl;

commit;
select * from dept_tcl;

update dept_tcl set loc='SEOUL' where deptno = 30;
select * from dept_tcl;
-- 위랑 아래의 select~ 구문의 출력이 동일한게 맞나?...
-- 같은 세션에서는 동일하게 수정사항이 반영되게 보임! 
-- 다른 세션에서 위 과정만 진행하고 select * from dept_tcl; 할 경우는
-- update dept_tcl set loc='SEOUL' where deptno = 30;이 반영되지 않음
update dept_tcl set dname='DATABASE' where deptno = 30;
commit;
select * from dept_tcl;
-- 여기는 commit을 했기 때문에 다른세션에서 열어봐도 수정사항이 전부 반영되어있음!
