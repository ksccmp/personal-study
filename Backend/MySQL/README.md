## 테이블에 한글값 제대로 입력되게 하기
* set charset utf8;
* alter database 데이터베이스명 default character set utf8;
* alter table 테이블명 convert to character set utf8;

## 날짜 계산법
* 하루 더하기: date_add('2020-02-29', interval 1 day)
* 하루 빼기: date_add('2020-02-29', interval -1 day)
* 일 => day, 년 => year, 월 => month, 시간 => hour, 분 => minute, 초 => second

## 문자를 날짜로 변환시키기
* date_format('2020-02-09', '%Y-%m-%d') => 날짜 형태의 '2020-02-29'로 출력