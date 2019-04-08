import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int n;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int startX, startY;
	static int desX, desY;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			n = Integer.parseInt(br.readLine());
			board = new int[n][n];
			visited = new boolean[n][n];
			
			input = br.readLine().split(" ");
			startX = Integer.parseInt(input[0]);
			startY = Integer.parseInt(input[1]);
			input = br.readLine().split(" ");
			desX = Integer.parseInt(input[0]);
			desY = Integer.parseInt(input[1]);
			
			bw.write(bfs() + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int bfs() {
		int ans = 0;
		Queue<Position> queue = new LinkedList<>();
		queue.offer(new Position(startX, startY, 0));
		
		while (!queue.isEmpty()) {
			Position curPos = queue.poll();
			
			if (curPos.x == desX && curPos.y == desY) {
				ans = curPos.count;
				break;
			}
			
			for (int i = 0; i < 8; i++) {
				int nx = curPos.x + dx[i];
				int ny = curPos.y + dy[i];
				
				if (inRange(nx, ny) && !visited[ny][nx]) {
					visited[ny][nx] = true;
					queue.offer(new Position(nx, ny, curPos.count + 1));
				}
			}
		}
		
		return ans;
	}
	
	public static boolean inRange(int x, int y) {
		return (x >= 0 && x < n && y >= 0 && y < n);
	}
}

class Position {
	int x, y;
	int count;
	public Position(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}