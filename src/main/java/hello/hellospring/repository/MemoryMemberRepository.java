package hello.hellospring.repository;


import hello.hellospring.demain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//정형화된 포지션
//Controller에서 데이터를 받음
//Service에서 비즈니스 로직을 만듦
//Repository에서 데이터를 저장함

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    //key값 자동 생성
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
      member.setId(++sequence);
      store.put(member.getId(), member);

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //nullable이 가능하도록
        return Optional.ofNullable(store.get(id));
    }

    //아래는 자바 문법 좀 더 공부하기, store에서 name과 같은 내용을 찾고 없으면 null로 리턴되는 코드
    @Override
    public Optional<Member> findByName(String name) {
        return  store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        //store에 있는 member들을 전부 반환
        return new ArrayList<>(store.values());
    }
}
