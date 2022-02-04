package kea.sem3.jwtdemo.repositories;

import kea.sem3.jwtdemo.entity.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepoTest {

    @Autowired
    MemberRepo memberRepo;

    @BeforeEach
    void setUp() {
        memberRepo.save(new Member("xxx", "xxx@a.dk", "xxx", "peter"));
        memberRepo.save(new Member("zzz", "zzz@a.dk", "xxx", "Zone"));

    }

    @Test
    public void testCount(){
        assertEquals(2, memberRepo.count());
    }
}