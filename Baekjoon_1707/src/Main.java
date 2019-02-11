import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int RED = 1;
	static final int BLUE = -1;
	static boolean flag;
	static int[] nodeColor;
	static ArrayList<Integer>[] adjList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		
		while (K-- > 0) {
			flag = true;
			st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			nodeColor = new int[V + 1];
			adjList = new ArrayList[V + 1];
			
			for (int i = 1; i <= V; i++)
				adjList[i] = new ArrayList<Integer>();
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjList[a].add(b);
				adjList[b].add(a);
			}
			
			for (int i = 1; i <= V; i++) {
				if (nodeColor[i] == 0)
					bfs(i);
			}
			
			if (flag)
				bw.write("YES" + "\n");
			else
				bw.write("NO" + "\n");
			
			bw.flush();
		}
		bw.close();
		br.close();
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		nodeColor[start] = RED;
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			
			for (int end : adjList[current]) {
				if (nodeColor[end] == 0) {
					queue.offer(end);
					nodeColor[end] = nodeColor[current] * -1;
				}
				else if ((nodeColor[current] + nodeColor[end]) != 0) {
					flag = false;
					return;
				}
			}
		}
	}
}
