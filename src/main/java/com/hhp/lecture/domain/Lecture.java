package com.hhp.lecture.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lecture {
    private long id;
    private String name;
    private long instructorId;
    private LocalDateTime date;
    private int maxUserCount;
    private int totalAppliedUser;
}
