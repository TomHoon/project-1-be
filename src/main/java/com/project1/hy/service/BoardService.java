package com.project1.hy.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.project1.hy.dto.BoardDTO;
import com.project1.hy.entity.BoardEntity;
import com.project1.hy.entity.MemberEntity;
import com.project1.hy.exceptions.BoardException;
import com.project1.hy.exceptions.MemberException;
import com.project1.hy.repository.BoardRepository;
import com.project1.hy.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;
  private final MemberRepository memberRepository;

  public List<BoardDTO> getBoards(int pageNum) {
    PageRequest pageable = PageRequest.of(pageNum, 10);

    return boardRepository.findAll(pageable)
        .getContent()
        .stream()
        .map(e -> new BoardDTO(e))
        .toList();
  } 

  @Transactional
  public BoardDTO addBoard(BoardDTO dto) {
    String author = dto.getAuthor();
    MemberEntity mEntity = memberRepository.findByMemberId(author).orElseThrow(() -> MemberException.NOT_EXIST_MEMBER.getException());

    BoardEntity bEntity = dto.toEntity(mEntity);

    return boardRepository.save(bEntity).toDTO();
  }

  public Boolean deleteById(Long bno) {
    try {
      boardRepository.deleteById(bno);
    } catch (Exception e) {
      return false;
    }

    return true;
  }

  public BoardDTO getDetail(Long bno) {
    BoardEntity entity = boardRepository.findById(bno).orElseThrow(() -> BoardException.NO_BOARD.getException());
    return entity.toDTO();
  }

}
