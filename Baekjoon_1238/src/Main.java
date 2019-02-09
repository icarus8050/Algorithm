import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static final int INF = 1000001;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int destination = sc.nextInt();
		
		int[][] maps = new int[N + 1][N + 1];
		int[][] rev_maps = new int[N + 1][N + 1];
		
		int[] dist = new int[N + 1];
		int[] rev_dist = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			dist[i] = rev_dist[i] = INF;
			for (int j = 1; j <= N; j++) {
				maps[i][j] = rev_maps[i][j] = INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			
			maps[from][to] = rev_maps[to][from] = cost;
		}
		dijkstra(destination, maps, dist, N);
		dijkstra(destination, rev_maps, rev_dist, N);
		
		int MaxCost = 0;
		for (int i = 1; i <= N; i++) {
			MaxCost = Math.max(MaxCost, dist[i] + rev_dist[i]);
		}
		System.out.println(MaxCost);
		
	}
	
	public static void dijkstra(int start, int[][] map, int dist[], int N) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.offer(start);
		map[start][start] = 0;
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			int from = pq.poll();
			
			for(int to = 1; to <= N; to++) {
				if(dist[to] > map[from][to] + dist[from]) {
					dist[to] = map[from][to] + dist[from];
					pq.offer(to);
				}
			}
		}
	}
}
