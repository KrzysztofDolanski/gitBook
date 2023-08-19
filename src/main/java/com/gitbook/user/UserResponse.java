package com.gitbook.user;

import lombok.Builder;

import java.time.LocalDateTime;

/**
 * @author Krzysztof Dolański
 */
public record UserResponse (Long id, String login, String name, String type, String avatarUrl,
                            LocalDateTime createdAt, Long calculations) implements Response {
}
