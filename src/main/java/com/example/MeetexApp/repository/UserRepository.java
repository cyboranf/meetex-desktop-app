package com.example.MeetexApp.repository;

import com.example.MeetexApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user WHERE email = :eMail", nativeQuery = true)
    List<User> findByEmail(@Param("eMail") String eMail);

    @Query(value = "SELECT * FROM user WHERE logged = true ", nativeQuery = true)
    List<User> findByLogged();

    @Query(value = "SELECT * FROM user WHERE first_name = :name", nativeQuery = true)
    List<User> findByFirstName(@Param("name") String name);

    Optional<User> findById(Long id);
}

