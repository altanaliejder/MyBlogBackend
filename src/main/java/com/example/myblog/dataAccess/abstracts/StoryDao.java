package com.example.myblog.dataAccess.abstracts;

import com.example.myblog.entities.concretes.Story;
import com.example.myblog.entities.concretes.Subject;
import com.example.myblog.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoryDao extends JpaRepository<Story,Long> {
    Story getById(Long id);
    Story getByTitle(String title);
    List<Story> getStoryBySubjectId(Long subjectId);
    List<Story> getStoryByUser(User user);

}
