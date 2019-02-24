import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	static boolean[] visited;
	static int N;
	static BufferedReader br;
	static BufferedWriter bw;
	static StringBuilder sb;
	static Stack<Integer> stack;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		stack = new Stack<Integer>();
		
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++) {
			dfs(i, 0);
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void dfs(int start, int cnt) {
		visited[start] = true;
		stack.push(start);
		cnt++;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) 
				dfs(i, cnt);
		}
		if (cnt == N) {
			for (int item : stack) {
				sb.append(item).append(" ");
			}
			sb.append("\n");
		}
		
		visited[start] = false;
		stack.pop();
	}
}
