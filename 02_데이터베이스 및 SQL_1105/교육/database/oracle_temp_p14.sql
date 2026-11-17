-- 14-02
create table table_notnull(
login_id varchar2(20) not null,
login_pw varchar2(20) not null,
tel varchar2(20)
);

desc table_notnull;

insert into table_notnull(login_id, login_pw)
values('TEST_ID_01', '1234');

select owner, constraint_name, constraint_type, table_name from user_constraints where table_name='TABLE_NOTNULL';
-- 맨 하단에 두개 있음 > table name으로 봐바

-- 제약조건 별칭 지정
create table table_notnull2(
login_id varchar2(20) constraint tblnn2_lgnid_nn not null,
login_pw varchar2(20) constraint tblnn2_lgnpw_nn not null,
tel varchar(20)
);

select owner, constraint_name, constraint_type, table_name from user_constraints where table_name like 'TABLE_NOTNULL%';

-- 생성한 테이블 제약 조건 지정
alter table table_notnull modify(tel not null);
-- tel에 null이 있어서 안됨
-- null 없애주기
update table_notnull
set tel='010-1234-5678'
where login_id='TEST_ID_01';

alter table table_notnull modify(tel not null);

select owner, constraint_name, constraint_type, table_name from user_constraints where table_name = 'TABLE_NOTNULL';

-- 기존 테이블에 제약 조건 생성 후 별칭 정정
alter table table_notnull2 modify (tel constraint tblnn_tel_nn not null);
select owner, constraint_name, constraint_type, table_name from user_constraints where table_name = 'TABLE_NOTNULL2';

alter table table_notnull2
rename constraint tblnn_tel_nn to tblnn2_tel_nn;
select owner, constraint_name, constraint_type, table_name from user_constraints where table_name = 'TABLE_NOTNULL2';

-- 제약 조건 삭제
alter table table_notnull2
drop constraint tblnn2_tel_nn;
select owner, constraint_name, constraint_type, table_name from user_constraints where table_name = 'TABLE_NOTNULL2';

-- 14-03
create table table_unique(
login_id varchar(20) unique, -- 이 경우 null은 들어감
login_pw varchar(20) not null,
tel varchar2(20)
);
select owner, constraint_name, constraint_type, table_name from user_constraints where table_name = 'TABLE_UNIQUE';

insert into table_unique(login_id, login_pw, tel)
values('test_id_01', 'pw001', '010-1234-5678');
select * from table_unique;

insert into table_unique(login_id, login_pw, tel)
values('test_id_01', 'pw001', '010-1234-5678');
-- id 가 중복되기에 오류

-- 이건 들어감 id= null로 들어가니까 주의
insert into table_unique(login_pw, tel)
values('pw001', '010-1234-5678');
delete from table_unique where login_id is null;
select * from table_unique;

create table table_unique2(
login_id varchar2(20) constraint tblunq2_lgnid_unq unique,
login_pw varchar2(20) constraint tblunq2_lgnpw_nn not null,
tel varchar2(20)
);
select owner, constraint_name, constraint_type, table_name from user_constraints where table_name = 'TABLE_UNIQUE2';

--alter table table_unique2
--rename constraint tblunq2lgnpw_nn to tblunq2_lgnpw_nn;

alter table table_unique2
modify(tel constraint tblunq2_tel_unq unique);
select owner, constraint_name, constraint_type, table_name from user_constraints where table_name = 'TABLE_UNIQUE2';

update table_unique set tel=null;
select * from table_unique2;
