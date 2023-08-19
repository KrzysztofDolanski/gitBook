package com.gitbook.request;

import com.gitbook.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RequestInfoRepositoryTest {

    private static final String EXAMPLE_LOGIN = "example login";

    @Autowired
    RequestInfoRepository repository;

    @Autowired
    RequestInfoService service;

    @Autowired
    private UserService userService;

    @BeforeEach
    void setUp() {
        service.deleteAll();
    }

    @Test
    void whenRequestInfoIsWrittenToDB_thenRequestCountIncrements() {
        //given
        //when
        service.saveRequestInfo(EXAMPLE_LOGIN);
        service.saveRequestInfo(EXAMPLE_LOGIN);
        service.saveRequestInfo(EXAMPLE_LOGIN);

        //then
        Long count = service.findOneByREQUEST_COUNTDesc().get(0).getRequestCount();
        assertEquals(count, 3);
    }

    @Test
    void whenRequestToFindUserOccurThenRequestInfoDataWriteToDB() {
        //given
        //when
        userService.getUserResponseByLogin(EXAMPLE_LOGIN);
        userService.getUserResponseByLogin(EXAMPLE_LOGIN);
        //then
        Long requestCount = repository.findAll().stream().reduce((x, y) -> x.getRequestCount() > y.getRequestCount() ? x : y).orElseThrow().getRequestCount();
        assertEquals(requestCount, 2);
    }

}