package com.example.MeetexApp.domain;

import jakarta.persistence.*;
import lombok.Data;

import org.springframework.lang.Nullable;


import java.util.List;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60, unique = true)
    private String email;

    @Column(length = 60)
    private String firstName;

    @Column(length = 60)
    private String lastName;

    @Column(length = 100)
    private String password;

    @OneToMany
    @Nullable
    private List<User> friends;

    @Column
    private String matchingPassword;

}
