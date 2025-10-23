package com.api.spring.security.service;


import com.api.spring.security.CustomUserDetails;
import com.api.spring.security.models.User;
import com.api.spring.security.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CustomUserDetailService implements UserDetailsService {


    private final UserRepo repo;

    public CustomUserDetailService(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  repo.findByUsername(username);

        if (user == null){
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User not found");
        }

        System.out.println("✅ Found user: " + user.getUsername());
        System.out.println("🔑 Stored (encoded) password: " + user.getPassword());
        return new CustomUserDetails(user);

    }
}
