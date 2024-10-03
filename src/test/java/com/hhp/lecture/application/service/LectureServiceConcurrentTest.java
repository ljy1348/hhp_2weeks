package com.hhp.lecture.application.service;

import com.hhp.lecture.application.dto.request.LectureApplyRequest;
import com.hhp.lecture.application.dto.response.LectureApplyResponse;
import com.hhp.lecture.application.dto.response.LectureResponse;
import com.hhp.lecture.domain.Lecture;
import com.hhp.lecture.domain.LectureAppliedUser;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LectureServiceConcurrentTest {
    @Autowired
    LectureService lectureService;

    @Autowired
    LectureAppliedUserService lectureAppliedUserService;

    @Test
    @DisplayName("40명 동시 요청 정상 테스트")
    public void testMultiApply() throws InterruptedException {
        int numberOfThreads = 40;

        // 스레드 풀 생성
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        long id = 1L;

        // 40개의 요청을 동시에 실행
        for (int i = 0; i < numberOfThreads; i++) {
            int threadIndex = i;
            executorService.submit(() -> {
                try {
                    LectureApplyRequest request = new LectureApplyRequest(id, Integer.valueOf(threadIndex + 1).longValue());
                    LectureApplyResponse result = lectureService.apply(request);
                }
                finally {
                    latch.countDown();
                }
            });
        }

        latch.await(10, TimeUnit.SECONDS);

        executorService.shutdown();
        Optional<Lecture> lecture = lectureService.findById(id);
        int maxCount = lecture.get().getMaxUserCount();
        long count = lectureAppliedUserService.countByLecturId(id);

        assertEquals(maxCount, lecture.get().getTotalAppliedUser());
        assertEquals(maxCount, count);

    }


    @Test
    @DisplayName("동일 유저 동일 강의 동시 요청 테스트")
    public void testMultiApplyOneUser() throws InterruptedException {
        int numberOfThreads = 5;

        // 스레드 풀 생성
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        long id = 2L;
        long userId = 40L;

        // 40개의 요청을 동시에 실행
        for (int i = 0; i < numberOfThreads; i++) {
            int threadIndex = i;
            executorService.submit(() -> {
                try {
                    LectureApplyRequest request = new LectureApplyRequest(id, userId);
                    LectureApplyResponse result = lectureService.apply(request);
                }
                finally {
                    latch.countDown();
                }
            });
        }

        latch.await(10, TimeUnit.SECONDS);

        executorService.shutdown();

        long count = lectureAppliedUserService.countAllByUserIdAndLectureId(userId, id);

        assertEquals(1, count);

    }
}
