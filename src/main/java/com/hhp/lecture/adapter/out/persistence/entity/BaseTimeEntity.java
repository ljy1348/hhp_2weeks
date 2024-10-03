package com.hhp.lecture.adapter.out.persistence.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // 자동으로 날짜 업데이트를 관리
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createDate; // 생성 시간

    @LastModifiedDate
    private LocalDateTime updateDate; // 수정 시간

    // Getters
    public LocalDateTime getCreatedDate() {
        return createDate;
    }

    public LocalDateTime getModifiedDate() {
        return updateDate;
    }

    public void setCreatedDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void setModifiedDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}