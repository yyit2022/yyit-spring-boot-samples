package com.yyit.easyrule.pojo.rules;

import org.jeasy.rules.annotation.*;

@Rule(name = "被8整除")
public class EightRule {

    @Condition
    public boolean isEight(@Fact("number") int number){
        return number % 8 == 0;
    }

    @Action
    public void eightAction(@Fact("number") int number){
        System.out.println(number + " is eight");
    }

    @Priority
    public int getPriority(){
        return 2;
    }

}
