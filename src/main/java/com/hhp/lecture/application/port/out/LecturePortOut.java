package com.hhp.lecture.application.port.out;

import com.hhp.lecture.adapter.out.persistence.entity.LectureEntity;
import com.hhp.lecture.application.dto.response.LectureResponse;
import com.hhp.lecture.domain.Lecture;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface LecturePortOut {
    Optional<Lecture> findById(long id);
    Optional<Lecture> findByIdLock(long id);
    Lecture save(Lecture lecture);
    List<LectureResponse> findAll();
    List<LectureResponse> findByDate(LocalDateTime startDate, LocalDateTime endDate);
    List<LectureResponse> getById(long userId);
}
