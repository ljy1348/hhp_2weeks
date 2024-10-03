package com.hhp.lecture.adapter.out.persistence.impl;

import com.hhp.lecture.adapter.out.persistence.entity.InstructorEntity;
import com.hhp.lecture.adapter.out.persistence.jpa.InstructorJpaRepository;
import com.hhp.lecture.application.port.out.InstructorPortOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ImstructorJpaImpl implements InstructorPortOut {
    private final InstructorJpaRepository instructorJpaRepository;

    @Override
    public Optional<InstructorEntity> findById(long id) {
        return instructorJpaRepository.findById(id);
    }

    @Override
    public InstructorEntity save(InstructorEntity instructor) {
        return instructorJpaRepository.save(instructor);
    }

    @Override
    public List<InstructorEntity> findAll() {
        return instructorJpaRepository.findAll();
    }
}
