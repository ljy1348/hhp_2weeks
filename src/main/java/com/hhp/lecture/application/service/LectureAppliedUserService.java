package com.hhp.lecture.application.service;

import com.hhp.lecture.application.port.in.LectureAppliedUserPortIn;
import com.hhp.lecture.application.port.out.LectureAppliedUserPortOut;
import com.hhp.lecture.domain.LectureAppliedUser;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class LectureAppliedUserService implements LectureAppliedUserPortIn {
    private final LectureAppliedUserPortOut lectureAppliedUserPortOut;

    @Override
    public Optional<LectureAppliedUser> findById(long id) {
        return lectureAppliedUserPortOut.findById(id);
    }

    @Override
    public LectureAppliedUser save(LectureAppliedUser lectureAppliedUser) {
        return lectureAppliedUserPortOut.save(lectureAppliedUser);
    }

    @Override
    public List<LectureAppliedUser> findAll() {
        return lectureAppliedUserPortOut.findAll();
    }

    @Override
    public long countByLecturId(long lectureId) {
        return lectureAppliedUserPortOut.countByLecturId(lectureId);
    }

    @Override
    public long countAllByUserIdAndLectureId(long userId, long lectureId) {
        return lectureAppliedUserPortOut.countAllByUserIdAndLectureId(userId, lectureId);
    }
}
