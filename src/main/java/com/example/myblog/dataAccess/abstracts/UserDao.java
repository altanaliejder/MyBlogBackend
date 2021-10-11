package com.example.myblog.dataAccess.abstracts;

import com.example.myblog.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
    User getByEmail(String email);

    User findByUsername(String username);
}
