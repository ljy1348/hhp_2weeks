package com.hhp.lecture.adapter.out.persistence.impl;

import com.hhp.lecture.adapter.out.persistence.jpa.UserJpaRepository;
import com.hhp.lecture.application.port.out.UserAppRepository;
import com.hhp.lecture.adapter.out.persistence.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserJpaImpl implements UserAppRepository {
    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<User> getUserById(long id) {
        return userJpaRepository.findById(id);
    }
}
