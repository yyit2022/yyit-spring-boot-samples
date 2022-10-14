package com.yyit.jwt.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenProperties {
    private int jwtExpirationMs;
    private int jwtRefreshExpirationMs;
}
