package com.gitbook.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users/{login}")
    public ResponseEntity<User> getUserByLogin(@PathVariable("login") String login) {

    }
}
