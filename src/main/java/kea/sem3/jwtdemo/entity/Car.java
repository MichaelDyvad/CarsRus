package kea.sem3.jwtdemo.entity;

import kea.sem3.jwtdemo.dto.CarRequest;
import kea.sem3.jwtdemo.dto.CarResponse;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "brand", nullable = false, length = 100)
    private String brand;

    @Column(name = "model", nullable = false, length = 100)
    private String model;

    @Column(name = "priceprday", nullable = false)
    private double pricePrDay;

    @OneToMany(mappedBy = "reservedCar")
    private Set<Reservation> reservations = new HashSet<>();

    public void addReservation(Reservation res){
        reservations.add(res);
    }

    double bestDiscount;

    @CreationTimestamp
    LocalDateTime created;

    @UpdateTimestamp
    LocalDateTime edited;


    public Car(){}

    public Car(String brand, String model, int pricePrDay) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
    }

    public Car(CarRequest body) {
        this.brand = body.getCarBrand();
        this.model = body.getModel();
        this.pricePrDay = body.getPricePrDay();
    }
}
