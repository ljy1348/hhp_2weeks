package com.hhp.lecture.application.port.in;

import com.hhp.lecture.adapter.out.persistence.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserPortIn {
    Optional<UserEntity> findById(long id);
    UserEntity save(UserEntity user);
    List<UserEntity> findAll();
}
