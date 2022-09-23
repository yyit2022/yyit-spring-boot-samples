package com.yyit.errorhandlingsample.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yyit.errorhandlingsample.appliation.user.UserId;
import com.yyit.errorhandlingsample.exceptions.UserNotFoundException;

@RestController
@RequestMapping("/user")
public class UserController {
    


    @GetMapping("/{id}")
    HttpEntity<String> getUserById(@PathVariable("id") String id){
        if(!"admin".equals(id)){
            throw new UserNotFoundException(UserId.of(id));
        }
        return ResponseEntity.ok("success");
    }  

}
