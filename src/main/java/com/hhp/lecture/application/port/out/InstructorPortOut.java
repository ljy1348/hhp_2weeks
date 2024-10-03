package com.hhp.lecture.application.port.out;

import com.hhp.lecture.adapter.out.persistence.entity.InstructorEntity;

import java.util.List;
import java.util.Optional;

public interface InstructorPortOut {
    Optional<InstructorEntity> findById(long id);
    InstructorEntity save(InstructorEntity instructor);
    List<InstructorEntity> findAll();
}
