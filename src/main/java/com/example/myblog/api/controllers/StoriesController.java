package com.example.myblog.api.controllers;

import com.example.myblog.business.abstracts.StoryService;
import com.example.myblog.entities.concretes.Story;
import com.example.myblog.entities.concretes.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/stories")
public class StoriesController {

    private StoryService storyService;

    @Autowired
    public StoriesController(StoryService storyService) {
        super();
        this.storyService = storyService;
    }


    @GetMapping(value = "/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.storyService.getAll());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@RequestBody Story story){
        return ResponseEntity.ok(this.storyService.add(story));
    }

    @GetMapping(value="/getSubjectToStory")
    public ResponseEntity<?> getSubjectToStory(@RequestParam(value = "subjectId",required = false)  Long subjectId){
        return ResponseEntity.ok(this.storyService.getStoryBySubjectId(subjectId));
    }
    @GetMapping(value="/getStoryById")
    public ResponseEntity<?> getStoryById(@RequestParam(value="storyId")Long storyId){
        return ResponseEntity.ok(this.storyService.getStoryById(storyId));
    }

    @GetMapping(value="/search")
    public ResponseEntity<?> searchStory(Model model, @Param(value = "keyword")String keyword){
        var stories= this.storyService.searchStories(keyword).getData();
        model.addAttribute("listStories",stories);
        model.addAttribute("keyword",keyword);
        return ResponseEntity.ok(stories);
    }

    @GetMapping(value="/getstoriesbyuserid")
    public ResponseEntity<?> getStoriesByUserId(@RequestParam(value="userId") Long userId){
        return ResponseEntity.ok(this.storyService.getStoryByUserId(userId));
    }

}
