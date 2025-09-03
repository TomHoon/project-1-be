package com.project1.hy.controller;

import com.project1.hy.dto.MemberDTO;
import com.project1.hy.service.MemberService;
import com.project1.hy.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    // 가입
    @PostMapping("/join")
    public ResponseEntity<ApiResponse<MemberDTO>> join(@RequestBody MemberDTO dto)  {
        if (dto.getMemberId().isEmpty()) return ResponseEntity.ok(ApiResponse.error("아이디가 없습니다"));
        if (dto.getPassword().isEmpty()) return ResponseEntity.ok(ApiResponse.error("비밀번호가 없습니다"));

        return memberService.join(dto);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<MemberDTO>> login(@RequestBody MemberDTO dto) {
        if (dto.getMemberId().isEmpty()) return ResponseEntity.ok(ApiResponse.error("아이디가 없습니다"));
        if (dto.getPassword().isEmpty()) return ResponseEntity.ok(ApiResponse.error("비밀번호가 없습니다"));

        return memberService.login(dto);
    }


}
