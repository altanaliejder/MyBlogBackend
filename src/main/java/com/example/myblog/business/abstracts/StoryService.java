package com.example.myblog.business.abstracts;

import com.example.myblog.core.utilities.results.DataResult;
import com.example.myblog.core.utilities.results.Result;
import com.example.myblog.entities.concretes.Story;
import com.example.myblog.entities.concretes.Subject;
import com.example.myblog.entities.concretes.User;

import java.util.List;

public interface StoryService  {
    Result add(Story story);
    Result update(Story story);
    Result delete(Story story);
    DataResult<List<Story>> getAll();
    DataResult<Story> getStoryById(Long storyId);
    DataResult<List<Story>> getStoryBySubjectId(Long subjectId);
    DataResult<List<Story>> searchStories(String keyword);
    DataResult<List<Story>> getStoryByUserId(Long userId);

}
