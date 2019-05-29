package de.exonity01.dataresttest.user.web;

import de.exonity01.dataresttest.user.Address;
import de.exonity01.dataresttest.user.User;
import de.exonity01.dataresttest.user.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final @NonNull UserService userService;

    @PostMapping("")
    public ResponseEntity<User> register(@RequestBody @Valid UserForm userForm) {
        Address address = Address.builder()
                .street(userForm.getAddress().getStreet())
                .houseNumber(userForm.getAddress().getHouseNumber())
                .build();

        User user = User.builder()
                .name(userForm.getName())
                .surname(userForm.getSurname())
                .address(address)
                .build();

        return ResponseEntity.ok(userService.create(user));
    }

    @GetMapping("")
    public Page<User> getAll(Pageable pageable) {
        return userService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") long id) {
        User user = userService.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/{id}/deactivate")
    public ResponseEntity<User> deactivateById(@PathVariable("id") long id) {
        User user = userService.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user.deactivate());
    }

}
