package com.doohong.shoesfit.board.service;

import com.doohong.shoesfit.board.domain.Board;
import com.doohong.shoesfit.board.dto.BoardResponse;
import com.doohong.shoesfit.board.dto.BoardWriteDto;
import com.doohong.shoesfit.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardResponse write(BoardWriteDto boardWriteDto){
        Board board = boardRepository.save(Board.builder().boardTitle(boardWriteDto.getBoardTitle()).boardContent(boardWriteDto.getBoardContent()).build());
        return BoardResponse.builder().boardContent(board.getBoardContent()).boardNo(board.getBoardNo()).boardTitle(board.getBoardTitle()).build();
    }

    public List<Board> list(){
        List<Board> boardList = boardRepository.findAll();
        return boardList;
    }
}
