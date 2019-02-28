import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 10000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Node>[] adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			adjList[i] = new ArrayList<Node>();
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjList[a].add(new Node(b, c));
		}
		
		dist[1] = 0;
		boolean flag = false;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				
				for (Node nextNode : adjList[j]) {
					if (dist[j] != INF && dist[nextNode.pos] > dist[j] + nextNode.cost) {
						dist[nextNode.pos] = dist[j] + nextNode.cost;
						
						if (i == N)
							flag = true;
					}
				}
			}
		}
		if (flag)
			bw.write(-1 + "\n");
		else {
			for (int i = 2; i <= N; i++) {
				if (dist[i] != INF)
					bw.write(dist[i] + "\n");
				else
					bw.write(-1 + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

class Node {
	int pos; int cost;
	public Node(int pos, int cost) {
		this.pos = pos; this.cost = cost;
	}
}