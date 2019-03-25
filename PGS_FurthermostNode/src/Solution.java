import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] arr = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(sol.solution(6, arr));
	}
	static final int INF = 9999999;
	public int solution(int n, int[][] edge) {
        int answer = 0;
        int max = 0;
        int[] dist = new int[n + 1];
        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
        	dist[i] = INF;
        	adjList[i] = new ArrayList<Integer>();
        }
        
        for (int[] e: edge) {
        	adjList[e[0]].add(e[1]);
        	adjList[e[1]].add(e[0]);
        }
        
        dijkstra(dist, adjList);
        for (int d: dist) {
        	if (d != INF)
        		max = Math.max(max, d);
        }
        
        for (int d: dist) {
        	if (d == max)
        		answer++;
        }
        return answer;
    }
	
	public void dijkstra(int[] dist, ArrayList<Integer>[] adjList) {
		dist[1] = 0;
		PriorityQueue<Integer> pri_queue = new PriorityQueue<Integer>();
		pri_queue.offer(1);
		
		while (!pri_queue.isEmpty()) {
			int from = pri_queue.poll();
			
			for (int to: adjList[from]) {
				if (dist[to] > dist[from] + 1) {
					dist[to] = dist[from] + 1;
					pri_queue.offer(to);
				}
			}
		}
	}
}
