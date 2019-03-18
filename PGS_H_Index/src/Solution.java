import java.util.ArrayList;
import java.util.Collections;

public class Solution {

	public int solution(int[] citations) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < citations.length; i++) {
        	list.add(citations[i]);
        }
        Collections.sort(list, Collections.reverseOrder());
        
        for (int i = 0; i < list.size(); i++) {
        	if (list.get(i) < i + 1)
        		return i;
        }
        return list.size();
    }
}
