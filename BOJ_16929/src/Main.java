import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int startX, startY;
	static boolean flag = false;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			map[i] = input;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				startX = j;
				startY = i;
				dfs(startX, startY, 0, map[startY][startX]);
				if (flag)
					break;
			}
			if (flag)
				break;
		}
		
		if (flag)
			bw.write("Yes\n");
		else
			bw.write("No\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int x, int y, int cnt, char element) {
		if (flag)
			return;
		
		if (visited[y][x] && cnt >= 4 && x == startX && y == startY) {
			flag = true;
			return;
		}
		
		if (visited[y][x])
			return;
		
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if (inRange(nx, ny) && map[ny][nx] == element) {
				dfs(nx, ny, cnt + 1, element);
			}
		}
		visited[y][x] = false;
	}
	
	public static boolean inRange(int x, int y) {
		return (x >= 0 && x < M && y >= 0 && y < N);
	}
}
