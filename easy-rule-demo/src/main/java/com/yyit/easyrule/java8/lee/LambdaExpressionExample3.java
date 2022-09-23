package com.yyit.easyrule.java8.lee;

public class LambdaExpressionExample3 {

    public static void main(String[] args) {
        Sayable s = () ->{
            return "I have nothing to say.";
        };

        System.out.println(s.say());
    }

}


