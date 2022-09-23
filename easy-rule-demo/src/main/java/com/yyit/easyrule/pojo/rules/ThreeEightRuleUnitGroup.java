package com.yyit.easyrule.pojo.rules;

import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.support.composite.UnitRuleGroup;

@Rule(name = "被3和8同时整除" , description = "这是一个组合规则")
public class ThreeEightRuleUnitGroup extends UnitRuleGroup {

    public ThreeEightRuleUnitGroup(Object... rules){
        for (Object rule:rules){
            addRule(rule);
        }
    }

    @Override
    public int getPriority(){
        return 0;
    }

}
