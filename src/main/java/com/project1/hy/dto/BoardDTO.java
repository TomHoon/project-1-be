package com.project1.hy.dto;

import java.util.List;

import com.project1.hy.entity.BoardEntity;
import com.project1.hy.entity.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BoardDTO {
  private String title;
  private String content;
  private String author;
  private List<String> imageUrls;

  public void setTitle(String title) {
    this.title = title;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setImageUrls(List<String> imageUrls) {
    this.imageUrls = imageUrls;
  }


  public BoardEntity toEntity(MemberEntity e) {
    return BoardEntity.builder()
        .title(this.title)
        .content(this.content)
        .imageUrls(this.imageUrls)
        .memberEntity(e)
        .build();
  }

  public BoardDTO(BoardEntity e) {
    this.title = e.getTitle();
    this.content = e.getContent();
    this.imageUrls = e.getImageUrls();
    this.author = e.getMemberEntity().getMemberId();
  }
}
