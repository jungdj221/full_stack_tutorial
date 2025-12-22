package com.learn.tutorial.controller;

import com.learn.tutorial.domain.Movie;
import com.learn.tutorial.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/*")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
@Slf4j
public class MovieController {

    @Autowired
    private MovieService service;

    // 추가
    @PostMapping("/movie")
    public ResponseEntity<Movie> insert(@RequestBody Movie vo){
        log.info("vo : " + vo);
//        service.insert(vo);
        return ResponseEntity.ok(service.insert(vo));
    }

    // 하나보기
    @GetMapping("/movie/{no}")
    public  ResponseEntity<Movie> select(@PathVariable(name = "no") int no){
        Movie vo =service.select(no);
        return ResponseEntity.status(HttpStatus.OK).body(vo);
    }

    //전체보기
    @GetMapping("/movie")
    public ResponseEntity<List<Movie>> selectAll(){
       List<Movie> list =  service.select();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    // 수정
    @PutMapping("/movie")
    public ResponseEntity<Movie> update(@RequestBody Movie vo){
        service.update(vo);
        return ResponseEntity.status(HttpStatus.OK).body(vo);
    }

    // 삭제
    @DeleteMapping("/movie/{no}")
    public ResponseEntity<Movie> delete(@PathVariable(name = "no") int no){
        service.delete(no);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
