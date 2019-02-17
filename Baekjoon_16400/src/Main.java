import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int MOD = 123456789;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] primeCheck = new boolean[N + 1];
		
		Arrays.fill(primeCheck, true);
		
		for (int i = 2; i * i <= N; i++) {
			if(primeCheck[i]) {
				for (int j = i * i; j <= N; j += i) {
					primeCheck[j] = false;
				}
			}
		}
		
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		for (int i = 2; i < N + 1; i++) {
			if (primeCheck[i])
				primeList.add(i);
		}
		
		int[] dp = new int[N + 1];
		dp[0] = 1;
		
		for (int i = 0; i < primeList.size(); i++) {
			for (int j = primeList.get(i); j <= N; j++) {
				dp[j] = (dp[j] + dp[j - primeList.get(i)]) % MOD;
			}
		}
		System.out.println(dp[N]);
		sc.close();
	}
}