package com.hhp.lecture.adapter.out.persistence.jpa;

import com.hhp.lecture.adapter.out.persistence.entity.LectureAppliedUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LectureAppliedUserJpaRepository extends JpaRepository<LectureAppliedUserEntity, Long> {
    Optional<LectureAppliedUserEntity> findById(long id);
    LectureAppliedUserEntity save(LectureAppliedUserEntity lectureAppliedUser);
    List<LectureAppliedUserEntity> findAll();
    long countAllByLectureId(long lectureId);
}

