package kea.sem3.jwtdemo.repositories;

import kea.sem3.jwtdemo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepo extender også CRUDREPO
public interface MemberRepo extends  JpaRepository<Member, String> {



}
