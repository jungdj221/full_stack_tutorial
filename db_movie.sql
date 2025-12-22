CREATE TABLE movie (
	movie_id INT PRIMARY KEY AUTO_INCREMENT,
    movie_title VARCHAR(30),
    movie_genre VARCHAR(30),
    movie_main_actor VARCHAR(30)
);
select * from movie;
drop table movie;