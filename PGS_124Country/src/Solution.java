
public class Solution {
	public static void main(String[] args) {
		System.out.println(solution(1));
		System.out.println(solution(2));
		System.out.println(solution(3));
		System.out.println(solution(4));
		System.out.println(solution(5));
		System.out.println(solution(6));
		System.out.println(solution(10));
		System.out.println(solution(11));
	}
	public static String solution(int n) {
	      String answer = "";
	      int a;
	      while (n > 0) {
	    	  a = n % 3;
	    	  n /= 3;
	    	  if (a == 0) {
	    		  a = 4;
	    		  n--;
	    	  }
	    	  answer = a + answer;
	      }
	      return answer;
	  }
}