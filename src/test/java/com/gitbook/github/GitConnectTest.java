package com.gitbook.github;

import com.gitbook.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GitConnectTest {

    @Autowired
    private GitConnect gitConnect;

    @Test
    void givenLogin_shouldGiveProperUser() {
        //given
        String login = "KrzysztofDolanski";
        //when
        List<User> users = gitConnect.getUsers(login);
        //then
        assertAll(
                () -> assertNotNull(users),
                () -> assertEquals(users.get(0).login(), login)
        );
    }
}