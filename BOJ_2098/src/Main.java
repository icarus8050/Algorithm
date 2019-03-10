import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 987654321;
	static int N;
	static int[][] map;
	static int[][] dp;
	static int allVisited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][1 << N];
		allVisited = (1 << N) - 1;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
			
			Arrays.fill(dp[i], INF);
		}
		
		System.out.println(tsp(0, 1));
		br.close();
	}
	
	public static int tsp(int cur, int status) {
		if (allVisited == status) {
			if (map[cur][0] != 0)
				return map[cur][0];
			else
				return INF;
		}
		
		if (dp[cur][status] != INF)
			return dp[cur][status];
		
		for (int i = 0; i < N; i++) {
			if ((status & (1 << i)) == 0 && map[cur][i] != 0)
				dp[cur][status] = Math.min(dp[cur][status], tsp(i, status | (1 << i)) + map[cur][i]);
		}
		return dp[cur][status];
	}
}
