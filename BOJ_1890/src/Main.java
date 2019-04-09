import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static long[][] dp;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new long[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int jump = map[i][j];
				
				if (dp[i][j] == 0 || jump == 0)
					continue;
				
				if (i + jump < N) {
					dp[i + jump][j] += dp[i][j];
				}
				
				if (j + jump < N) {
					dp[i][j + jump] += dp[i][j];
				}
			}
		}
		System.out.println(dp[N - 1][N - 1]);
		br.close();
	}
}
