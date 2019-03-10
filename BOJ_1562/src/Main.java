import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static long[][][] dp;
	static final int MOD = 1000000000;
	static int ALL = 1 << 10;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new long[N + 1][10][ALL];
		
		for (int i = 1; i < 10; i++)
			dp[1][i][1 << i] = 1;
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < ALL; k++) {
					int status = k | (1 << j);
					
					if (j > 0)
						dp[i][j][status] = (dp[i][j][status] + dp[i - 1][j - 1][k]) % MOD;
					
					if (j < 9)
						dp[i][j][status] = (dp[i][j][status] + dp[i - 1][j + 1][k]) % MOD;
				}
			}
		}
		
		long result = 0;
		for (int i = 0; i < 10; i++)
			result = (result + dp[N][i][ALL - 1]) % MOD;
		
		System.out.println(result);
		br.close();
	}
}
