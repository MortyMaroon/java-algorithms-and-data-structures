package Chap04;

public class Reverser {
    private String input;
    private String output;

    public Reverser(String in) {
        this.input = in;
    }

    public String doRev() {
        int stackSize = input.length();
        StackChar theStack = new StackChar(stackSize);
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            theStack.push(ch);
        }
        output = "";
        while (!theStack.isEmpty()) {
            char ch = theStack.pop();
            output = output + ch;
        }
        return output;
    }
}
