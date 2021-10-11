package com.example.myblog.dataAccess.abstracts;

import com.example.myblog.entities.concretes.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectDao extends JpaRepository<Subject,Long> {
    Subject getById(Long id);
    Subject getByName(String name);
}
