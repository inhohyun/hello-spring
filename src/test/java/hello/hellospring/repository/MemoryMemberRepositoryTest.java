package hello.hellospring.repository;

import hello.hellospring.demain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {
    //Test : 앞서 개발한 내용이 정상적으로 작동하는지 확인하는 공간
    MemoryMemberRepository repository = new MemoryMemberRepository();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    //각 메소드가 끝날때마다 동작하는 메소드
    @AfterEach
    public void afterEach(){
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        Assertions.assertEquals(member, result);


    }



}
