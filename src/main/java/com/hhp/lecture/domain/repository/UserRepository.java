package com.hhp.lecture.domain.repository;

import com.hhp.lecture.adapter.out.persistence.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(long id);
    User save(User user);
}
