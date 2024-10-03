package com.hhp.lecture.adapter.out.persistence.impl;

import com.hhp.lecture.adapter.out.persistence.entity.Lecture;
import com.hhp.lecture.adapter.out.persistence.jpa.LectureJpaRepository;
import com.hhp.lecture.application.port.out.LecturePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LectureJpaImple implements LecturePort {
    private final LectureJpaRepository lectureJpaRepository;

    @Override
    public Optional<Lecture> findById(long id) {
        return lectureJpaRepository.findById(id);
    }

    @Override
    public Lecture save(Lecture lecture) {
        return lectureJpaRepository.save(lecture);
    }

    @Override
    public List<Lecture> findAll() {
        return lectureJpaRepository.findAll();
    }
}
