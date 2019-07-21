package com.doohong.shoesfit.board.repository;

import com.doohong.shoesfit.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
