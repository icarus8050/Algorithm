import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long[] dp;
		int T = sc.nextInt();
		
		while (T-- > 0) {
			int N = sc.nextInt();
			
			dp = new long[101];
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			dp[4] = 2;
			dp[5] = 2;
			
			for (int i = 6; i <= N; i++) {
				dp[i] = dp[i - 1] + dp[i - 5];
			}
			System.out.println(dp[N]);
		}
		
	}
}
