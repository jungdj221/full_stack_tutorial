package com.learn.tutorial.service;

import com.learn.tutorial.domain.Movie;
import com.learn.tutorial.domain.MovieDTO;
import com.learn.tutorial.repo.DirectorDAO;
import com.learn.tutorial.repo.MovieDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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
    public List<MovieDTO> select(){
       List<MovieDTO> list = dao.findAllMovieInfo();
       log.info("반환 list : " + list);

        return list;

    }

    // 수정
    public void update(Movie vo){
        if(dao.existsById(vo.getMovieId())){
              dao.updateMovie(vo.getMovieId(),vo.getMovieTitle(),vo.getMovieGenre(),vo.getMovieMainActor());
        }
    }

    // 삭제
    public void delete(int no){
        if(dao.existsById(no)){
            dao.deleteById(no);
        }

    }
}
