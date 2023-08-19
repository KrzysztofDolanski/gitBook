package com.gitbook.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record User(Long id, String login, String name, String type, @JsonProperty("avatar_url") String avatarUrl,
                   @JsonProperty("created_at") LocalDateTime createdAt, @JsonProperty("public_repos") Long publicRepos,
                   Long followers, Long calculations) {

}
