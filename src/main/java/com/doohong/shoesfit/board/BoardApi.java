package com.doohong.shoesfit.board;


import com.doohong.shoesfit.board.domain.Board;
import com.doohong.shoesfit.board.dto.BoardResponse;
import com.doohong.shoesfit.board.dto.BoardUpdateDto;
import com.doohong.shoesfit.board.dto.BoardWriteDto;
import com.doohong.shoesfit.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/board")
public class BoardApi {
    private final BoardService boardService;

    @PostMapping(value = "write")
    public ResponseEntity<BoardResponse> write(@RequestBody @Valid BoardWriteDto boardWriteDto) {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.write(boardWriteDto));

    }
    @GetMapping(value="list")
    public ResponseEntity<List<Board>> list(){
        return ResponseEntity.status(HttpStatus.OK).body(boardService.list());
    }

    @PutMapping(value="update")
    public ResponseEntity<BoardResponse> update(@RequestBody @Valid BoardUpdateDto boardUpdateDto){
        return ResponseEntity.status(HttpStatus.OK).body(boardService.update(boardUpdateDto));
    }

}
