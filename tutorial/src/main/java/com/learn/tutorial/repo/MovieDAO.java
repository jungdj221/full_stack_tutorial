package com.learn.tutorial.repo;

import com.learn.tutorial.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDAO extends JpaRepository<Movie, Integer> {
}
