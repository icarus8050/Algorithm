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
		
		int N = Integer.parseInt(br.readLine());
		int[] indegree = new int[N + 1];
		int[] works = new int[N + 1];
		int[] endTime = new int[N + 1];
		int result = 0;
		ArrayList<Integer>[] adjList = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++)
			adjList[i] = new ArrayList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			works[i] = Integer.parseInt(st.nextToken());
			
			int cnt = Integer.parseInt(st.nextToken());
			for (int k = 0; k < cnt; k++) {
				int node = Integer.parseInt(st.nextToken());
				adjList[i].add(node);
				indegree[node]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
				endTime[i] = works[i];
			}
		}
		
		while (!queue.isEmpty()) {
			int curNode = queue.poll();
			
			for (int nextNum : adjList[curNode]) {
				endTime[nextNum] = Math.max(endTime[nextNum], endTime[curNode] + works[nextNum]);
				if (--indegree[nextNum] == 0) {
					queue.offer(nextNum);
				}
			}
		}
		for (int i = 1; i <= N; i++)
			result = Math.max(result, endTime[i]);
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
