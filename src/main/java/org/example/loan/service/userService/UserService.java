package org.example.loan.service.userService;

import org.example.loan.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User findUserById(Long id);

    List<User> findAllUsers();
}
