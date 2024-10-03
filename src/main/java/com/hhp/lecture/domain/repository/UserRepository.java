package com.hhp.lecture.domain.repository;

import com.hhp.lecture.adapter.out.persistence.entity.Lecture;
import com.hhp.lecture.adapter.out.persistence.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(long id);
    User save(User user);
    List<Lecture> findAll();
}
