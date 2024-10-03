package com.hhp.lecture.adapter.out.persistence.jpa;

import com.hhp.lecture.adapter.out.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findById(long id);
    UserEntity save(UserEntity user);
    List<UserEntity> findAll();
}

