import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] dp;
	static int[] arr;
	static int[][] minArr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n][n];
		minArr = new int[n][n];
		
		for (int[] row : dp)
			Arrays.fill(row, -1);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			minArr[i][i] = arr[i];
			for (int j = i + 1; j < n; j++)
				minArr[i][j] = Math.min(minArr[i][j - 1], arr[j]);
		}
		
		bw.write(solve(0, n - 1) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int solve(int s, int e) {
		if (dp[s][e] != -1) return dp[s][e];
		
		if (s == e) return dp[s][e] = 0;
		
		dp[s][e] = Integer.MAX_VALUE;
		
		for (int k = s; k < e; k++)
			dp[s][e] = Math.min(dp[s][e], solve(s, k) + solve(k + 1, e) + Math.abs(minArr[s][k] - minArr[k + 1][e]));
		
		return dp[s][e];
	}
}
