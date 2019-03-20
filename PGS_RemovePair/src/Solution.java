import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("cdcd"));
	}
	public int solution(String s)
    {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
        	if (stack.isEmpty()) {
        		stack.push(s.charAt(i));
        	} else {
        		if (stack.peek() != s.charAt(i))
            		stack.push(s.charAt(i));
            	else
            		stack.pop();
        	}
        }
        if (stack.isEmpty())
        	return 1;
        else
        	return 0;
    }
}
