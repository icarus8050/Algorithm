import java.util.Arrays;

public class Solution {

	public int[] solution(int n, int s) {
	      int[] answer;
	      
	      if (n > s)
	    	  return new int[] {-1};
	      
	      int a = s / n;
	      int b = s % n;
	      answer = new int[n];
	      
	      Arrays.fill(answer, a);
	      int idx = answer.length - 1;
	      while (b > 0) {
	    	  answer[idx--]++;
	    	  b--;
	      }
	      
	      return answer;
	}
}
