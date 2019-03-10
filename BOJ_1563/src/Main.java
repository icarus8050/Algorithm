import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[][][] dp;
	static int result = 0;
	static final int MOD = 1000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][2][3];
		
		System.out.println(dfs(0, 0, 0));
		br.close();
	}
	
	public static int dfs(int day, int late, int absence) {
		if (day == N)
			return 1;
		
		if (dp[day][late][absence] != 0)
			return dp[day][late][absence];
		
		if (late < 1)
			dp[day][late][absence] = (dp[day][late][absence] + dfs(day + 1, late + 1, 0)) % MOD;
		
		if (absence < 2)
			dp[day][late][absence] = (dp[day][late][absence] + dfs(day + 1, late, absence + 1)) % MOD;
		
		return dp[day][late][absence] = (dp[day][late][absence] + dfs(day + 1, late, 0)) % MOD;
	}
}
