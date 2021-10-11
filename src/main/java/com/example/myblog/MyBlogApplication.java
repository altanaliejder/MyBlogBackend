package com.example.myblog;

import com.example.myblog.business.abstracts.StoryService;
import com.example.myblog.business.abstracts.SubjectService;
import com.example.myblog.business.abstracts.UserService;
import com.example.myblog.core.utilities.results.Result;
import com.example.myblog.entities.concretes.Role;
import com.example.myblog.entities.concretes.Story;
import com.example.myblog.entities.concretes.Subject;
import com.example.myblog.entities.concretes.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

@EnableSwagger2

public class MyBlogApplication {

    public static void main(String[] args) {

        SpringApplication.run(MyBlogApplication.class, args);

    }
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.myblog"))
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /*@Bean
    CommandLineRunner run(UserService userService, SubjectService subjectService, StoryService storyService){
        return args -> {
           subjectService.add(new Subject(null,"Technology",new ArrayList<>()));
            subjectService.add(new Subject(null,"Software",new ArrayList<>()));
            subjectService.add(new Subject(null,"Science",new ArrayList<>()));
            subjectService.add(new Subject(null,"Work",new ArrayList<>()));
            subjectService.add(new Subject(null,"School",new ArrayList<>()));


            userService.deleteAllUser();
            userService.saveRole(new Role(null,"ROLE_USER"));
            userService.saveRole(new Role(null,"ROLE_MANAGER"));
            userService.saveRole(new Role(null,"ROLE_ADMIN"));
           userService.add(new User(null, "altan", "altan@altan.com", "1234", "Altan", "Ejder",new ArrayList<>(),new ArrayList<>()));
            userService.add(new User(null, "duygu", "duygu@duygu.com", "1234", "Duygu", "Ejder",new ArrayList<>(),new ArrayList<>()));
            userService.add(new User(null, "zeynep", "zeynep@zeynep.com", "1234", "Zeynep", "Ejder",new ArrayList<>(),new ArrayList<>()));
            userService.add(new User(null, "filiz", "filiz@filiz.com", "1234", "Filiz", "Ejder",new ArrayList<>(),new ArrayList<>()));
            userService.add(new User(null, "yetgin", "yetgin@yetgin.com", "1234", "Yetgin", "Ejder",new ArrayList<>(),new ArrayList<>()));
            userService.addRoleToUser("altan","ROLE_ADMIN");
            userService.addRoleToUser("altan","ROLE_MANAGER");
            userService.addRoleToUser("altan","ROLE_USER");
            userService.addRoleToUser("yetgin","ROLE_ADMIN");
            userService.addRoleToUser("yetgin","ROLE_USER");
            userService.addRoleToUser("yetgin","ROLE_MANAGER");
            userService.addRoleToUser("filiz","ROLE_ADMIN");
            userService.addRoleToUser("duygu","ROLE_USER");
            userService.addRoleToUser("zeynep","ROLE_MANAGER");
            userService.addRoleToUser("zeynep","ROLE_USER");
            storyService.add(new Story(null,"asdsad","jkdfghasjkmb jgbjmfdnblkgfnkldfbmnvckjbndflk",null,null ));
            storyService.add(new Story(null,"asdsaddsad","jkdfghasjkmb jgbjmfdnblkgfnkdasdasxzczldfbmnvckjbndflk",null,null) );
            storyService.add(new Story(null,"asdasdassad","jkmjöjköhjmghmghasjkmbdsadsajgbjmfdnblkgfnkldfbmnvckjbndflk",null,null) );
            storyService.add(new Story(null,"asbfgnhgtdsad","jkdfghasjkmbhgfhgfhfjgbjmfdnbldsadasdaskgfnkldfbmnvckjbndflk",null,null));

            subjectService.addSubjectToStory(1L,"Technology");
            subjectService.addSubjectToStory(2L,"Science");
            subjectService.addSubjectToStory(3L,"Technology");
            subjectService.addSubjectToStory(4L,"Software");

            userService.addStoryToUser("altan",2L);
            userService.addStoryToUser("altan",2L);
            userService.addStoryToUser("yetgin",3L);
            userService.addStoryToUser("zeynep",4L);

        };
    }*/


}
