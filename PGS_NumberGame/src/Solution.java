import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public int solution(int[] A, int[] B) {
		int answer = 0;
		
        Arrays.sort(A);
        Arrays.sort(B);
        int len = A.length;
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        
        for (int i = 0; i < len; i++) {
        	listA.add(A[i]);
        	listB.add(B[i]);
        }
        
        while (!listA.isEmpty()) {
        	if (listA.get(listA.size() - 1) >= listB.get(listB.size() - 1)) {
        		listA.remove(listA.size() - 1);
        		listB.remove(0);
        	} else {
        		listA.remove(listA.size() - 1);
        		listB.remove(listB.size() - 1);
        		answer++;
        	}
        }
        
        return answer;
    }
}
