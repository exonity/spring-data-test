package de.exonity01.dataresttest.user;


import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private EntityManager entityManager;
    @Autowired
    private  UserService userService;
    @Autowired
    private UserRepository userRepository;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/old")
    public ResponseEntity getAll(Pageable pageable) {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QUser qUser = QUser.user;
        StringExpression exp = qUser.name.concat(" ").concat(qUser.surname);
        JPAQuery<UserTableProjection> jpaQuery = jpaQueryFactory.select(Projections.fields(UserTableProjection.class, exp.as("nameSurnameId"))).from(qUser).orderBy(exp.asc());
        return ResponseEntity.ok(jpaQuery.fetch());
    }

    @GetMapping("")
    public Page<UserTableProjection2> getAll2(Pageable pageable) {
        return userRepository.findAll2(pageable);
    }

}
