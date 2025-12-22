package com.learn.tutorial.service;

import com.learn.tutorial.domain.Movie;
import com.learn.tutorial.repo.MovieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieDAO dao;

    // 추가
    public Movie insert(Movie movie){
         return dao.save(movie);
    }
    //보기
    public Movie select(int no){
        return dao.findById(no).orElse(null);
    }

    //전체보기
    public List<Movie> select(){
        return  dao.findAll();

    }

    // 수정
    public void update(Movie movie){
        if(dao.existsById(movie.getMovieId())){
             dao.save(movie);
        }

    }

    // 삭제
    public void delete(int no){
        if(dao.existsById(no)){
            dao.deleteById(no);
        }

    }
}
