package com.hhp.lecture.application.service;

import com.hhp.lecture.application.dto.request.LectureApplyRequest;
import com.hhp.lecture.application.dto.response.LectureApplyResponse;
import com.hhp.lecture.application.dto.response.LectureResponse;
import com.hhp.lecture.application.port.in.LecturePortIn;
import com.hhp.lecture.application.port.out.LectureAppliedUserPortOut;
import com.hhp.lecture.application.port.out.LecturePortOut;
import com.hhp.lecture.domain.Lecture;
import com.hhp.lecture.domain.LectureAppliedUser;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class LectureService implements LecturePortIn {

    private final LecturePortOut lecturePortOut;
    private final LectureAppliedUserPortOut lectureAppliedUserPortOut;

    @Override
    public Optional<Lecture> findById(long id) {
        // 엔티티 -> 도메인 객체로 변환
        return lecturePortOut.findById(id);
    }

    @Override
    public Optional<Lecture> findByIdLock(long id) {
        return lecturePortOut.findByIdLock(id);
    }

    @Override
    public Lecture save(Lecture lecture) {
        return lecturePortOut.save(lecture);
    }

    @Override
    public List<LectureResponse> findAll() {
        List<LectureResponse> getList = lecturePortOut.findAll();
        return getList;
    }

    @Transactional
    @Override
    public LectureApplyResponse apply(LectureApplyRequest request) {
        Optional<Lecture> optionalLecture = findByIdLock(request.lectureId());
        if (optionalLecture.isPresent()) {
            Lecture lecture = optionalLecture.get();
            int count = lecture.getTotalAppliedUser();
            int max = lecture.getMaxUserCount();
            if (count < max) {
                lecture.setTotalAppliedUser(count+1);
                save(lecture);
                LectureAppliedUser lectureAppliedUser = new LectureAppliedUser(request.lectureId(), request.userId());
                lectureAppliedUserPortOut.save(lectureAppliedUser);
                return new LectureApplyResponse(lecture.getName(), lecture.getDate(), "Y");
            }
        }
        return new LectureApplyResponse("", null, "N");
    }

    @Override
    public List<LectureResponse> findByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return lecturePortOut.findByDate(startDate, endDate);
    }

    public List<LectureResponse> getById(long userId) {
        return lecturePortOut.getById(userId);
    }
}
