import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i < clothes.length; i++) {
        	if (map.containsKey(clothes[i][1]))
        		map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
        	else
        		map.put(clothes[i][1], 1);
        }
        for (Integer val : map.values()) {
        	answer *= (val + 1);
        }
        return answer - 1;
    }
}
