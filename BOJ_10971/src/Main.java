import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int INF = Integer.MAX_VALUE;
	static int[][] map;
	static int N;
	static int start;
	static int result = INF;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			start = i;
			dfs(start, 0, 0);
		}
		if (result != INF)
			bw.write(result + "\n");
		else
			bw.write(-1 + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int node, int cnt, int sum) {
		if (!visited[node]) {
			visited[node] = true;
			cnt++;
			
			for (int i = 0; i < N; i++) {
				if (map[node][i] != 0)
					dfs(i, cnt, sum + map[node][i]);
			}
			visited[node] = false;
		}
		
		if (start == node && cnt == N)
			result = Math.min(result, sum);
	}
}
