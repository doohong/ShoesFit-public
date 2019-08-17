package com.doohong.shoesfit.board.service;

import com.doohong.shoesfit.board.domain.Board;
import com.doohong.shoesfit.board.dto.BoardResponse;
import com.doohong.shoesfit.board.dto.BoardUpdateDto;
import com.doohong.shoesfit.board.dto.BoardWriteDto;
import com.doohong.shoesfit.board.repository.BoardRepository;
import com.doohong.shoesfit.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public BoardResponse write(BoardWriteDto boardWriteDto){
        Board board = boardRepository.save(Board.builder().boardTitle(boardWriteDto.getBoardTitle()).boardContent(boardWriteDto.getBoardContent()).build());
        return BoardResponse.builder().boardContent(board.getBoardContent()).boardNo(board.getBoardNo()).boardTitle(board.getBoardTitle()).build();
    }

    public List<Board> list(){
        List<Board> boardList = boardRepository.findAll();
        return boardList;
    }

    public BoardResponse update(BoardUpdateDto boardUpdateDto){
        Optional<Board> board = boardRepository.findById(boardUpdateDto.getBoardNo());
        //if(board.orElseThrow().getMember().getEmail().equals(boardUpdateDto.get)
        //boardRepository.
        return null;
    }
}
