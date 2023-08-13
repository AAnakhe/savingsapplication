package org.aspacelife.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.aspacelife.model.User;
import org.aspacelife.repository.UserRepository;
import org.aspacelife.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Inject
    UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        try {
            return userRepository.listAll();
        } catch (Exception e) {
            logger.error("Error while getting all users", e);
            return Collections.emptyList();
        }
    }

    @Override
    public User getUserById(Long id) {
        try {
            return userRepository.findById(id);
        } catch (Exception e) {
            logger.error("Error while getting user by ID", e);
            return null;
        }
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        try {
            userRepository.persist(user);
            return user;
        } catch (Exception e) {
            logger.error("Error while saving user", e);
            throw new RuntimeException("Failed to save user", e);
        }
    }

    @Override
    @Transactional
    public User updateUser(Long id, User updateUser) {
        try {
            User user = userRepository.findById(id);
            if (user == null) {
                return null;
            }
            user.setFirstName(updateUser.getFirstName());
            user.setLastName(updateUser.getLastName());
            user.setPhoneNumber(updateUser.getPhoneNumber());
            user.setEmail(updateUser.getEmail());
            user.setPassword(updateUser.getPassword());
            user.setIsActive(updateUser.getIsActive());
            return user;
        } catch (Exception e) {
            logger.error("Error while updating user", e);
            throw new RuntimeException("Failed to update user", e);
        }
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Error while deleting user", e);
            throw new RuntimeException("Failed to delete user", e);
        }
    }
}
