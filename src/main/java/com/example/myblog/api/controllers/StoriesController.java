package com.example.myblog.api.controllers;

import com.example.myblog.business.abstracts.StoryService;
import com.example.myblog.entities.concretes.Story;
import com.example.myblog.entities.concretes.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
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
}
