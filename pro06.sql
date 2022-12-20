create table notice(
    notiNo int primary key,
	title varchar(200) not null,
	content varchar(1000) not null,
	author varchar(20) not null,
	resdate date default sysdate
    );
    
    
insert into notice(notiNo, title, content, author) values (1, '테스트', '테스트내용', 'admin');
    
select*from notice;
select*from sample;

create table sample(
    id varchar(10) not null,
    pw varchar(10) not null,
    vcnt varchar(10)
    );

desc notice;
commit;