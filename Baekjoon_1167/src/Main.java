import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Node>[] adjList;
	static boolean[] visited;
	static int diameter = 0;
	static int farthest = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int V = Integer.parseInt(br.readLine());
		adjList = new ArrayList[V + 1];
		visited = new boolean[V + 1];
		
		for (int i = 1; i <= V; i++)
			adjList[i] = new ArrayList<Node>();
		
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			while (true) {
				int b = Integer.parseInt(st.nextToken());
				
				if (b == -1) break;
				int c = Integer.parseInt(st.nextToken());
				adjList[a].add(new Node(b, c));
			}
		}
		dfs(1, 0);
		Arrays.fill(visited, false);
		diameter = 0;
		dfs(farthest, 0);
		System.out.println(diameter);
		
		br.close();
	}
	
	public static void dfs(int node, int cost) {
		if (visited[node])
			return;
		visited[node] = true;
		if (cost > diameter) {
			diameter = cost;
			farthest = node;
		}
		
		for (Node toNode : adjList[node]) {
			dfs(toNode.to, cost + toNode.cost);
		}
	}
}

class Node {
	int to, cost;
	public Node(int to, int cost) {
		this.to = to; this.cost = cost;
	}
}