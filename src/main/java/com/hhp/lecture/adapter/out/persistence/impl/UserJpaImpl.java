package com.hhp.lecture.adapter.out.persistence.impl;

import com.hhp.lecture.adapter.out.persistence.jpa.UserJpaRepository;
import com.hhp.lecture.application.port.out.UserPortOut;
import com.hhp.lecture.adapter.out.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserJpaImpl implements UserPortOut {

    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<UserEntity> findById(long id) {
        return userJpaRepository.findById(id);
    }

    @Override
    public UserEntity save(UserEntity user) {
        return userJpaRepository.save(user);
    }

    @Override
    public List<UserEntity> findAll() {
        return userJpaRepository.findAll();
    }
}
