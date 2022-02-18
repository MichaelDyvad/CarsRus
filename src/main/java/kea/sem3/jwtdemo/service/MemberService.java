package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.MemberRequest;
import kea.sem3.jwtdemo.dto.MemberResponse;
import kea.sem3.jwtdemo.entity.Member;
import kea.sem3.jwtdemo.entity.Role;
import kea.sem3.jwtdemo.error.Client4xxException;
import kea.sem3.jwtdemo.repositories.MemberRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    MemberRepo memberRepo;

    public MemberService(MemberRepo memberRepo){
        this.memberRepo = memberRepo;
    }

    public List<MemberResponse> getMembers()throws Exception{
        List<Member> members = memberRepo.findAll();
        return MemberResponse.getMembersFromEntities(members);
    }

    public MemberResponse getMemberByUserName(String username) {
        Member member = memberRepo.findById(username).orElseThrow(() -> new Client4xxException("User not found", HttpStatus.NOT_FOUND));
        return new MemberResponse(member);
    }

    public MemberResponse addMember(MemberRequest body) {

        if (memberRepo.existsById((body.getUsername()))) {
            throw new Client4xxException("Provided user name is taken");
        }
        if (memberRepo.existsById(body.getEmail())) {
            throw new Client4xxException("Provided email is taken");
        }
        Member member = new Member(body);
        member.addRole(Role.USER);
        member = memberRepo.save(member);
        return new MemberResponse(member.getUsername(), member.getCreated(), member.getRoles());
    }

}
