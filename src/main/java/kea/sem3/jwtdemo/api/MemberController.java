package kea.sem3.jwtdemo.api;

import kea.sem3.jwtdemo.dto.CarResponse;
import kea.sem3.jwtdemo.dto.MemberRequest;
import kea.sem3.jwtdemo.dto.MemberResponse;
import kea.sem3.jwtdemo.service.MemberService;
import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/members")
public class MemberController {
    MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    //Man skal være user for få adgang til dette endpoint er i tvivl om det virker
    @Role(1)
    @GetMapping()
    public List<MemberResponse> getMembers() throws Exception {
        return memberService.getMembers();
    }

    @GetMapping("/{id}")
    public MemberResponse getMember(@PathVariable String username) throws Exception {
        return memberService.getMemberByUserName(username);
    }

    @PostMapping
    public MemberResponse addMember(@RequestBody MemberRequest body){
        return memberService.addMember(body);
    }

    @PutMapping("/{id}")
    public void editMember(@RequestBody MemberRequest body, @PathVariable String id){
        memberService.editMember(body, id);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable String id){
        memberService.deleteMeber(id);
    }


}
