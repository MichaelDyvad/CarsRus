package kea.sem3.jwtdemo.entity;

import kea.sem3.jwtdemo.dto.MemberRequest;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@DiscriminatorValue("MEMBER")
public class Member extends BaseUser {

    @Column(name = "firstname", length = 40)
    String firstName;


    @CreationTimestamp
    LocalDateTime created;

    @UpdateTimestamp
    LocalDateTime edited;

    @OneToMany(mappedBy = "reservedTo")
    private Set<Reservation> reservations = new HashSet<>();

    public void addReservation(Reservation res){
        reservations.add(res);
    }

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

    public Member(MemberRequest body){
        this.firstName = body.getFirstName();
        this.lastName = body.getLastName();
        this.street = body.getStreet();
        this.city = body.getCity();
        this.zip = body.getZip();
        this.created = body.getCreated();
        this.edited = body.getEdited();
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
