package com.project1.hy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project1.hy.dto.BoardDTO;
import com.project1.hy.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {
  private final BoardService boardService;

  // ✅ 글조회
  @GetMapping("/list")
  public List<BoardDTO> getBoards(@RequestParam(defaultValue = "0") int pageNum) {
    if (pageNum > 0)
      pageNum -= 1;
    return boardService.getBoards(pageNum);
  }

  // ✅ 글등록
  @PostMapping("/addBoard")
  public BoardDTO addBoard(
      @RequestParam("title") String title,
      @RequestParam("content") String content,
      @RequestParam("author") String author,
      @RequestParam(value = "file", required = false) MultipartFile file) {

    List<String> imageList = new ArrayList<String>();

    if (file != null && !file.isEmpty()) {
      String filename = com.project1.hy.utils.FileUtil.saveFile(file);
      imageList.add(filename);
    }

    BoardDTO dto = BoardDTO.builder()
        .title(title)
        .content(content)
        .imageUrls(imageList)
        .author(author)
        .build();

    return boardService.addBoard(dto);
  }

  // ✅ 글삭제
  @DeleteMapping("/deleteBoard/{bno}")
  public Boolean deleteBoard(@PathVariable(name = "bno") Long bno) {
    try {
      boardService.deleteById(bno);
    } catch (Exception e) {
      return false;
    }

    return true;
  }

  // ✅ 글수정
  @PutMapping("/modify")
  public BoardDTO modifyBoard(@RequestBody BoardDTO dto) {
    // BoardDTO resDTO = boardService.modifyBoard(dto);
    // return resDTO;
    return null;
  }

  // @GetMapping("/detail/{bno}")
  // public BoardDTO getDetail(@PathVariable Long bno) {
  // return boardService.getDetail(bno);
  // }
}
