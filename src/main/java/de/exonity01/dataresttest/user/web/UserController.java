package de.exonity01.dataresttest.user.web;

import de.exonity01.dataresttest.user.User;
import de.exonity01.dataresttest.user.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final @NonNull UserService userService;

    @GetMapping("")
    public Page<User> getAll(Pageable pageable) {
        return userService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") User user) {
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }

    @PostMapping("/{id}/profile-image")
    public ResponseEntity<User> findById(@PathVariable("id") User user,
                                         @RequestParam("fileId") Long fileId) {
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        userService.updateProfileImage(user, fileId);
        return ResponseEntity.ok(user);
    }

}
