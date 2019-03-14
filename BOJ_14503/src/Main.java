import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int N, M, ans = 0;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static int[] bx = {0, -1, 0, 1};
	static int[] by = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int direction = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		solve(x, y, direction);
		System.out.println(ans);
		br.close();
	}
	
	public static void solve(int x, int y, int direction) {
		
		if (map[y][x] == 1) return;
		
		if (map[y][x] == 0) {
			map[y][x] = 2;
			ans++;
		}
		
		for (int i = 0; i < 4; i++) {
			int next_direction = (direction - 1 >= 0) ? direction - 1 : 3;
			int nextX = x + dx[next_direction];
			int nextY = y + dy[next_direction];
			
			if (map[nextY][nextX] == 0) {
				solve(nextX, nextY, next_direction);
				return;
			}
			direction = next_direction;
		}
		int nextX = x + bx[direction];
		int nextY = y + by[direction];
		solve(nextX, nextY, direction);
	}
}
