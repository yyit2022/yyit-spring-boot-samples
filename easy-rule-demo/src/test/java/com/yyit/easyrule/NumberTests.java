package com.yyit.easyrule;


import com.yyit.easyrule.pojo.rules.EightRule;
import com.yyit.easyrule.pojo.rules.OtherRule;
import com.yyit.easyrule.pojo.rules.ThreeEightRuleUnitGroup;
import com.yyit.easyrule.pojo.rules.ThreeRule;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.api.RulesEngineParameters;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.junit.jupiter.api.Test;

public class NumberTests {

    @Test
    void execute(){
        RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);

        RulesEngine rulesEngine = new DefaultRulesEngine(parameters);

        Rules rules = new Rules();
        rules.register(new EightRule());
        rules.register(new ThreeRule());
        rules.register(new ThreeEightRuleUnitGroup(new EightRule(), new ThreeRule()));
        rules.register(new OtherRule());

        Facts facts = new Facts();
        for (int i=1 ; i<=50;i++){
            facts.put("number",i);
            rulesEngine.fire(rules,facts);
            System.out.println();
        }
    }

}
