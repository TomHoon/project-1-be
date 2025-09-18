package com.project1.hy.entity;

import java.util.ArrayList;
import java.util.List;

import com.project1.hy.dto.BoardDTO;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_board")
public class BoardEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bno;

  private String title;
  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_mno")
  private MemberEntity memberEntity;

  @ElementCollection
  @CollectionTable(name = "tbl_board_images", joinColumns = @JoinColumn(name = "bno"))
  @Column(name = "image_url")
  private List<String> imageUrls = new ArrayList<>();

  public BoardDTO toDTO() {
    return BoardDTO.builder()
        .title(this.title)
        .content(this.content)
        .author(this.memberEntity.getMemberId())
        .imageUrls(this.imageUrls)
        .build();
  }

}
