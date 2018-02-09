package ccic.ds;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    public static boolean isBalanced(String expression) {
        final Stack<Character> brackets = new Stack<>();
        for (char bracket : expression.toCharArray()) {
            if (bracket == '{' || bracket == '[' || bracket == '(') {
                brackets.push(bracket);
            } else {
                if (brackets.isEmpty()) {
                    return false;
                }

                if (!isMatchingPair(brackets.pop(), bracket)) {
                    return false;
                }
            }
        }

        return brackets.isEmpty();
    }

    private static boolean isMatchingPair(char openBracket, char closedBracket) {
        return openBracket == '[' && closedBracket == ']' ||
                openBracket == '{' && closedBracket == '}' ||
                openBracket == '(' && closedBracket == ')';
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}
