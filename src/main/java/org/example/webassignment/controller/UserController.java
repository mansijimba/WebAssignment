package org.example.webassignment.controller;

import lombok.RequiredArgsConstructor;
import org.example.webassignment.Entity.User;
import org.example.webassignment.pojo.AuthPojo;
import org.example.webassignment.pojo.GlobalApiResponse;
import org.example.webassignment.pojo.UserPojo;
import org.example.webassignment.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> findAll() {
        return this.userService.findAll();
    }
    @PostMapping("/register")
    public GlobalApiResponse<Integer> registerUser(@RequestBody UserPojo userPojo) {
        GlobalApiResponse<Integer> globalAPIResponse = new GlobalApiResponse<>();
        Integer userId = userService.save(userPojo);
        globalAPIResponse.setData(userId);
        globalAPIResponse.setStatus(String.valueOf(200));
        globalAPIResponse.setMessage("User registered successfully");
        return globalAPIResponse;
    }

    @PostMapping
    public GlobalApiResponse<Integer> save(@RequestBody UserPojo userPojo) {
        GlobalApiResponse<Integer> globalAPIResponse = new GlobalApiResponse<>();
        Integer userId = userService.save(userPojo);
        globalAPIResponse.setData(userId);
        globalAPIResponse.setStatus(String.valueOf(200));
        globalAPIResponse.setMessage("Data saved successfully");
        return globalAPIResponse;
    }

    @PutMapping
    public void update(@RequestBody UserPojo userPojo) {
        userService.save(userPojo);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @GetMapping("{id}")
    public User findById(@PathVariable Integer id) {
        return this.userService.findById(id);
    }

    @PostMapping("/login")
    public Integer getUserIdByUserNameAndPword(@RequestBody AuthPojo authPojo) {
        return userService.getUserIdByUserNameAndPword(authPojo);
    }
}
