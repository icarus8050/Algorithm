import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Node>[] adjList;
	static PriorityQueue<Node> pri_queue = new PriorityQueue<Node>();
	static int[] dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		dist = new int[v + 1];
		adjList = new ArrayList[v + 1];
		
		for(int i = 1; i <= v; i++) {
			dist[i] = Integer.MAX_VALUE;
			adjList[i] = new ArrayList<Node>();
		}
		
		int start = Integer.parseInt(br.readLine());
		dist[start] = 0;
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjList[from].add(new Node(to, cost));
		}
		
		dijkstra(start);
		
		for (int i = 1; i <= v; i++) {
			bw.write(dist[i] < Integer.MAX_VALUE ? dist[i] + "\n" : "INF\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dijkstra(int start) {
		pri_queue.offer(new Node(start, dist[start]));

		while (!pri_queue.isEmpty()) {
			int from = pri_queue.peek().to;
			pri_queue.poll();
			
			for (Node des : adjList[from]) {
				if (dist[des.to] > dist[from] + des.cost) {
					dist[des.to] = dist[from] + des.cost;
					pri_queue.offer(new Node(des.to, dist[des.to]));
				}
			}
		}
	}
}

class Node implements Comparable<Node>{
	int to;
	int cost;
	
	Node(int to, int cost){
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node target) {
		// TODO Auto-generated method stub
		return this.cost - target.cost;
	}
}