package com.yyit.jwt.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "yyit.app")
@Getter
@Setter
public class AppProperties {
    


    private RsaKeyProperties rsa;
    private TokenProperties token;

}
