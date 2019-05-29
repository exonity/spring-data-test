package de.exonity01.dataresttest.user;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class UserManagement {

    private final @NonNull UserRepository userRepository;

    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User create(User user) {
        Assert.notNull(user, "UserForm must not be null!");

        return userRepository.save(user);
    }

    public User deacativateById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        return user.deactivate();
    }

}
