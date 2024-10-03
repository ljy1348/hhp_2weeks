package com.hhp.lecture.application.service;

import com.hhp.lecture.application.port.in.UserUsecase;
import com.hhp.lecture.application.port.out.UserAppRepository;
import com.hhp.lecture.adapter.out.persistence.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements UserUsecase {

    private final UserAppRepository userAppRepository;

    @Override
    public Optional<User> findByUser(long id) {
        return userAppRepository.getUserById(id);
    }
}
