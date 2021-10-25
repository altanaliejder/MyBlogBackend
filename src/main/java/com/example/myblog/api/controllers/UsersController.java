package com.example.myblog.api.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.myblog.business.abstracts.UserService;
import com.example.myblog.entities.concretes.Role;
import com.example.myblog.entities.concretes.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController

@RequestMapping(value = "/api/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        super();
        this.userService = userService;
    }


    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@RequestBody User user){
        return ResponseEntity.ok(this.userService.add(user));
    }


    @GetMapping(value = "/getall")
    public ResponseEntity<?> getAll(){
    return ResponseEntity.ok(this.userService.getAll());
    }

    @PostMapping(value = "/addstorytouser")
    public ResponseEntity<?>addStoryToUser(@RequestParam(required = false, name="userId") Long userId, @RequestParam(required = false, name="storyId")  Long storyId){
        System.out.println(userId +"  "+ storyId);
        var a=this.userService.addStoryToUser(userId,storyId);
        System.out.println(a);
        return ResponseEntity.ok(a.getMessage());
    }

    @GetMapping(value = "/getuserbyusername")
    public ResponseEntity<?> getUserByUsername(@RequestParam(name = "username") String username){
        return ResponseEntity.ok(this.userService.getUserByUsername(username));
    }
    @GetMapping(value="/getuserbyid")
    public ResponseEntity<?> getUserById(@RequestParam(name="userId")Long userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }
}
