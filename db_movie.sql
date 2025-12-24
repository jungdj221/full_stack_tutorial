/*
기초지식.
sql데이터를 저장하기 위해서는 테이블을 만들어야한다. 그리고 사용할 테이블들의 집합을 Schemas라고 부른다.
workbench를 보면 schemas들이 있는 란이 있고, 컨테이너의 빈부분을 우클릭하여 schemas생성이 가능하다.


기존 설정과 부딪히는것을 방지하기 위해 schemas이름은 똑같이 full_stack_test01로 설정

테이블 생성규칙
CREATE TABLE 테이블명 (
	id 메인키. 이 정보로 데이터의 유일성(unique)획보 가능. main key로써 사용하고 싶다면 PRIMARY KEY를 사용
		추가로 int를 사용하고 싶은데, 데이터가 늘어날때마다 일일히 쓰기 귀찮다? 이럴떄 쓰는게, AUTO_INCREMNENT 자동으로 int값 생성
        컬럼을 추가하고 싶다면, 설정을 완료한 컬럼란 끝에","쓰고 다름 컬럼 쓰면 됨.

)

SELECT 테이블을 검색할떄. "*": 테이블의 모든것을 가져온다
SELECT(가져온다) *(모든것을) FROM(어디서?) movie(movie라는 full_stack_test01 schemas내에 있는 테이블에서) 

DROP : 테이블을 삭제할떄. 왠만하면 쓸일 없음. 초기 실험떄 빨리빨리 확인하는 용도
DROP(삭제하다) TABLE(테이블을) movie(movie라는 테이블을 삭제하다.)
*/
SELECT * FROM movie;
SELECT * FROM director;

DROP TABLE movie;
DROP TABLE director;

CREATE TABLE movie (
	movie_id INT PRIMARY KEY AUTO_INCREMENT,
    movie_title VARCHAR(30),
    movie_genre VARCHAR(30),
    movie_main_actor VARCHAR(30),
    movie_director_id INT -- 왜래기를 설정하기위한 신규 컬럼
);
CREATE TABLE director(
	director_id INT PRIMARY KEY AUTO_INCREMENT,
    director_name VARCHAR(30)
);
ALTER TABLE movie ADD FOREIGN KEY (movie_director_id) REFERENCES director(director_id) ON DELETE CASCADE;
-- 테이블에 수정을 할거다. mive에 외래키를 추가함으로써.



update movie set movie_director_id = 2 where movie_id = 4;

INSERT INTO movie(movie_title,movie_genre,movie_main_actor,movie_director_id) VALUES ("전설의 비둘기","SF","산비둘기",1);
select movie_title,movie_genre,movie_main_actor, director_name from movie join director on movie_director_id = director_id;
select * from movie join director on movie_director_id = director_id;

