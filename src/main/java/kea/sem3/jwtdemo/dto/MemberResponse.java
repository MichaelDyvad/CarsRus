package kea.sem3.jwtdemo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kea.sem3.jwtdemo.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberResponse {
    @Enumerated(EnumType.STRING)
    String firstName;
    String lastName;
    String street;
    String city;
    int zip;


    public MemberResponse(Member member){
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.street = member.getStreet();
        this.city = member.getCity();
        this.zip = member.getZip();
    }

    public static List<MemberResponse> getMembersFromEntities(List<Member> members) throws Exception{
        return members.stream().map(member -> new MemberResponse(member)).collect(Collectors.toList());
    }
}
