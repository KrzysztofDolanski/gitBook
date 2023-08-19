package com.gitbook.github;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gitbook.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Component
public class GitConnect {

    @Value("${github.url}")
    private String URL;

    @Value("${github.users}")
    private String USERS;

    public User getUser(String login) {
        List<User> gitUser = getUserData(login);
        ObjectMapper mapper = new ObjectMapper();
//        return mapDataToUser(gitUser, mapper).findFirst().orElseThrow(UserNotFoundException::new);
        return gitUser.get(0);
    }

    private List<User> getUserData(String login) {
        return WebClient.create().get()
                .uri(URL + USERS + "/" + login)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, this::handleErrors)
                .bodyToFlux(User.class)
                .collectList()
                .block();
    }

    private Mono<Throwable> handleErrors(ClientResponse response) {
        return response.bodyToMono(String.class).flatMap(body -> Mono.error(UserNotFoundException::new));
    }

    private static Stream<User> mapDataToUser(Object[] gitUser, ObjectMapper mapper) {
        return Arrays.stream(Objects.requireNonNull(gitUser))
                .map(o -> mapper.convertValue(o, User.class));
    }
}
