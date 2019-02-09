import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] dist = new int[N + 1];
		ArrayList<Integer>[] adjList = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			dist[i] = INF;
			adjList[i] = new ArrayList<Integer>();
		}
		dist[1] = 0;
		
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from].add(to);
			adjList[to].add(from);
		}
		sc.close();
		
		dijkstra(dist, adjList);
		
		int place = 0, place_count = 0, place_max = 0;
		for(int i = 2; i <= N; i++) {
			if (dist[i] > place_max) {
				place = i;
				place_max = dist[i];
			}
		}
		for (int i = 2; i <= N; i++) {
			if(dist[i] == dist[place])
				place_count++;
		}
		System.out.println(place + " " + dist[place] + " " + place_count);
	}
	
	public static void dijkstra(int[] dist, ArrayList<Integer>[] adjList) {
		PriorityQueue<Integer> pri_queue = new PriorityQueue<Integer>();
		pri_queue.offer(1);
		
		while (!pri_queue.isEmpty()) {
			int from = pri_queue.poll();
			
			for(int to : adjList[from]) {
				if (dist[to] > dist[from] + 1) {
					dist[to] = dist[from] + 1;
					pri_queue.offer(to);
				}
			}
		}
	}
	
}
