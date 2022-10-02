package com.knubisoft.utils;

public class Stack {
    private final char[] stackArray;
    private int top;

    public Stack(int s) {
        stackArray = new char[s];
        top = -1;
    }

    public void push(char j) {      //put an element on the top of stack
        stackArray[++top] = j;
    }

    public char pop() {         //extract an element from the top of stack
        return stackArray[top--];
    }

    public char peek() {        //read an element from the top of stack
        return stackArray[top];
    }

    public boolean isEmpty() {      //true if stack is empty else false
        return top == -1;
    }

    public int size() {     // return current size of stack
        return top + 1;
    }

    public char peekN(int n) {  //read an element with index N from stack
        return stackArray[n];
    }

    public void displayStack(String s) {
        System.out.println(s);
        System.out.print("Stack (bottom-->top): ");
        for (int i = 0; i < size(); i++) {
            System.out.print(peekN(i) + " ");
        }
        System.out.println();
    }

}
