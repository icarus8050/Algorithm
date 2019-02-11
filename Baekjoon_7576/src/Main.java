import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] adjMat;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, M, days;
	static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		days = -1;
		flag = true;
		Queue<Position> queue_1 = new LinkedList<Position>();
		Queue<Position> queue_2 = new LinkedList<Position>();
		
		adjMat = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				int tomato = Integer.parseInt(st.nextToken());
				adjMat[i][j] = tomato;
				if (tomato == 1)
					queue_1.offer(new Position(j, i));
			}
		}
		
		while(!queue_1.isEmpty() || !queue_2.isEmpty()) {
			if (flag) {
				BFS(queue_1, queue_2);
				flag = false;
			} else {
				BFS(queue_2, queue_1);
				flag = true;
			}
			days++;
		}
		
		if (check())
			bw.write(days + "\n");
		else
			bw.write(-1 + "\n");
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void BFS(Queue<Position> queue, Queue<Position> nextQueue) {
		while (!queue.isEmpty()) {
			Position pos = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = dx[i] + pos.x;
				int nextY = dy[i] + pos.y;
				
				if (
						nextX > 0 && nextY > 0
						&& nextX <= M && nextY <= N
						&& adjMat[nextY][nextX] == 0
						)
				{
					adjMat[nextY][nextX] = 1;
					nextQueue.offer(new Position(nextX, nextY));
				}
			}
		}
	}
	static boolean check() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (adjMat[i][j] == 0)
					return false;
			}
		}
		return true;
	}
	static class Position {
		int x;
		int y;
		public Position (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
