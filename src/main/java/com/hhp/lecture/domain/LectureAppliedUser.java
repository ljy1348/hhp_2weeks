package com.hhp.lecture.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LectureAppliedUser {
    private long id;
    private long instructorId;
    private long userId;

    public LectureAppliedUser(long instructorId, long userId) {
        this.instructorId = instructorId;
        this.userId = userId;
    }
}
