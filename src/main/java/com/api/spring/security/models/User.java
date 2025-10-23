package com.api.spring.security.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
@Entity
public class User {
    @Id
    private int id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "StudentController{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password=" + password +
                '}';
    }

}
