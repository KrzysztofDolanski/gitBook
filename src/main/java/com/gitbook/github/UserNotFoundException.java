package com.gitbook.github;

/**
 * @author Krzysztof Dolański
 */
public class UserNotFoundException extends RuntimeException{

    @Override
    public String getMessage() {
        return "User not found";
    }
}
