package com.hhp.lecture.application.port.in;

import com.hhp.lecture.application.dto.request.LectureApplyRequest;
import com.hhp.lecture.application.dto.response.LectureApplyResponse;
import com.hhp.lecture.application.dto.response.LectureResponse;
import com.hhp.lecture.domain.Lecture;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface LecturePortIn {
    Optional<Lecture> findById(long id);
    Lecture save(Lecture lecture);
    List<LectureResponse> findAll();
    LectureApplyResponse apply(LectureApplyRequest request);
    List<LectureResponse> findByDate(LocalDateTime startDate, LocalDateTime endDate);
    List<LectureResponse> getById(long userId);

}
