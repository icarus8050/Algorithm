import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] w = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int[] t = sol.solution(3, w);
		System.out.println(t[0]);
	}
	
	public int[] solution(int n, String[] words) {
        int idx = 1;
        int turn = 1;
        char pre = 0;
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < words.length; i++) {
        	if ((pre == 0 || words[i].charAt(0) == pre) && !set.contains(words[i])) {
        		pre = words[i].charAt(words[i].length() - 1);
        		set.add(words[i]);
        		idx++;
        	}
        	else break;
        	
        	if (idx == n + 1) {
        		idx = 1;
        		turn++;
        	}
        	
        	if (i == words.length - 1) {
        		idx = 0;
        		turn = 0;
        	}
        }
        int[] answer = {idx, turn};
        return answer;
    }
}
