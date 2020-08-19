import java.util.Stack;

/**
 * 20. Valid Parentheses (https://leetcode.com/problems/valid-parentheses/)
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String str = "()[]{}";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String s) {
        char[] ch = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char c : ch) {
            if (c == ')') {
                if (stack.isEmpty()) return false;
                Character pop = stack.pop();
                if (!pop.equals('(')) return false;

            } else if (c == '}') {
                if (stack.isEmpty()) return false;
                Character pop = stack.pop();
                if (!pop.equals('{')) return false;
            } else if (c == ']') {
                if (stack.isEmpty()) return false;
                Character pop = stack.pop();
                if (!pop.equals('[')) return false;
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
