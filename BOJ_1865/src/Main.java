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
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		while (TC-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int[] dist = new int[N + 1];
			Arrays.fill(dist, INF);
			dist[1] = 0;
			ArrayList<Node>[] adjList = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++)
				adjList[i] = new ArrayList<Node>();
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				adjList[a].add(new Node(b, c));
				adjList[b].add(new Node(a, c));
			}
			
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				adjList[a].add(new Node(b, -c));
			}
			
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
				bw.write("YES\n");
			else
				bw.write("NO\n");
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