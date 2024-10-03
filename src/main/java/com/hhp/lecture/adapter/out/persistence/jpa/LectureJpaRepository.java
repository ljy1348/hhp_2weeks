package com.hhp.lecture.adapter.out.persistence.jpa;

import com.hhp.lecture.adapter.out.persistence.entity.Lecture;
import com.hhp.lecture.adapter.out.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LectureJpaRepository extends JpaRepository<Lecture, Long> {
    Optional<Lecture> findById(long id);
    Lecture save(Lecture lecture);
    List<Lecture> findAll();
}

