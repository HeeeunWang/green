desc emp;
desc dept;

select * from emp;
select empno, ename, job from emp;
select * from dept;

select distinct deptno from emp;

select ename, sal, sal*12+comm as annsal, comm from emp;

select * from emp order by sal;
select * from emp order by sal, empno;
select * from emp order by sal desc;

select * from emp where deptno=30;
select * from emp where deptno=30 and job='SALESMAN';
select * from emp where deptno=30 or job='CLERK';

select * from emp where ename >= 'F';
select * from emp where sal <> 3000;
select * from emp where sal != 3000;
select * from emp where not sal = 3000;

select * from emp where job in ('MANAGER', 'CLERK');
select * from emp where sal between 2000 and 5000;
select * from emp where sal not between 2000 and 5000;

select * from emp where ename like 'S%';
select * from emp where ename like '%S';
select * from emp where ename like '_L%';
select * from emp where ename like '%AM%';

select * from emp where comm is null;
select * from emp where sal is not null and comm is null;
select sal from emp;

-- 중복을 제거한 합집합 union = or
select empno, ename, sal, deptno from emp where deptno = 10
union
select empno, ename, sal, deptno from emp where deptno = 10;
-- 중복을 포함하는 합집합 union all
select empno, ename, sal, deptno from emp where deptno = 10
union all
select empno, ename, sal, deptno from emp where deptno = 10;
-- 차집합 minus
select empno, ename, sal, deptno from emp
minus
select empno, ename, sal, deptno from emp where deptno = 10;
-- 교집합 intersect = and
select empno, ename, sal, deptno from emp
intersect
select empno, ename, sal, deptno from emp where deptno = 10;
