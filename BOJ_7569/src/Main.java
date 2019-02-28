import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, H, days = 0;
	static int[][][] basket = new int[H][N][M];
	static int[] dx = {-1, 0, 1, 0, 0, 0};
	static int[] dy = {0, -1, 0, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int ripen = 0;
		basket = new int[H][N][M];
		ArrayList<Point> ripenList = new ArrayList<Point>();
		
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					int tomato = Integer.parseInt(st.nextToken());
					basket[h][n][m] = tomato;
					if (tomato == 1) {
						ripenList.add(new Point(h, n, m));
						ripen++;
					}
				}
			}
		}
		
		if (ripen == H * N * M) {
			days = 0;
		} else if (ripen == 0) {
			days = -1;
		} else {
			for (Point pos : ripenList) {
				bfs(pos.h, pos.n, pos.m);
			}
			days = check();
		}
		bw.write(days + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void bfs(int z, int y, int x) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(z, y, x));
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for (int i = 0; i < 6; i++) {
				int nextZ = dz[i] + cur.h;
				int nextY = dy[i] + cur.n;
				int nextX = dx[i] + cur.m;
				if (inRange(nextZ, nextY, nextX) && basket[nextZ][nextY][nextX] != -1) {
					if (basket[nextZ][nextY][nextX] == 0 || basket[nextZ][nextY][nextX] > basket[cur.h][cur.n][cur.m] + 1) {
						basket[nextZ][nextY][nextX] = basket[cur.h][cur.n][cur.m] + 1;
						queue.offer(new Point(nextZ, nextY, nextX));
					}
				}
			}
		}
	}
	
	public static boolean inRange(int z, int y, int x) {
		return (z >= 0 && z < H) && (y >= 0 && y < N) && (x >= 0 && x < M);
	}
	
	public static int check() {
		int result = 0;
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (basket[h][n][m] == 0)
						return -1;
					result = Math.max(result, basket[h][n][m]);
				}
			}
		}
		return result - 1;
	}
}

class Point {
	int h, n, m;
	public Point(int h, int n, int m) {
		this.h = h; this.n = n; this.m = m;
	}
}
