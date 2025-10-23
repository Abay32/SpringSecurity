package com.api.spring.security.controllers;

import com.api.spring.security.models.User;
import com.api.spring.security.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    //token generation
    @GetMapping("login")
    public String greet(HttpServletRequest request){
        return "Welcome to Bergen: The rainy city " + request.getSession().getId();
    }

    @PostMapping("loginInfo")
    public String loginInfo(@RequestBody User user){
        return userService.loginVerifier(user);
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers(User user){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("create")
    public User create(@RequestBody User user){

        return  userService.create(user);
    }
}
