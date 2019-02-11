import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] map;
	static boolean[][] visited;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int maxLand = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] != 0 && !visited[i][j])
					dfs(i, j, ++maxLand);
			}
		}
		
		int result = Integer.MAX_VALUE;
		for (int i = 1; i <= maxLand; i++) {
			result = Math.min(result, bfs(i));
		}
		System.out.println(result);
		br.close();
	}
	
	public static void dfs(int y, int x, int landNum) {
		visited[y][x] = true;
		map[y][x] = landNum;
		for (int i = 0; i < 4; i++) {
			int nextX = dx[i] + x;
			int nextY = dy[i] + y;
			
			if (nextX > 0 && nextX <= N && nextY > 0 && nextY <= N) {
				if (map[nextY][nextX] != 0 && !visited[nextY][nextX]) {
					dfs(nextY, nextX, landNum);
				}
			}
		}
	}
	
	public static int bfs(int landNum) {
		Queue<Position> queue = new LinkedList<Position>();
		int[][] dist = new int[N + 1][N + 1];
		int min = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == landNum) {
					queue.offer(new Position(j, i));
				}
			}
		}
		
		while (!queue.isEmpty()) {
			Position curPos = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = dx[i] + curPos.x;
				int nextY = dy[i] + curPos.y;
				
				if (nextX > 0 && nextY > 0 && nextX <= N && nextY <= N) {
					if (map[nextY][nextX] == 0 && dist[nextY][nextX] == 0) {
						dist[nextY][nextX] = dist[curPos.y][curPos.x] + 1;
						queue.offer(new Position(nextX, nextY));
					}
					else if (map[nextY][nextX] != landNum && map[nextY][nextX] != 0) {
						min = Math.min(min, dist[curPos.y][curPos.x]);
					}
				}
			}
		}
		return min;
	}
}

class Position {
	int x, y;
	public Position(int x, int y) {
		this.x = x; this.y = y;
	}
}
