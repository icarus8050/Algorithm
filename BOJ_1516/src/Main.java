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
		int[] building = new int[N + 1];
		int[] endTime = new int[N + 1];
		int[] indegree = new int[N + 1];
		ArrayList<Integer>[] adjList = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++)
			adjList[i] = new ArrayList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			building[i] = Integer.parseInt(st.nextToken());
			
			while (st.hasMoreTokens()) {
				int nextNode = Integer.parseInt(st.nextToken());
				if (nextNode == -1)
					break;
				
				adjList[nextNode].add(i);
				indegree[i]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
				endTime[i] = building[i];
			}
		}
		
		while (!queue.isEmpty()) {
			int curNode = queue.poll();
			
			for (int nextNode : adjList[curNode]) {
				endTime[nextNode] = Math.max(endTime[nextNode], endTime[curNode] + building[nextNode]);
				if (--indegree[nextNode] == 0) {
					queue.offer(nextNode);
				}
			}
		}
		
		for (int i = 1; i <= N; i++)
			bw.write(endTime[i] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
