
public class Solution {

	static int[] dp = new int[100001];
	static final int MOD = 1234567;
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(3));
	}
	public int solution(int n) {
	      dp[0] = 0;
	      dp[1] = 1;
	      for (int i = 2; i <= n; i++)
	    	  dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
	      
	      return dp[n];
	}
}
