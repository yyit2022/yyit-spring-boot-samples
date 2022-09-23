package com.yyit.exceptionhandlesample.exceptions;

public class CustomDataNotFoundException  extends RuntimeException{
    public CustomDataNotFoundException() {
        super();
    }

    public CustomDataNotFoundException(String message) {
        super(message);
    }
}
