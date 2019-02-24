
public class BadNeighbors {

	public int maxDonations(int[] donations) {
		
		int result = 0;
		int N = donations.length;
		int[] dp = new int[N];
		
		for (int i = 0; i < N - 1; i++) {
			dp[i] = donations[i];
			
			if (i > 0)
				dp[i] = Math.max(dp[i], dp[i - 1]);
			
			if (i > 1)
				dp[i] = Math.max(dp[i], dp[i - 2] + donations[i]);
			
			result = Math.max(result, dp[i]);
		}
		
		for (int i = 1; i < N; i++) {
			dp[i] = donations[i];
			
			if (i > 1)
				dp[i] = Math.max(dp[i], dp[i - 1]);
			
			if (i > 2)
				dp[i] = Math.max(dp[i], dp[i - 2] + donations[i]);
			
			result = Math.max(result, dp[i]);
		}
		
		return result;
	}
}
