package com.hhp.lecture.adapter.out.persistence.jpa;

import com.hhp.lecture.adapter.out.persistence.entity.InstructorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InstructorJpaRepository extends JpaRepository<InstructorEntity, Long> {
    Optional<InstructorEntity> findById(long id);
    InstructorEntity save(InstructorEntity instructor);
    List<InstructorEntity> findAll();
}

