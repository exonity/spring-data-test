package de.exonity01.dataresttest.user;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final EntityManager entityManager;

    private final UserService userService;

    private final UserRepository userRepository;

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


///////////////////////////////////////

    @GetMapping("/new")
    public ResponseEntity getAll(UserSearchCriteria criteria, Pageable pageable) {
        // QueryFactory
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);

        // Query
        QUser qUser = QUser.user;
        StringExpression exp = qUser.name.concat(" ").concat(qUser.surname);
        JPAQuery<UserTableProjection> query = jpaQueryFactory
                .select(Projections.fields(UserTableProjection.class, exp.as("nameSurname")))
                .from(qUser);

        // Offset and limit
        query.offset(pageable.getOffset());
        query.limit(pageable.getPageSize());

        // Filter

        // Order
        convertSortToOrderSpecifier(pageable.getSort());
        query.orderBy(convertSortToOrderSpecifier(pageable.getSort()));

        // Build page
        long rowsCount = query.fetchCount();
        Page page = new PageImpl<>(query.fetch(), pageable, rowsCount);

        // Serve
        return ResponseEntity.ok(page);
    }

    private OrderSpecifier[] convertSortToOrderSpecifier(Sort sort) {
        List<OrderSpecifier> orderSpecifierList = new ArrayList<>();
        for (Sort.Order order : sort) {
            OrderSpecifier orderSpecifier = convertOrderToOrderSpecifier(order);
            if (orderSpecifier != null) {
                orderSpecifierList.add(orderSpecifier);
            }
        }
        return orderSpecifierList.toArray(new OrderSpecifier[orderSpecifierList.size()]);
    }

    private OrderSpecifier convertOrderToOrderSpecifier(Sort.Order order) {
        QUser qUser = QUser.user;
        if ("name".equals(order.getProperty())) {
            return order.isAscending() ? qUser.name.asc() : qUser.name.desc();
        } else if ("surname".equals(order.getProperty())) {
            return order.isAscending() ? qUser.surname.asc() : qUser.surname.desc();
        } else if ("nameSurname".equals(order.getProperty())) {
            StringExpression exp = qUser.name.concat(" ").concat(qUser.surname);
            return order.isAscending() ? exp.asc() : exp.desc();
        }
        return null;
    }


}
