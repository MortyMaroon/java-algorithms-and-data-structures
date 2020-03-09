package Chap04.Arithmetic;

public class StackChar {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackChar(int max) {
        this.maxSize = max;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    public void push(int element) {
        stackArray[++top] = element;
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

    public int size() {
        return top + 1;
    }

    public int peekN(int n) {
        return stackArray[n];
    }

    public void displayStack(String str) {
        System.out.print(str);
        System.out.print("Stack (bottom-->top): ");
        for (int i = 0; i < size(); i++) {
            System.out.print(peekN(i));
            System.out.print(' ');
        }
        System.out.println("");
    }
}
