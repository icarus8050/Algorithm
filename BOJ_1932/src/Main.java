import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] mat;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		mat = new int[n + 1][n + 1];
		dp = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++)
				mat[i][j] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		dp[1][1] = mat[1][1];
		
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) 
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + mat[i][j];
		}
		
		for (int i = 1; i <= n; i++)
			result = Math.max(result, dp[n][i]);
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
