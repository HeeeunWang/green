create table dept_temp as select * from dept;
-- 위 경우 제약조건이 없음

select * from dept;

insert into dept_temp (deptno, dname, loc)
values(50, 'DATABASE', 'SEOUL');

select * from dept_temp;

insert into dept_temp
values(60, 'NETWORK', 'BUSAN');

insert into dept_temp
values(70, 'WEB', null);

insert into dept_temp
values(80, 'MOBILE', '');

insert into dept_temp(deptno, loc)
values(90, 'INCHEON');
-- 이 경우 미입력값은 null

create table emp_temp as select * from emp where 1<>1;

select * from emp where 1<>1;
select * from emp_temp where 1<>1;

insert into emp_temp(empno, ename, job, mgr, hiredate, sal, comm, deptno)
values(9999, '홍길동', 'PRESIDENT', NULL, '2001/01/01', 5000, 1000, 10);

insert into emp_temp(empno, ename, job, mgr, hiredate, sal, comm, deptno)
values(1111, '성춘향', 'MANAGER', 9999, '2001-01-05', 4000, NULL, 20);

INSERT INTO EMP_TEMP(empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES(2111, '이순신', 'MANAGER', 9999, '2001/01/07', 4000, NULL, 20);
-- '07/01/2001' : 날짜 형식의 지정에 불필요한 데이터

INSERT INTO EMP_TEMP (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES(2111, '이순신', 'MANAGER', 9999, TO_DATE('07/01/2001', 'DD/MM/YYYY'), 4000, NULL, 20);

INSERT INTO EMP_TEMP(empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES(3111, '심청이', 'MANAGER', 9999, SYSDATE, 4000, NULL, 30);



SELECT EMP.EMPNO, EMP.ENAME, EMP.JOB, EMP.MGR, EMP.HIREDATE, EMP.SAL, EMP.COMM, EMP.DEPTNO, 
    salgrade.grade, salgrade.hisal, salgrade.losal
FROM EMP, SALGRADE;
-- 조건이 없기때문에 EMP, SALGRADE의 전체 JOIN

SELECT EMP.EMPNO, EMP.ENAME, EMP.JOB, EMP.MGR, EMP.HIREDATE, EMP.SAL, EMP.COMM, EMP.DEPTNO, 
    salgrade.grade, salgrade.hisal, salgrade.losal
FROM EMP, SALGRADE 
WHERE EMP.SAL BETWEEN SALGRADE.LOSAL AND SALGRADE.HISAL;
-- WHERE 조건에 맞게 EMP, SALGRADE JOIN!

INSERT INTO EMP_TEMP(empno, ename, job, mgr, hiredate, sal, comm, deptno)
SELECT EMP.EMPNO, EMP.ENAME, EMP.JOB, EMP.MGR, EMP.HIREDATE, EMP.SAL, EMP.COMM, EMP.DEPTNO 
FROM EMP, SALGRADE
WHERE EMP.SAL BETWEEN SALGRADE.LOSAL AND SALGRADE.HISAL
AND SALGRADE.GRADE=1;
-- WHERE 조건이 둘! > 이 경우 위의 결과에서 일부(GRADE=1)만 입력됨

CREATE TABLE DEPT_TEMP2 
AS SELECT * FROM DEPT;

SELECT * FROM DEPT_TEMP2;

UPDATE DEPT_TEMP2
SET LOC = 'SEOUL';
-- 조건을 안주면 전제 LOC이 SEOUL로 변경됨

ROLLBACK;
-- 직전 커밋으로 롤백 > 더 뒤로는 못감. 딱 직전까지만!
-- 실행 전 자동커밋 해줌

UPDATE DEPT_TEMP2
SET DNAME = 'DATABASE', LOC = 'SEOUL'
WHERE DEPTNO = 40;

UPDATE DEPT_TEMP2
SET(DNAME, LOC) = (SELECT DNAME, LOC FROM DEPT WHERE DEPTNO=40);
--WHERE DEPTNO = 40;

UPDATE dept_temp2
SET LOC = 'SEOUL'
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT_TEMP2 WHERE DNAME = 'OPERATIONS');


-- 10-3
CREATE TABLE EMP_TEMP2 AS SELECT * FROM EMP;
SELECT * FROM EMP_TEMP2;
SELECT * FROM SALGRADE;

DELETE FROM EMP_TEMP2
WHERE JOB = 'MANAGER';

DELETE FROM EMP_TEMP2
WHERE EMPNO IN 
    (SELECT EMP_TEMP2.EMPNO FROM EMP_TEMP2, SALGRADE 
    WHERE EMP_TEMP2.SAL BETWEEN SALGRADE.LOSAL AND SALGRADE.HISAL
    AND SALGRADE.GRADE = 3
    AND DEPTNO = 30);
