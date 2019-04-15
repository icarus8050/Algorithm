import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static boolean[][] isPalindrome;
	static int[] dp;
	static final int MAX = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		int len = str.length();
		isPalindrome = new boolean[len][len];
		dp = new int[len];
		Arrays.fill(dp, -1);
		
		for (int i = 0; i < len; i++) {
			isPalindrome[i][i] = true;
			for (int j = i - 1; j >= 0; j--) {
				if (str.charAt(i) == str.charAt(j))
					isPalindrome[j][i] = isPalindrome[j + 1][i - 1];
				
				//길이가 2인 경우
				if (i - j == 1)	
					isPalindrome[j][i] |= (str.charAt(i) == str.charAt(i - 1));
			}
		}
		
		System.out.println(solve(len - 1));
		sc.close();
	}
	
	public static int solve(int pos) {
		if (pos < 0) return 0;
		if (dp[pos] != -1) return dp[pos];
		
		dp[pos] = MAX;
		for (int i = pos; i >= 0; i--) {
			if (isPalindrome[i][pos]) {
				dp[pos] = Math.min(dp[pos], solve(i - 1) + 1);
			}
		}
		return dp[pos];
	}
}
