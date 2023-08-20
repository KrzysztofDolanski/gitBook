package com.gitbook.github;

import com.gitbook.request.RequestInfoService;
import com.gitbook.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@Component
public class GitConnect {

    @Value("${github.url}")
    private String URL;

    @Value("${github.users}")
    private String USERS;

    private static final Logger logger = LoggerFactory.getLogger(RequestInfoService.class);

    public List<User> getUsers(String login) {
        return getUserData(login);
    }


    private final RestTemplate restTemplate = new RestTemplate();

    private List<User> getUserData(String login) {
        try {
            return List.of(Objects.requireNonNull(restTemplate.getForEntity(URL + USERS + "/" + login, User.class)
                    .getBody()));
        } catch (Exception e) {
            if (e instanceof HttpServerErrorException serverEx) {
                logger.error("User with login {} not found cause of {}", login, serverEx.getMessage());
            } else if (e instanceof HttpClientErrorException clientEx) {
                logger.error("User with login {} not found cause of {}", login, clientEx.getMessage());
            } else {
                logger.error("User with login {} not found cause of {}", login, e.getMessage());
            }
            return null;
        }
    }

    private Mono<Throwable> handleErrors(ClientResponse response) {
        return response.bodyToMono(String.class).flatMap(body -> Mono.error(UserNotFoundException::new));
    }

}
