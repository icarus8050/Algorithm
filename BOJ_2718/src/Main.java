import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	static int N;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int t = Integer.parseInt(br.readLine());
		
		while (t-- > 0) {
			N = Integer.parseInt(br.readLine());
			dp = new int[N + 1][4];
			for (int[] arr : dp)
				Arrays.fill(arr, -1);
			
			bw.write(solve(N, 0) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int solve(int n, int state) {
		if (n < 0)
			return 0;
		if (n < 1)
			return (state == 0 ? 1 : 0);
		
		if (dp[n][state] != -1)
			return dp[n][state];
		
		if (state == 0) {
			dp[n][state] = solve(n - 1, 0) + solve(n - 1, 3) + solve(n - 1, 1) * 2 + solve(n - 2, 0);
		} else if (state == 1) {
			dp[n][state] = solve(n - 1, 0) + solve(n - 1, 1);
		} else if (state == 2) {
			dp[n][state] = solve(n - 1, 3);
		} else if (state == 3){
			dp[n][state] = solve(n - 1, 2) + solve(n - 1, 0);
		}
		
		return dp[n][state];
	}
}
