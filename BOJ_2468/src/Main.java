import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int N, max = 1;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int h = Integer.parseInt(st.nextToken());
				map[i][j] = h;
				if (!set.contains(h))
					set.add(h);
			}
				
		}
		
		for (int high : set) {
			max = Math.max(max, bfs(high));
			for (boolean[] v : visited)
				Arrays.fill(v, false);
		}
		System.out.println(max);
		br.close();
	}
	
	public static int bfs(int h) {
		int cnt = 0;
		Queue<Pair> queue = new LinkedList<Pair>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > h && !visited[i][j]) {
					queue.offer(new Pair(j, i));
					visited[i][j] = true; 
					while (!queue.isEmpty()) {
						Pair cur = queue.poll();
						for (int c = 0; c < 4; c++) {
							int nx = dx[c] + cur.x;
							int ny = dy[c] + cur.y;
							if (inRange(nx, ny) && map[ny][nx] > h && !visited[ny][nx]) {
								queue.offer(new Pair(nx, ny));
								visited[ny][nx] = true;
							}
						}
					}
					cnt++;
				}
			}
		}
		return cnt;
	}
	public static boolean inRange(int x, int y) {
		return (x >= 0 && x < N) && (y >= 0 && y < N);
	}
}

class Pair {
	int x, y;
	public Pair(int x, int y) {
		this.x = x; this.y = y;
	}
}