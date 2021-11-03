package com.algs;

public class SubStr {

    public static void main(String[] args) {
        String str = "Java, Java,  Hello World";
        String newStr = str.replaceAll("Java", "Python");
        System.out.println(newStr);
    }
}
