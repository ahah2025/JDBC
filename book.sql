-- 데이타베이스(스키마) 리스트 보기
show databases;

-- web_db 접속
use web_db;

-- 테이블 리스트 보기
show tables;

-- 데이타 조회
select  book_id,
		title,
        pubs,
        pub_date,
        author_id
from book
;

-- book 데이터 추가  -- 추가 가능!!!!
insert into book
values(null, '니체가 세상에 남긴 66가지 인생지혜','예스24','2024-01-02',1);

-- 책 제목 수정 ( 우리들의 일그러진 영웅 --> 가족이야기) 
-- 수정이 안됨XXXXXXXXXX
update title 
set title = "우리들의 일그러진 영웅",
	title = "가족이야기" 
where author_id = 1
;

-- book 삭제
delete from book
where book_id = 15
;

-- 테이블 삭제
drop table article;