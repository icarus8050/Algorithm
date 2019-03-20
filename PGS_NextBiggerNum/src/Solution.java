
public class Solution {

	public int solution(int n) {
	      int next = n + 1;
	      int cnt = 0;
	      while (n != 0) {
	    	  if (n % 2 == 1)
	    		  cnt++;
	    	  n /= 2;
	      }
	      while (true) {
	    	  int temp = next;
	    	  int temp_cnt = 0;
	    	  while (temp != 0) {
	    		  if (temp % 2 == 1)
	    			  temp_cnt++;
	    		  temp /= 2;
	    	  }
	    	  if (cnt == temp_cnt)
	    		  break;
	    	  else
	    		  next++;
	      }
	      return next;
	  }
	
	
}
