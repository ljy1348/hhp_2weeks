package com.hhp.lecture.adapter.out.persistence.impl;

import com.hhp.lecture.adapter.out.persistence.entity.LectureAppliedUser;
import com.hhp.lecture.adapter.out.persistence.jpa.LectureAppliedUserJpaRepository;
import com.hhp.lecture.application.port.out.LectureAppliedUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LectureAppliedUserJpaImple implements LectureAppliedUserPort {
    private final LectureAppliedUserJpaRepository lectureAppliedUserJpaRepository;

    @Override
    public Optional<LectureAppliedUser> findById(long id) {
        return lectureAppliedUserJpaRepository.findById(id);
    }

    @Override
    public LectureAppliedUser save(LectureAppliedUser lectureAppliedUser) {
        return lectureAppliedUserJpaRepository.save(lectureAppliedUser);
    }

    @Override
    public List<LectureAppliedUser> findAll() {
        return lectureAppliedUserJpaRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        lectureAppliedUserJpaRepository.deleteById(id);
    }
}
