import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int[] dp;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		dp = new int[N + 1];
		Arrays.fill(dp, -1);
		
		dp[0] = dp[1] = 0;
		System.out.println(solve(N));
		sc.close();
	}
	
	public static int solve(int i) {
		if (dp[i] != -1) return dp[i];
		
		int min = Integer.MAX_VALUE;
		
		if (i % 3 == 0) min = Math.min(min, solve(i / 3));
		if (i % 2 == 0) min = Math.min(min, solve(i / 2));
		min = Math.min(min, solve(i - 1));
		
		return dp[i] = min + 1;
	}
}
