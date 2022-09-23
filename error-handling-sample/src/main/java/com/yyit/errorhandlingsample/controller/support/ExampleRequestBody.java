package com.yyit.errorhandlingsample.controller.support;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExampleRequestBody {
    @Size(min = 10,max = 50)
    private String name;
    @NotBlank
    private String favoriteMovie;
}
