package com.yyit.errorhandlingsample.appliation.user;

import java.util.UUID;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class UserId {

    private final String id;

    private UserId(String id){
        this.id = id;
    }

    public static UserId withoutOf(){
        return new UserId(UUID.randomUUID().toString());
    }

    public static UserId of(String id){
        return new UserId(id);
    }
    
}
