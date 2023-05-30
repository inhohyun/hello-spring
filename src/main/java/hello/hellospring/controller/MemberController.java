package hello.hellospring.controller;

import hello.hellospring.demain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    private final MemberService memberService;
    //Autowired->의존관계를 주입시켜줌 -> MemberController가 생성될때 Spring에  등록되어있는 memberService 객체를 가져다 넣어줌
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    //get방식 : url에 직접적으로 타이핑하는 것과 같음
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMembersForm";
    }
    //post : 데이터를 넣어서 전달할때 자주 사용
    //get : 데이터를 조회할 때 자주 사용
    @PostMapping("/members/new")
    public String create(MemberForm form){

        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        //이전 화면으로 전환(안드로이드의 finish()와 비슷한 느낌, 단 어디로 이동할지 정할 수 있는 듯)
        return "redirect:/";
    }
}
