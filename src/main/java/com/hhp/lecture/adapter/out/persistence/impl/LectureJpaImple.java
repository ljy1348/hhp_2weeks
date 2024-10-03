package com.hhp.lecture.adapter.out.persistence.impl;

import com.hhp.lecture.adapter.out.persistence.entity.LectureEntity;
import com.hhp.lecture.adapter.out.persistence.jpa.LectureJpaRepository;
import com.hhp.lecture.application.dto.response.LectureResponse;
import com.hhp.lecture.application.port.out.LecturePortOut;
import com.hhp.lecture.domain.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class LectureJpaImple implements LecturePortOut {
    private final LectureJpaRepository lectureJpaRepository;

    @Override
    public Optional<Lecture> findById(long id) {
        return lectureJpaRepository.findById(id)
                .map(LectureEntity::toDomain); // LectureEntity에서 도메인 변환 로직 호출
    }

    @Override
    public Optional<Lecture> findByIdLock(long id) {
        return lectureJpaRepository.getByIdLock(id)
                .map(LectureEntity::toDomain); // LectureEntity에서 도메인 변환 로직 호출
    }

    @Override
    public Lecture save(Lecture lecture) {
        LectureEntity entity = LectureEntity.fromDomain(lecture); // LectureEntity에서 도메인으로 변환
        LectureEntity savedEntity = lectureJpaRepository.save(entity);
        return savedEntity.toDomain(); // 저장 후 도메인 객체로 변환
    }

    @Override
    public List<LectureResponse> findAll() {
        return lectureJpaRepository.findAllList();
    }

    @Override
    public List<LectureResponse> findByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return lectureJpaRepository.findbydate(startDate, endDate);
    }

    @Override
    public List<LectureResponse> getById(long userId) {
        return lectureJpaRepository.getByUserId(userId);
    }
}
