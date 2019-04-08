package de.exonity01.dataresttest.user;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;
import com.querydsl.core.types.dsl.StringExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Page<?> findAll(Pageable pageable, UserSearchCriteria searchCriteria, String projectionName) {
        QUser qUser = QUser.user;

        if ("table".equals(projectionName)) {
            StringExpression nameSurnameConcatenation = qUser.name.concat(" ").concat(qUser.surname);
            QBean<UserProjectionTable> projection = Projections.fields(
                    UserProjectionTable.class,
                    nameSurnameConcatenation.as("nameSurname"),
                    qUser.name,
                    qUser.surname);
            return userRepository.findAll(projection, pageable, searchCriteria);
        }
        else if ("id".equals(projectionName)) {
            QBean<UserProjectionId> projection = Projections.fields(
                    UserProjectionId.class,
                    qUser.id);
            return userRepository.findAll(projection, pageable, searchCriteria);
        }

        return userRepository.findAll(null, pageable, searchCriteria);

    }

}
