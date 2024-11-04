package com.temp.homework2.domain;

import com.temp.homework2.dto.BoardRequestDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//getter, setter 등등 자동생성해줌
@Data
//기본 생성자를 만들어줌
@NoArgsConstructor
//DB 테이블 역할을 함
@Entity(name = "users")
public class Board extends Timestamped {
    //데이터 베이스 자동 생성
    @GeneratedValue(strategy = GenerationType.AUTO)
    //기본 키 설
    @Id
    private Long id;

    //Column은 앞에 나올 거 칼럼으로 설정하고 null 허용 여부 알려줌
    @Column(nullable = false)
    private String title;

    // 글 내용
    @Column(nullable = false)
    private String content;

    // 비밀번호
    @Column(nullable = false)
    private String password;

    //board 엔티티 생성하는 메서드
    public Board(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }

    //업데이트 메소드
    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }
}