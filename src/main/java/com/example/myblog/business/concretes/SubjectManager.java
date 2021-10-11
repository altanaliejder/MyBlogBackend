package com.example.myblog.business.concretes;

import com.example.myblog.business.abstracts.SubjectService;
import com.example.myblog.core.utilities.results.DataResult;
import com.example.myblog.core.utilities.results.Result;
import com.example.myblog.core.utilities.results.SuccessDataResult;
import com.example.myblog.core.utilities.results.SuccessResult;
import com.example.myblog.dataAccess.abstracts.StoryDao;
import com.example.myblog.dataAccess.abstracts.SubjectDao;
import com.example.myblog.entities.concretes.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service @Transactional
public class SubjectManager implements SubjectService {

    private final SubjectDao subjectDao;
    private final StoryDao storyDao;

    @Autowired
    public SubjectManager(SubjectDao subjectDao, StoryDao storyDao) {
        super();
        this.subjectDao = subjectDao;
        this.storyDao = storyDao;
    }

    @Override
    public Result add(Subject subject) {
        this.subjectDao.save(subject);
        return new SuccessResult("Başarıyla Eklendi");
    }

    @Override
    public Result update(Subject subject) {
        this.subjectDao.save(subject);
        return new SuccessResult("Başarıyla Güncellendi");
    }

    @Override
    public Result delete(Subject subject) {
        this.subjectDao.delete(subject);
        return new SuccessResult("Başarıyla Silnidi");
    }

    @Override
    public DataResult<List<Subject>> getAll() {
        return new SuccessDataResult<List<Subject>>(this.subjectDao.findAll());
    }

    @Override
    public DataResult<Subject> getStoryById(Long subjectId) {
        return new SuccessDataResult<Subject>(this.subjectDao.getById(subjectId));
    }

    @Override
    public Result addSubjectToStory(Long storyId, String subjectName) {
        var story=this.storyDao.getById(storyId);
        var subject=this.subjectDao.getByName(subjectName);
        story.setSubject(subject);
        subject.getStories().add(story);
        //this.subjectDao.save(subject);
        return new SuccessResult("Eklendi");
    }
}
