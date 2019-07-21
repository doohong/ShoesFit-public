package com.doohong.shoesfit.board.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardResponse {
    private Long boardNo;
    private String boardTitle;
    private String boardContent;
}
