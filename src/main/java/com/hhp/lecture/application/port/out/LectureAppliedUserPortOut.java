package com.hhp.lecture.application.port.out;

import com.hhp.lecture.adapter.out.persistence.entity.LectureAppliedUserEntity;
import com.hhp.lecture.domain.LectureAppliedUser;

import java.util.List;
import java.util.Optional;

public interface LectureAppliedUserPortOut {
    Optional<LectureAppliedUser> findById(long id);
    LectureAppliedUser save(LectureAppliedUser lectureAppliedUser);
    List<LectureAppliedUser> findAll();
    void deleteById(long id);
}
