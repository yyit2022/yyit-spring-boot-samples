package com.yyit.easyrule.pojo.rules;

import org.jeasy.rules.annotation.*;

@Rule(name = "被3整除", description = "number如果被3整除，打印：number is three")
public class ThreeRule {

    @Condition
    public boolean isThree(@Fact("number") int number){
        return number % 3 == 0;
    }

    @Action
    public void threeAction(@Fact("number") int number){
        System.out.println(number + " is three");
    }

    @Priority
    public int getPriority(){
        return 1;
    }

}
