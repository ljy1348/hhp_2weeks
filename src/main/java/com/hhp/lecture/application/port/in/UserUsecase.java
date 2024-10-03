package com.hhp.lecture.application.port.in;

import com.hhp.lecture.adapter.out.persistence.entity.User;

import java.util.Optional;

public interface UserUsecase {
    Optional<User> findByUser(long id);
}
