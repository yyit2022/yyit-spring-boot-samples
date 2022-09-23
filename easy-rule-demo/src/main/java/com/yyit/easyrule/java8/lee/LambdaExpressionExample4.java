package com.yyit.easyrule.java8.lee;

interface Sayable1{
    String say(String name);
}

public class LambdaExpressionExample4 {

    public static void main(String[] args) {
        Sayable1 s1 = (name) -> "Hello, " + name;

        System.out.println(s1.say("Sonoo"));

        Sayable1 s2 = name -> "Hello, " + name;

        System.out.println(s2.say("Sonoo"));
    }

}
