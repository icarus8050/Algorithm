import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] adjMat;
	static int N, M, V;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		adjMat = new boolean[N + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjMat[a][b] = true;
			adjMat[b][a] = true;
		}
		
		dfs();
		bfs();
		br.close();
	}
	
	public static void dfs() throws Exception {
		boolean[] visited = new boolean[N + 1];
		Stack<Integer> stack = new Stack<Integer>();
		boolean flag;
		
		stack.push(V);
		visited[V] = true;
		System.out.print(V);
		
		while (!stack.isEmpty()) {
			int start = stack.peek();
			flag = true;
			
			for (int i = 1; i <= N; i++) {
				if (adjMat[start][i] && !visited[i]) {
					stack.push(i);
					System.out.print(" " + i);
					visited[i] = true;
					flag = false;
					break;
				}
			}

			if (flag)
				stack.pop();
		}
		System.out.println();
	}
	
	public static void bfs() throws Exception {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(V);
		visited[V] = true;
		System.out.print(V);
		
		while (!queue.isEmpty()) {
			int start = queue.poll();
			
			for (int i = 1; i <= N; i++) {
				if (adjMat[start][i] && !visited[i]) {
					queue.offer(i);
					System.out.print(" " + i);
					visited[i] = true;
				}
			}
		}
		System.out.println();
	}
}
