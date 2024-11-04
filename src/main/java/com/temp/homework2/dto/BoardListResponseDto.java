package com.temp.homework2.dto;

import com.temp.homework2.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

//파라미터 없는 생성자 자동 생성
@NoArgsConstructor
//모든 필드를 파라미터로 받는 생성자 자동 생성
@AllArgsConstructor
@Getter
public class BoardListResponseDto {
    //제목
    private String title;

    //작성자명
    private String username;

    //게시글 첫 작성 시간
    private LocalDateTime createdAt;

    //게시글 수정 시간
    private LocalDateTime modifiedAt;

    //Entity 객체를 Dto로 변경
    public BoardListResponseDto(Board board) {
        this.title = board.getTitle();
        this.createdAt = board.getModifiedAt();
        this.modifiedAt = board.getCreatedAt();
    }
}