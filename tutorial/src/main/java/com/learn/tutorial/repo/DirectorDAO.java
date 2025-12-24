package com.learn.tutorial.repo;

import com.learn.tutorial.domain.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DirectorDAO extends JpaRepository<Director, Integer> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Director d " +
            "SET d.directorName = :name " +
            "WHERE d.directorId = :id")
    int updateDirector(@Param("id") Integer id,
                       @Param("name") String name);
}
