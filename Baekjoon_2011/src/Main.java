import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static int MOD = 1000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String cipher = br.readLine();
		
		if (cipher.charAt(0) == '0') {
			System.out.println("0");
		} else {
			int[] dp = new int[cipher.length() + 1];
			
			dp[0] = 1;
			dp[1] = 1;
			
			for (int i = 2; i <= cipher.length(); i++) {
				if (cipher.charAt(i - 1) != '0')
					dp[i] = dp[i - 1] % MOD;
				
				if (cipher.charAt(i - 2) == '1' || cipher.charAt(i - 2) == '2' && cipher.charAt(i - 1) <= '6')
					dp[i] += dp[i - 2] % MOD;
			}
			
			System.out.println(dp[cipher.length()] % MOD);
		}
		
		br.close();
	}
}
