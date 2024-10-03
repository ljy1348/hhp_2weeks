package com.hhp.lecture.application.port.out;

import com.hhp.lecture.adapter.out.persistence.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserPort {
    Optional<User> findById(long id);
    User save(User user);
    List<User> findAll();
}
