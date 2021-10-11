package com.example.myblog.business.concretes;

import com.example.myblog.business.abstracts.StoryService;
import com.example.myblog.core.utilities.results.DataResult;
import com.example.myblog.core.utilities.results.Result;
import com.example.myblog.core.utilities.results.SuccessDataResult;
import com.example.myblog.core.utilities.results.SuccessResult;
import com.example.myblog.dataAccess.abstracts.StoryDao;
import com.example.myblog.dataAccess.abstracts.SubjectDao;
import com.example.myblog.entities.concretes.Story;
import com.example.myblog.entities.concretes.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service @Transactional
public class StoryManager implements StoryService {
    private  StoryDao storyDao;

    @Autowired
    public StoryManager(StoryDao storyDao){
        super();
        this.storyDao=storyDao;
    }

    @Override
    public Result add(Story story) {
        this.storyDao.save(story);
        return new SuccessResult("Story eklendi");
    }

    @Override
    public Result update(Story story) {
        this.storyDao.save(story);
        return new SuccessResult("Story güncellendi");
    }

    @Override
    public Result delete(Story story) {
        this.storyDao.delete(story);
        return new SuccessResult("Silindi");
    }

    @Override
    public DataResult<List<Story>> getAll() {
        return new SuccessDataResult<List<Story>>(this.storyDao.findAll(),"Datalar listelendi");
    }

    @Override
    public DataResult<Story> getStoryById(Long storyId) {
        return new SuccessDataResult<Story>(this.storyDao.getById(storyId),"Story getirildi");
    }

    @Override
    public DataResult<List<Story>> getStoryBySubjectId(Long subjectId) {
        return new SuccessDataResult<List<Story>>(this.storyDao.getStoryBySubjectId(subjectId));
    }
}
