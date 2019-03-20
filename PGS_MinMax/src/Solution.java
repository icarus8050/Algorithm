import java.util.StringTokenizer;

public class Solution {

	public String solution(String s) {
	      StringBuilder sb = new StringBuilder();
	      StringTokenizer st = new StringTokenizer(s);
	      int min = Integer.MAX_VALUE;
	      int max = Integer.MIN_VALUE;
	      
	      while (st.hasMoreTokens()) {
	    	  int num = Integer.parseInt(st.nextToken());
	    	  max = Math.max(max, num);
	    	  min = Math.min(min, num);
	      }
	      sb.append(min).append(" ").append(max);
	      return sb.toString();
	  }
}
