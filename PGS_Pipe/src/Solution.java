import java.util.Stack;

public class Solution {

	public int solution(String arrangement) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < arrangement.length(); i++) {
        	if (arrangement.charAt(i) == '(')
        		stack.push(i);
        	else {
        		if (stack.peek() + 1 == i) {
        			stack.pop();
        			answer += stack.size();
        		}
        		else {
        			stack.pop();
        			answer++;
        		}
        	}
        }
        return answer;
    }
}
