package de.exonity01.dataresttest.user;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class UserService {

    private final @NonNull UserRepository userRepository;

    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User create(UserForm userForm) {
        Assert.notNull(userForm, "UserForm must not be null!");

        User user = User.builder()
                .name(userForm.getName())
                .surname(userForm.getSurname())
                .address(userForm.getAddress())
                .build();

        return userRepository.save(user);
    }

}
