import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

	static int N, M;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		visited = new boolean[N + 1];
		dfs(0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int cnt){
		if (cnt == M) {
			for (int num : list)
				sb.append(num).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (visited[i] != true) {
				list.add(i);
				visited[i] = true;
				dfs(cnt + 1);
				list.remove(list.size() - 1);
				visited[i] = false;
			}
		}
	}
}
