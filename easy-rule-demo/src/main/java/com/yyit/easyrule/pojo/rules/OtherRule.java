package com.yyit.easyrule.pojo.rules;

import org.jeasy.rules.annotation.*;

@Rule(name = "既不被3整除也不被8整除", description = "打印number自己")
public class OtherRule {


    @Condition
    public boolean isOther(@Fact("number")int number){
        return number % 3 != 0 || number % 8 !=0;
    }

    @Action
    public void printSelf(@Fact("number") int number){
        System.out.println(number);
    }

    @Priority
    public int getPriority(){
        return 3;
    }

}
