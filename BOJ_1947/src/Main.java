import java.util.Scanner;

public class Main {

	static int N;
	static long[] dp = new long[1_000_001];
	static final int MOD = 1_000_000_000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		dp[1] = 0;
		dp[2] = 1;
		for (int i = 3; i <= N; i++) {
			dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]) % MOD;
		}
		System.out.println(dp[N]);
		sc.close();
	}
}
