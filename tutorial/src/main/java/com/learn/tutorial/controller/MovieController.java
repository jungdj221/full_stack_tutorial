package com.learn.tutorial.controller;

import com.learn.tutorial.domain.Director;
import com.learn.tutorial.domain.Movie;
import com.learn.tutorial.domain.MovieDTO;
import com.learn.tutorial.service.DirectorService;
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
    private MovieService movieService;

    @Autowired
    private DirectorService directorService;

    // 추가
    /*기존로직*/
//    @PostMapping("/movie")
//    public ResponseEntity<Movie> insert(@RequestBody Movie vo){
//        return ResponseEntity.ok(movieService.insert(vo));
//    }
    /*director 추가*/
    @PostMapping("/movie")
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO dto){
        // 방법 1. dto 에 필요한 객체들의 단일컬럼들을 받아오고, 그거를 주입
        Director reqDirector= directorService.createDirector(
                Director.builder()
                        .directorName(dto.getDirectorName())
                        .build()
        );
        Movie reqMovie = movieService.insert(
                Movie.builder()
                        .movieTitle(dto.getMovieTitle())
                        .movieGenre(dto.getMovieGenre())
                        .movieMainActor(dto.getMovieMainActor())
                        .director(Director.builder()
                                .directorId(reqDirector.getDirectorId())
                                .build())
                        .build()
        );


        // 결과값 response 를 반환
        MovieDTO response = MovieDTO.builder()
                .movieTitle(reqMovie.getMovieTitle())
                .movieGenre(reqMovie.getMovieGenre())
                .movieMainActor(reqMovie.getMovieMainActor())
                .directorName(reqDirector.getDirectorName())
                .build();
        return ResponseEntity.ok(response);
    }

    // 하나보기
    @GetMapping("/movie/{no}")
    public  ResponseEntity<MovieDTO> select(@PathVariable(name = "no") int no){
        Movie reqMovie = movieService.select(no);
        Director reqDirector = directorService.readDirector(reqMovie.getDirector().getDirectorId());
        MovieDTO response = MovieDTO.builder()
                .movieId(reqMovie.getMovieId())
                .movieTitle(reqMovie.getMovieTitle())
                .movieGenre(reqMovie.getMovieGenre())
                .movieMainActor(reqMovie.getMovieMainActor())
                .director(Director.builder()
                        .directorId(reqDirector.getDirectorId())
                        .build())
                .directorName(reqDirector.getDirectorName())
                .build();
        return ResponseEntity.ok(response);
    }

    //전체보기
    @GetMapping("/movie")
    public ResponseEntity<List<MovieDTO>> selectAll(){
       List<MovieDTO> list =  movieService.select();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    // 수정
    @PutMapping("/movie")
    public ResponseEntity<MovieDTO> update(@RequestBody MovieDTO dto){
        Movie reqMovie = Movie.builder()
                .movieId(dto.getMovieId())
                .movieTitle(dto.getMovieTitle())
                .movieGenre(dto.getMovieGenre())
                .movieMainActor(dto.getMovieMainActor())
                .build();
        movieService.update(reqMovie);

        Director reqDirector= Director.builder()
                .directorId(dto.getDirector().getDirectorId())
                .directorName(dto.getDirectorName())
                .build();
        directorService.updateDirector(reqDirector);

        // 결과값 response 를 반환
//        MovieDTO response = MovieDTO.builder()
//                .movieTitle(reqMovie.getMovieTitle())
//                .movieGenre(reqMovie.getMovieGenre())
//                .movieMainActor(reqMovie.getMovieMainActor())
//                .directorName(reqDirector.getDirectorName())
//                .build();
        return ResponseEntity.ok().build();
    }

    // 삭제
    @DeleteMapping("/movie/{no}")
    public ResponseEntity<?> delete(@PathVariable(name = "no") int no){

        movieService.delete(no);
        return ResponseEntity.ok().build();
    }


}
