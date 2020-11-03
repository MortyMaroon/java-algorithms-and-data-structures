package Chap04;

public class BracketsChecker {
    private String input;

    public BracketsChecker(String input) {
        this.input = input;
    }

    public void check() {
        int stackSize = input.length();
        StackChar theStack = new StackChar(stackSize);
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    theStack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!theStack.isEmpty()) {
                        char chx = theStack.pop();
                        if ((ch =='}' && chx != '{') ||
                            (ch ==']' && chx != '[') ||
                            (ch ==')' && chx != '(') ) {
                            System.out.println("Error: " + ch + " at " + i);
                        }
                    } else {
                        System.out.println("Error: " + ch + " at " + i);
                    }
                    break;
                default:
                    break;
            }
        }
        if (!theStack.isEmpty()){
            System.out.println("Error: missing right delimiter");
        }
    }
}
