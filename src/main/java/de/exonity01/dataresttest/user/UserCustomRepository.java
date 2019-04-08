package de.exonity01.dataresttest.user;

import com.querydsl.core.types.QBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCustomRepository {

    public <T> Page<T> findAll(QBean<T> fields, Pageable pageable, UserSearchCriteria searchCriteria);

}
