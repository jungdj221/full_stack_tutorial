package com.learn.tutorial.repo;

import com.learn.tutorial.domain.Movie;
import com.learn.tutorial.domain.MovieDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MovieDAO extends JpaRepository<Movie, Integer> {

    @Query("SELECT new com.learn.tutorial.domain.MovieDTO(m.movieId, m.movieTitle, m.movieGenre, m.movieMainActor, d.directorName, m.director)" +
            "FROM Movie m " +
            "JOIN m.director d"
            )
    List<MovieDTO> findAllMovieInfo();

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Movie m " +
            "SET m.movieTitle = :title, " +
            "    m.movieGenre = :genre, " +
            "    m.movieMainActor = :actor " +
            "WHERE m.movieId = :id")
    int updateMovie(@Param("id") Integer id,
                    @Param("title") String title,
                    @Param("genre") String genre,
                    @Param("actor") String actor);
}
