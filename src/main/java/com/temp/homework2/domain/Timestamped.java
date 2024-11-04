package com.temp.homework2.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@Getter
//데이터베이스는 아니고 상속받는 Entity에서 공통 필드로 사용
@MappedSuperclass
//생성 시간과 수정 시간을 자동으로 기록
@EntityListeners(AuditingEntityListener.class)
public class Timestamped {

    //엔티티 최초 생성때 시간 기록
    @CreatedDate
    private LocalDateTime createdAt;

    //엔티티가 수정될때마다 수정 시간 기록함
    @LastModifiedDate
    private LocalDateTime modifiedAt;
}