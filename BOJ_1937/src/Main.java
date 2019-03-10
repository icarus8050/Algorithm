import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static int[][] dp;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int res = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				res = Math.max(res, move(j, i));
			}
		}
		System.out.println(res);
		br.close();
	}
	public static int move(int x, int y) {
		if (dp[y][x] != 0)
			return dp[y][x];
		
		dp[y][x] = 1;
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if (inRange(nx, ny) && (map[ny][nx] > map[y][x])) {
				dp[y][x] = Math.max(dp[y][x], move(nx, ny) + 1);
			}
		}
		return dp[y][x];
	}
	
	
	public static boolean inRange(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y <N);
	}
}
