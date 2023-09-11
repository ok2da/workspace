drop table member cascade constraints purge;
--1. index.jsp에서 시작합니다.
--2. 관리자 계정 admin, 비번 1234를 만듭니다.
--3. 사용자 계정을 3개 만듭니다.

create table member(
	id			VARCHAR2(12),
	password		VARCHAR2(10),
	name			VARCHAR2(15),	--한글 5글자까지 가능
	age			NUMBER(2),
	gender			VARCHAR2(3),
	email			VARCHAR2(30),
	PRIMARY KEY(id)
);
