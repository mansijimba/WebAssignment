package org.example.webassignment.service;

import org.example.webassignment.Entity.User;
import org.example.webassignment.pojo.AuthPojo;
import org.example.webassignment.pojo.UserPojo;

import java.util.List;

public interface UserService {
    List<User> findAll();

    Integer save(UserPojo userPojo);

    User findById(Integer id);

    void deleteById(Integer id);

    Integer getUserIdByUserNameAndPword(AuthPojo authPojo);
}
