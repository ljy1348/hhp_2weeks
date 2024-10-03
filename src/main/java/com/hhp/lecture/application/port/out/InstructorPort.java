package com.hhp.lecture.application.port.out;

import com.hhp.lecture.adapter.out.persistence.entity.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorPort {
    Optional<Instructor> findById(long id);
    Instructor save(Instructor instructor);
    List<Instructor> findAll();
}
