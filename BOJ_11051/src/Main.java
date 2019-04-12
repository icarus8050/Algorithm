import java.util.Scanner;

public class Main {

	static int n, k;
	static int[][] dp;
	static final int MOD = 10_007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		dp = new int[n + 1][k + 1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				if (i == j || j == 0) {
					dp[i][j] = 1;
					continue;
				}
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
			}
		}
		System.out.println(dp[n][k]);
		sc.close();
	}
}
