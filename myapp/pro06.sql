select * from sample;

desc sample;

create table sample(id varchar2(30), pw varchar2(30), vcnt varchar2(30));

desc sample;

commit;

desc board;
desc notice;

create table notice(
    no int PRIMARY KEY, 
    title varchar2(100) not null, 
    content varchar2(800) not null, 
    author varchar(20), 
    resdate date, 
    visited number(30)
    );

drop table notice;
insert into notice values(1, '샘플 글 제목1', '샘플 글1에 대한 내용', 'admin', sysdate, 0);

commit;