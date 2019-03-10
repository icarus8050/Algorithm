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
	static int[][] map;
	static int[][][] cache;
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		cache = new int[2][N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 1; j <= M; j++) {
				map[i][j] = input[j - 1] - '0';
			}
		}
		cache[0][1][1] = 1;
		bw.write(bfs() + "\n");
		bw.flush();
		bw.close();
		br.close();		
	}
	
	public static int bfs() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(1, 1, 0));
		
		while (!queue.isEmpty()) {
			Node curNode = queue.poll();
			
			if (curNode.x == M && curNode.y == N) {
				return cache[curNode.crash][curNode.y][curNode.x];
			}
			
			for (int i = 0; i < 4; i++) {
				int nextX = dx[i] + curNode.x;
				int nextY = dy[i] + curNode.y;
				if (nextX >= 1 && nextX <= M && nextY >= 1 && nextY <= N) {
					if (map[nextY][nextX] == 1 && curNode.crash == 0) {
						cache[curNode.crash + 1][nextY][nextX] = cache[curNode.crash][curNode.y][curNode.x] + 1;
						queue.offer(new Node(nextX, nextY, curNode.crash + 1));
					}
					else if (map[nextY][nextX] == 0 && cache[curNode.crash][nextY][nextX] == 0) {
						cache[curNode.crash][nextY][nextX] = cache[curNode.crash][curNode.y][curNode.x] + 1;
						queue.offer(new Node(nextX, nextY, curNode.crash));
					}
				}
			}
		}
		
		return -1;
	}
}
class Node {
	int x, y, crash;
	public Node(int x, int y, int crash) {
		this.x = x; this.y = y; this.crash = crash;
	}
}
