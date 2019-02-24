import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] indegree = new int[N + 1];
		ArrayList<Integer>[] adjList = new ArrayList[N + 1];
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		for (int i = 1; i <= N; i++)
			adjList[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList[a].add(b);
			indegree[b]++;
		}
		
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				queue.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current).append(" ");
			
			for (int link : adjList[current]) {
				if (--indegree[link] == 0)
					queue.offer(link);
			}
		}
		
		sb.append("\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
