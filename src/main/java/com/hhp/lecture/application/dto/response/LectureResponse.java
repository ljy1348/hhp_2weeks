package com.hhp.lecture.application.dto.response;

import java.time.LocalDateTime;

public record LectureResponse(long lectureId, String lectureName, int applyCount
        , int maxApplyCount, LocalDateTime date, String instructorName) {
}
