package com.gitbook.user;

import com.gitbook.request.RequestInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final RequestInfoService requestInfoService;

    @GetMapping("/users/{login}")
    public ResponseEntity<Response> getUserByLogin(@PathVariable("login") String login) {
        requestInfoService.saveRequestInfo(login);
        Response userByLogin = userService.getUserResponseByLogin(login);
        return ResponseEntity.ok(userByLogin);
    }
}
