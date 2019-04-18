package de.exonity01.dataresttest.user;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("")
    public Page<User> getAll(Pageable pageable,
                                            Predicate predicate) {

        QBean<UserProjectionTable> projection = Projections.fields(
                UserProjectionTable.class,
                QUser.user.name.concat(" ").concat(QUser.user.surname).as("nameSurname"),
                QUser.user.name,
                QUser.user.surname);

        return userRepository.findAll(predicate, pageable);
    }

}
