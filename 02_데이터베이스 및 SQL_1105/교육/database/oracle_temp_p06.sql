select * from emp where upper(ename) = upper('scott');
select ename, upper(ename), lower(ename), initcap(ename) from emp;
select * from emp where upper(ename) like upper('%scott%');
select * from emp where upper(ename) = upper('scott');

select job, substr(job, 1, 2), substr(job, 3, 2), substr(job, 3, 5), substr(job, 5) from emp;
select ename, length(ename) from emp;
select ename, length(ename) from emp where length(ename)>=5;

select * from emp where instr(ename, 'S')>0;
select * from emp where instr(ename, 'S')<=0;

select '010-1234-5678' as replace_before, 
replace('010-1234-5678', '-', ' ') as replace_before_2,
replace('010-1234-5678', '-') as replace_before3 from dual;

select '['|| trim('  Oracle  ') || ']' as trim, 
'[' || trim(leading from '  Oracle  ')|| ']' as trim_leading,
'[' || trim(trailing from '  Oracle  ')|| ']' as trim_trailing,
'[' || trim(both from '  Oracle  ')|| ']' as trim_both from dual;

select 'Oracle', lpad('oracle', 10, '#') as lpad_1;

select trunc(1234.5678) as trunc, trunc(1234.5678) as trunc_01
from dual;





select sysdate as now, sysdate-1 as yesterday, sysdate +1 as tomorrow from dual;
select sysdate, add_months(sysdate, 3) from dual;
select empno, ename, hiredate, add_months(hiredate, 120) as work10year from emp;
select empno, ename, hiredate, sysdate from emp where add_months(hiredate, 384) > sysdate;

select empno, ename, hiredate, sysdate, 
months_between(hiredate, sysdate) as months1,
months_between(sysdate, hiredate) as months2,
trunc(months_between(sysdate, hiredate)) as months3 from emp;

select sysdate, next_day(sysdate, '월요일'), last_day(sysdate) from dual;
select sysdate, to_char(sysdate, 'HH24:MI:SS') as HH24MISS, 
to_char(sysdate, 'HH12:MI:SS AM') as HHMISS_AM,
to_char(sysdate, 'HH:MI:SS P.M.') as HHMISS_PM from dual;

select to_number('1,300', '999,999')-to_number('1,500', '999,999') from dual;
select '1300'+1500 from dual;
select 1300-'1,500' from dual; --이건 안됨!

select to_date('2018-07-14', 'yyyy-mm-dd') as todate1,
to_date('20180714', 'yyyy-mm-dd') as todate2 from dual;

select * from emp where hiredate>to_date('1981/06/01', 'yyyy/mm/dd');

select empno, ename, sal, comm, sal+comm, nvl(comm, 0), sal+nvl(comm,0) from emp;
select empno, ename, sal, comm, nvl2(comm, 'o', 'x'), nvl2(comm, sal*12+comm, sal*12) as annsal from emp;


select empno, ename, job, sal, 
decode(job,
'MANAGER', sal*1.1,
'SALESMAN', sal*1.05,
'ANALYST', sal,
sal*1.03) as upsal from emp;

select empno, ename, job, sal, 
case job
when 'MANAGER' then sal*1.1
when 'SALESMAN' then sal*1.05
when 'ANALYSIS' then sal
else sal*1.03
end as upsal from emp;

select empno, ename, comm,
case
when comm is null then '해당없음'
when comm = 0 then '수당없음'
when comm > 0 then '수당: '||comm
end as comm_txt from emp;