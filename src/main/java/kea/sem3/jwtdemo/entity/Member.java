package kea.sem3.jwtdemo.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MEMBER")
public class Member extends BaseUser {

    @Column(name = "firstname", length = 40)
    String firstName;


    public Member(String username, String email, String password, String firstName) {
        super(username, email, password);
        this.firstName = firstName;
    }

    private String lastName;

    private String street;

    private String city;

    private int zip;

    private boolean approved;

    private int ranking;

    public Member(){}
}
