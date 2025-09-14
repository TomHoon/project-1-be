package com.project1.hy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project1.hy.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
