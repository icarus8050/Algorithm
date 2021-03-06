import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static int[][] dp;
	public static int MOD = 10007;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int ans = 0;
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][10];
		
		for (int i = 0; i < 10; i++)
			dp[1][i] = 1;
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k <= j; k++) {
					dp[i][j] = (dp[i][j] + dp[i-1][k]) % MOD;
				}
			}
		}
		
		for (int i = 0; i <10; i++) {
			ans = (ans + dp[N][i]) % MOD;
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
