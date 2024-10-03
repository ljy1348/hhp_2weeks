package com.hhp.lecture.application.port.in;

import com.hhp.lecture.adapter.out.persistence.entity.InstructorEntity;

import java.util.List;
import java.util.Optional;

public interface InstructorPortIn {
    Optional<InstructorEntity> findById(long id);
    InstructorEntity save(InstructorEntity instructor);
    List<InstructorEntity> findAll();
}
