package de.exonity01.dataresttest.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCustomRepository {

    public Page<User> findAll(Pageable pageable, UserSearchCriteria searchCriteria);

}
