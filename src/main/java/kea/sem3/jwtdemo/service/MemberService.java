package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.MemberResponse;
import kea.sem3.jwtdemo.entity.Member;
import kea.sem3.jwtdemo.repositories.MemberRepo;
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
}
