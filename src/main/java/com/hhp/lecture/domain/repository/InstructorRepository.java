package com.hhp.lecture.domain.repository;

import com.hhp.lecture.adapter.out.persistence.entity.Instructor;
import com.hhp.lecture.adapter.out.persistence.entity.Lecture;

import java.util.List;
import java.util.Optional;

public interface InstructorRepository {
    Optional<Instructor> findById(long id);
    Instructor save(Instructor lecture);
    List<Instructor> findAll();
}
