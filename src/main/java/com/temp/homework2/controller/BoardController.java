package com.temp.homework2.controller;

import com.temp.homework2.Service.BoardService;
import com.temp.homework2.dto.BoardListResponseDto;
import com.temp.homework2.dto.BoardRequestDto;
import com.temp.homework2.dto.BoardResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//JSON으로 데이터를 주고받음을 선언
@RestController
//그 url 기본으로 /boards 세팅하고 간다고 해야하나? 기본 셋 해주는 애임
@RequestMapping("/boards")
//생성자 자동으로 그 해주는 거
@AllArgsConstructor
public class BoardController {

    //boardService에서 만든 메서드 쓸게요 ~
    private final BoardService boardService;

    // 글 등록
    @PostMapping("/post")
    //RequestBody 는 html에서 작성한 json 메서드에서 쓸거야~ 이런 느낌? 여기서는 BoardRequestDto 객체로 씀
    public ResponseEntity<String> createBoard(@RequestBody BoardRequestDto requestDto){
        //Service에서 그 생성하고 그 결과를 ResponseDto 객체에 저장
        BoardResponseDto board = boardService.createBoard(requestDto);
        //생성된 게시글 정보 ResponseEntity 사용해 정보를 문자열 형태로 변환해서 반환
        return ResponseEntity.ok(board.toString());
    }

    // 전체 목록 조회
    @GetMapping("/boardlist")
    public List<BoardListResponseDto> getAllBoards() {
        //service에서 게시글 목록 들고와
        return boardService.findAllBoard();
    }

    // 글 하나 조회
    @GetMapping("/{id}")
    //pathVariable은 url에 있는 값 들고 올게요
    public BoardResponseDto getOneBoard(@PathVariable Long id) {
        return boardService.findOneBoard(id);
    }

    // 글 수정
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        boardService.updateBoard(id,requestDto);
        return ResponseEntity.ok("success");
    }

    // 글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.ok("success");
    }
}