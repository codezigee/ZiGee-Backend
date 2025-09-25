package academy.zigee.controller;

import academy.zigee.domain.Member;
import academy.zigee.repository.MemberDaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MemberController {

    private MemberDaoService service ;


    // MemberController 생성자 역시 Spring Context가 호출 <- 생성함에 있어서 그 전에 주입된 MemberDaoService 인스턴스 값을 가지고 오겠다
    public MemberController(MemberDaoService service) {
        this.service = service;
    }

    @GetMapping("/members")
    public List<Member> retrieveAllMembers() {
        return service.findAll();
    }

    @GetMapping("/members/{id}")
    public Member retrieveMember(@PathVariable int id){
        return service.findOne(id);
    }
}
