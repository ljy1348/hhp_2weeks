package com.hhp.lecture.domain.repository;

import com.hhp.lecture.adapter.out.persistence.entity.Lecture;
import com.hhp.lecture.adapter.out.persistence.entity.LectureAppliedUser;

import java.util.List;
import java.util.Optional;

public interface LectureAppliedUserRepository {
    Optional<LectureAppliedUser> findById(long id);
    LectureAppliedUser save(LectureAppliedUser lecture);
    List<LectureAppliedUser> findAll();
    void deleteById(long id);
}
