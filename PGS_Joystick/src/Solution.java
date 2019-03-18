
public class Solution {

	public static void main(String[] args) {
		System.out.println(solution("ABABAAAAAAABA"));
	}
	public static int solution(String name) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < name.length(); i++)
        	sb.append("A");
        
        int cursor = 0;
        for (int i = 0; i < sb.length(); i++) {
        	if (sb.charAt(i) != name.charAt(i)) {
        		if (i != cursor) {
        			int left = cursor + (sb.length() - i);
        			int right = i - cursor;
        			answer += Math.min(left, right);
        			cursor = i;
        		}
    			int up = name.charAt(i) - sb.charAt(i);
    			int down = ('Z' + 1) - name.charAt(i);
    			answer += Math.min(up, down);
        	}
        }
        return answer;
    }
}
