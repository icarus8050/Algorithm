import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char[][] map;
	static boolean[] visited = new boolean[26];
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int res = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			char[] input = br.readLine().toCharArray();
			map[i] = input;
		}
		visited[map[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		System.out.println(res);
		br.close();
	}
	
	public static void dfs(int x, int y, int cnt) {
		
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if (inRange(nx, ny) && !visited[map[ny][nx] - 'A']) {
				visited[map[ny][nx] - 'A'] = true;
				dfs(nx, ny, cnt + 1);
				visited[map[ny][nx] - 'A'] = false;
			}
		}
		res = Math.max(res, cnt);
	}
	
	public static boolean inRange(int x, int y) {
		return (x >= 0 && x < C && y >= 0 && y < R);
	}
}
