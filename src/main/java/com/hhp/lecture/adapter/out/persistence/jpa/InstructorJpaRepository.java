package com.hhp.lecture.adapter.out.persistence.jpa;

import com.hhp.lecture.adapter.out.persistence.entity.Instructor;
import com.hhp.lecture.adapter.out.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InstructorJpaRepository extends JpaRepository<Instructor, Long> {
    Optional<Instructor> findById(long id);
    Instructor save(Instructor instructor);
    List<Instructor> findAll();
}

