package com.hhp.lecture.application.service;

import com.hhp.lecture.application.dto.request.LectureApplyRequest;
import com.hhp.lecture.application.dto.response.LectureApplyResponse;
import com.hhp.lecture.application.dto.response.LectureResponse;
import com.hhp.lecture.application.port.out.LectureAppliedUserPortOut;
import com.hhp.lecture.application.port.out.LecturePortOut;
import com.hhp.lecture.domain.Lecture;
import com.hhp.lecture.domain.LectureAppliedUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LectureServiceTest {
    @Mock
    LecturePortOut lecturePortOut;

    @Mock
    LectureAppliedUserPortOut lectureAppliedUserPortOut;

    @InjectMocks
    LectureService lectureService;

    List<LectureResponse> list;
    LectureResponse lectureResponse;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        lectureResponse = new LectureResponse(
                1L,                           // lectureId
                "Spring Boot Basics",          // lectureName
                10,                            // applyCount
                30,                            // maxApplyCount
                LocalDateTime.now(),            // date
                "John Doe"                     // instructorName
        );
        list.add(lectureResponse);
    }

    @Test
    @DisplayName("강의 신청 수강 인원 초과 하지 않는 경우")
    void lectureAppliedUserSucc() {
        Lecture lecture = new Lecture();
        lecture.setId(1L);
        lecture.setName("test");
        lecture.setMaxUserCount(30);
        lecture.setTotalAppliedUser(1);
        Optional<Lecture> optionalLecture = Optional.of(lecture);
        doReturn(optionalLecture).when(lecturePortOut).findById(1L);

        LectureApplyResponse result = lectureService.apply(new LectureApplyRequest(1L, 1L));

        assertEquals("test", result.lectureName());

    }

    @Test
    @DisplayName("강의 신청 수강 인원 초과 하는 경우")
    void lectureAppliedUserCountOver() {
        Lecture lecture = new Lecture();
        lecture.setId(1L);
        lecture.setName("test");
        lecture.setMaxUserCount(30);
        lecture.setTotalAppliedUser(30);
        Optional<Lecture> optionalLecture = Optional.of(lecture);
        doReturn(optionalLecture).when(lecturePortOut).findById(1L);

        LectureApplyResponse result = lectureService.apply(new LectureApplyRequest(1L, 1L));

        assertEquals(null, result);
    }

    @Test
    @DisplayName("강의 목록 조회 정상 테스트")
    public void testGetLectureList() {
        doReturn(list).when(lecturePortOut).findAll();

        List<LectureResponse> result = lectureService.findAll();

        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("날짜별 강의 목록 조회 정상 테스트")
    public void testGetLectureListByDate() {
        LocalDate localDate = LocalDate.now();
        LocalDateTime startDateTime = localDate.atStartOfDay();
        LocalDateTime endDateTime = localDate.plusDays(1).atStartOfDay().minusSeconds(1); // 하루의 끝

        // 테스트 로직 작성
        doReturn(list).when(lecturePortOut).findByDate(startDateTime, endDateTime);

        List<LectureResponse> result = lectureService.findByDate(startDateTime, endDateTime);

        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("회원별 강의 목록 조회 정상 테스트")
    public void testGetLectureListByMember() {
        // 테스트 로직 작성
        doReturn(list).when(lecturePortOut).getById(1L);

        List<LectureResponse> result = lectureService.getById(1L);

        assertEquals(1, result.size());
    }
}
