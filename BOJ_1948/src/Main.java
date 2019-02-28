import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		int[] indegree = new int[n + 1];
		boolean[][] visited = new boolean[n + 1][n + 1];
		ArrayList<Node>[] adjList = new ArrayList[n + 1];
		ArrayList<Node>[] reverseList = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<Node>();
			reverseList[i] = new ArrayList<Node>();
		}
			
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjList[a].add(new Node(b, c));
			reverseList[b].add(new Node(a, c));
			indegree[b]++;
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		while (!queue.isEmpty()) {
			int curNum = queue.poll();
			
			for (Node nextNode : adjList[curNum]) {
				dp[nextNode.pos] = Math.max(dp[nextNode.pos], dp[curNum] + nextNode.cost);
				if (--indegree[nextNode.pos] == 0)
					queue.offer(nextNode.pos);
			}
		}
		
		int road = 0;
		queue.offer(end);
		while (!queue.isEmpty()) {
			int curNum = queue.poll();
			
			for (Node nextNode : reverseList[curNum]) {
				if (dp[curNum] == dp[nextNode.pos] + nextNode.cost && !visited[curNum][nextNode.pos]) {
					visited[curNum][nextNode.pos] = true; 
					road++;
					queue.offer(nextNode.pos);
				}
			}
		}
		
		bw.write(dp[n] + "\n");
		bw.write(road + "\n");
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
