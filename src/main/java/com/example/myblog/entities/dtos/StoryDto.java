package com.example.myblog.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoryDto {
    private Long id;
    private String title;
    private String story;
    private String username;
    private String subjectName;

}
