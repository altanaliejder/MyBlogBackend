package com.example.myblog.dataAccess.abstracts;

import com.example.myblog.core.utilities.results.DataResult;
import com.example.myblog.entities.concretes.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleDao extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
