package com.yyit.exceptionhandlesample.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.yyit.exceptionhandlesample.exceptions.CustomErrorException;
import com.yyit.exceptionhandlesample.model.Foo;

@Service
public class FooService {









    public Foo retrieveFooById(int id){
        try{

            if(id<500){
                throw new NullPointerException("FOO 不存在");
            }

            return defaultFoo();

        }catch(NullPointerException e){
            throw new CustomErrorException(
                HttpStatus.NOT_FOUND,
                e.getMessage(),
                (Integer) id
              );
        }
    }





    Foo defaultFoo(){
        Foo f = new Foo();
        f.setFirstName("Tom");
        f.setLastName("jhone");
        return f;
    }

    
}
