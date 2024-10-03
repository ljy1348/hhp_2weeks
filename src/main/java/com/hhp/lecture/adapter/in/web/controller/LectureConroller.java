package com.hhp.lecture.adapter.in.web.controller;

import com.hhp.lecture.application.dto.request.LectureApplyRequest;
import com.hhp.lecture.application.dto.response.LectureApplyResponse;
import com.hhp.lecture.application.dto.response.LectureResponse;
import com.hhp.lecture.application.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/lecture")
@RequiredArgsConstructor
public class LectureConroller {

    private final LectureService lectureService;

    @PostMapping("apply")
    public LectureApplyResponse apply(@RequestBody LectureApplyRequest request) {
        LectureApplyResponse result =
                lectureService.apply(request);
        return result;
    }

    @GetMapping("/list/all")
    public List<LectureResponse> listAll() {
        return lectureService.findAll();
    }

    @GetMapping("/list/date/{date}")
    public List<LectureResponse> getLecturesByDate(@PathVariable String date) {
            LocalDate startDate = LocalDate.parse(date);
            LocalDateTime startDateTime = startDate.atStartOfDay();
            LocalDateTime endDateTime = startDate.plusDays(1).atStartOfDay().minusSeconds(1); // 하루의 끝
            System.out.println(startDateTime);
            System.out.println(endDateTime);
            List<LectureResponse> lectures = lectureService.findByDate(startDateTime, endDateTime);
            return lectures;
    }

    @GetMapping("/list/user/{userId}")
    public List<LectureResponse> getLecturesByDate(@PathVariable long userId) {
        return lectureService.getById(userId);
    }
}
