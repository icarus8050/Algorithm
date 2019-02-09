import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] dist;
	static int INF = 800001;
	static ArrayList<Node>[] adjList;
	static PriorityQueue<Node> pri_queue = new PriorityQueue<Node>();
	public static void main(String[] args) throws IOException {
		int second, third;
		int result_1 = 0;
		int result_2 = 0;
		int ans;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		dist = new int[N + 1];
		adjList = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjList[a].add(new Node(b, c));
			adjList[b].add(new Node(a, c));
		}
		st = new StringTokenizer(br.readLine());
		second = Integer.parseInt(st.nextToken());
		third = Integer.parseInt(st.nextToken());
		
		result_1 += dijkstra(1, second);
		result_2 += dijkstra(1, third);
		
		result_1 += dijkstra(second, third);
		result_2 += dijkstra(third, second);
		
		result_1 += dijkstra(third, N);
		result_2 += dijkstra(second, N);
		
		ans = Math.min(result_1, result_2);
		
		if (ans >= INF)
			bw.write("-1");
		else
			bw.write(ans + "\n");
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	public static void dist_Initializing(int start) {
		for (int i = 1; i < dist.length; i++) {
			dist[i] = INF;
		}
		dist[start] = 0;
	}
	
	public static int dijkstra(int start, int end) {
		dist_Initializing(start);
		
		pri_queue.offer(new Node(start, dist[start]));
		while(!pri_queue.isEmpty()) {
			int from = pri_queue.poll().to;
			
			for (Node toNode : adjList[from]) {
				if (dist[toNode.to] > toNode.cost + dist[from]) {
					dist[toNode.to]= toNode.cost + dist[from];
					pri_queue.offer(new Node(toNode.to, toNode.cost));
				}
			}
		}
		
		return dist[end];
	}
}
class Node implements Comparable<Node>{
	int to;
	int cost;
	
	public Node(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node target) {
		// TODO Auto-generated method stub
		return this.cost - target.cost;
	}
}
