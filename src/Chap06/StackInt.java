package Chap06;

public class StackInt {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackInt(int s) {
        this.maxSize = s;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int p) {
        stackArray[++top] = p;
    }

    public int pop() {
        return stackArray[top--];
    }

    public int peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}
