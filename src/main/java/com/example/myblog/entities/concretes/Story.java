package com.example.myblog.entities.concretes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stories")

public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title",nullable = false)
    @NotBlank
    @NotNull
    private String title;

    @Column(name = "story",nullable = false)
    @NotBlank
    @NotNull
    private String story;

    @ManyToOne()
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;


}
