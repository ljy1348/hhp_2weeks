package com.hhp.lecture.application.port.out;

import com.hhp.lecture.adapter.out.persistence.entity.Lecture;
import com.hhp.lecture.adapter.out.persistence.entity.User;

import java.util.List;
import java.util.Optional;

public interface LecturePort {
    Optional<Lecture> findById(long id);
    Lecture save(Lecture lecture);
    List<Lecture> findAll();
}
