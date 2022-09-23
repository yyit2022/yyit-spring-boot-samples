package com.yyit.exceptionhandlesample.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yyit.exceptionhandlesample.service.FooService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/error")
@RequiredArgsConstructor
public class FooController {


    private final FooService fooService;

    @GetMapping("/common")
    public ResponseEntity<Void> exceptionForCommon() throws Exception{

        throw new Exception("普通异常");

    }

    @GetMapping("/nullendpoint")
    public HttpEntity<Void> nullException(){
        throw new NullPointerException();
    }

    @GetMapping("/datanotfound")
    public HttpEntity<String> dataNotfound(){
        fooService.retrieveFooById(20);
        return ResponseEntity.ok("body");
    } 
  

    
}
