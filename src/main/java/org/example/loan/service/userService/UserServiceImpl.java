package org.example.loan.service.userService;

import org.example.loan.entity.User;
import org.example.loan.repository.userRepository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);

    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

}
