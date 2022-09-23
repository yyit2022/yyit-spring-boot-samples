package com.yyit.easyrule.java8.lee;

public class LambdaExpressionExample {

    public static void main(String[] args) {
        int width=10;

        Drawable d = new Drawable() {
            @Override
            public void draw() {
                System.out.println("Drawing "+width);
            }
        };
        d.draw();
    }

}
