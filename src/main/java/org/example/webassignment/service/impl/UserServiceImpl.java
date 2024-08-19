package org.example.webassignment.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.webassignment.Entity.User;
import org.example.webassignment.pojo.AuthPojo;
import org.example.webassignment.pojo.UserPojo;
import org.example.webassignment.repo.UserRepo;
import org.example.webassignment.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Override
    public Integer save(UserPojo userPojo) {
        if (userPojo == null) {
            throw new IllegalArgumentException("UserPojo cannot be null");
        }

        User user = new User();
        user.setId(userPojo.getId());
        user.setFirstName(userPojo.getFirstName());
        user.setLastName(userPojo.getLastName());
        user.setUserName(userPojo.getUserName());
        user.setEmail(userPojo.getEmail());
        user.setPassword(userPojo.getPassword());
        user.setAddress(userPojo.getAddress());
        user.setContactNumber(userPojo.getContactNumber());

        user = userRepo.save(user);
        return user.getId();
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        userRepo.deleteById(id);
    }

    @Override
    public Integer getUserIdByUserNameAndPword(AuthPojo authPojo) {
        if (authPojo == null) {
            throw new IllegalArgumentException("AuthPojo cannot be null");
        }

        User user = userRepo.findByUsernameAndPassword(authPojo.getUsername(), authPojo.getPassword());
        return (user != null) ? user.getId() : null;
    }
}
