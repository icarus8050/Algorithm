import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = " " + br.readLine();
		String s2 = " " + br.readLine();
		
		int[][] dp = new int[s1.length()][s2.length()];
		
		for (int i = 0; i < s1.length(); i++) {
			dp[i][0] = i;
		}
		
		for (int i = 0; i < s2.length(); i++) {
			dp[0][i] = i;
		}
		
		for (int i = 1; i < s1.length(); i++) {
			for (int j = 1; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
				}
			}
		}
		
		System.out.println(dp[s1.length() - 1][s2.length() - 1]);
		
		br.close();
	}
}
