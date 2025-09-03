package com.project1.hy.dto;

import com.project1.hy.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String memberId;

    private String password;

    private Boolean isAdult;

    private Boolean isApproved;

    public MemberDTO(MemberEntity e) {
        this.memberId = e.getMemberId();
        this.password = e.getPassword();
        this.isAdult = e.getIsAdult();
        this.isApproved = e.getIsApproved();
    }

    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .memberId(this.memberId)
                .password(this.password)
                .isAdult(this.isAdult)
                .isApproved(this.isApproved)
                .build();
    }
}
