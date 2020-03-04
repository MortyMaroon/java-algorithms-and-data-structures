package Chap04;

public class StackChar {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackChar(int max) {
        this.maxSize = max;
        this.stackArray = new char[maxSize];
        this.top = -1;
    }

    public void push(char value) {
        stackArray[++top] = value;
    }

    public char pop() {
        return stackArray[top--];
    }

    public long peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}
