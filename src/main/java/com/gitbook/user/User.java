package com.gitbook.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public record User(Long id, String login, String name, String type, String avatarUrl, LocalDateTime createdAt,
                   Long calculations) {

}
