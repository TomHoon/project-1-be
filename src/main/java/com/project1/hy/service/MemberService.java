package com.project1.hy.service;

import com.project1.hy.dto.MemberDTO;
import com.project1.hy.entity.MemberEntity;
import com.project1.hy.repository.MemberRepository;
import com.project1.hy.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 가입
    public ResponseEntity<ApiResponse<MemberDTO>> join(MemberDTO dto) {

        Optional<MemberEntity> res = memberRepository.findByMemberId(dto.getMemberId());
        if (res.isPresent()) {
            return ResponseEntity.ok(ApiResponse.error("이미 존재하는아이디"));
        }

        MemberEntity e = dto.toEntity();
        MemberEntity resEntity = memberRepository.save(e);

        return ResponseEntity.ok(ApiResponse.success(resEntity.toDTO()));
    }

    // 로그인
    public ResponseEntity<ApiResponse<MemberDTO>> login(MemberDTO dto) {
        MemberEntity e = memberRepository.findByMemberId(dto.getMemberId()).orElseThrow();
        String pw = e.getPassword();

        if (!pw.equals(dto.getPassword())) {
            return ResponseEntity.ok(ApiResponse.error("비밀번호가 맞지 않습니다"));
        }

        return ResponseEntity.ok(ApiResponse.success(e.toDTO()));
    }
}
