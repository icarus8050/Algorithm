import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		int result = 0, count = 0;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N + 1];
		
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			queue.offer(new Edge(a, b, c));
		}
		
		for (int i = 0; i < M; i++) {
			Edge temp = queue.poll();
			if ( merge(temp.a, temp.b) ) {
				result += temp.c;
				count++;
			}
			if (count == N - 1)
				break;
		}
		bw.write(result + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
	
	static int find(int u) {
		if (parent[u] == u)
			return u;
		
		return parent[u] = find(parent[u]);
	}
	
	static boolean merge(int u, int v) {
		u = find(u);
		v = find(v);
		
		if (u == v)
			return false;
		
		parent[u] = v;
		return true;
	}
	
	static class Edge implements Comparable<Edge>{

		int a;
		int b;
		int c;
		
		public Edge(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		@Override
		public int compareTo(Edge target) {
			// TODO Auto-generated method stub
			return this.c - target.c;
		}
		
	}
}
