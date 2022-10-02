package com.knubisoft;

import com.knubisoft.utils.Calculator;
import com.knubisoft.utils.InToPost;

public class Main {
    public static void main(String[] args) {
        InToPost translation = new InToPost("3*(4+5)-6/(1+2)");
        Calculator calculator = new Calculator();
        System.out.println(translation.doTrans());
        System.out.println(calculator.calculate(translation.doTrans()));
    }
}