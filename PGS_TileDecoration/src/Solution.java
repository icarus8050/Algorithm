
public class Solution {

	static long[] dp;
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(5));
	}
	public long solution(int N) {
        long answer = 0;
        dp = new long[N + 1];
        solve(N);
        answer = dp[N] * 2 + dp[N - 1] * 2;
        return answer;
    }
	
	public long solve(int N) {
		if (N == 0)
			return 1;
		
		if (N == 1)
			return 1;
		
		if (dp[N] != 0)
			return dp[N];
		
		return dp[N] = solve(N - 1) + solve(N - 2);
	}
}
