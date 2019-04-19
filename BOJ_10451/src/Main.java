import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			N =  Integer.parseInt(br.readLine());
			arr = new int[N + 1];
			visited = new boolean[N + 1];
			int ans = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					dfs(i);
					ans++;
				}
			}
			
			bw.write(ans + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int node) {
		visited[node] = true;
		if (!visited[arr[node]])
			dfs(arr[node]);
	}
}
