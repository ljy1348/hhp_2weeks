package com.hhp.lecture.adapter.out.persistence.jpa;

import com.hhp.lecture.adapter.out.persistence.entity.LectureAppliedUser;
import com.hhp.lecture.adapter.out.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LectureAppliedUserJpaRepository extends JpaRepository<LectureAppliedUser, Long> {
    Optional<LectureAppliedUser> findById(long id);
    LectureAppliedUser save(LectureAppliedUser lectureAppliedUser);
    List<LectureAppliedUser> findAll();
    void deleteById(long id);
}

