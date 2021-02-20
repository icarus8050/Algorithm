import java.util.Stack;

/**
 * 괄호 변환 (https://programmers.co.kr/learn/courses/30/lessons/60058)
 */
public class Programmers_60058 {
    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
    }

    public static String solution(String p) {
        if (p == null || p.equals("")) {
            return "";
        }

        String[] uv = separate(p);
        if (isRight(uv[0])) {
            return uv[0] + solution(uv[1]);
        } else {
            String s = "(" + solution(uv[1]) + ")";
            uv[0] = uv[0].substring(1, uv[0].length() - 1);
            return s + reverse(uv[0]);
        }
    }

    private static String[] separate(String s) {
        int length = s.length();
        for (int i = 1; i <= length; i++) {
            String u = s.substring(0, i);
            if (isBalanced(u)) {
                String v = s.substring(i);
                return new String[]{u, v};
            }
        }

        throw new IllegalArgumentException();
    }

    private static boolean isBalanced(String s) {
        int open = 0;
        int close = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
        }

        return open == close;
    }

    private static boolean isRight(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }

                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder();

        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }

        return sb.toString();
    }
}
