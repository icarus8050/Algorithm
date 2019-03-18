import java.util.Arrays;

public class Solution {

	public int solution(int[] weight) {
        int answer = 0;
        
        Arrays.sort(weight);
        
        if (weight[0] != 1) {
        	return 1;
        } else {
        	int sum = weight[0];
        	int size = weight.length;
        	for (int i = 1; i < size; i++) {
        		
        		if (weight[i] > sum + 1) {
        			answer = sum + 1;
        			break;
        		}
        		
        		sum += weight[i];
        	}
        	answer = sum + 1;
        }
        return answer;
    }
}
