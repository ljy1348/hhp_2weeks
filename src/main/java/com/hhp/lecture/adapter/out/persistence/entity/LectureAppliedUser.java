package com.hhp.lecture.adapter.out.persistence.entity;

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
public class LectureAppliedUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long lectureId;
    private long userId;
}
