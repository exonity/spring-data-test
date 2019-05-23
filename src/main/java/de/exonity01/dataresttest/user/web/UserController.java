package de.exonity01.dataresttest.user.web;

import de.exonity01.dataresttest.user.User;
import de.exonity01.dataresttest.user.UserForm;
import de.exonity01.dataresttest.user.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final @NonNull UserService userService;

    @PostMapping("")
    public User register(UserForm userForm, BindingResult binding) {
        userForm.validate(binding);

        return userService.create(userForm);
    }

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

}
