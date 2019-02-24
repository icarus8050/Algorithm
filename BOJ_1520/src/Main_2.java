import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2 {

	static int M, N;
	static int[][] map;
	static int[][] dp;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		dp = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		int result = dfs(0, 0);
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int dfs(int x, int y) {
		if (x == N - 1 && y == M - 1) return 1;
		
		if (dp[y][x] != -1) return dp[y][x];
		
		dp[y][x] = 0;
		for (int i = 0; i < 4; i++) {
			int nextX = dx[i] + x;
			int nextY = dy[i] + y;
			
			if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M
					&& map[y][x] > map[nextY][nextX])
			{
				dp[y][x] += dfs(nextX, nextY);
			}
		}
		
		return dp[y][x];
	}
}
