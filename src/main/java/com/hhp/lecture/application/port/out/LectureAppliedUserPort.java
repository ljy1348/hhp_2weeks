package com.hhp.lecture.application.port.out;

import com.hhp.lecture.adapter.out.persistence.entity.Lecture;
import com.hhp.lecture.adapter.out.persistence.entity.LectureAppliedUser;
import com.hhp.lecture.adapter.out.persistence.entity.User;

import java.util.List;
import java.util.Optional;

public interface LectureAppliedUserPort {
    Optional<LectureAppliedUser> findById(long id);
    LectureAppliedUser save(LectureAppliedUser lectureAppliedUser);
    List<LectureAppliedUser> findAll();
    void deleteById(long id);
}
