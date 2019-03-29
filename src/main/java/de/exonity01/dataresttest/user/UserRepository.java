package de.exonity01.dataresttest.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {

    @Query("select concat(u.name,' ',u.surname,' ',u.id) as nameSurnameId, u.name as name, u.surname as surname, u.id as id from User u")
    Page<UserTableProjection2> findAll2(Pageable page);
}
