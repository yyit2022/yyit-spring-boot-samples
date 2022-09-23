package com.yyit.easyrule.mvel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {

    private String name;

    private boolean adult;

    private int age;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }



}
