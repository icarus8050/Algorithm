import java.util.Scanner;

public class Main {

	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new int[31];
		
		dp[0] = 1;
		dp[1] = 0;
		dp[2] = 3;
		
		for (int i = 3; i <= N; i++) {
			dp[i] += dp[i - 2] * dp[2];
			
			for (int j = 4; j <= i; j += 2) {
				dp[i] += dp[i - j] * 2;
			}
		}
		
		System.out.println(dp[N]);
	}
}
