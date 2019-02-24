import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visited;
	static int N;
	static int[] arr;
	static int result = -1000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++)
			dfs(i, 0, 0);
		System.out.println(result);
		
		br.close();
	}
	
	public static void dfs(int node, int sum, int cnt) {
		visited[node] = true;
		cnt++;
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				dfs(i, sum + Math.abs(arr[node] - arr[i]), cnt);
			}
		}
		visited[node] = false;
		
		if (cnt == N)
			result = Math.max(result, sum);
	}
}
