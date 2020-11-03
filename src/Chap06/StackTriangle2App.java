package Chap06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackTriangle2App {
    static int theNumber;
    static int theAnswer;
    static StackInt theStack;

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a number: ");
        theNumber = getInt();
        stackTriangle();
        System.out.println("Triangle = " + theAnswer);
    }

    public static void stackTriangle() {
        theStack = new StackInt(10000);
        theAnswer = 0;
        while (theNumber > 0) {
            theStack.push(theNumber);
            theNumber--;
        }
        while (!theStack.isEmpty()) {
            int newN = theStack.pop();
            theAnswer += newN;
        }
    }

    public static String getString() throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String s = br.readLine();
        return s;
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
