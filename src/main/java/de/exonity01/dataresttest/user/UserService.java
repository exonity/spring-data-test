package de.exonity01.dataresttest.user;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final EntityManager entityManager;

    private final UserRepository userRepository;

    public Page<User> findAll(Pageable pageable, UserSearchCriteria searchCriteria) {
        // QueryFactory
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);

        // Query
        QUser qUser = QUser.user;
        StringExpression exp = qUser.name.concat(" ").concat(qUser.surname);
        JPAQuery<UserTableProjection> query = jpaQueryFactory
                .select(Projections.fields(
                        UserTableProjection.class,
                        exp.as("nameSurname"),
                        qUser.name,
                        qUser.surname))
                .from(qUser);

        // Offset and limit
        query.offset(pageable.getOffset());
        query.limit(pageable.getPageSize());

        // Filter
        query.where(convertCriteriaToPredicate(searchCriteria));

        // Order
        query.orderBy(convertSortToOrderSpecifier(pageable.getSort()));

        // Build page
        long rowsCount = query.fetchCount();
        Page page = new PageImpl<>(query.fetch(), pageable, rowsCount);

        return page;
    }

    private Predicate convertCriteriaToPredicate(UserSearchCriteria searchCriteria) {
        QUser qUser = QUser.user;
        BooleanBuilder builder = new BooleanBuilder();
        searchCriteria.getName().ifPresent(value -> builder.and(qUser.name.contains(value)));
        searchCriteria.getSurname().ifPresent(value -> builder.and(qUser.surname.contains(value)));
        StringExpression exp = qUser.name.concat(" ").concat(qUser.surname);
        searchCriteria.getNameSurname().ifPresent(value -> builder.and(exp.contains(value)));
        return builder.getValue();
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
