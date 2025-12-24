package com.learn.tutorial.service;

import com.learn.tutorial.domain.Director;
import com.learn.tutorial.repo.DirectorDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DirectorService {

    @Autowired
    private DirectorDAO directorDAO;

    //추가
    public Director createDirector(Director vo){
        return directorDAO.save(vo);
    }

    //보기
    public Director readDirector(int no){
        return  directorDAO.findById(no).orElse(null);
    }

    //수정
    public void updateDirector(Director vo){
         directorDAO.updateDirector(vo.getDirectorId(),vo.getDirectorName());
    }
//    //삭제
//    public void deleteDirector(int no){
//        directorDAO.deleteById(no);
//    }
    // db 상에 on delete cascade 설정을 통해 자식컬럼 자동 삭제.
}
