package com.hhp.lecture.adapter.in.web;

import com.hhp.lecture.application.port.in.UserUsecase;
import com.hhp.lecture.adapter.out.persistence.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserConroller {

    private final UserUsecase userUsecase;

    @GetMapping("/test")
    public String test() {
        Optional<User> user = userUsecase.findByUser(1L);
        if (user.isPresent()) {
            return user.get().getName();
        } else {
            return "user not found";
        }
    }


}
