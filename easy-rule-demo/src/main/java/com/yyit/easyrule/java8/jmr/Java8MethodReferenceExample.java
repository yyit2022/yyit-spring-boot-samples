package com.yyit.easyrule.java8.jmr;

import java.util.function.BiFunction;

public class Java8MethodReferenceExample {



    public static void main(String[] args) {

        Java8MethodReferenceExample example = new Java8MethodReferenceExample();

        example.reference_to_a_static_method();

        example.reference_to_a_static_method1();

        example.methodReference3();

        example.methodReference4();

        example.instanceMethodReference();

        example.instanceMethodReference1();

        example.instanceMethodReference2();

        example.constructorReference();

    }


    /****静态方法引用****/

    private void reference_to_a_static_method(){
        // Referring static method
        Sayable sayable = Java8MethodReferenceExample::saySomething;
        // Calling interface method
        sayable.say();
    }

    public static void saySomething(){
        System.out.println("Hello, this is static method.");
    }

    private void reference_to_a_static_method1(){
        Thread t2 = new Thread(Java8MethodReferenceExample::ThreadStatus);
        t2.start();
    }

    public static void ThreadStatus(){
        System.out.println("Thread is running...");
    }

    private void methodReference3(){
        BiFunction<Integer,Integer,Integer> adder = Arithmetic::add;
        int result = adder.apply(10,20);
        System.out.println(result);
    }


    private void  methodReference4(){
        BiFunction<Integer, Integer, Integer>adder1 = Arithmetic::add;
        BiFunction<Integer, Float, Float>adder2 = Arithmetic::add;
        BiFunction<Float, Float, Float>adder3 = Arithmetic::add;

        int result1 = adder1.apply(10, 20);
        float result2 = adder2.apply(10, 20.0f);
        float result3 = adder3.apply(10.0f, 20.0f);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }


    /****引用实例方法****/

    private void  instanceMethodReference(){
        InstanceMethodReference methodReference = new InstanceMethodReference(); // Creating object

        // Referring non-static method using reference
        Sayable sayable = methodReference::saySomething;
        // Calling interface method
        sayable.say();
        // Referring non-static method using anonymous object
        Sayable sayable2 = new InstanceMethodReference()::saySomething; // You can use anonymous object also
        // Calling interface method
        sayable2.say();
    }



    private void  instanceMethodReference1(){
        Thread t2 = new Thread(new InstanceMethodReference2()::printnMsg);
        t2.start();
    }

    private void  instanceMethodReference2(){
        BiFunction<Integer,Integer,Integer> adder = new Arithmetic1()::add;
        int result = adder.apply(10,20);
        System.out.println(result);
    }

    /*** 引用构造方法 ***/

    private  void  constructorReference(){
        Messageable hello = Message::new;
        hello.getMessage("Hello");
    }


}
