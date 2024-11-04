package com.temp.homework2.repository;

import com.temp.homework2.domain.Board;
import com.temp.homework2.dto.BoardListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//얘는 그냥 기본적으로 spring에서 제공되는 repository 쓴다? 정도로 이해하면 될 (crud만 포함) 여기서는 board 엔티티에 대해 crud 제공하고 id타입이 Long임을 의미
public interface BoardRepository extends JpaRepository<Board, Long> {
    //여러개의 boardListResponseDto객체 리스트로 반환 + 순서대로 모든 데이터 조회, 데이터 정렬, 정렬 기준 선택, 내림차순 이라는 의미임
    List<BoardListResponseDto> findAllByOrderByModifiedAtDesc();
}