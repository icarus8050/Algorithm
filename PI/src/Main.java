import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] dp;
	static String pi;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(br.readLine());
		
		while (C-- > 0) {
			pi = br.readLine();
			dp = new int[pi.length()];
			System.out.println(solve(0));
		}
	}
	
	public static int solve(int begin) {
		
		if (begin == pi.length()) return 0;
		
		if (dp[begin] != 0) return dp[begin];
		
		dp[begin] = 999999999;
		
		for (int i = 3; i <= 5; i++) {
			if (begin + i <= pi.length()) {
				dp[begin] = Math.min(dp[begin], solve(begin + i) + classify(begin, begin + i - 1));
			}
		}
		return dp[begin];
	}
	
	public static int classify(int begin, int end) {
		char[] ch = pi.substring(begin, end + 1).toCharArray();
		boolean same_flag = true;
		for (int i = 1; i < ch.length; i++) {
			if (ch[0] != ch[i]) {
				same_flag = false;
				break;
			}
		}
		if (same_flag) return 1;
		
		boolean sequence_flag = true;
		int d = ch[1] - ch[0];
		for (int i = 0; i < ch.length - 1; i++) {
			if (ch[i + 1] - ch[i] != d) {
				sequence_flag = false;
				break;
			}
		}
		if (sequence_flag && Math.abs(d) == 1) return 2;
		
		boolean alternate_flag = true;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] != ch[i % 2]) {
				alternate_flag = false;
				break;
			}
		}
		if (alternate_flag) return 4;
		if (sequence_flag) return 5;
		
		return 10;
	}
}
