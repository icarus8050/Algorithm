import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		
		dfs(0, 0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int num, int cnt) {
		if (cnt == M) {
			for (int i : list)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = num + 1; i <= N; i++) {
			if (visited[i] != true) {
				visited[i] = true;
				list.add(i);
				dfs(i, cnt + 1);
				visited[i] = false;
				list.remove(list.size() - 1);
			}
		}
	}
}
