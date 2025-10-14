package academy.zigee.controller;

import academy.zigee.domain.Member;
import academy.zigee.exception.MemberNotFoundException;
import academy.zigee.repository.MemberDaoService;
import io.jsonwebtoken.security.RsaPrivateJwk;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MemberController {

    private MemberDaoService service ;

    public MemberController(MemberDaoService service) {
        this.service = service;
    }

    @PostMapping("/members")
    public ResponseEntity<Member> createUser(@RequestBody Member member) {
        Member savedMember = service.save(member);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedMember.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/members")
    public List<Member> retrieveAllMembers() {
        return service.findAll();
    }

    @GetMapping("/members/{id}")
    public Member retrieveMember(@PathVariable int id){
        Member member = service.findOne(id);

        if (member == null) {
            throw new MemberNotFoundException(String.format("ID[%s not found", id ));
        }

        return member;
    }

    @DeleteMapping("/members/{id}")
    public void deleteMember(@PathVariable int id){
        Member member = service.deleteById(id);

        if (member == null){
            throw new MemberNotFoundException(String.format("ID[%s not found", id ));
        }
    }



}
