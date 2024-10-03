package com.hhp.lecture.adapter.out.persistence.impl;

import com.hhp.lecture.adapter.out.persistence.jpa.UserJpaRepository;
import com.hhp.lecture.application.port.out.UserPort;
import com.hhp.lecture.adapter.out.persistence.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserJpaImpl implements UserPort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<User> findById(long id) {
        return userJpaRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userJpaRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userJpaRepository.findAll();
    }
}
