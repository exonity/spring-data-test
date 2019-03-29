package de.exonity01.dataresttest.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    final private UserRepository userRepository;

    public Page<User> findAll(Pageable pageable) {
        // Create custom sort for name and surname


        return userRepository.findAll(pageable);
    }
}
