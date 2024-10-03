package com.hhp.lecture.application.port.out;

import com.hhp.lecture.adapter.out.persistence.entity.User;

import java.util.Optional;

public interface UserAppRepository {
    Optional<User> getUserById(long id);
}
