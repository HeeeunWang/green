select sum(sal) from emp;
select sum(distinct sal), sum(all sal), sum(sal) from emp;

select count(*) from emp;
select count(*) from emp where deptno=30;

select count(distinct sal), count(all sal), count(sal) from emp;
select max(sal) from emp where deptno = 10;

select max(hiredate) from emp where deptno = 20;
select min(hiredate) from emp where deptno = 20;
select hiredate from emp where deptno = 20;

select avg(sal) from emp where deptno = 30;
select avg(distinct sal) from emp where deptno = 30;

select avg(sal), '10' as deptno from emp where deptno = 10
union all
select avg(sal), '20' as deptno from emp where deptno = 20
union all
select avg(sal), '30' as deptno from emp where deptno = 30;


select avg(sal), deptno from emp
group by deptno;

select deptno, job, avg(sal) from emp
group by deptno, job
order by deptno, job;

select deptno, job, avg(sal) from emp
group by deptno, job
having avg(sal) >= 2000
order by deptno, job;

-- where함수에 
select deptno, job, avg(sal) from emp
group by deptno, job
having avg(sal)>=2000
order by deptno, job;

select deptno, job, avg(sal) from emp
where sal <= 3000 -- group by 앞으로 와야하나?
group by deptno, job
having avg(sal)>=2000
order by deptno, job;

select deptno, job, count(*), max(sal), sum(sal), avg(sal) from emp
-- select는 group by의 기준에 사용할 필드만 가져올 수 있음
-- 그 뒤로는 다중행함수의 나열
group by deptno, job
order by deptno, job;

select job, avg(sal) from emp
where deptno < 30
having avg(sal)>=2000
group by job
order by job;

select * from emp, dept 
where emp.deptno = dept.deptno;
--order by empno;

select * from emp e, dept d
where e.deptno = d.deptno;
-- 약식으로는 쓰지 않는다구? 꼬이면 골치아픔

select emp.empno, emp.ename, emp.sal, dept.deptno, dept.dname, dept.loc from emp, dept
where emp.deptno = dept.deptno and sal>= 3000;

--이건 그냥 가져오기
select empno, ename, mgr, empno as mgr_empno, ename as mgr_ename from emp;
where mgr = empno;
--이건 self join해서 where에 맞는 애들 가져오기 > where 없으면 무조건 self join > e1*e2해서 196개 생김
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_empno, e2.ename as mgr_ename from emp e1, emp e2
where e1.mgr = e2.empno; -- 두 테이블의 연결 기준

-- natural join
select emp.empno, emp.ename, emp.job, emp.mgr, emp.hiredate, emp.sal, emp.comm, deptno, dept.dname, dept.loc
from emp natural join dept; -- natural join은 같은 키값을 같는 열을 기준으로 조인하며 사용된 열은 식별자를 가질 수 없음 deptno: 식별자x

-- join using
select emp.empno, emp.ename, emp.job, emp.mgr, emp.hiredate, emp.sal, emp.comm, deptno, dept.dname, dept.loc 
from emp join dept using (deptno);
