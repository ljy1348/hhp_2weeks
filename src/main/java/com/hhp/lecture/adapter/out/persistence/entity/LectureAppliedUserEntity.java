package com.hhp.lecture.adapter.out.persistence.entity;

import com.hhp.lecture.domain.LectureAppliedUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lecture_applied_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LectureAppliedUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long lectureId;
    private long userId;

    // LectureAppliedUserEntity -> LectureAppliedUser 도메인 객체로 변환
    public LectureAppliedUser toDomain() {
        return new LectureAppliedUser(this.id, this.lectureId, this.userId);
    }

    // LectureAppliedUser 도메인 객체 -> LectureAppliedUserEntity로 변환
    public static LectureAppliedUserEntity fromDomain(LectureAppliedUser lectureAppliedUser) {
        return new LectureAppliedUserEntity(
                lectureAppliedUser.getId(),
                lectureAppliedUser.getInstructorId(),
                lectureAppliedUser.getUserId()
        );
    }
}
