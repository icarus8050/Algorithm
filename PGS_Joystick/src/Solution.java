
public class Solution {

	public static void main(String[] args) {
		System.out.println(solution("AAAABAAAAAAAA"));
	}
	public static int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1;;
        for (int i = 0; i < len; i++) {
        	int next = i + 1;
        	char ch = name.charAt(i);
        	if (ch <= 'N')
        		answer += ch - 'A';
        	else
        		answer += 'Z' - ch + 1;
        	
        	while (next < len && name.charAt(next) == 'A')
        		next++;
        	
        	int temp = i + len - next + Math.min(i, len - next);
        	move = Math.min(move, temp);
        	
        }
        answer += move;
        return answer;
    }
}
