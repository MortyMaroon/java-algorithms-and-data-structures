package Chap04.Arithmetic;

public class ParsePost {
    private StackChar theStack;
    private String input;

    public ParsePost(String str) {
        this.input = str;
    }

    public int doParse() {
        theStack = new StackChar(10);
        char ch;
        int num1, num2, answer;
        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            theStack.displayStack("" + ch + " ");
            if (ch >= '0' && ch <= '9') {
                theStack.push((int) (ch - '0'));
            } else {
                num2 = theStack.pop();
                num1 = theStack.pop();
                switch (ch) {
                    case '+':
                        answer = num1 + num2;
                        break;
                    case '-':
                        answer = num1 - num2;
                        break;
                    case '/':
                        answer = num1 / num2;
                        break;
                    case '*':
                        answer = num1 * num2;
                        break;
                    default:
                        answer = 0;
                }
                theStack.push(answer);
            }
        }
        answer = theStack.pop();
        return answer;
    }
}
