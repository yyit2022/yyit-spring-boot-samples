package com.yyit.errorhandlingsample.controller;

import javax.validation.Valid;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yyit.errorhandlingsample.controller.support.ExampleRequestBody;

@RestController
@RequestMapping("/example")
public class MyExampleController {
    
    @PostMapping
    public HttpEntity<String> doSomething(@Valid @RequestBody ExampleRequestBody requestBody ) {
        return ResponseEntity.ok("SUCCESS");
    }

}
