package com.doohong.shoesfit.board;


import com.doohong.shoesfit.board.dto.BoardResponse;
import com.doohong.shoesfit.board.dto.BoardWriteDto;
import com.doohong.shoesfit.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/board")
public class BoardApi {
    private final BoardService boardService;

    @PostMapping(value = "write")
    public ResponseEntity<BoardResponse> write(@RequestBody @Valid BoardWriteDto boardWriteDto) {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.write(boardWriteDto));

    }

}
