package com.doohong.shoesfit.board.domain;

import com.doohong.shoesfit.member.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.jdo.annotations.Join;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(name = "tbl_board_comment")
@Getter
public class BoardComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_comment_no")
    private Long boardCommentNo;

    @Column(name = "board_comment_content")
    private String boardCommentContent;
    @OneToOne
    @JoinColumn(name = "board_comment_member")
    private Member member;
    @Column(name = "board_comment_reg_dt")
    private LocalDateTime boardCommentRegDt;
    @Column(name = "board_comment_mod_dt")
    private LocalDateTime boardCommentModDt;
    @ManyToOne
    @JoinColumn(name = "board_no")
    private Board board;
}
