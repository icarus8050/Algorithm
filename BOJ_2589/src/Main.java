import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int N, M;
	static char[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new char[N][M];
		
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 'W') {
					int[][] dist = new int[N][M];
					Queue<Pair> queue = new LinkedList<Pair>();
					
					queue.offer(new Pair(j, i));
					while (!queue.isEmpty()) {
						Pair cur = queue.poll();
						for (int k = 0; k < 4; k++) {
							int nx = dx[k] + cur.x;
							int ny = dy[k] + cur.y;
							
							if (inRange(nx, ny) && map[ny][nx] != 'W' && dist[ny][nx] == 0) {
								queue.offer(new Pair(nx, ny));
								dist[ny][nx] = dist[cur.y][cur.x] + 1;
								ans = Math.max(ans, dist[ny][nx]);
							}
						}
					}
				}
			}
		}
		
		System.out.println(ans);
		br.close();
	}
	
	public static boolean inRange(int x, int y) {
		return (x >= 0 && x < M && y >= 0 && y < N);
	}
}
class Pair {
	int x, y;
	public Pair(int x, int y) {
		this.x = x; this.y = y;
	}
}