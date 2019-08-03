package com.doohong.shoesfit.board.domain;

import com.doohong.shoesfit.member.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "tbl_board")
@Getter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private Long boardNo;

    @Column(name = "board_title")
    private String boardTitle;

    @Column(name = "board_content")
    private String boardContent;

    @Column(name = "board_reg_dt")
    private LocalDateTime boardRegDt;
    @Column(name = "board_mod_dt")
    private LocalDateTime boardModDt;
    @Column(name = "board_member")
    private Member member;
    @OneToMany
    private List<BoardComment> boardComments;
    @Builder
    public Board(String boardTitle, String boardContent) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
    }
}

