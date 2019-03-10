import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static char[][] board;
	static int R, C, N;
	static Queue<Bomb> queue = new LinkedList<Bomb>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (input[j] == 'O') {
					board[i][j] = 'O';
					queue.offer(new Bomb(j, i, 2));
				} else
					board[i][j] = '.';
			}
		}
		
		solve();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void printMap() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
	}
	
	public static void solve() {
		if (N != 1) {
			for (int i = 2; i <= N; i++) {
				if (i % 2 == 0) {
					tick();
					putBomb();
				} else {
					tick();
					explode();
				}
			}
		}
		printMap();
	}
	
	public static void tick() {
		int len = queue.size();
		for (int i = 0; i < len; i++) {
			Bomb bomb = queue.poll();
			bomb.t--;
			queue.offer(bomb);
		}
	}
	
	public static void putBomb() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == '.') {
					board[i][j] = 'O';
					queue.offer(new Bomb(j, i, 3));
				}
			}
		}
	}
	
	public static void explode() {
		int len = queue.size();
		for (int i = 0; i < len; i++) {
			Bomb bomb = queue.poll();
			
			if (bomb.t == 0) {
				board[bomb.y][bomb.x] = '.';
				for (int k = 0; k < 4; k++) {
					int nx = dx[k] + bomb.x;
					int ny = dy[k] + bomb.y;
					if (inRange(nx, ny)) {
						board[ny][nx] = '.';
					}
				}
			} else {
				if (board[bomb.y][bomb.x] != '.')
					queue.offer(bomb);
			}
		}
	}
	
	public static boolean inRange(int x, int y) {
		return (x >= 0 && x < C && y >= 0 && y < R);
	}
}

class Bomb {
	int x, y, t;
	public Bomb(int x, int y, int t) {
		this.x = x; this.y = y; this.t = t;
	}
}