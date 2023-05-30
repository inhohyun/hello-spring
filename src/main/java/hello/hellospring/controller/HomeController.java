package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //"/" : localhost:8080으로 호출하면 아래 api가 호출됨
    //요청이 들어오면 스프링 컨테이너에서 관련 controller가 있는지 찾고, 없으면 static 파일을 찾음
    //따라서 아래 "/"을 매핑해놓음으로써 바로 localhost:8080/home으로 넘어가게 되는 것임
    @GetMapping("/")
    public String home(){
        return "home";
    }



}
