package kea.sem3.jwtdemo.repositories;

import kea.sem3.jwtdemo.entity.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarRepoTest {

    @Autowired
    CarRepository carRepo;

    @BeforeEach
    void setUp() {
        carRepo.save(new Car("Toyota", "1998", 420));
        carRepo.save(new Car("Audi", "1992", 1000));

    }

    @Test
    public void testCount(){
        assertEquals(2, carRepo.count());
    }
}