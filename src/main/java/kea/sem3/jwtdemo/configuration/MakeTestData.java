package kea.sem3.jwtdemo.configuration;

import kea.sem3.jwtdemo.entity.*;
import kea.sem3.jwtdemo.repositories.CarRepository;
import kea.sem3.jwtdemo.repositories.MemberRepo;
import kea.sem3.jwtdemo.repositories.ReservationRepo;
import kea.sem3.jwtdemo.security.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Controller
@Profile("!test")
public class MakeTestData implements ApplicationRunner {


    UserRepository userRepository;
    MemberRepo memberRepo;
    CarRepository carRepo;
    ReservationRepo reservationRepo;

    public MakeTestData(UserRepository userRepository, MemberRepo memberRepo, CarRepository carRepo, ReservationRepo reservationRepo) {
        this.userRepository = userRepository;
        this.memberRepo = memberRepo;
        this.carRepo = carRepo;
        this.reservationRepo = reservationRepo;
    }

    public  void makePlainUsers(){
        BaseUser user = new BaseUser("user", "user@a.dk", "test12");
        user.addRole(Role.USER);
        BaseUser admin = new BaseUser("admin", "admin@a.dk", "test12");
        admin.addRole(Role.ADMIN);

        BaseUser both = new BaseUser("user_admin", "both@a.dk", "test12");
        both.addRole(Role.USER);
        both.addRole(Role.ADMIN);

        userRepository.save(user);
        userRepository.save(admin);
        userRepository.save(both);

        Member m1 = new Member("xxx", "m@m.dk", "test212", "Kurt");
        m1.addRole(Role.USER);
        userRepository.save(m1);


        Car car1 = new Car("Toyota1", "1993", 421);
        Car car2 = new Car("Audi", "2003", 500);
        carRepo.save(car1);
        carRepo.save(car2);

        //Create a reservation
        Reservation res1 = new Reservation(LocalDate.of(2022, 3, 1), car1, m1);
        reservationRepo.save(res1);

        System.out.println("########################################################################################");
        System.out.println("########################################################################################");
        System.out.println("#################################### WARNING ! #########################################");
        System.out.println("## This part breaks a fundamental security rule -> NEVER ship code with default users ##");
        System.out.println("########################################################################################");
        System.out.println("########################  REMOVE BEFORE DEPLOYMENT  ####################################");
        System.out.println("########################################################################################");
        System.out.println("########################################################################################");
        System.out.println("Created TEST Users");

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        userRepository.deleteAll();

        makePlainUsers();


    }
}
