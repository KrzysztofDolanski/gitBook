package com.gitbook.github;

import com.gitbook.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class GitConnectTest {

    @Autowired
    private GitConnect gitConnect;

    @Test
    void givenLogin_shouldGiveProperUser() {
        //given
        String login = "KrzysztofDolanski";
        //when
        User user = gitConnect.getUser(login);
        //then
        assertTrue(user.name().equals(login));
    }
}