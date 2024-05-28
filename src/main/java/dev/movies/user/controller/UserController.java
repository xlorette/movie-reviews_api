package dev.movies.user.controller;

import dev.movies.user.entity.User;
import dev.movies.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping(value = "/api/v0/user")
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/signUp")
    public void signUp(@RequestBody User user) {
        log.warn(user.toString());
        userService.signUpUser(user);
    }

    @PostMapping(value = "/login")
    public Long logIn(@RequestBody User user) {
        return userService.logInUser(user);
    }
}
