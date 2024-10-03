package com.hhp.lecture.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LectureAppliedUser {
    private long id;
    private long lectureId;
    private long userId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public LectureAppliedUser(long instructorId, long userId) {
        this.lectureId = instructorId;
        this.userId = userId;
    }

//    public LectureAppliedUser(long id, long instructorId, long userId) {
//        this.id = id;
//        this.instructorId = instructorId;
//        this.userId = userId;
//    }
}
