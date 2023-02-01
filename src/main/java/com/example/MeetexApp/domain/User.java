package com.example.MeetexApp.domain;

import jakarta.persistence.*;
import lombok.Data;

import org.springframework.lang.Nullable;


import javax.validation.constraints.Pattern;
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
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,100}$")
    private String password;

    @ManyToMany(cascade = {CascadeType.ALL})
    @Nullable
    private List<User> friends;

    private int friendsCount;
    private int msgCount;
    private int notCount;

    @Column
    private String matchingPassword;

    @Column
    private String role;

    @Column
    private boolean logged;

}
