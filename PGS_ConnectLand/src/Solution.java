import java.util.PriorityQueue;

public class Solution {

	static int[] parent;
	public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++)
        	parent[i] = i;
        
        PriorityQueue<Edge> pri_queue = new PriorityQueue<Edge>();
        for (int i = 0; i < costs.length; i++) {
        	int a = costs[i][0];
        	int b = costs[i][1];
        	int c = costs[i][2];
        	pri_queue.offer(new Edge(a, b, c));
        }
        
        int cnt = 0;
        for (int i = 0; i < costs.length; i++) {
        	Edge cur = pri_queue.poll();
        	if (merge(cur.a, cur.b)) {
        		answer += cur.c;
        		cnt++;
        	}
        	
        	if (cnt == n - 1) break;
        }
        return answer;
    }
	
	public boolean merge(int u, int v) {
		u = find(u);
		v = find(v);
		if (u == v) return false;
		else {
			parent[u] = v;
			return true;
		}
	}
	public int find(int u) {
		if (parent[u] == u) return u;
		else return parent[u] = find(parent[u]);
	}
}

class Edge implements Comparable<Edge> {
	int a, b, c;
	public Edge(int a, int b, int c) {
		this.a = a; this.b = b; this.c = c;
	}
	@Override
	public int compareTo(Edge o) {
		return c - o.c;
	}
}
