package org.example.securitymaster.dao;

import org.example.securitymaster.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,Integer> {
    Optional<User> findUserByUsername(String username);
}
