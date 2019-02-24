import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static double[] probability = new double[4];
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[100][100];
		visited = new boolean[100][100];
		
		for (int i = 0; i < 4; i++)
			probability[i] = Integer.parseInt(st.nextToken()) / 100.0;
		
		double ans = dfs(49, 49, 0);
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static double dfs(int x, int y, int n) {
		if (visited[y][x]) return 0;
		if (n == N) return 1;
		visited[y][x] = true;
		double result = 0;
		
		for (int i = 0; i < 4; i++) {
			int nextX = dx[i] + x;
			int nextY = dy[i] + y;
			result += dfs(nextX, nextY, n + 1) * probability[i];
		}
		visited[y][x] = false;
		
		return result;
	}
}
