import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int N;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] input;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = input[j] - '0';
			}
		}
		
		int blockNum = 0;
		PriorityQueue<Integer> pri_queue = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] != true && map[i][j] != 0) {
					pri_queue.offer(dfs(j, i, ++blockNum));
				}
			}
		}
		bw.write(blockNum + "\n");
		while (!pri_queue.isEmpty())
			bw.write(pri_queue.poll() + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int dfs(int x, int y, int blockNum) {
		if (visited[y][x] == true)
			return 0;
		
		visited[y][x] = true;
		map[y][x] = blockNum;
		int cnt = 1;
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if (inRange(nx, ny)) {
				cnt += dfs(nx, ny, blockNum);
			}
		}
		return cnt;
	}
	
	public static boolean inRange(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N && map[y][x] != 0);
	}
}
