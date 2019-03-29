package de.exonity01.dataresttest.user;


import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequestMapping("/user")
public class UserController {

    @PersistenceContext
    private EntityManager entityManager;

    private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity getAll(Pageable pageable) {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QUser qUser = QUser.user;
        StringExpression exp = qUser.name.concat(" ").concat(qUser.surname);
        JPAQuery<UserTableProjection> jpaQuery = jpaQueryFactory.select(Projections.fields(UserTableProjection.class,exp.as("nameSurnameId"))).from(qUser).orderBy(exp.asc());
        return ResponseEntity.ok(jpaQuery.fetch());
    }

}
