import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int mem;
		int cost;
		public Node(int mem, int cost) {
			this.mem = mem;
			this.cost = cost;
		}
	}
	
	static int N;
	static List<Node>[] adjList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		adjList = new ArrayList[N];
		
		for (int i = 0; i < N; i++)
			adjList[i] = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent == -1) continue;
			
			adjList[parent].add(new Node(i, 0));
		}
		
		System.out.println(dfs(0));
		br.close();
	}
	
	public static int dfs(int here) {
		int ret = 0;
		
		for (int i = 0; i < adjList[here].size(); i++) {
			int next = adjList[here].get(i).mem;
			adjList[here].get(i).cost = 1 + dfs(next);
		}
		
		Collections.sort(adjList[here], (a, b) -> {
			return b.cost - a.cost;
		});
		
		for (int i = 0; i < adjList[here].size(); i++) {
			adjList[here].get(i).cost += i;
			ret = Math.max(ret, adjList[here].get(i).cost);
		}
		
		return ret;
	}
}
