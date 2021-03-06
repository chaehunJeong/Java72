/* 
테이블 생성 - null 또는 not null
- 컬럼의 입력 값이 필수인지 여부 설정

컬럼명 타입 null(기본)
컬럼명 타입 not null 
*/
create table board2 (
  bno   int not null,
  title   varchar(255) not null,
  content mediumtext,
  views int,
  cre_dt  datetime not null,
  pwd   varchar(20)
);

/* 
컬럼의 기본 값 설정
- 컬럼의 값이 없을 때 자동으로 입력될 값 지정
컬럼명 타입 default 값
 */
create table board3 (
  bno   int not null,
  title   varchar(255) not null,
  content mediumtext,
  views int default 0,
  cre_dt  datetime not null,
  pwd   varchar(20)
);


/* 
테이블 = 엔티티 
레코드 = 열(row) = tuple : 테이블에 들어 있는 한 데이터
컬럼 = 속성(attribute) : 테이터의 특정 속성을 가리킨다.

키(key): 레코드를 구분하기 위한 식별자. 한 개 이상의 컬럼을 묶어서 식별자로 사용한다.
후보키(candidate key): 키들 중에서 가장 적은 컬럼을 갖는 키.최소 키.
주키(Primary Key): DBMS 관리자가 후보 키 중에서 어떤 것을 식별자로 사용할 지 결정한 것.
 */
/*
primary key 설정 방법1.
컬럼명 타입 ... primary key
 */
create table board4 (
  bno   int not null,
  title   varchar(255) not null primary key,
  content mediumtext,
  views int default 0,
  cre_dt  datetime not null,
  pwd   varchar(20)
);

create table board5 (
  bno   int not null primary key,
  title   varchar(255) not null ,
  content mediumtext,
  views int default 0,
  cre_dt  datetime not null,
  pwd   varchar(20)
);

/*
primary key 설정 방법2.
컬럼명 타입 ..., 
컬럼명 타입 ...,
constraint board6_pk primary key (컬럼명,...)
 */
create table board6 (
  bno   int not null,
  title   varchar(255) not null ,
  content mediumtext,
  views int default 0,
  cre_dt  datetime not null,
  pwd   varchar(20),
  constraint board6_pk primary key (bno)
);

/*
primary key 설정 방법3.
alter table 테이블명 
  add constraint board6_pk primary key (컬럼명,...)

 */
create table board7 (
  bno   int not null,
  title   varchar(255) not null ,
  content mediumtext,
  views int default 0,
  cre_dt  datetime not null,
  pwd   varchar(20)
);

alter table board7
  add constraint board7_pk primary key (bno);

/*
여러 개의 컬럼을 묶어 primary key로 사용하기
 */
create table board8 (
  bno   int not null,
  title   varchar(255) not null ,
  content mediumtext,
  views int default 0,
  cre_dt  datetime not null,
  pwd   varchar(20)
);

alter table board8
  add constraint board8_pk primary key (bno,title);

















