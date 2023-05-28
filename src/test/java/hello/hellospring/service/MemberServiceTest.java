package hello.hellospring.service;

import hello.hellospring.demain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();
    @Test
    void join() {
        //given(무언가가 주어지고)
        Member member = new Member();
        member.setName("hello");
        //when(무언가가 실행될때)
        Long saveId = memberService.join(member);
        //then(결과가 나와야 함)
        Member findMember = memberService.findOne(saveId).get();
        org.assertj.core.api.Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    @Test
    public void 중복_회원_예회(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member1.setName("spring");
        //when
        //이미 있는 이름을 회원가입할 경우
        memberService.join(member1);
        //예외처리
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));



//        try{
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//
//        }

        //then
    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}