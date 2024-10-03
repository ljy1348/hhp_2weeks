package com.hhp.lecture.adapter.out.persistence.entity;

import com.hhp.lecture.domain.Lecture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "lecture")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LectureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long instructorId;
    private LocalDateTime date;
    private Integer maxUserCount;
    private Integer totalAppliedUser;

    public Lecture toDomain() {
        return new Lecture(
                this.id,
                this.name,
                this.instructorId,
                this.date,
                this.maxUserCount != null ? this.maxUserCount : 0,
                this.totalAppliedUser != null ? this.totalAppliedUser : 0
        );
    }

    public static LectureEntity fromDomain(Lecture lecture) {
        return new LectureEntity(
                lecture.getId(),
                lecture.getName(),
                lecture.getInstructorId(),
                lecture.getDate(),
                lecture.getMaxUserCount(),
                lecture.getTotalAppliedUser()
        );
    }
}
