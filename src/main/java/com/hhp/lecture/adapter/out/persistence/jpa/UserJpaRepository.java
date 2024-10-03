package com.hhp.lecture.adapter.out.persistence.jpa;

import com.hhp.lecture.adapter.out.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    Optional<User> findById(long id);
}

