import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, cnt;
	static int[] workers;
	static int[] job;
	static int[][] adjMat;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjMat = new int[N + 1][M + 1];
		
		workers = new int[N + 1];
		Arrays.fill(workers, -1);
		job = new int[M + 1];
		Arrays.fill(job, -1);
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			for (int k = 0; k < x; k++) {
				int j = Integer.parseInt(st.nextToken());
				adjMat[i][j] = 1;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			if (dfs(i))
				cnt++;
		}
		System.out.println(cnt);
		br.close();
	}
	
	public static boolean dfs(int here) {
		if (visited[here]) return false;
		
		visited[here] = true;
		for (int i = 1; i <= M; i++) {
			if (adjMat[here][i] == 1) {
				
				if (job[i] == -1 || dfs(job[i])) {
					workers[here] = i;
					job[i] = here;
					return true;
				}
			}
		}
		return false;
	}
}
