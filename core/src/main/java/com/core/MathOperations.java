package com.core;

public class MathOperations {

    public interface MathOperation{
        int performOperation(int a, int b);

    }


    public static void main(String[] args) {

        MathOperation multiply = (a, b)-> a *b;
        MathOperation add = (a, b) -> a+b;
        MathOperation subtract = (a, b) -> a-b;
        MathOperation divide  = (a, b) -> a/b;
        System.out.println(multiply.performOperation(3,4));
        System.out.println(add.performOperation(3,4));
        System.out.println(subtract.performOperation(4,3));
        System.out.println(divide.performOperation(4,2));

    }
}
