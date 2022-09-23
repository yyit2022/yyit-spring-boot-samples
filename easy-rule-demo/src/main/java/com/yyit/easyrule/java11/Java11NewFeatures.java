package com.yyit.easyrule.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Java11NewFeatures {

    public static void main(String[] args) {
        Java11NewFeatures example = new Java11NewFeatures();

        example.string_isBlank();
        example.string_lines();
        example.string_repeat();
        example.string_stripLeading();
        example.string_stripTrailing();
        example.string_strip();

        example.string_writeString();

        example.string_readString();

    }

    private void string_isBlank(){

        // 返回 false
        String myStr = "MyString";
        System.out.println(myStr.isBlank());

        // 返回 true
        String anotherStr = "";
        System.out.println(anotherStr.isBlank());

        // 返回 true
        String anotherBlankStr = " ";
        System.out.println(anotherBlankStr.isBlank());
    }

    /**
     * 此方法返回字符串的集合。 它们由行终止符（“\n”）划分。
     */
    private void string_lines(){

        String myStr = "I\nam\ntest\nString";

        System.out.println(myStr.lines().collect(Collectors.toList()));

    }

    private void string_repeat(){
        String myStr = "testString";
        System.out.println(myStr.repeat(3));
    }

    /**
     * stripLeading() - 此方法用于删除任何字符串之前的空白。
     */
    private void string_stripLeading(){
        String myStr = "    testString";
        System.out.println(myStr.stripLeading());
    }

    /**
     * stripTrailing() – 该方法用于去除字符串后面的空格。
     */
    private void string_stripTrailing(){
        String myStr = "anyString      ";
        System.out.println(myStr.stripTrailing());
    }

    /**
     * strip() – 该方法用于去除字符串前后的空白。
     */
    private void string_strip(){
        String myStr = "    anyString      ";
        System.out.println(myStr.strip());
    }

    /**
     * writeString() – 该方法用于在文件中写入一些内容。
     */
    private void string_writeString(){
        Path filePath = Paths.get(".", "myFile.txt");
        try{
            Files.writeString(filePath,"Hello World !!", StandardOpenOption.WRITE);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void string_readString(){
        Path filePath = Paths.get(".", "myFile1.txt");
        try{

            //Write content to file
            Files.writeString(filePath, "Hello World !!", StandardOpenOption.WRITE);

            String content = Files.readString(filePath);

            System.out.println(content);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * asMatchPredicate() –此方法与 Java 8 方法 asPredicate() 相同，但如果模式与输入字符串匹配，此方法将创建一个谓词。
     */
    private void asMatchPredicateExample(){
        Pattern pattern = Pattern.compile("myStr");
        Predicate<String> predicate = pattern.asMatchPredicate();

        // return true
        System.out.println(predicate.test("myStr"));

        // return false
        System.out.println(predicate.test("anotherStr"));
    }



}
