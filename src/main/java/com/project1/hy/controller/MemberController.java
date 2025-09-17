package com.project1.hy.controller;

import com.project1.hy.dto.MemberDTO;
import com.project1.hy.exceptions.MemberException;
import com.project1.hy.service.MemberService;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    // 가입
    @PostMapping("/join")
    public MemberDTO join(@RequestBody MemberDTO dto) {
        if (dto.getMemberId().isEmpty())
            throw MemberException.NOT_FOUND.getException();
        if (dto.getPassword().isEmpty())
            throw MemberException.EMPTY_PASSWORD.getException();

        return memberService.join(dto);
    }

    // 로그인
    @PostMapping("/login")
    public MemberDTO login(@RequestBody MemberDTO dto) {
        if (dto.getMemberId().isEmpty())
            throw MemberException.NOT_EXIST_MEMBER.getException();
        if (dto.getPassword().isEmpty())
            throw MemberException.EMPTY_PASSWORD.getException();

        return memberService.login(dto);
    }

}
