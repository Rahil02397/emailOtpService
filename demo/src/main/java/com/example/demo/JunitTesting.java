package com.example.demo;

import org.springframework.stereotype.Controller;

@Controller
public class JunitTesting {

    public static int add(int x, int y){
        return x+y;
    }

    public static int sub(int x, int y){
        return x-y;
    }

    public static int multiply(int x, int y){
        return x*y;
    }

    public static int divison(int x , int y){
        return x/y;
    }



}
