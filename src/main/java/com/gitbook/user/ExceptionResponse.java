package com.gitbook.user;

import org.springframework.boot.context.properties.bind.DefaultValue;

/**
 * @author Krzysztof Dolański
 */
public record ExceptionResponse (String login, @DefaultValue("This login is not in use.") String message) implements Response {

}
