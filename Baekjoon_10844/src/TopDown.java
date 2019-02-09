import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TopDown {

	static int[][] dp;
	static int MOD = 1000000000;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int ans = 0;
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][10];
		
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < 10; j++) {
				dp[i][j] = -1;
			}
		}
		
		for (int x = 0; x < 10; x++) {
			ans = (ans + solve(N, x)) % MOD;
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int solve(int n, int x) {
		if (n == 1)
			return x == 0 ? 0 : 1;
		
		if (dp[n][x] != -1)
			return dp[n][x];
		
		if (x == 0) {
			return dp[n][x] = solve(n - 1, 1) % MOD;
		} else if (x == 9) {
			return dp[n][x] = solve(n - 1, 8) % MOD;
		} else {
			return dp[n][x] = (solve(n - 1, x - 1) + solve(n - 1, x + 1)) % MOD;
		}
	}
}
