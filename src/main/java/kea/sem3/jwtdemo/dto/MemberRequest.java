package kea.sem3.jwtdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequest {
    @Enumerated(EnumType.STRING)
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private int zip;

    @CreationTimestamp
    LocalDateTime created;

    @UpdateTimestamp
    LocalDateTime edited;
}
