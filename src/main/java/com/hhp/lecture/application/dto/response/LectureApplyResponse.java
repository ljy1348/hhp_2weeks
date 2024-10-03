package com.hhp.lecture.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


public record LectureApplyResponse (
    String lectureName,
    LocalDateTime lectureDate,
    String resultYn
) {}
