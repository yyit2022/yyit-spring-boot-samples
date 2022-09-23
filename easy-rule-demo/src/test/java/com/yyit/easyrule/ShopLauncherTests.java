package com.yyit.easyrule;

import com.yyit.easyrule.mvel.Person;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.reader.JsonRuleDefinitionReader;
import org.jeasy.rules.support.reader.YamlRuleDefinitionReader;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.FileReader;

public class ShopLauncherTests {

    @Test
    void execute() throws Exception {

        Person tom = new Person("Tom",19);

        Facts facts = new Facts();

        facts.put("person",tom);


        Rule ageRule = new MVELRule()
                .name("age rule")
                .description("Check if person's age is > 18 and marks the person as adult")
                .priority(1)
                .when("person.age > 18")
                .then("person.setAdult(true);")
                ;

        Rule alcoholRule = new MVELRuleFactory(new JsonRuleDefinitionReader())
                .createRule(new FileReader(ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "rules/alcohol-rule.json")));

        Rules rules = new Rules();
        rules.register(ageRule);
        rules.register(alcoholRule);

        RulesEngine rulesEngine = new DefaultRulesEngine();

        System.out.println("Tom: Hi! can I have some Vodka please?");

        rulesEngine.fire(rules, facts);

        System.out.println(tom);

    }

}
