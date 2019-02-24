import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] arr = new int[T + 1];
		int[][] dp = new int[T + 1][W + 1];
		
		for (int i = 1; i <= T; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		for (int i = 1; i <= T; i++) {
			if (arr[i] == 1)
				dp[i][0] = dp[i - 1][0] + 1;
			else
				dp[i][0] = dp[i - 1][0];
			
			for (int j = 1; j <= W; j++) {
				if (arr[i] == 1 && j % 2 == 0)
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + 1;
				else if (arr[i] == 2 && j % 2 == 1)
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
				
			}
		}
		
		for (int i = 0; i <= W; i++)
			result = Math.max(result, dp[T][i]);
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
