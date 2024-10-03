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
    public void testConcurrentFunctionExecution() throws InterruptedException {
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
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await(10, TimeUnit.SECONDS);

        executorService.shutdown();
        Optional<Lecture> lecture = lectureService.findById(id);
        int maxCount = lecture.get().getMaxUserCount();
        List<LectureAppliedUser> count = lectureAppliedUserService.findAll();

        Optional<Lecture> result = lectureService.findById(id);

        assertEquals(maxCount, result.get().getTotalAppliedUser());
        assertEquals(maxCount, count.size());

    }
}
