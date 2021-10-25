package com.example.myblog.dataAccess.abstracts;

import com.example.myblog.entities.concretes.Story;
import com.example.myblog.entities.concretes.Subject;
import com.example.myblog.entities.concretes.User;
import com.example.myblog.entities.dtos.StoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoryDao extends JpaRepository<Story,Long> {
    Story getById(Long id);
    Story getByTitle(String title);
    List<Story> getStoryBySubjectId(Long subjectId);
    List<Story> getStoryByUser(User user);
    @Query("SELECT s from Story s where concat(s.title,' ',s.story,' ',s.subject.name, ' ',s.user.username) like %?1%")
    List<Story> searchStories(String keyword);
    List<Story> getStoriesByUserId(Long userId);


}
