import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Edge> pri_queue = new PriorityQueue<Edge>();
		int edgeCount = 0;
		int ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		parent = new int[V + 1];
		
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pri_queue.offer(new Edge(a, b, c));
		}
		
		while(!pri_queue.isEmpty()) {
			Edge edge = pri_queue.poll();
			if (merge(edge.a, edge.b))
				ans += edge.cost;
			
			if (edgeCount == V - 1)
				break;
		}
		bw.write(ans + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int find(int u) {
		if (u == parent[u])
			return u;
		
		return parent[u] = find(parent[u]);
	}
	
	public static boolean merge(int u, int v) {
		u = find(u);
		v = find(v);
		
		if (u == v)
			return false;
		
		parent[u] = v;
		return true;
	}
}

class Edge implements Comparable<Edge> {
	int a;
	int b;
	int cost;
	public Edge(int a, int b, int cost) {
		this.a = a;
		this.b = b;
		this.cost = cost;
	}
	@Override
	public int compareTo(Edge target) {
		// TODO Auto-generated method stub
		return this.cost - target.cost;
	}
}