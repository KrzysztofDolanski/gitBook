package com.gitbook.user;

import com.gitbook.github.GitConnect;
import com.gitbook.github.UserNotFoundException;
import com.gitbook.request.RequestInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Krzysztof Dolański
 */
@Service
@AllArgsConstructor
public class UserService {

    private final RequestInfoService requestInfoService;
    private final GitConnect gitConnect;

    public Response getUserResponseByLogin(String login) {
        saveUserInRequestInfo(login);
        List<User> users = gitConnect.getUsers(login);
        if (users != null) {
            User user = gitConnect.getUsers(login).stream().findFirst().orElseThrow(UserNotFoundException::new);
            return userToUserResponseMapper(user);
        }

        return new ExceptionResponse(login, String.format("Login %s is not in use", login));
    }

    private UserResponse userToUserResponseMapper(User user) {
        Long calculations = calculate(user);
        return new UserResponse(user.id(), user.login(), user.name(), user.type(), user.avatarUrl(), user.createdAt(), calculations);
    }

    private long calculate(User user) {
        long followers = user.followers() != null ? user.followers() : 0;
        long publicRepos = user.publicRepos() != null ? user.publicRepos() : 0;

        return followers == 0 ? 0 : 6 / followers * (2 + publicRepos);
    }

    private void saveUserInRequestInfo(String login) {
        requestInfoService.saveRequestInfo(login);
    }

}
