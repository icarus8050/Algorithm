import java.util.Stack;

/**
 * 큰 수 만들기 (https://programmers.co.kr/learn/courses/30/lessons/42883)
 */
public class MakeBiggestNumber {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int size = number.length();
        int resultSize = size - k;
        for (int i = 0; i < size; i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }

        for (int i = 0; i < resultSize; i++) {
            sb.append(stack.get(i));
        }

        return sb.toString();
    }
}
