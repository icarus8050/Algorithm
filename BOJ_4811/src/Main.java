import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N;
	static long dp[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			
			dp = new long[N + 1][N + 1];
			sb.append(dfs(N, 0)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static long dfs(int one, int half) {
		if (one == 0 && half == 0)
			return 1;
		
		if (dp[one][half] != 0)
			return dp[one][half];
		
		if (one > 0)
			dp[one][half] += dfs(one - 1, half + 1);
		
		if (half > 0)
			dp[one][half] += dfs(one, half - 1);
		
		return dp[one][half];
	}
}
