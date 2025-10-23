package com.api.spring.security.service;

import com.api.spring.security.models.User;
import com.api.spring.security.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    private final AuthenticationManager authenticationManager;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final JwtService jwtService;

    public User create(User user){
        user.setPassword(
                bCryptPasswordEncoder
                        .encode(user.getPassword())
        );
        return userRepo.save(user);
    }

    public String loginVerifier(User user){

        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(), user.getPassword()
                )
        );

        //var userInfo = userRepo.findByUsername(user.getUsername());
        if (authenticate.isAuthenticated()){
            return jwtService.generateToken(user);
        }
        return "failure";
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
