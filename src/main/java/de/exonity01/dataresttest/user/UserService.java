package de.exonity01.dataresttest.user;

import de.exonity01.dataresttest.file.File;
import de.exonity01.dataresttest.file.FileService;
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

    private final @NonNull FileService fileService;

    private final @NonNull UserRepository userRepository;

    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public void updateProfileImage(User user, Long fileId) {
        Assert.notNull(user, "User must not be null!");
        Assert.notNull(fileId, "FileId must not be null!");

        File file = fileService.findById(fileId).orElseThrow(() -> new IllegalStateException("Could not find file."));

        user.setProfileImage(file);
    }

}
