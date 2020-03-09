package Chap04.Arithmetic;

public class InToPost {
    private StackX theStack;
    private String input;
    private String output = "";

    public InToPost(String in) {
        this.input = in;
        int stackSize = input.length();
        this.theStack = new StackX(stackSize);
    }

    public String doTrans() {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            theStack.displayStack("For " + ch + " ");
            switch (ch) {
                case '+':
                case '-':
                    gotOperand(ch,1);
                    break;
                case '*':
                case '/':
                    gotOperand(ch,2);
                    break;
                case '(':
                    theStack.push(ch);
                    break;
                case ')':
                    getParent(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }
        while (!theStack.isEmpty()) {
            theStack.displayStack("While ");
            output = output + theStack.pop();
        }
        theStack.displayStack("End ");
        return output;
    }

    public void gotOperand(char opThis, int prec1) {
        while (!theStack.isEmpty()) {
            char onTop = theStack.pop();
            if (onTop == '(') {
                theStack.push(onTop);
                break;
            } else {
                int prec2;
                if (onTop == '+' || onTop == '-') {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }
                if (prec2 < prec1) {
                    theStack.push(onTop);
                    break;
                } else {
                    output = output + onTop;
                }
            }
        }
        theStack.push(opThis);
    }

    public void getParent(char ch) {
        while (!theStack.isEmpty()) {
            char chx = theStack.pop();
            if (chx == '(') {
                break;
            } else {
                output = output + chx;
            }
        }
    }
}
