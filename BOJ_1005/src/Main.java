import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K, W;
	static int[] time;
	static int[] indegree;
	static int[] dp;
	static ArrayList<Integer>[] adjList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			time = new int[N + 1];
			dp = new int[N + 1];
			indegree = new int[N + 1];
			adjList = new ArrayList[N + 1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				adjList[i] = new ArrayList<Integer>();
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjList[a].add(b);
				indegree[b]++;
			}
			
			W = Integer.parseInt(br.readLine());
			
			Queue<Integer> queue = new LinkedList<Integer>();
			for (int i = 1; i <= N; i++) {
				if (indegree[i] == 0) {
					queue.offer(i);
					dp[i] = time[i];
				}
					
			}
			
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				int size = adjList[cur].size();
				for (int next : adjList[cur]) {
					indegree[next]--;
					if (dp[next] < dp[cur] + time[next])
						dp[next] = dp[cur] + time[next];
					
					if (indegree[next] == 0)
						queue.offer(next);
				}
				
				if (indegree[W] == 0)
					break;
			}
			
			sb.append(dp[W]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
