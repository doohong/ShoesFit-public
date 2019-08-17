package com.doohong.shoesfit.board.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class BoardUpdateDto {
    private Long boardNo;
    private String boardTitle;
    private String boardContent;
}
