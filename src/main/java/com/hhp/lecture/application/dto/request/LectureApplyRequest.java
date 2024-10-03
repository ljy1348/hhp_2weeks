package com.hhp.lecture.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record LectureApplyRequest (long lectureId, long userId) {}
