package com.knubisoft.utils;

public class Calculator {

    public int calculate(String postEquation) {
        Stack stack = new Stack(postEquation.length());
        int num1, num2, answer;

        for (int i = 0; i < postEquation.length(); i++) {
            char ch = postEquation.charAt(i);

            if (ch >= '0' && ch <= '9') {
                stack.push((char) (ch-'0'));
            } else {
                num2 = stack.pop();
                num1 = stack.pop();

                switch (ch) {
                    case '+' -> answer = num1 + num2;
                    case '-' -> answer = num1 - num2;
                    case '*' -> answer = num1 * num2;
                    case '/' -> answer = num1 / num2;
                    default -> answer = 0;
                }

                stack.push((char) answer);
            }
        }
        return stack.pop();
    }
}
