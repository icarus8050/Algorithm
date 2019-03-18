import java.util.PriorityQueue;

public class Solution {

	static final int INF = 1000001;
	public static void main(String[] args) {
		int N = 5;
		int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
		int K = 3;
		int res = solution(N, road, K);
		System.out.println(res);
	}
	public static int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] adjMat = new int[N + 1][N + 1];
        int[] dist = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
        	dist[i] = INF;
        	for (int j = 1; j <= N; j++)
        		adjMat[i][j] = INF;
        }
        
        for (int i = 0; i < road.length; i++) {
        	int a = road[i][0];
        	int b = road[i][1];
        	int c = road[i][2];
        	
        	adjMat[a][b] = Math.min(adjMat[a][b], c);
        	adjMat[b][a] = Math.min(adjMat[b][a], c);
        }
        dijkstra(N, 1, adjMat, dist);
        for (int i = 1; i <= N; i++) {
        	if (dist[i] <= K)
        		answer++;
        }

        return answer;
    }
	public static void dijkstra(int N, int start, int adjMat[][], int[] dist) {
		adjMat[start][start] = 0;
		dist[start] = 0;
		PriorityQueue<Integer> pri_queue = new PriorityQueue<Integer>();
		pri_queue.offer(start);
		
		while (!pri_queue.isEmpty()) {
			int cur = pri_queue.poll();
			for (int to = 1; to <= N; to++) {
				if (dist[to] > adjMat[cur][to] + dist[cur]) {
					dist[to] = adjMat[cur][to] + dist[cur];
					pri_queue.offer(to);
				}
			}
		}
	}
}
