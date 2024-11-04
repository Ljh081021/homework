package com.temp.homework2.Service;

import com.temp.homework2.domain.Board;
import com.temp.homework2.dto.BoardListResponseDto;
import com.temp.homework2.dto.BoardRequestDto;
import com.temp.homework2.dto.BoardResponseDto;
import com.temp.homework2.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {
    //리포지토리 쓸거임
    private final BoardRepository boardRepository;
    public BoardResponseDto createBoard(BoardRequestDto requestDto) {
        //board 써서 객체 생성
        Board board = new Board(requestDto);
        //db에 저장
        boardRepository.save(board);
        //저장된 board 객체 반환
        return new BoardResponseDto(board);
    }

    //모든 글 가져오기
    public List<BoardListResponseDto> findAllBoard() {
        try{
            //모든 게시글 가져와서 boardList 리스트로 저장
            List<Board> boardList = boardRepository.findAll();

            //BoardListResponseDto 타입으로 새로운 리스트 생성
            List<BoardListResponseDto> responseDtoList = new ArrayList<>();

            //모든 board 객체 순회하면서 BoardResponseDto로 변환하고 ResponseDto 리스트에 추가
            for (Board board : boardList) {
                responseDtoList.add(
                        new BoardListResponseDto(board)
                );
            }
            //모든 게시글 반환
            return responseDtoList;
        } catch (Exception e) {
            //에러 발생하면 실행되는 거
//            throw new DBEmptyDataException("a");
        }
        return null;
    }

    //글 하나 가져오기
    public BoardResponseDto findOneBoard(Long id) {
        //리포지토리에서 id에 맞는 애 델꼬 오고 안되면 예외 발생시킴
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("조회 실패")
        );
        //객체 ResponseDto 형태로 반환
        return new BoardResponseDto(board);
    }

    //글 수정
    //Transactional은 예외 발생 시 데이터베이스를 원 상태로 돌려주는 애임
    @Transactional
    public void updateBoard(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        //업데이트 하는 애
        board.update(requestDto);
    }

    //삭제
    @Transactional
    public void deleteBoard(Long id) {
        //id로 삭제
        boardRepository.deleteById(id);
    }
}