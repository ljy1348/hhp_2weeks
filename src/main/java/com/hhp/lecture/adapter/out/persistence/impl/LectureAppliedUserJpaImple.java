package com.hhp.lecture.adapter.out.persistence.impl;

import com.hhp.lecture.adapter.out.persistence.entity.LectureAppliedUserEntity;
import com.hhp.lecture.adapter.out.persistence.jpa.LectureAppliedUserJpaRepository;
import com.hhp.lecture.application.port.out.LectureAppliedUserPortOut;
import com.hhp.lecture.domain.LectureAppliedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class LectureAppliedUserJpaImple implements LectureAppliedUserPortOut {
    private final LectureAppliedUserJpaRepository lectureAppliedUserJpaRepository;

    @Override
    public Optional<LectureAppliedUser> findById(long id) {
        return lectureAppliedUserJpaRepository.findById(id)
                .map(LectureAppliedUserEntity::toDomain); // 엔티티에서 도메인 객체로 변환
    }

    @Override
    public LectureAppliedUser save(LectureAppliedUser lectureAppliedUser) {
        LectureAppliedUserEntity entity = LectureAppliedUserEntity.fromDomain(lectureAppliedUser); // 도메인 -> 엔티티 변환
        LectureAppliedUserEntity savedEntity = lectureAppliedUserJpaRepository.save(entity);
        return savedEntity.toDomain(); // 엔티티 -> 도메인 변환
    }

    @Override
    public List<LectureAppliedUser> findAll() {
        return lectureAppliedUserJpaRepository.findAll()
                .stream()
                .map(LectureAppliedUserEntity::toDomain) // 엔티티에서 도메인 객체로 변환
                .collect(Collectors.toList());
    }

    @Override
    public long countByLecturId(long lectureId) {
        return lectureAppliedUserJpaRepository.countAllByLectureId(lectureId);
    }
}

