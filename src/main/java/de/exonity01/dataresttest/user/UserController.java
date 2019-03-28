package de.exonity01.dataresttest.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{userId}/enable")
    public ResponseEntity enable(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.enable(userId, true));
    }

    @PostMapping("/{userId}/disable")
    public ResponseEntity disable(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.enable(userId, false));
    }

}
