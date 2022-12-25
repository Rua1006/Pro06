create table notice(
    notiNo int primary key,
	title varchar(200) not null,
	content varchar(1000) not null,
	author varchar(20) not null,
	resdate date default sysdate
    );
    
drop table notice;
    
create sequence notival;
drop sequence notival;

desc notice;
select*from notice;

update notice set notiNo=2 where notiNo=3;

insert into notice(notiNo, title, content, author) values (notival.nextval, '테스트', '테스트내용', 'admin');
insert into notice(notiNo, title, content, author) values (1, '테스트', '테스트내용', 'admin');
    
create table sample(
    id varchar(10) not null,
    pw varchar(10) not null,
    vcnt varchar(10)
    );
    
insert into sample values('kbs',1234,0);     
select*from sample;

-- 회원
create table user_shop(
    userNo number primary key, 
    userId varchar2(20) not null, 
    userPw varchar2(500) not null, 
    userName varchar2(20),
    email varchar2(20),
    regdate date default sysdate
    );
commit;