package hello.hellospring.service;

import hello.hellospring.demain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//아래 어노테이션으로 인해 시스템이 시작할때 spring이 아래 클래스를 Container에 등록시켜줌(static과 비슷한 효과인가?)
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member) {

        validateDuplicateMember(member); // 중복회원 검증
        //매개변수를 repository에 저장
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //같은 이름이 있는 중복 회원x, ctrl alt v : 해당 값을 변수에 저장?
        //ifPresent : result에 null이 아닌 값이 있으면 아래 코드 동작할 것
        //Optional로 감싸져있어서 가능함, null일 가능성이 있는 변수는 Optional로 감싸서 반환해줌
        //아래는 변수 선언 없이 바로 ifPresent로 리팩토링한 코드, interface의 findByName 메소드가 이미 Optional로 감싸져있기 때문에 사용 가능
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    //전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //id값을 활용해 회원 1명 찾기
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
