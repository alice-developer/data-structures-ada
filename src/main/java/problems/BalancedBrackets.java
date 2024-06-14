package problems;

import java.util.Set;
import java.util.Stack;

public class BalancedBrackets {
    public static boolean solve(String expression) {
        Set<Character> openSymbols = Set.of('(', '[', '{');
        Set<Character> closeSymbols = Set.of(')', ']', '}');
        Stack<Character> stack = new Stack<>();

        for (char c: expression.toCharArray()) {
            if (openSymbols.contains(c)) stack.push(c);

            if (closeSymbols.contains(c)) {
                if (stack.isEmpty()) return false;

                var open = stack.pop();

                if (open == '(' && c != ')') return false;
                if (open == '[' && c != ']') return false;
                if (open == '{' && c != '}') return false;
            }
        }

        return true;
    }
}
