import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0, node;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[N + 1];
		ArrayList<Integer>[] adjList = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++)
			adjList[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adjList[u].add(v);
			adjList[v].add(u);
		}
		
		while ((node = unvisitedCheck(visited)) != 0) {
			result++;
			dfs(adjList, visited, node);
		}
		System.out.println(result);
	}
	
	public static int unvisitedCheck(boolean[] visited) {
		for (int i = 1; i < visited.length; i++) {
			if (!visited[i])
				return i;
		}
		return 0;
	}
	
	public static void dfs(ArrayList<Integer>[] adjList, boolean[] visited, int start) {
		if (visited[start])
			return;
		
		visited[start] = true;
		
		for (int end : adjList[start]) {
			if (!visited[end])
				dfs(adjList, visited, end);
		}
	}
}
