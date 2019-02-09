import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] citys = new int[N + 1][N + 1];
		int[] minCost = new int[N + 1];
		//boolean[] visited = new boolean[N + 1];
		PriorityQueue<Integer> pri_Queue = new PriorityQueue<>();
		
		for (int i = 1; i <= N; i++) {
			minCost[i] = INF;
			
			for (int j = 1; j <= N; j++) {
				if (i == j)
					citys[i][j] = 0;
				else
					citys[i][j] = INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			
			citys[from][to] = Math.min(citys[from][to], cost);
		}
		
		int start = sc.nextInt();
		int destination = sc.nextInt();
		sc.close();
		
		citys[start][start] = 0;
		minCost[start] = 0;
		pri_Queue.offer(start);
		
		while (!pri_Queue.isEmpty()) {
			int from = pri_Queue.poll();
			
			for (int to = 1; to <= N; to++) {
				if (citys[from][to] == INF)
					continue;
				
				if (minCost[to] > citys[from][to] + minCost[from]) {
					minCost[to] = citys[from][to] + minCost[from];
					pri_Queue.offer(to);
				}
			}
		}
		
		System.out.println(minCost[destination]);
	}
}
