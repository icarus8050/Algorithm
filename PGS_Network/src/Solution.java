
public class Solution {

	static int[] parent;
	public int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++)
        	parent[i] = i;
        
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (i == j) continue;
        		if (computers[i][j] == 1) merge(i, j);
        	}
        }
        for (int i = 0; i < n; i++) {
        	if (parent[i] == i) answer++;
        }
        return answer;
    }
	
	public int find(int u) {
		if (parent[u] == u) return u;
		else return parent[u] = find(parent[u]);
	}
	
	public void merge(int u, int v) {
		u = find(u);
		v = find(v);
		if (u == v) return;
		else {
			parent[u] = v;
			return;
		}
	}
}
