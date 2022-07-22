package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        JOptional<String> jOptional= new JOptional<>("123");
        JOptional<String> jOptional2= new JOptional<>();
        System.out.println(jOptional.get());
        System.out.println(jOptional.stream().map(value -> Integer.parseInt(value)).map(num -> num*2).findAny().get());
        System.out.println(jOptional2.orElse("Hello"));
        System.out.println(jOptional2.orElseGet(() -> "orElseGet"));
    }
}