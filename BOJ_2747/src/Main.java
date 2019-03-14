import java.util.Scanner;

public class Main {

	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		dp = new int[N + 1];
		System.out.println(f(N));
	}
	
	public static int f(int num) {
		if (dp[num] != 0)
			return dp[num];
		
		if (num == 1 || num == 2)
			return dp[num] = 1;
		
		return dp[num] = f(num - 1) + f(num - 2);
	}
}
