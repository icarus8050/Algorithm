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
		int[] parent = new int[N + 1];
		ArrayList<Integer>[] adjList = new ArrayList[N + 1];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++)
			adjList[i] = new ArrayList<Integer>();
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		queue.offer(1);
		
		while (!queue.isEmpty()) {
			int from = queue.poll();
			
			for (int to : adjList[from]) {
				if (parent[to] == 0) {
					parent[to] = from;
					queue.offer(to);
				}
			}
		}
		
		for (int i = 2; i <= N; i++) {
			bw.write(parent[i] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
