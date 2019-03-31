import java.util.Arrays;

public class Solution {

	public int solution(int[] A, int[] B) {
		int answer = 0;
		
        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i = A.length - 1, j = B.length - 1; i >= 0; i--) {
        	if (B[j] > A[i]) {
        		answer++;
        		j--;
        	}
        }
        
        return answer;
    }
}
