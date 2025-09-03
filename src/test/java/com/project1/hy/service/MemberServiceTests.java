package com.project1.hy.service;

import com.project1.hy.dto.MemberDTO;
import com.project1.hy.entity.MemberEntity;
import com.project1.hy.repository.MemberRepository;
import com.project1.hy.utils.ApiResponse;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Commit;

@SpringBootTest
@Log4j2
public class MemberServiceTests {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @Test
    @Commit
    public void testJoin() {
        MemberEntity e = MemberEntity.builder()
                        .memberId("test1")
                        .password("1234")
                        .isAdult(true)
                        .isApproved(true)
                        .build();

        memberRepository.save(e);

    }

    @Test
    public void testLogin() {
        MemberDTO dto = MemberDTO.builder()
                .memberId("test1")
                .password("1234")
                .build();

        ResponseEntity<ApiResponse<MemberDTO>> res = memberService.login(dto);
        ApiResponse<MemberDTO> res2 = res.getBody();
        MemberDTO resDTO = res2.getData();




        log.info("obj >>> {}", resDTO);
    }
}
