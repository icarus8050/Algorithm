import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 987654321;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[][] dp = new int[N + 1][N + 1];
			int[] sum = new int[N + 1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++)
				sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
			
			for (int k = 1; k < N; k++) {
				for (int i = 1; i <= N - k; i++) {
					dp[i][i + k] = INF;
					for (int j = i; j < i + k; j++)
						dp[i][i + k] = Math.min(dp[i][i + k], dp[i][j] + dp[j + 1][i + k]);
					dp[i][i + k] += sum[i + k] - sum[i - 1];
				}
			}
			bw.write(dp[1][N] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
