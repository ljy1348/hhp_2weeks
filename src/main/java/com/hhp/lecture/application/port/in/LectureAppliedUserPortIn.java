package com.hhp.lecture.application.port.in;

import com.hhp.lecture.adapter.out.persistence.entity.LectureAppliedUserEntity;
import com.hhp.lecture.domain.LectureAppliedUser;

import java.util.List;
import java.util.Optional;

public interface LectureAppliedUserPortIn {
    Optional<LectureAppliedUser> findById(long id);
    LectureAppliedUser save(LectureAppliedUser lectureAppliedUser);
    List<LectureAppliedUser> findAll();
    long countByLecturId(long lectureId);
    long countAllByUserIdAndLectureId(long userId, long lectureId);
}
