package com.hhp.lecture.adapter.out.persistence.jpa;

import com.hhp.lecture.adapter.out.persistence.entity.LectureEntity;
import com.hhp.lecture.application.dto.response.LectureResponse;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface LectureJpaRepository extends JpaRepository<LectureEntity, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("""
    select l from LectureEntity l where l.id = :id
    """)
    Optional<LectureEntity> getByIdLock(long id);
    
    Optional<LectureEntity> findById(long id);

    LectureEntity save(LectureEntity lecture);

    @Query("""
            select new com.hhp.lecture.application.dto.response.LectureResponse(
                l.id
                , l.name
                , l.totalAppliedUser
                , l.maxUserCount
                , l.date
                , i.name
            )
            from LectureEntity l
            left join InstructorEntity i on l.instructorId = i.id
            """)
    List<LectureResponse> findAllList();

    @Query("""
            select new com.hhp.lecture.application.dto.response.LectureResponse(
                l.id
                , l.name
                , l.totalAppliedUser
                , l.maxUserCount
                , l.date
                , i.name
            )
            from LectureEntity l
            left join InstructorEntity i on l.instructorId = i.id
            where l.date between :startDate and :endDate
            """)
    List<LectureResponse> findbydate(LocalDateTime startDate, LocalDateTime endDate);

    @Query("""
            select new com.hhp.lecture.application.dto.response.LectureResponse(
                l.id
                , l.name
                , l.totalAppliedUser
                , l.maxUserCount
                , l.date
                , i.name
            )
            from LectureAppliedUserEntity a
            left join LectureEntity l
            on a.lectureId = l.id
            left join InstructorEntity i
            on i.id = l.instructorId
            where a.userId = :userId
            """)
    List<LectureResponse> getByUserId(long userId);
}
