package com.project1.hy.service;

import com.project1.hy.dto.MemberDTO;
import com.project1.hy.entity.MemberEntity;
import com.project1.hy.exceptions.MemberException;
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
    public MemberDTO join(MemberDTO dto) {

        Optional<MemberEntity> res = memberRepository.findByMemberId(dto.getMemberId());
        if (res.isPresent()) {
            throw MemberException.ALREADY_EXIST.getException();
        }

        MemberEntity e = dto.toEntity();
        MemberEntity resEntity = memberRepository.save(e);

        return resEntity.toDTO();
    }

    // 로그인
    public MemberDTO login(MemberDTO dto) {
        MemberEntity e = memberRepository.findByMemberId(dto.getMemberId()).orElseThrow();
        String pw = e.getPassword();

        if (!pw.equals(dto.getPassword())) {
            throw MemberException.WRONG_PASSWORD.getException();
        }

        return e.toDTO();
    }
}
