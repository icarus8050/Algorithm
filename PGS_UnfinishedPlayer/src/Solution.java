import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		String[] str = 	{"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] str2 = {"josipa", "filipa", "marina", "nikola"};
		Solution sol = new Solution();
		System.out.println(sol.solution(str, str2));
	}
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        int cnt;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String name : participant) {
        	if (map.containsKey(name)) {
        		cnt = map.get(name) + 1;
        		map.put(name, cnt);
        	}
        	else {
        		map.put(name, 1);
        	}
        }
        for (String name : completion) {
        	cnt = map.get(name) - 1;
        	map.put(name, cnt);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
        	if (entry.getValue() == 1) {
        		answer = entry.getKey();
        		break;
        	}
        }
        return answer;
    }
}
