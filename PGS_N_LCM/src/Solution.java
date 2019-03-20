import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] arr = {2, 6, 8, 14};
		System.out.println(sol.solution(arr));
	}
	public int solution(int[] arr) {
	      int answer = 1;
	      boolean[] prime = new boolean[101];
	      for (int i = 2; i * i <= 100; i++) {
	    	  for (int j = i * i; j <= 100; j += i) {
	    		  if (prime[j] == false)
	    			  prime[j] = true;
	    	  }
	      }
	      
	      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	      for (int i = 0; i < arr.length; i++) {
	    	  int num = arr[i];
    		  for (int j = 2; j <= 100; j++) {
    			  int cnt = 0;
    			  if (!prime[j]) {
    				  while (num != 1 && num % j == 0) {
    					  cnt++;
    					  num /= j;
    				  }
    				  if (cnt != 0) {
    					  if (map.containsKey(j))
    						  map.put(j, Math.max(map.get(j), cnt));
    					  else
    						  map.put(j, cnt);
    				  }
    			  }
    			  if (num == 1)
    				  break;
    		  }
	      }
	      for (Map.Entry<Integer, Integer> entry : map.entrySet())
	    	  answer *= Math.pow(entry.getKey(), entry.getValue());
	      
	      return answer;
	}
}
