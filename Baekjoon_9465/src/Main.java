import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[][] s;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			s = new int [2][n + 1];
			dp = new int[2][n + 1];
			
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					s[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dp[0][1] = s[0][1];
			dp[1][1] = s[1][1];
			
			for (int i = 2; i <= n; i++) {
				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + s[0][i];
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + s[1][i];
			}
			
			bw.write(Math.max(dp[0][n], dp[1][n]) + "\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
}
