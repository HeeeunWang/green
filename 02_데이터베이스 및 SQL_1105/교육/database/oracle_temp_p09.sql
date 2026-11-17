select * from emp where sal > (select sal from emp where ename= 'JONES');
select * from emp where sal > (select sal from emp where ename like 'JON%');

select * from emp
where hiredate < (select hiredate from emp where ename= 'SCOTT');

select emp.empno, emp.ename, emp.job, emp.sal, dept.deptno, dept.dname, dept.loc from emp, dept
where emp.deptno= dept.deptno
and emp.deptno= 20
and emp.sal> (select avg(sal) from emp);

select * from emp where sal in (select max(sal) from emp group by deptno);