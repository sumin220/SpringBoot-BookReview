package example.review.domain.service;

import example.review.domain.entity.Member;
import example.review.domain.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원등록() throws Exception {

        //given
        Member member = Member.builder()
                .name("son")
                .build();
        //when
        Long saveId = memberService.join(member);
        //then
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test
    public void 중복회원예외() throws Exception {

        //given
        Member member1 = Member.builder()
                .name("sson")
                .build();

        Member member2 = Member.builder()
                .name("sson")
                .build();

        //when
        memberService.join(member1);

        try {
            memberService.join(member2);
        }catch (IllegalStateException e){
            return;
        }

        //then
        fail("예외가 발생");
    }

}