package com.hhp.lecture.adapter.out.persistence.impl;

import com.hhp.lecture.adapter.out.persistence.entity.Instructor;
import com.hhp.lecture.adapter.out.persistence.jpa.InstructorJpaRepository;
import com.hhp.lecture.application.port.out.InstructorPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ImstructorJpaImpl implements InstructorPort {
    private final InstructorJpaRepository instructorJpaRepository;

    @Override
    public Optional<Instructor> findById(long id) {
        return instructorJpaRepository.findById(id);
    }

    @Override
    public Instructor save(Instructor instructor) {
        return instructorJpaRepository.save(instructor);
    }

    @Override
    public List<Instructor> findAll() {
        return instructorJpaRepository.findAll();
    }
}
