import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, mid;
	static List<Integer>[] heavier;
	static List<Integer>[] lighter;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mid = (N + 1) / 2;
		
		int ans = 0;
		visited = new boolean[N + 1];
		heavier = new ArrayList[N + 1];
		lighter = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			heavier[i] = new ArrayList<>();
			lighter[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			heavier[a].add(b);
			lighter[b].add(a);
		}
		
		for (int i = 1; i <= N; i++) {
			Arrays.fill(visited, false);
			if (dfs(i, heavier) > mid) {
				ans++;
				continue;
			}
			
			Arrays.fill(visited, false);
			if (dfs(i, lighter) > mid) {
				ans++;
			}
		}
		
		System.out.println(ans);
		br.close();
	}
	
	static int dfs(int node, List<Integer>[] adjList) {
		visited[node] = true;
		int ret = 1;
		for (int i = 0; i < adjList[node].size(); i++) {
			if (!visited[adjList[node].get(i)]) {
				ret += dfs(adjList[node].get(i), adjList);
			}
		}
		
		return ret;
	}
}
