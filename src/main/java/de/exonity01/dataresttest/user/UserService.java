package de.exonity01.dataresttest.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Page<User> findAll(Pageable pageable, UserSearchCriteria searchCriteria) {
        return userRepository.findAll(pageable, searchCriteria);
    }

}
