package com.knubisoft.utils;

public class InToPost {
    private final Stack stack;
    private final String input;
    private String output = "";

    public InToPost(String input) {
        this.input = input;
        int stackSize = input.length();
        stack = new Stack(stackSize);
    }

    public String doTrans() {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '+', '-' -> gotOperation(ch, 1);
                case '*', '/' -> gotOperation(ch, 2);
                case '(' -> stack.push(ch);
                case ')' -> gotParen(ch);
                default -> output += ch;
            }
        }
        while (!stack.isEmpty()) {
            output += stack.pop();
        }
        return output;
    }

    private void gotParen(char ch) {
        while (!stack.isEmpty()) {
            char chx = stack.pop();
            if (chx == '(') {
                break;
            } else {
                output += chx;
            }
        }
    }

    private void gotOperation(char ch, int prec1) {
        while (!stack.isEmpty()) {
            char onTop = stack.pop();
            if (onTop == '(') {
                stack.push(onTop);
                break;
            } else {
                int prec2;
                if (onTop == '+' || onTop == '-') {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }
                if (prec2 < prec1) {
                    stack.push(onTop);
                    break;
                } else {
                    output += onTop;
                }
            }
        }
        stack.push(ch);
    }
}
