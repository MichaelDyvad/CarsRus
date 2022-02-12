package kea.sem3.jwtdemo.api;

import kea.sem3.jwtdemo.dto.MemberResponse;
import kea.sem3.jwtdemo.service.MemberService;
import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
