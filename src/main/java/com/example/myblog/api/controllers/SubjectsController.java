package com.example.myblog.api.controllers;

import com.example.myblog.business.abstracts.SubjectService;
import com.example.myblog.entities.concretes.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/subjects")
public class SubjectsController {

    private SubjectService subjectService;
    @Autowired
    public SubjectsController(SubjectService subjectService) {
        super();
        this.subjectService = subjectService;
    }


    @GetMapping(value = "/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.subjectService.getAll());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@RequestBody Subject subject){
        return ResponseEntity.ok(this.subjectService.add(subject));
    }

    @PostMapping(value="/addSubjectToStory")
    public ResponseEntity<?> addSubjectToStory(@RequestParam(name = "storyId")  Long storyId, @RequestParam(name = "subjectName") String subjectName){
        return ResponseEntity.ok(this.subjectService.addSubjectToStory(storyId,subjectName));
    }



}
