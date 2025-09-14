package com.project1.hy.entity;

import com.project1.hy.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_member")
public class MemberEntity {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long mno;

 private String memberId;

 private String password;

 private Boolean isAdult;

 private Boolean isApproved;

 public MemberDTO toDTO() {
   return MemberDTO.builder()
       .memberId(this.memberId)
       .isAdult(this.isAdult)
        .build();
 }

}
