import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static final int INF = Integer.MAX_VALUE;
	static ArrayList<Node>[] adjList;
	static int[] dist, connect;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N + 1];
		dist = new int[N + 1];
		connect = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			dist[i] = INF;
			adjList[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjList[from].add(new Node(to, cost));
			adjList[to].add(new Node(from, cost));
		}
		
		dist[1] = 0;
		dijkstra(dist, adjList, connect);
		
		System.out.println(N - 1);
		for(int i = 2; i <= N; i++) {
			bw.write(connect[i] + " " + i + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dijkstra(int[] dist, ArrayList<Node>[] adjList, int[] connect) {
		PriorityQueue<Node> pri_Queue = new PriorityQueue<Node>();
		pri_Queue.offer(new Node(1, 0));
		
		while (!pri_Queue.isEmpty()) {
			Node from_Node = pri_Queue.poll();
			for (Node to_Node : adjList[from_Node.to]) {
				if (dist[to_Node.to] > dist[from_Node.to] + to_Node.cost) {
					dist[to_Node.to] = dist[from_Node.to] + to_Node.cost;
					pri_Queue.offer(to_Node);
					connect[to_Node.to] = from_Node.to;
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