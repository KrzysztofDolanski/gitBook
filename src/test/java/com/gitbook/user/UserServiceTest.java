package com.gitbook.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    void whenLoginExists_thenUserResponse() {
        //given
        String login = "KrzysztofDolanski";

        //when
        var userResponseByLogin = service.getUserResponseByLogin(login);

        //then
        assertTrue(userResponseByLogin instanceof UserResponse);
    }

    @Test
    void whenLoginNotExists_thenExceptionResponse() {
        //given
        String login = UUID.randomUUID().toString();

        //when
        var userResponseByLogin = service.getUserResponseByLogin(login);

        //then
        assertTrue(userResponseByLogin instanceof ExceptionResponse);
    }
}