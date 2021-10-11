package com.example.myblog.business.abstracts;

import com.example.myblog.core.utilities.results.DataResult;
import com.example.myblog.core.utilities.results.Result;
import com.example.myblog.entities.concretes.Story;
import com.example.myblog.entities.concretes.Subject;

import java.util.List;

public interface SubjectService {
    Result add(Subject subject);
    Result update(Subject subject);
    Result delete(Subject subject);
    DataResult<List<Subject>> getAll();
    DataResult<Subject> getStoryById(Long subjectId);
    Result addSubjectToStory(Long storyId,String subjectName);

}
