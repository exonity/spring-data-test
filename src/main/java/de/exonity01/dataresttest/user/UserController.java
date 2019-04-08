package de.exonity01.dataresttest.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public Page<UserProjectionTable> getAll(Pageable pageable,
                             UserSearchCriteria searchCriteria) {
        return userService.findAll(pageable, searchCriteria);
    }

}
