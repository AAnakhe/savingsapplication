package org.aspacelife.service;

import org.aspacelife.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserById(Long id);
    User saveUser(User user);
    User updateUser(Long id, User updateUser);
    void deleteUser(Long id);
}
