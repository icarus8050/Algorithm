import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	
	static int M, N, K, cnt;
	static boolean[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		List<Integer> area = new ArrayList<>();
		
		map = new boolean[M][N];
		visited = new boolean[M][N];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int leftDown_x = Integer.parseInt(st.nextToken());
			int leftDown_y = Integer.parseInt(st.nextToken());
			int rightUp_x = Integer.parseInt(st.nextToken());
			int rightUp_y = Integer.parseInt(st.nextToken());
			
			for (int row = leftDown_y; row < rightUp_y; row++) {
				for (int col = leftDown_x; col < rightUp_x; col++) {
					map[row][col] = true;
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && !map[i][j]) {
					cnt ++;
					area.add(dfs(j, i));
				}
			}
		}
		
		List<String> result = area.stream()
				.sorted()
				.map(num -> Integer.toString(num))
				.collect(Collectors.toList());
		
		bw.write(cnt + "\n");
		bw.write(String.join(" ", result) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int dfs(int x, int y) {
		if (visited[y][x])
			return 0;
		
		visited[y][x] = true;
		int ret = 1;
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if (inRange(nx, ny) && !map[ny][nx]) {
				ret += dfs(nx, ny);
			}
		}
		
		return ret;
	}
	
	public static boolean inRange(int x, int y) {
		return ((x >= 0 && x < N) && (y >= 0 && y < M));
	}
}
