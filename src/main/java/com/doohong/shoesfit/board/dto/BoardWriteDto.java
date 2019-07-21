package com.doohong.shoesfit.board.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class BoardWriteDto {
    private String boardTitle;
    private String boardContent;
}
