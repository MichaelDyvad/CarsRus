package kea.sem3.jwtdemo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@DiscriminatorValue("MEMBER")
public class Member extends BaseUser {

    @Column(name = "firstname", length = 40)
    String firstName;


    public Member(String username, String email, String password, String firstName) {
        super(username, email, password);
        this.firstName = firstName;
    }

    public Member(String username, String email, String password, String firstName, String lastName, String street, String city, int zip, boolean approved, int ranking) {
        super(username, email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.approved = approved;
        this.ranking = ranking;
    }

    @Column(length = 40)
    private String lastName;

    @Column(length = 40)
    private String street;

    @Column(length = 50)
    private String city;

    @Column
    private int zip;

    @Column
    private boolean approved;

    @Column
    private int ranking;

    public Member(){}
}
