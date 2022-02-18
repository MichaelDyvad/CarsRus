package kea.sem3.jwtdemo.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @CreationTimestamp
    LocalDateTime reservationDate;

    LocalDate rentalDate;

    @ManyToOne
    Car reservedCar;

    //Laver en relation mellem reservation og member. Fortæller at der er mange reservationer til 1 member
    @ManyToOne
    Member reservedTo;

    public Reservation(LocalDate rentalDate, Car reservedCar, Member reservedTo) {
        this.rentalDate = rentalDate;
        this.reservedCar = reservedCar;
        this.reservedTo = reservedTo;
    }

    public Reservation(){}
}
