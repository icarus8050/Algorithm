
public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(15));
	}
	public int solution(int n) {
	      int answer = 1;
	      
	      int start = 0, end = 0, sum = 0;
	      int m = n / 2 + 1;
	      while (end <= m) {
	    	  if (sum < n) {
	    		  sum += ++end;
	    	  } else {
	    		  if (sum == n)
	    			  answer++;
	    		  sum -= ++start;
	    	  }
	      }
	      return answer;
	  }
}
